package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.node.ObjectNode;

@JacksonStdImpl
public final class StdArraySerializers$CharArraySerializer
  extends SerializerBase<char[]>
{
  public StdArraySerializers$CharArraySerializer()
  {
    super(char[].class);
  }
  
  private final void _writeArrayContents(JsonGenerator paramJsonGenerator, char[] paramArrayOfChar)
    throws IOException, JsonGenerationException
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      paramJsonGenerator.writeString(paramArrayOfChar, i, 1);
      i += 1;
    }
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    paramSerializerProvider = createSchemaNode("array", true);
    paramType = createSchemaNode("string");
    paramType.put("type", "string");
    paramSerializerProvider.put("items", paramType);
    return paramSerializerProvider;
  }
  
  public void serialize(char[] paramArrayOfChar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      paramJsonGenerator.writeStartArray();
      _writeArrayContents(paramJsonGenerator, paramArrayOfChar);
      paramJsonGenerator.writeEndArray();
      return;
    }
    paramJsonGenerator.writeString(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void serializeWithType(char[] paramArrayOfChar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonGenerationException
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      paramTypeSerializer.writeTypePrefixForArray(paramArrayOfChar, paramJsonGenerator);
      _writeArrayContents(paramJsonGenerator, paramArrayOfChar);
      paramTypeSerializer.writeTypeSuffixForArray(paramArrayOfChar, paramJsonGenerator);
      return;
    }
    paramTypeSerializer.writeTypePrefixForScalar(paramArrayOfChar, paramJsonGenerator);
    paramJsonGenerator.writeString(paramArrayOfChar, 0, paramArrayOfChar.length);
    paramTypeSerializer.writeTypeSuffixForScalar(paramArrayOfChar, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.ser.std.StdArraySerializers.CharArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */