package org.codehaus.jackson.map.ser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.BeanPropertyDefinition;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.ser.std.MapSerializer;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializerFactory
  extends BasicSerializerFactory
{
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  protected final SerializerFactory.Config _factoryConfig;
  
  protected BeanSerializerFactory(SerializerFactory.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = new ConfigImpl();
    }
    _factoryConfig = ((SerializerFactory.Config)localObject);
  }
  
  protected BeanPropertyWriter _constructWriter(SerializationConfig paramSerializationConfig, TypeBindings paramTypeBindings, PropertyBuilder paramPropertyBuilder, boolean paramBoolean, String paramString, AnnotatedMember paramAnnotatedMember)
    throws JsonMappingException
  {
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMember.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMember.getType(paramTypeBindings);
    BeanProperty.Std localStd = new BeanProperty.Std(paramString, localJavaType, paramPropertyBuilder.getClassAnnotations(), paramAnnotatedMember);
    JsonSerializer localJsonSerializer = findSerializerFromAnnotation(paramSerializationConfig, paramAnnotatedMember, localStd);
    paramTypeBindings = null;
    if (ClassUtil.isCollectionMapOrArray(localJavaType.getRawClass())) {
      paramTypeBindings = findPropertyContentTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd);
    }
    paramTypeBindings = paramPropertyBuilder.buildWriter(paramString, localJavaType, localJsonSerializer, findPropertyTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd), paramTypeBindings, paramAnnotatedMember, paramBoolean);
    paramTypeBindings.setViews(paramSerializationConfig.getAnnotationIntrospector().findSerializationViews(paramAnnotatedMember));
    return paramTypeBindings;
  }
  
  protected JsonSerializer<Object> constructBeanSerializer(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (paramBasicBeanDescription.getBeanClass() == Object.class) {
      throw new IllegalArgumentException("Can not create bean serializer for Object.class");
    }
    BeanSerializerBuilder localBeanSerializerBuilder = constructBeanSerializerBuilder(paramBasicBeanDescription);
    Object localObject2 = findBeanProperties(paramSerializationConfig, paramBasicBeanDescription);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localObject1;
    Iterator localIterator;
    if (_factoryConfig.hasSerializerModifiers())
    {
      localIterator = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)localIterator.next()).changeProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
      }
    }
    localObject1 = sortBeanProperties(paramSerializationConfig, paramBasicBeanDescription, filterBeanProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject2));
    localObject2 = localObject1;
    if (_factoryConfig.hasSerializerModifiers())
    {
      localIterator = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)localIterator.next()).orderProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
      }
    }
    localBeanSerializerBuilder.setProperties((List)localObject2);
    localBeanSerializerBuilder.setFilterId(findFilterId(paramSerializationConfig, paramBasicBeanDescription));
    localObject1 = paramBasicBeanDescription.findAnyGetter();
    if (localObject1 != null)
    {
      if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
        ((AnnotatedMethod)localObject1).fixAccess();
      }
      localObject2 = ((AnnotatedMethod)localObject1).getType(paramBasicBeanDescription.bindingsForBeanType());
      localBeanSerializerBuilder.setAnyGetter(new AnyGetterWriter((AnnotatedMethod)localObject1, MapSerializer.construct(null, (JavaType)localObject2, paramSerializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING), createTypeSerializer(paramSerializationConfig, ((JavaType)localObject2).getContentType(), paramBeanProperty), paramBeanProperty, null, null)));
    }
    processViews(paramSerializationConfig, localBeanSerializerBuilder);
    localObject1 = localBeanSerializerBuilder;
    if (_factoryConfig.hasSerializerModifiers())
    {
      localObject2 = _factoryConfig.serializerModifiers().iterator();
      for (paramBeanProperty = localBeanSerializerBuilder;; paramBeanProperty = ((BeanSerializerModifier)((Iterator)localObject2).next()).updateBuilder(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty))
      {
        localObject1 = paramBeanProperty;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      }
    }
    paramBeanProperty = ((BeanSerializerBuilder)localObject1).build();
    paramSerializationConfig = paramBeanProperty;
    if (paramBeanProperty == null)
    {
      paramSerializationConfig = paramBeanProperty;
      if (paramBasicBeanDescription.hasKnownClassAnnotations()) {
        paramSerializationConfig = ((BeanSerializerBuilder)localObject1).createDummy();
      }
    }
    return paramSerializationConfig;
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    return new BeanSerializerBuilder(paramBasicBeanDescription);
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    return FilteredBeanPropertyWriter.constructViewBased(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return new PropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
  }
  
  public JsonSerializer<Object> createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject;
    if (!_factoryConfig.hasKeySerializers()) {
      localObject = null;
    }
    JsonSerializer localJsonSerializer;
    do
    {
      BasicBeanDescription localBasicBeanDescription;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return (JsonSerializer<Object>)localObject;
        localBasicBeanDescription = (BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
        localObject = null;
        localIterator = _factoryConfig.keySerializers().iterator();
      }
      localJsonSerializer = ((Serializers)localIterator.next()).findSerializer(paramSerializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
      localObject = localJsonSerializer;
    } while (localJsonSerializer == null);
    return localJsonSerializer;
  }
  
  public JsonSerializer<Object> createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject2 = (BasicBeanDescription)paramSerializationConfig.introspect(paramJavaType);
    Object localObject1 = findSerializerFromAnnotation(paramSerializationConfig, ((BasicBeanDescription)localObject2).getClassInfo(), paramBeanProperty);
    if (localObject1 != null) {
      return (JsonSerializer<Object>)localObject1;
    }
    JavaType localJavaType = modifyTypeByAnnotation(paramSerializationConfig, ((BasicBeanDescription)localObject2).getClassInfo(), paramJavaType);
    if (localJavaType != paramJavaType) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = localObject2;
      if (localJavaType != paramJavaType)
      {
        localObject1 = localObject2;
        if (localJavaType.getRawClass() != paramJavaType.getRawClass()) {
          localObject1 = (BasicBeanDescription)paramSerializationConfig.introspect(localJavaType);
        }
      }
      if (!paramJavaType.isContainerType()) {
        break;
      }
      return buildContainerSerializer(paramSerializationConfig, localJavaType, (BasicBeanDescription)localObject1, paramBeanProperty, bool);
    }
    paramJavaType = _factoryConfig.serializers().iterator();
    while (paramJavaType.hasNext())
    {
      localObject2 = ((Serializers)paramJavaType.next()).findSerializer(paramSerializationConfig, localJavaType, (BeanDescription)localObject1, paramBeanProperty);
      if (localObject2 != null) {
        return (JsonSerializer<Object>)localObject2;
      }
    }
    localObject2 = findSerializerByLookup(localJavaType, paramSerializationConfig, (BasicBeanDescription)localObject1, paramBeanProperty, bool);
    paramJavaType = (JavaType)localObject2;
    if (localObject2 == null)
    {
      localObject2 = findSerializerByPrimaryType(localJavaType, paramSerializationConfig, (BasicBeanDescription)localObject1, paramBeanProperty, bool);
      paramJavaType = (JavaType)localObject2;
      if (localObject2 == null)
      {
        localObject2 = findBeanSerializer(paramSerializationConfig, localJavaType, (BasicBeanDescription)localObject1, paramBeanProperty);
        paramJavaType = (JavaType)localObject2;
        if (localObject2 == null) {
          paramJavaType = findSerializerByAddonType(paramSerializationConfig, localJavaType, (BasicBeanDescription)localObject1, paramBeanProperty, bool);
        }
      }
    }
    return paramJavaType;
  }
  
  protected Iterable<Serializers> customSerializers()
  {
    return _factoryConfig.serializers();
  }
  
  protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyWriter> paramList)
  {
    paramSerializationConfig = paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo());
    if ((paramSerializationConfig != null) && (paramSerializationConfig.length > 0))
    {
      paramSerializationConfig = ArrayBuilders.arrayToSet(paramSerializationConfig);
      paramBasicBeanDescription = paramList.iterator();
      while (paramBasicBeanDescription.hasNext()) {
        if (paramSerializationConfig.contains(((BeanPropertyWriter)paramBasicBeanDescription.next()).getName())) {
          paramBasicBeanDescription.remove();
        }
      }
    }
    return paramList;
  }
  
  protected List<BeanPropertyWriter> findBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    Object localObject1 = paramBasicBeanDescription.findProperties();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    removeIgnorableTypes(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.REQUIRE_SETTERS_FOR_GETTERS)) {
      removeSetterlessGetters(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
    }
    if (((List)localObject1).isEmpty())
    {
      paramBasicBeanDescription = null;
      return paramBasicBeanDescription;
    }
    boolean bool = usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, null, null);
    PropertyBuilder localPropertyBuilder = constructPropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    TypeBindings localTypeBindings = paramBasicBeanDescription.bindingsForBeanType();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      paramBasicBeanDescription = localArrayList;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      Object localObject2 = (BeanPropertyDefinition)((Iterator)localObject1).next();
      paramBasicBeanDescription = ((BeanPropertyDefinition)localObject2).getAccessor();
      AnnotationIntrospector.ReferenceProperty localReferenceProperty = localAnnotationIntrospector.findReferenceType(paramBasicBeanDescription);
      if ((localReferenceProperty == null) || (!localReferenceProperty.isBackReference()))
      {
        localObject2 = ((BeanPropertyDefinition)localObject2).getName();
        if ((paramBasicBeanDescription instanceof AnnotatedMethod)) {
          localArrayList.add(_constructWriter(paramSerializationConfig, localTypeBindings, localPropertyBuilder, bool, (String)localObject2, (AnnotatedMethod)paramBasicBeanDescription));
        } else {
          localArrayList.add(_constructWriter(paramSerializationConfig, localTypeBindings, localPropertyBuilder, bool, (String)localObject2, (AnnotatedField)paramBasicBeanDescription));
        }
      }
    }
  }
  
  public JsonSerializer<Object> findBeanSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (!isPotentialBeanType(paramJavaType.getRawClass())) {
      paramJavaType = null;
    }
    do
    {
      return paramJavaType;
      paramBeanProperty = constructBeanSerializer(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty);
      paramJavaType = paramBeanProperty;
    } while (!_factoryConfig.hasSerializerModifiers());
    Iterator localIterator = _factoryConfig.serializerModifiers().iterator();
    for (;;)
    {
      paramJavaType = paramBeanProperty;
      if (!localIterator.hasNext()) {
        break;
      }
      paramBeanProperty = ((BeanSerializerModifier)localIterator.next()).modifySerializer(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty);
    }
  }
  
  protected Object findFilterId(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return paramSerializationConfig.getAnnotationIntrospector().findFilterId(paramBasicBeanDescription.getClassInfo());
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JavaType localJavaType = paramJavaType.getContentType();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    paramJavaType = localAnnotationIntrospector.findPropertyContentTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (paramJavaType == null) {
      return createTypeSerializer(paramSerializationConfig, localJavaType, paramBeanProperty);
    }
    return paramJavaType.buildTypeSerializer(paramSerializationConfig, localJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return createTypeSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  public SerializerFactory.Config getConfig()
  {
    return _factoryConfig;
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    return (ClassUtil.canBeABeanType(paramClass) == null) && (!ClassUtil.isProxyType(paramClass));
  }
  
  protected void processViews(SerializationConfig paramSerializationConfig, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    List localList = paramBeanSerializerBuilder.getProperties();
    boolean bool = paramSerializationConfig.isEnabled(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
    int m = localList.size();
    int j = 0;
    paramSerializationConfig = new BeanPropertyWriter[m];
    int i = 0;
    if (i < m)
    {
      BeanPropertyWriter localBeanPropertyWriter = (BeanPropertyWriter)localList.get(i);
      Class[] arrayOfClass = localBeanPropertyWriter.getViews();
      int k;
      if (arrayOfClass == null)
      {
        k = j;
        if (bool)
        {
          paramSerializationConfig[i] = localBeanPropertyWriter;
          k = j;
        }
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j + 1;
        paramSerializationConfig[i] = constructFilteredBeanWriter(localBeanPropertyWriter, arrayOfClass);
      }
    }
    if ((bool) && (j == 0)) {
      return;
    }
    paramBeanSerializerBuilder.setFilteredProperties(paramSerializationConfig);
  }
  
  protected void removeIgnorableTypes(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramBasicBeanDescription = ((BeanPropertyDefinition)localIterator.next()).getAccessor();
      if (paramBasicBeanDescription == null)
      {
        localIterator.remove();
      }
      else
      {
        Class localClass = paramBasicBeanDescription.getRawType();
        paramList = (Boolean)localHashMap.get(localClass);
        paramBasicBeanDescription = paramList;
        if (paramList == null)
        {
          paramList = localAnnotationIntrospector.isIgnorableType(((BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(localClass)).getClassInfo());
          paramBasicBeanDescription = paramList;
          if (paramList == null) {
            paramBasicBeanDescription = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramBasicBeanDescription);
        }
        if (paramBasicBeanDescription.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected void removeSetterlessGetters(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    paramSerializationConfig = paramList.iterator();
    while (paramSerializationConfig.hasNext())
    {
      paramBasicBeanDescription = (BeanPropertyDefinition)paramSerializationConfig.next();
      if ((!paramBasicBeanDescription.couldDeserialize()) && (!paramBasicBeanDescription.isExplicitlyIncluded())) {
        paramSerializationConfig.remove();
      }
    }
  }
  
  @Deprecated
  protected List<BeanPropertyWriter> sortBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyWriter> paramList)
  {
    return paramList;
  }
  
  public SerializerFactory withConfig(SerializerFactory.Config paramConfig)
  {
    if (_factoryConfig == paramConfig) {
      return this;
    }
    if (getClass() != BeanSerializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new BeanSerializerFactory(paramConfig);
  }
  
  public static class ConfigImpl
    extends SerializerFactory.Config
  {
    protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
    protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
    protected final Serializers[] _additionalKeySerializers;
    protected final Serializers[] _additionalSerializers;
    protected final BeanSerializerModifier[] _modifiers;
    
    public ConfigImpl()
    {
      this(null, null, null);
    }
    
    protected ConfigImpl(Serializers[] paramArrayOfSerializers1, Serializers[] paramArrayOfSerializers2, BeanSerializerModifier[] paramArrayOfBeanSerializerModifier)
    {
      Serializers[] arrayOfSerializers = paramArrayOfSerializers1;
      if (paramArrayOfSerializers1 == null) {
        arrayOfSerializers = NO_SERIALIZERS;
      }
      _additionalSerializers = arrayOfSerializers;
      paramArrayOfSerializers1 = paramArrayOfSerializers2;
      if (paramArrayOfSerializers2 == null) {
        paramArrayOfSerializers1 = NO_SERIALIZERS;
      }
      _additionalKeySerializers = paramArrayOfSerializers1;
      paramArrayOfSerializers1 = paramArrayOfBeanSerializerModifier;
      if (paramArrayOfBeanSerializerModifier == null) {
        paramArrayOfSerializers1 = NO_MODIFIERS;
      }
      _modifiers = paramArrayOfSerializers1;
    }
    
    public boolean hasKeySerializers()
    {
      return _additionalKeySerializers.length > 0;
    }
    
    public boolean hasSerializerModifiers()
    {
      return _modifiers.length > 0;
    }
    
    public boolean hasSerializers()
    {
      return _additionalSerializers.length > 0;
    }
    
    public Iterable<Serializers> keySerializers()
    {
      return ArrayBuilders.arrayAsIterable(_additionalKeySerializers);
    }
    
    public Iterable<BeanSerializerModifier> serializerModifiers()
    {
      return ArrayBuilders.arrayAsIterable(_modifiers);
    }
    
    public Iterable<Serializers> serializers()
    {
      return ArrayBuilders.arrayAsIterable(_additionalSerializers);
    }
    
    public SerializerFactory.Config withAdditionalKeySerializers(Serializers paramSerializers)
    {
      if (paramSerializers == null) {
        throw new IllegalArgumentException("Can not pass null Serializers");
      }
      paramSerializers = (Serializers[])ArrayBuilders.insertInListNoDup(_additionalKeySerializers, paramSerializers);
      return new ConfigImpl(_additionalSerializers, paramSerializers, _modifiers);
    }
    
    public SerializerFactory.Config withAdditionalSerializers(Serializers paramSerializers)
    {
      if (paramSerializers == null) {
        throw new IllegalArgumentException("Can not pass null Serializers");
      }
      return new ConfigImpl((Serializers[])ArrayBuilders.insertInListNoDup(_additionalSerializers, paramSerializers), _additionalKeySerializers, _modifiers);
    }
    
    public SerializerFactory.Config withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
    {
      if (paramBeanSerializerModifier == null) {
        throw new IllegalArgumentException("Can not pass null modifier");
      }
      paramBeanSerializerModifier = (BeanSerializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, paramBeanSerializerModifier);
      return new ConfigImpl(_additionalSerializers, _additionalKeySerializers, paramBeanSerializerModifier);
    }
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.ser.BeanSerializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */