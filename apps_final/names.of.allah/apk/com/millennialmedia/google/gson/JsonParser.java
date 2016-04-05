package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser
{
  /* Error */
  public final JsonElement parse(JsonReader paramJsonReader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 21	com/millennialmedia/google/gson/stream/JsonReader:isLenient	()Z
    //   4: istore_3
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 25	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   10: aload_1
    //   11: invokestatic 29	com/millennialmedia/google/gson/internal/Streams:parse	(Lcom/millennialmedia/google/gson/stream/JsonReader;)Lcom/millennialmedia/google/gson/JsonElement;
    //   14: astore_2
    //   15: aload_1
    //   16: iload_3
    //   17: invokevirtual 25	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: new 31	com/millennialmedia/google/gson/JsonParseException
    //   26: dup
    //   27: new 33	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 35
    //   33: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 44
    //   42: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aload_2
    //   49: invokespecial 54	com/millennialmedia/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: astore_2
    //   54: aload_1
    //   55: iload_3
    //   56: invokevirtual 25	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   59: aload_2
    //   60: athrow
    //   61: astore_2
    //   62: new 31	com/millennialmedia/google/gson/JsonParseException
    //   65: dup
    //   66: new 33	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 35
    //   72: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc 44
    //   81: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aload_2
    //   88: invokespecial 54	com/millennialmedia/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	JsonParser
    //   0	92	1	paramJsonReader	JsonReader
    //   14	7	2	localJsonElement	JsonElement
    //   22	27	2	localStackOverflowError	StackOverflowError
    //   53	7	2	localObject	Object
    //   61	27	2	localOutOfMemoryError	OutOfMemoryError
    //   4	52	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	15	22	java/lang/StackOverflowError
    //   10	15	53	finally
    //   23	53	53	finally
    //   62	92	53	finally
    //   10	15	61	java/lang/OutOfMemoryError
  }
  
  public final JsonElement parse(Reader paramReader)
  {
    JsonElement localJsonElement;
    try
    {
      paramReader = new JsonReader(paramReader);
      localJsonElement = parse(paramReader);
      if ((!localJsonElement.isJsonNull()) && (paramReader.peek() != JsonToken.END_DOCUMENT)) {
        throw new JsonSyntaxException("Did not consume the entire document.");
      }
    }
    catch (MalformedJsonException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new JsonIOException(paramReader);
    }
    catch (NumberFormatException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    return localJsonElement;
  }
  
  public final JsonElement parse(String paramString)
  {
    return parse(new StringReader(paramString));
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.google.gson.JsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */