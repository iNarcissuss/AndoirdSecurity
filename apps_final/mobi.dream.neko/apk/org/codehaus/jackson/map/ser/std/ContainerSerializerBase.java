package org.codehaus.jackson.map.ser.std;

import org.codehaus.jackson.map.TypeSerializer;

public abstract class ContainerSerializerBase<T>
  extends SerializerBase<T>
{
  protected ContainerSerializerBase(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected ContainerSerializerBase(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public abstract ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  public ContainerSerializerBase<?> withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer == null) {
      return this;
    }
    return _withValueTypeSerializer(paramTypeSerializer);
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.ser.std.ContainerSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */