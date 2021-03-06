package org.codehaus.jackson.map.ser;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.impl.UnwrappingBeanSerializer;
import org.codehaus.jackson.map.ser.std.BeanSerializerBase;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializer
  extends BeanSerializerBase
{
  public BeanSerializer(Class<?> paramClass, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramClass, paramArrayOfBeanPropertyWriter1, paramArrayOfBeanPropertyWriter2, paramAnyGetterWriter, paramObject);
  }
  
  protected BeanSerializer(BeanSerializer paramBeanSerializer)
  {
    super(paramBeanSerializer);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase)
  {
    super(paramBeanSerializerBase);
  }
  
  public BeanSerializer(JavaType paramJavaType, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramJavaType, paramArrayOfBeanPropertyWriter1, paramArrayOfBeanPropertyWriter2, paramAnyGetterWriter, paramObject);
  }
  
  public static BeanSerializer createDummy(Class<?> paramClass)
  {
    return new BeanSerializer(paramClass, NO_PROPS, null, null, null);
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeStartObject();
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      paramJsonGenerator.writeEndObject();
      return;
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public String toString()
  {
    return "BeanSerializer for " + handledType().getName();
  }
  
  public JsonSerializer<Object> unwrappingSerializer()
  {
    return new UnwrappingBeanSerializer(this);
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.ser.BeanSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */