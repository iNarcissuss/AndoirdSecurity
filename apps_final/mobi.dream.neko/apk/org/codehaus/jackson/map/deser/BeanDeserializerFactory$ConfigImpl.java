package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializerFactory.Config;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.util.ArrayBuilders;

public class BeanDeserializerFactory$ConfigImpl
  extends DeserializerFactory.Config
{
  protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
  protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
  protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
  protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
  protected final AbstractTypeResolver[] _abstractTypeResolvers;
  protected final Deserializers[] _additionalDeserializers;
  protected final KeyDeserializers[] _additionalKeyDeserializers;
  protected final BeanDeserializerModifier[] _modifiers;
  protected final ValueInstantiators[] _valueInstantiators;
  
  public BeanDeserializerFactory$ConfigImpl()
  {
    this(null, null, null, null, null);
  }
  
  protected BeanDeserializerFactory$ConfigImpl(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver, ValueInstantiators[] paramArrayOfValueInstantiators)
  {
    Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
    if (paramArrayOfDeserializers == null) {
      arrayOfDeserializers = BeanDeserializerFactory.access$000();
    }
    _additionalDeserializers = arrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfKeyDeserializers;
    if (paramArrayOfKeyDeserializers == null) {
      paramArrayOfDeserializers = NO_KEY_DESERIALIZERS;
    }
    _additionalKeyDeserializers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfBeanDeserializerModifier;
    if (paramArrayOfBeanDeserializerModifier == null) {
      paramArrayOfDeserializers = NO_MODIFIERS;
    }
    _modifiers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfAbstractTypeResolver;
    if (paramArrayOfAbstractTypeResolver == null) {
      paramArrayOfDeserializers = NO_ABSTRACT_TYPE_RESOLVERS;
    }
    _abstractTypeResolvers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfValueInstantiators;
    if (paramArrayOfValueInstantiators == null) {
      paramArrayOfDeserializers = NO_VALUE_INSTANTIATORS;
    }
    _valueInstantiators = paramArrayOfDeserializers;
  }
  
  public Iterable<AbstractTypeResolver> abstractTypeResolvers()
  {
    return ArrayBuilders.arrayAsIterable(_abstractTypeResolvers);
  }
  
  public Iterable<BeanDeserializerModifier> deserializerModifiers()
  {
    return ArrayBuilders.arrayAsIterable(_modifiers);
  }
  
  public Iterable<Deserializers> deserializers()
  {
    return ArrayBuilders.arrayAsIterable(_additionalDeserializers);
  }
  
  public boolean hasAbstractTypeResolvers()
  {
    return _abstractTypeResolvers.length > 0;
  }
  
  public boolean hasDeserializerModifiers()
  {
    return _modifiers.length > 0;
  }
  
  public boolean hasDeserializers()
  {
    return _additionalDeserializers.length > 0;
  }
  
  public boolean hasKeyDeserializers()
  {
    return _additionalKeyDeserializers.length > 0;
  }
  
  public boolean hasValueInstantiators()
  {
    return _valueInstantiators.length > 0;
  }
  
  public Iterable<KeyDeserializers> keyDeserializers()
  {
    return ArrayBuilders.arrayAsIterable(_additionalKeyDeserializers);
  }
  
  public Iterable<ValueInstantiators> valueInstantiators()
  {
    return ArrayBuilders.arrayAsIterable(_valueInstantiators);
  }
  
  public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    if (paramAbstractTypeResolver == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramAbstractTypeResolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(_abstractTypeResolvers, paramAbstractTypeResolver);
    return new ConfigImpl(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, paramAbstractTypeResolver, _valueInstantiators);
  }
  
  public DeserializerFactory.Config withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    if (paramDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null Deserializers");
    }
    return new ConfigImpl((Deserializers[])ArrayBuilders.insertInListNoDup(_additionalDeserializers, paramDeserializers), _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    if (paramKeyDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null KeyDeserializers");
    }
    paramKeyDeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(_additionalKeyDeserializers, paramKeyDeserializers);
    return new ConfigImpl(_additionalDeserializers, paramKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    if (paramBeanDeserializerModifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    paramBeanDeserializerModifier = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, paramBeanDeserializerModifier);
    return new ConfigImpl(_additionalDeserializers, _additionalKeyDeserializers, paramBeanDeserializerModifier, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactory.Config withValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    if (paramValueInstantiators == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramValueInstantiators = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(_valueInstantiators, paramValueInstantiators);
    return new ConfigImpl(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, paramValueInstantiators);
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.deser.BeanDeserializerFactory.ConfigImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */