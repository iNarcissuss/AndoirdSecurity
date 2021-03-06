package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.map.deser.impl.CreatorCollector;
import org.codehaus.jackson.map.deser.impl.ExternalTypeHandler;
import org.codehaus.jackson.map.deser.impl.ExternalTypeHandler.Builder;
import org.codehaus.jackson.map.deser.impl.PropertyBasedCreator;
import org.codehaus.jackson.map.deser.impl.PropertyValueBuffer;
import org.codehaus.jackson.map.deser.impl.UnwrappedPropertyHandler;
import org.codehaus.jackson.map.deser.impl.ValueInjector;
import org.codehaus.jackson.map.deser.std.ContainerDeserializerBase;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

@JsonCachable
public class BeanDeserializer
  extends StdDeserializer<Object>
  implements ResolvableDeserializer
{
  protected SettableAnyProperty _anySetter;
  protected final Map<String, SettableBeanProperty> _backRefs;
  protected final BeanPropertyMap _beanProperties;
  protected final JavaType _beanType;
  protected JsonDeserializer<Object> _delegateDeserializer;
  protected ExternalTypeHandler _externalTypeIdHandler;
  protected final AnnotatedClass _forClass;
  protected final HashSet<String> _ignorableProps;
  protected final boolean _ignoreAllUnknown;
  protected final ValueInjector[] _injectables;
  protected boolean _nonStandardCreation;
  protected final BeanProperty _property;
  protected final PropertyBasedCreator _propertyBasedCreator;
  protected HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
  protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
  protected final ValueInstantiator _valueInstantiator;
  
  public BeanDeserializer(BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, ValueInstantiator paramValueInstantiator, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty, List<ValueInjector> paramList)
  {
    this(paramBeanDescription.getClassInfo(), paramBeanDescription.getType(), paramBeanProperty, paramValueInstantiator, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean, paramSettableAnyProperty, paramList);
  }
  
  protected BeanDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    this(paramBeanDeserializer, _ignoreAllUnknown);
  }
  
  protected BeanDeserializer(BeanDeserializer paramBeanDeserializer, boolean paramBoolean)
  {
    super(_beanType);
    _forClass = _forClass;
    _beanType = _beanType;
    _property = _property;
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
    _propertyBasedCreator = _propertyBasedCreator;
    _beanProperties = _beanProperties;
    _backRefs = _backRefs;
    _ignorableProps = _ignorableProps;
    _ignoreAllUnknown = paramBoolean;
    _anySetter = _anySetter;
    _injectables = _injectables;
    _nonStandardCreation = _nonStandardCreation;
    _unwrappedPropertyHandler = _unwrappedPropertyHandler;
  }
  
  protected BeanDeserializer(AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, BeanProperty paramBeanProperty, ValueInstantiator paramValueInstantiator, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty, List<ValueInjector> paramList)
  {
    super(paramJavaType);
    _forClass = paramAnnotatedClass;
    _beanType = paramJavaType;
    _property = paramBeanProperty;
    _valueInstantiator = paramValueInstantiator;
    if (paramValueInstantiator.canCreateFromObjectWith())
    {
      _propertyBasedCreator = new PropertyBasedCreator(paramValueInstantiator);
      _beanProperties = paramBeanPropertyMap;
      _backRefs = paramMap;
      _ignorableProps = paramHashSet;
      _ignoreAllUnknown = paramBoolean;
      _anySetter = paramSettableAnyProperty;
      paramAnnotatedClass = (AnnotatedClass)localObject;
      if (paramList != null)
      {
        if (!paramList.isEmpty()) {
          break label154;
        }
        paramAnnotatedClass = (AnnotatedClass)localObject;
      }
      label101:
      _injectables = paramAnnotatedClass;
      if ((!paramValueInstantiator.canCreateUsingDelegate()) && (_propertyBasedCreator == null) && (paramValueInstantiator.canCreateUsingDefault()) && (_unwrappedPropertyHandler == null)) {
        break label178;
      }
    }
    label154:
    label178:
    for (paramBoolean = true;; paramBoolean = false)
    {
      _nonStandardCreation = paramBoolean;
      return;
      _propertyBasedCreator = null;
      break;
      paramAnnotatedClass = (ValueInjector[])paramList.toArray(new ValueInjector[paramList.size()]);
      break label101;
    }
  }
  
  @Deprecated
  public BeanDeserializer(AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, BeanProperty paramBeanProperty, CreatorCollector paramCreatorCollector, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty)
  {
    this(paramAnnotatedClass, paramJavaType, paramBeanProperty, paramCreatorCollector.constructValueInstantiator(null), paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean, paramSettableAnyProperty, null);
  }
  
  private final void _handleUnknown(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    if ((_ignorableProps != null) && (_ignorableProps.contains(paramString)))
    {
      paramJsonParser.skipChildren();
      return;
    }
    if (_anySetter != null) {
      try
      {
        _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, paramString);
        return;
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, paramObject, paramString, paramDeserializationContext);
        return;
      }
    }
    handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, paramString);
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
    Object localObject1 = null;
    Object localObject4 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject4 == JsonToken.FIELD_NAME)
    {
      localObject4 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty((String)localObject4);
      if (localSettableBeanProperty != null)
      {
        Object localObject5 = localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
        localObject2 = localObject1;
        if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty.getPropertyIndex(), localObject5)) {
          paramJsonParser.nextToken();
        }
      }
    }
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
        if (localObject2.getClass() != _beanType.getRawClass())
        {
          paramJsonParser = handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject2, (TokenBuffer)localObject1);
          return paramJsonParser;
        }
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, _beanType.getRawClass(), (String)localObject4, paramDeserializationContext);
        localObject3 = localObject1;
      }
      for (;;)
      {
        localObject4 = paramJsonParser.nextToken();
        localObject1 = localObject3;
        break;
        localObject4 = localObject3;
        if (localObject1 != null) {
          localObject4 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
        }
        return deserialize(paramJsonParser, paramDeserializationContext, localObject4);
        localObject3 = _beanProperties.find((String)localObject4);
        if (localObject3 != null)
        {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(localObject4)))
        {
          paramJsonParser.skipChildren();
          localObject3 = localObject1;
        }
        else if (_anySetter != null)
        {
          localPropertyValueBuffer.bufferAnyProperty(_anySetter, (String)localObject4, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new TokenBuffer(paramJsonParser.getCodec());
          }
          ((TokenBuffer)localObject3).writeFieldName((String)localObject4);
          ((TokenBuffer)localObject3).copyCurrentStructure(paramJsonParser);
        }
      }
      try
      {
        localObject3 = localPropertyBasedCreator.build(localPropertyValueBuffer);
        paramJsonParser = (JsonParser)localObject3;
        if (localObject1 != null) {
          if (localObject3.getClass() != _beanType.getRawClass()) {
            return handlePolymorphic(null, paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
          }
        }
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
        return null;
      }
    }
    return handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
  }
  
  protected JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    try
    {
      if (_subDeserializers == null) {}
      for (paramTokenBuffer = null;; paramTokenBuffer = (JsonDeserializer)_subDeserializers.get(new ClassKey(paramObject.getClass())))
      {
        if (paramTokenBuffer == null) {
          break;
        }
        return paramTokenBuffer;
      }
      localDeserializerProvider = paramDeserializationContext.getDeserializerProvider();
    }
    finally {}
    DeserializerProvider localDeserializerProvider;
    if (localDeserializerProvider != null)
    {
      paramTokenBuffer = paramDeserializationContext.constructType(paramObject.getClass());
      paramDeserializationContext = localDeserializerProvider.findValueDeserializer(paramDeserializationContext.getConfig(), paramTokenBuffer, _property);
      paramTokenBuffer = paramDeserializationContext;
      if (paramDeserializationContext != null) {
        try
        {
          if (_subDeserializers == null) {
            _subDeserializers = new HashMap();
          }
          _subDeserializers.put(new ClassKey(paramObject.getClass()), paramDeserializationContext);
          paramTokenBuffer = paramDeserializationContext;
        }
        finally {}
      }
    }
    return paramTokenBuffer;
  }
  
  protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject2 = paramSettableBeanProperty.getValueDeserializer();
    Object localObject1 = paramSettableBeanProperty;
    Object localObject3;
    int j;
    int i;
    if ((localObject2 instanceof BeanDeserializer))
    {
      localObject1 = paramSettableBeanProperty;
      if (!((BeanDeserializer)localObject2).getValueInstantiator().canCreateUsingDefault())
      {
        localObject3 = paramSettableBeanProperty.getType().getRawClass();
        localObject2 = ClassUtil.getOuterClass((Class)localObject3);
        localObject1 = paramSettableBeanProperty;
        if (localObject2 != null)
        {
          localObject1 = paramSettableBeanProperty;
          if (localObject2 == _beanType.getRawClass())
          {
            localObject3 = ((Class)localObject3).getConstructors();
            j = localObject3.length;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSettableBeanProperty;
      if (i < j)
      {
        localObject1 = localObject3[i];
        Class[] arrayOfClass = ((Constructor)localObject1).getParameterTypes();
        if ((arrayOfClass.length == 1) && (arrayOfClass[0] == localObject2))
        {
          if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            ClassUtil.checkAndFixAccess((Member)localObject1);
          }
          localObject1 = new SettableBeanProperty.InnerClassProperty(paramSettableBeanProperty, (Constructor)localObject1);
        }
      }
      else
      {
        return (SettableBeanProperty)localObject1;
      }
      i += 1;
    }
  }
  
  protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getManagedReferenceName();
    if (str == null) {
      return paramSettableBeanProperty;
    }
    paramDeserializationConfig = paramSettableBeanProperty.getValueDeserializer();
    boolean bool = false;
    if ((paramDeserializationConfig instanceof BeanDeserializer)) {
      paramDeserializationConfig = ((BeanDeserializer)paramDeserializationConfig).findBackReference(str);
    }
    while (paramDeserializationConfig == null)
    {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + paramSettableBeanProperty.getType());
      if ((paramDeserializationConfig instanceof ContainerDeserializerBase))
      {
        paramDeserializationConfig = ((ContainerDeserializerBase)paramDeserializationConfig).getContentDeserializer();
        if (!(paramDeserializationConfig instanceof BeanDeserializer)) {
          throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + paramDeserializationConfig.getClass().getName() + ")");
        }
        paramDeserializationConfig = ((BeanDeserializer)paramDeserializationConfig).findBackReference(str);
        bool = true;
      }
      else
      {
        if ((paramDeserializationConfig instanceof AbstractDeserializer)) {
          throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + _beanType.getRawClass().getName() + "." + paramSettableBeanProperty.getName() + ")");
        }
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + paramDeserializationConfig.getClass().getName());
      }
    }
    JavaType localJavaType1 = _beanType;
    JavaType localJavaType2 = paramDeserializationConfig.getType();
    if (!localJavaType2.getRawClass().isAssignableFrom(localJavaType1.getRawClass())) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + localJavaType2.getRawClass().getName() + ") not compatible with managed type (" + localJavaType1.getRawClass().getName() + ")");
    }
    return new SettableBeanProperty.ManagedReferenceProperty(str, paramSettableBeanProperty, paramDeserializationConfig, _forClass.getAnnotations(), bool);
  }
  
  protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject = paramSettableBeanProperty.getMember();
    if ((localObject != null) && (paramDeserializationConfig.getAnnotationIntrospector().shouldUnwrapProperty((AnnotatedMember)localObject) == Boolean.TRUE))
    {
      paramDeserializationConfig = paramSettableBeanProperty.getValueDeserializer();
      localObject = paramDeserializationConfig.unwrappingDeserializer();
      if ((localObject != paramDeserializationConfig) && (localObject != null)) {
        return paramSettableBeanProperty.withValueDeserializer((JsonDeserializer)localObject);
      }
    }
    return null;
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      paramJsonParser.nextToken();
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localJsonToken.ordinal()])
    {
    default: 
      throw paramDeserializationContext.mappingException(getBeanClass());
    case 1: 
      return deserializeFromString(paramJsonParser, paramDeserializationContext);
    case 2: 
      return deserializeFromNumber(paramJsonParser, paramDeserializationContext);
    case 3: 
      return deserializeFromDouble(paramJsonParser, paramDeserializationContext);
    case 4: 
      return paramJsonParser.getEmbeddedObject();
    case 5: 
    case 6: 
      return deserializeFromBoolean(paramJsonParser, paramDeserializationContext);
    case 7: 
      return deserializeFromArray(paramJsonParser, paramDeserializationContext);
    }
    return deserializeFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    if (_injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (_unwrappedPropertyHandler != null) {
      localObject2 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    do
    {
      return localObject2;
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
      }
      localObject2 = paramJsonParser.getCurrentToken();
      localObject1 = localObject2;
      if (localObject2 == JsonToken.START_OBJECT) {
        localObject1 = paramJsonParser.nextToken();
      }
      localObject2 = paramObject;
    } while (localObject1 != JsonToken.FIELD_NAME);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    Object localObject2 = _beanProperties.find((String)localObject1);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
        localObject1 = paramJsonParser.nextToken();
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
        continue;
      }
      if ((_ignorableProps != null) && (_ignorableProps.contains(localObject1))) {
        paramJsonParser.skipChildren();
      } else if (_anySetter != null) {
        _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
      } else {
        handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
      }
    }
  }
  
  public Object deserializeFromArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_delegateDeserializer != null) {
      try
      {
        paramJsonParser = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        if (_injectables != null) {
          injectValues(paramDeserializationContext, paramJsonParser);
        }
        return paramJsonParser;
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
      }
    }
    throw paramDeserializationContext.mappingException(getBeanClass());
  }
  
  public Object deserializeFromBoolean(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if ((_delegateDeserializer != null) && (!_valueInstantiator.canCreateFromBoolean()))
    {
      paramJsonParser = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      if (_injectables != null) {
        injectValues(paramDeserializationContext, paramJsonParser);
      }
      return paramJsonParser;
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_TRUE) {}
    for (boolean bool = true;; bool = false) {
      return _valueInstantiator.createFromBoolean(bool);
    }
  }
  
  public Object deserializeFromDouble(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getNumberType())
    {
    default: 
      if (_delegateDeserializer != null) {
        paramJsonParser = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      }
      break;
    case ???: 
    case ???: 
      Object localObject;
      do
      {
        return paramJsonParser;
        if ((_delegateDeserializer == null) || (_valueInstantiator.canCreateFromDouble())) {
          break;
        }
        localObject = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (_injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return _valueInstantiator.createFromDouble(paramJsonParser.getDoubleValue());
    }
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON floating-point number");
  }
  
  public Object deserializeFromNumber(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject;
    switch (paramJsonParser.getNumberType())
    {
    default: 
      if (_delegateDeserializer == null) {
        break label201;
      }
      localObject = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
      if (_injectables != null)
      {
        injectValues(paramDeserializationContext, localObject);
        paramJsonParser = (JsonParser)localObject;
      }
      break;
    }
    do
    {
      do
      {
        return paramJsonParser;
        if ((_delegateDeserializer == null) || (_valueInstantiator.canCreateFromInt())) {
          break;
        }
        localObject = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (_injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return _valueInstantiator.createFromInt(paramJsonParser.getIntValue());
      if ((_delegateDeserializer == null) || (_valueInstantiator.canCreateFromInt())) {
        break;
      }
      localObject = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
    } while (_injectables == null);
    injectValues(paramDeserializationContext, localObject);
    return localObject;
    return _valueInstantiator.createFromLong(paramJsonParser.getLongValue());
    label201:
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON integer number");
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_nonStandardCreation) {
      if (_unwrappedPropertyHandler != null) {
        localObject1 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext);
      }
      return deserializeFromObjectUsingNonDefault(paramJsonParser, paramDeserializationContext);
      localObject2 = _valueInstantiator.createUsingDefault();
      if (_injectables != null) {
        injectValues(paramDeserializationContext, localObject2);
      }
      localObject1 = localObject2;
    } while (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    SettableBeanProperty localSettableBeanProperty = _beanProperties.find((String)localObject1);
    if (localSettableBeanProperty != null) {}
    for (;;)
    {
      try
      {
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        paramJsonParser.nextToken();
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, localObject2, (String)localObject1, paramDeserializationContext);
        continue;
      }
      _handleUnknown(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
    }
  }
  
  protected Object deserializeFromObjectUsingNonDefault(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (_propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    if (_beanType.isAbstract()) {
      throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
    }
    throw JsonMappingException.from(paramJsonParser, "No suitable constructor found for type " + _beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
  }
  
  public Object deserializeFromString(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if ((_delegateDeserializer != null) && (!_valueInstantiator.canCreateFromString()))
    {
      paramJsonParser = _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      if (_injectables != null) {
        injectValues(paramDeserializationContext, paramJsonParser);
      }
      return paramJsonParser;
    }
    return _valueInstantiator.createFromString(paramJsonParser.getText());
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    ExternalTypeHandler localExternalTypeHandler = _externalTypeIdHandler.start();
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((SettableBeanProperty)localObject1).deserialize(paramJsonParser, paramDeserializationContext);
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getPropertyIndex(), localObject3))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
              continue;
              localObject2 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, _beanType.getRawClass(), str, paramDeserializationContext);
          }
        }
      }
      for (;;)
      {
        break;
        if (localObject3.getClass() != _beanType.getRawClass()) {
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject3);
        localObject2 = _beanProperties.find(str);
        if (localObject2 != null) {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject2, ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext));
        } else if (!localExternalTypeHandler.handleToken(paramJsonParser, paramDeserializationContext, str, null)) {
          if ((_ignorableProps != null) && (_ignorableProps.contains(str))) {
            paramJsonParser.skipChildren();
          } else if (_anySetter != null) {
            localPropertyValueBuffer.bufferAnyProperty(_anySetter, str, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          }
        }
      }
    }
    try
    {
      localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
      return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject2);
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    PropertyBasedCreator localPropertyBasedCreator = _propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((SettableBeanProperty)localObject1).deserialize(paramJsonParser, paramDeserializationContext);
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getPropertyIndex(), localObject3))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
              continue;
              localObject2 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, _beanType.getRawClass(), str, paramDeserializationContext);
          }
        }
      }
      for (;;)
      {
        break;
        localTokenBuffer.writeEndObject();
        if (localObject3.getClass() != _beanType.getRawClass()) {
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject3, localTokenBuffer);
        localObject2 = _beanProperties.find(str);
        if (localObject2 != null)
        {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject2, ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext));
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
        {
          paramJsonParser.skipChildren();
        }
        else
        {
          localTokenBuffer.writeFieldName(str);
          localTokenBuffer.copyCurrentStructure(paramJsonParser);
          if (_anySetter != null) {
            localPropertyValueBuffer.bufferAnyProperty(_anySetter, str, _anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          }
        }
      }
    }
    try
    {
      localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
      return _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject2, localTokenBuffer);
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, _valueInstantiator.createUsingDefault());
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    ExternalTypeHandler localExternalTypeHandler = _externalTypeIdHandler.start();
    if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = _beanProperties.find(str);
      if (localSettableBeanProperty != null) {
        if (paramJsonParser.getCurrentToken().isScalarValue()) {
          localExternalTypeHandler.handleTypePropertyValue(paramJsonParser, paramDeserializationContext, str, paramObject);
        }
      }
      for (;;)
      {
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
          paramJsonParser.nextToken();
        }
        catch (Exception localException1)
        {
          wrapAndThrow(localException1, paramObject, str, paramDeserializationContext);
          continue;
        }
        if ((_ignorableProps != null) && (_ignorableProps.contains(str))) {
          paramJsonParser.skipChildren();
        } else if (!localExternalTypeHandler.handleToken(paramJsonParser, paramDeserializationContext, str, paramObject)) {
          if (_anySetter != null) {
            try
            {
              _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, str);
            }
            catch (Exception localException2)
            {
              wrapAndThrow(localException2, paramObject, str, paramDeserializationContext);
            }
          } else {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
          }
        }
      }
    }
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(_delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(paramJsonParser, paramDeserializationContext);
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject = _valueInstantiator.createUsingDefault();
    if (_injectables != null) {
      injectValues(paramDeserializationContext, localObject);
    }
    if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = _beanProperties.find(str);
      if (localSettableBeanProperty != null) {}
      for (;;)
      {
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject);
          paramJsonParser.nextToken();
        }
        catch (Exception localException1)
        {
          wrapAndThrow(localException1, localObject, str, paramDeserializationContext);
          continue;
        }
        if ((_ignorableProps != null) && (_ignorableProps.contains(str)))
        {
          paramJsonParser.skipChildren();
        }
        else
        {
          localTokenBuffer.writeFieldName(str);
          localTokenBuffer.copyCurrentStructure(paramJsonParser);
          if (_anySetter != null) {
            try
            {
              _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject, str);
            }
            catch (Exception localException2)
            {
              wrapAndThrow(localException2, localObject, str, paramDeserializationContext);
            }
          }
        }
      }
    }
    localTokenBuffer.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject, localTokenBuffer);
    return localObject;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    localObject2 = new TokenBuffer(paramJsonParser.getCodec());
    ((TokenBuffer)localObject2).writeStartObject();
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      SettableBeanProperty localSettableBeanProperty = _beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localSettableBeanProperty != null) {}
      for (;;)
      {
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
          localObject1 = paramJsonParser.nextToken();
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
          continue;
        }
        if ((_ignorableProps != null) && (_ignorableProps.contains(localObject1)))
        {
          paramJsonParser.skipChildren();
        }
        else
        {
          ((TokenBuffer)localObject2).writeFieldName((String)localObject1);
          ((TokenBuffer)localObject2).copyCurrentStructure(paramJsonParser);
          if (_anySetter != null) {
            _anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
          }
        }
      }
    }
    ((TokenBuffer)localObject2).writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, (TokenBuffer)localObject2);
    return paramObject;
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (_backRefs == null) {
      return null;
    }
    return (SettableBeanProperty)_backRefs.get(paramString);
  }
  
  public final Class<?> getBeanClass()
  {
    return _beanType.getRawClass();
  }
  
  public int getPropertyCount()
  {
    return _beanProperties.size();
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return _valueInstantiator;
  }
  
  public JavaType getValueType()
  {
    return _beanType;
  }
  
  protected Object handlePolymorphic(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    JsonDeserializer localJsonDeserializer = _findSubclassDeserializer(paramDeserializationContext, paramObject, paramTokenBuffer);
    if (localJsonDeserializer != null)
    {
      localObject = paramObject;
      if (paramTokenBuffer != null)
      {
        paramTokenBuffer.writeEndObject();
        paramTokenBuffer = paramTokenBuffer.asParser();
        paramTokenBuffer.nextToken();
        localObject = localJsonDeserializer.deserialize(paramTokenBuffer, paramDeserializationContext, paramObject);
      }
      paramObject = localObject;
      if (paramJsonParser != null) {
        paramObject = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext, localObject);
      }
      return paramObject;
    }
    Object localObject = paramObject;
    if (paramTokenBuffer != null) {
      localObject = handleUnknownProperties(paramDeserializationContext, paramObject, paramTokenBuffer);
    }
    paramObject = localObject;
    if (paramJsonParser != null) {
      paramObject = deserialize(paramJsonParser, paramDeserializationContext, localObject);
    }
    return paramObject;
  }
  
  protected Object handleUnknownProperties(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    paramTokenBuffer.writeEndObject();
    paramTokenBuffer = paramTokenBuffer.asParser();
    while (paramTokenBuffer.nextToken() != JsonToken.END_OBJECT)
    {
      String str = paramTokenBuffer.getCurrentName();
      paramTokenBuffer.nextToken();
      handleUnknownProperty(paramTokenBuffer, paramDeserializationContext, paramObject, str);
    }
    return paramObject;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    if ((_ignoreAllUnknown) || ((_ignorableProps != null) && (_ignorableProps.contains(paramString))))
    {
      paramJsonParser.skipChildren();
      return;
    }
    super.handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, paramString);
  }
  
  public boolean hasProperty(String paramString)
  {
    return _beanProperties.find(paramString) != null;
  }
  
  protected void injectValues(DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    ValueInjector[] arrayOfValueInjector = _injectables;
    int j = arrayOfValueInjector.length;
    int i = 0;
    while (i < j)
    {
      arrayOfValueInjector[i].inject(paramDeserializationContext, paramObject);
      i += 1;
    }
  }
  
  public Iterator<SettableBeanProperty> properties()
  {
    if (_beanProperties == null) {
      throw new IllegalStateException("Can only call before BeanDeserializer has been resolved");
    }
    return _beanProperties.allProperties();
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
    throws JsonMappingException
  {
    Iterator localIterator = _beanProperties.allProperties();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2;
    Object localObject4;
    while (localIterator.hasNext())
    {
      Object localObject5 = (SettableBeanProperty)localIterator.next();
      localObject2 = localObject5;
      localObject4 = localObject2;
      if (!((SettableBeanProperty)localObject2).hasValueDeserializer()) {
        localObject4 = ((SettableBeanProperty)localObject2).withValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, ((SettableBeanProperty)localObject2).getType(), (BeanProperty)localObject2));
      }
      localObject4 = _resolveManagedReferenceProperty(paramDeserializationConfig, (SettableBeanProperty)localObject4);
      SettableBeanProperty localSettableBeanProperty = _resolveUnwrappedProperty(paramDeserializationConfig, (SettableBeanProperty)localObject4);
      localObject2 = localObject1;
      if (localSettableBeanProperty != null)
      {
        localObject4 = localSettableBeanProperty;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new UnwrappedPropertyHandler();
        }
        ((UnwrappedPropertyHandler)localObject2).addProperty((SettableBeanProperty)localObject4);
      }
      localObject4 = _resolveInnerClassValuedProperty(paramDeserializationConfig, (SettableBeanProperty)localObject4);
      if (localObject4 != localObject5) {
        _beanProperties.replace((SettableBeanProperty)localObject4);
      }
      localObject1 = localObject2;
      if (((SettableBeanProperty)localObject4).hasValueTypeDeserializer())
      {
        localObject5 = ((SettableBeanProperty)localObject4).getValueTypeDeserializer();
        localObject1 = localObject2;
        if (((TypeDeserializer)localObject5).getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY)
        {
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new ExternalTypeHandler.Builder();
          }
          ((ExternalTypeHandler.Builder)localObject1).addExternal((SettableBeanProperty)localObject4, ((TypeDeserializer)localObject5).getPropertyName());
          _beanProperties.remove((SettableBeanProperty)localObject4);
          localObject3 = localObject1;
          localObject1 = localObject2;
        }
      }
    }
    if ((_anySetter != null) && (!_anySetter.hasValueDeserializer())) {
      _anySetter = _anySetter.withValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, _anySetter.getType(), _anySetter.getProperty()));
    }
    if (_valueInstantiator.canCreateUsingDelegate())
    {
      localObject2 = _valueInstantiator.getDelegateType();
      if (localObject2 == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + _beanType + ": value instantiator (" + _valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      localObject4 = _valueInstantiator.getDelegateCreator();
      _delegateDeserializer = findDeserializer(paramDeserializationConfig, paramDeserializerProvider, (JavaType)localObject2, new BeanProperty.Std(null, (JavaType)localObject2, _forClass.getAnnotations(), (AnnotatedMember)localObject4));
    }
    if (_propertyBasedCreator != null)
    {
      localObject2 = _propertyBasedCreator.getCreatorProperties().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (SettableBeanProperty)((Iterator)localObject2).next();
        if (!((SettableBeanProperty)localObject4).hasValueDeserializer()) {
          _propertyBasedCreator.assignDeserializer((SettableBeanProperty)localObject4, findDeserializer(paramDeserializationConfig, paramDeserializerProvider, ((SettableBeanProperty)localObject4).getType(), (BeanProperty)localObject4));
        }
      }
    }
    if (localObject3 != null)
    {
      _externalTypeIdHandler = ((ExternalTypeHandler.Builder)localObject3).build();
      _nonStandardCreation = true;
    }
    _unwrappedPropertyHandler = ((UnwrappedPropertyHandler)localObject1);
    if (localObject1 != null) {
      _nonStandardCreation = true;
    }
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer()
  {
    if (getClass() != BeanDeserializer.class) {
      return this;
    }
    return new BeanDeserializer(this, true);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt)
    throws IOException
  {
    wrapAndThrow(paramThrowable, paramObject, paramInt, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramInt);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString)
    throws IOException
  {
    wrapAndThrow(paramThrowable, paramObject, paramString, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramString);
  }
  
  protected void wrapInstantiationProblem(Throwable paramThrowable, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    throw paramDeserializationContext.instantiationException(_beanType.getRawClass(), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.deser.BeanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */