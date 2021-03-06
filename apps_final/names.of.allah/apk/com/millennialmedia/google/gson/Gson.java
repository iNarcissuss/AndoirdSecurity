package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.internal.Excluder;
import com.millennialmedia.google.gson.internal.Primitives;
import com.millennialmedia.google.gson.internal.Streams;
import com.millennialmedia.google.gson.internal.bind.ArrayTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.DateTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.JsonTreeReader;
import com.millennialmedia.google.gson.internal.bind.JsonTreeWriter;
import com.millennialmedia.google.gson.internal.bind.MapTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.ObjectTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.millennialmedia.google.gson.internal.bind.SqlDateTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.TimeTypeAdapter;
import com.millennialmedia.google.gson.internal.bind.TypeAdapters;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import com.millennialmedia.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Gson
{
  static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
  private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
  private final ThreadLocal<Map<TypeToken<?>, Gson.FutureTypeAdapter<?>>> calls = new ThreadLocal();
  private final ConstructorConstructor constructorConstructor;
  final JsonDeserializationContext deserializationContext = new Gson.1(this);
  private final List<TypeAdapterFactory> factories;
  private final boolean generateNonExecutableJson;
  private final boolean htmlSafe;
  private final boolean prettyPrinting;
  final JsonSerializationContext serializationContext = new Gson.2(this);
  private final boolean serializeNulls;
  private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache = Collections.synchronizedMap(new HashMap());
  
  public Gson()
  {
    this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
  }
  
  Gson(Excluder paramExcluder, FieldNamingStrategy paramFieldNamingStrategy, Map<Type, InstanceCreator<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, LongSerializationPolicy paramLongSerializationPolicy, List<TypeAdapterFactory> paramList)
  {
    constructorConstructor = new ConstructorConstructor(paramMap);
    serializeNulls = paramBoolean1;
    generateNonExecutableJson = paramBoolean3;
    htmlSafe = paramBoolean4;
    prettyPrinting = paramBoolean5;
    paramMap = new ArrayList();
    paramMap.add(TypeAdapters.JSON_ELEMENT_FACTORY);
    paramMap.add(ObjectTypeAdapter.FACTORY);
    paramMap.add(paramExcluder);
    paramMap.addAll(paramList);
    paramMap.add(TypeAdapters.STRING_FACTORY);
    paramMap.add(TypeAdapters.INTEGER_FACTORY);
    paramMap.add(TypeAdapters.BOOLEAN_FACTORY);
    paramMap.add(TypeAdapters.BYTE_FACTORY);
    paramMap.add(TypeAdapters.SHORT_FACTORY);
    paramMap.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter(paramLongSerializationPolicy)));
    paramMap.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(paramBoolean6)));
    paramMap.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(paramBoolean6)));
    paramMap.add(TypeAdapters.NUMBER_FACTORY);
    paramMap.add(TypeAdapters.CHARACTER_FACTORY);
    paramMap.add(TypeAdapters.STRING_BUILDER_FACTORY);
    paramMap.add(TypeAdapters.STRING_BUFFER_FACTORY);
    paramMap.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
    paramMap.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
    paramMap.add(TypeAdapters.URL_FACTORY);
    paramMap.add(TypeAdapters.URI_FACTORY);
    paramMap.add(TypeAdapters.UUID_FACTORY);
    paramMap.add(TypeAdapters.LOCALE_FACTORY);
    paramMap.add(TypeAdapters.INET_ADDRESS_FACTORY);
    paramMap.add(TypeAdapters.BIT_SET_FACTORY);
    paramMap.add(DateTypeAdapter.FACTORY);
    paramMap.add(TypeAdapters.CALENDAR_FACTORY);
    paramMap.add(TimeTypeAdapter.FACTORY);
    paramMap.add(SqlDateTypeAdapter.FACTORY);
    paramMap.add(TypeAdapters.TIMESTAMP_FACTORY);
    paramMap.add(ArrayTypeAdapter.FACTORY);
    paramMap.add(TypeAdapters.ENUM_FACTORY);
    paramMap.add(TypeAdapters.CLASS_FACTORY);
    paramMap.add(new CollectionTypeAdapterFactory(constructorConstructor));
    paramMap.add(new MapTypeAdapterFactory(constructorConstructor, paramBoolean2));
    paramMap.add(new ReflectiveTypeAdapterFactory(constructorConstructor, paramFieldNamingStrategy, paramExcluder));
    factories = Collections.unmodifiableList(paramMap);
  }
  
  private static void assertFullConsumption(Object paramObject, JsonReader paramJsonReader)
  {
    if (paramObject != null) {
      try
      {
        if (paramJsonReader.peek() != JsonToken.END_DOCUMENT) {
          throw new JsonIOException("JSON document was not fully consumed.");
        }
      }
      catch (MalformedJsonException paramObject)
      {
        throw new JsonSyntaxException((Throwable)paramObject);
      }
      catch (IOException paramObject)
      {
        throw new JsonIOException((Throwable)paramObject);
      }
    }
  }
  
  private void checkValidFloatingPoint(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }
  }
  
  private TypeAdapter<Number> doubleAdapter(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TypeAdapters.DOUBLE;
    }
    return new Gson.3(this);
  }
  
  private TypeAdapter<Number> floatAdapter(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TypeAdapters.FLOAT;
    }
    return new Gson.4(this);
  }
  
  private TypeAdapter<Number> longAdapter(LongSerializationPolicy paramLongSerializationPolicy)
  {
    if (paramLongSerializationPolicy == LongSerializationPolicy.DEFAULT) {
      return TypeAdapters.LONG;
    }
    return new Gson.5(this);
  }
  
  private JsonWriter newJsonWriter(Writer paramWriter)
  {
    if (generateNonExecutableJson) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new JsonWriter(paramWriter);
    if (prettyPrinting) {
      paramWriter.setIndent("  ");
    }
    paramWriter.setSerializeNulls(serializeNulls);
    return paramWriter;
  }
  
  public final <T> T fromJson(JsonElement paramJsonElement, Class<T> paramClass)
  {
    paramJsonElement = fromJson(paramJsonElement, paramClass);
    return (T)Primitives.wrap(paramClass).cast(paramJsonElement);
  }
  
  public final <T> T fromJson(JsonElement paramJsonElement, Type paramType)
  {
    if (paramJsonElement == null) {
      return null;
    }
    return (T)fromJson(new JsonTreeReader(paramJsonElement), paramType);
  }
  
  /* Error */
  public final <T> T fromJson(JsonReader paramJsonReader, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 402	com/millennialmedia/google/gson/stream/JsonReader:isLenient	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 405	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   13: aload_1
    //   14: invokevirtual 281	com/millennialmedia/google/gson/stream/JsonReader:peek	()Lcom/millennialmedia/google/gson/stream/JsonToken;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 411	com/millennialmedia/google/gson/reflect/TypeToken:get	(Ljava/lang/reflect/Type;)Lcom/millennialmedia/google/gson/reflect/TypeToken;
    //   25: invokevirtual 415	com/millennialmedia/google/gson/Gson:getAdapter	(Lcom/millennialmedia/google/gson/reflect/TypeToken;)Lcom/millennialmedia/google/gson/TypeAdapter;
    //   28: aload_1
    //   29: invokevirtual 421	com/millennialmedia/google/gson/TypeAdapter:read	(Lcom/millennialmedia/google/gson/stream/JsonReader;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 405	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: iload_3
    //   43: ifeq +11 -> 54
    //   46: aload_1
    //   47: iload 4
    //   49: invokevirtual 405	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 296	com/millennialmedia/google/gson/JsonSyntaxException
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 299	com/millennialmedia/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: iload 4
    //   67: invokevirtual 405	com/millennialmedia/google/gson/stream/JsonReader:setLenient	(Z)V
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: new 296	com/millennialmedia/google/gson/JsonSyntaxException
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 299	com/millennialmedia/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   81: athrow
    //   82: astore_2
    //   83: new 296	com/millennialmedia/google/gson/JsonSyntaxException
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 299	com/millennialmedia/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	Gson
    //   0	92	1	paramJsonReader	JsonReader
    //   0	92	2	paramType	Type
    //   1	42	3	i	int
    //   6	60	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	java/io/EOFException
    //   20	33	41	java/io/EOFException
    //   13	18	63	finally
    //   20	33	63	finally
    //   54	63	63	finally
    //   73	82	63	finally
    //   83	92	63	finally
    //   13	18	72	java/lang/IllegalStateException
    //   20	33	72	java/lang/IllegalStateException
    //   13	18	82	java/io/IOException
    //   20	33	82	java/io/IOException
  }
  
  public final <T> T fromJson(Reader paramReader, Class<T> paramClass)
  {
    paramReader = new JsonReader(paramReader);
    Object localObject = fromJson(paramReader, paramClass);
    assertFullConsumption(localObject, paramReader);
    return (T)Primitives.wrap(paramClass).cast(localObject);
  }
  
  public final <T> T fromJson(Reader paramReader, Type paramType)
  {
    paramReader = new JsonReader(paramReader);
    paramType = fromJson(paramReader, paramType);
    assertFullConsumption(paramType, paramReader);
    return paramType;
  }
  
  public final <T> T fromJson(String paramString, Class<T> paramClass)
  {
    paramString = fromJson(paramString, paramClass);
    return (T)Primitives.wrap(paramClass).cast(paramString);
  }
  
  public final <T> T fromJson(String paramString, Type paramType)
  {
    if (paramString == null) {
      return null;
    }
    return (T)fromJson(new StringReader(paramString), paramType);
  }
  
  public final <T> TypeAdapter<T> getAdapter(TypeToken<T> paramTypeToken)
  {
    Object localObject1 = (TypeAdapter)typeTokenCache.get(paramTypeToken);
    if (localObject1 != null) {
      return (TypeAdapter<T>)localObject1;
    }
    Object localObject3 = (Map)calls.get();
    int i = 0;
    if (localObject3 == null)
    {
      localObject3 = new HashMap();
      calls.set(localObject3);
      i = 1;
    }
    for (;;)
    {
      Object localObject4 = (Gson.FutureTypeAdapter)((Map)localObject3).get(paramTypeToken);
      localObject1 = localObject4;
      if (localObject4 != null) {
        break;
      }
      try
      {
        localObject1 = new Gson.FutureTypeAdapter();
        ((Map)localObject3).put(paramTypeToken, localObject1);
        Iterator localIterator = factories.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject4 = ((TypeAdapterFactory)localIterator.next()).create(this, paramTypeToken);
            if (localObject4 != null)
            {
              ((Gson.FutureTypeAdapter)localObject1).setDelegate((TypeAdapter)localObject4);
              typeTokenCache.put(paramTypeToken, localObject4);
              ((Map)localObject3).remove(paramTypeToken);
              localObject1 = localObject4;
              if (i == 0) {
                break;
              }
              calls.remove();
              return (TypeAdapter<T>)localObject4;
            }
          }
        }
        throw new IllegalArgumentException("GSON cannot handle " + paramTypeToken);
      }
      finally
      {
        ((Map)localObject3).remove(paramTypeToken);
        if (i != 0) {
          calls.remove();
        }
      }
    }
  }
  
  public final <T> TypeAdapter<T> getAdapter(Class<T> paramClass)
  {
    return getAdapter(TypeToken.get(paramClass));
  }
  
  public final <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory paramTypeAdapterFactory, TypeToken<T> paramTypeToken)
  {
    Iterator localIterator = factories.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (TypeAdapterFactory)localIterator.next();
      if (i == 0)
      {
        if (localObject == paramTypeAdapterFactory) {
          i = 1;
        }
      }
      else
      {
        localObject = ((TypeAdapterFactory)localObject).create(this, paramTypeToken);
        if (localObject != null) {
          return (TypeAdapter<T>)localObject;
        }
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize " + paramTypeToken);
  }
  
  public final String toJson(JsonElement paramJsonElement)
  {
    StringWriter localStringWriter = new StringWriter();
    toJson(paramJsonElement, localStringWriter);
    return localStringWriter.toString();
  }
  
  public final String toJson(Object paramObject)
  {
    if (paramObject == null) {
      return toJson(JsonNull.INSTANCE);
    }
    return toJson(paramObject, paramObject.getClass());
  }
  
  public final String toJson(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    toJson(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public final void toJson(JsonElement paramJsonElement, JsonWriter paramJsonWriter)
  {
    boolean bool1 = paramJsonWriter.isLenient();
    paramJsonWriter.setLenient(true);
    boolean bool2 = paramJsonWriter.isHtmlSafe();
    paramJsonWriter.setHtmlSafe(htmlSafe);
    boolean bool3 = paramJsonWriter.getSerializeNulls();
    paramJsonWriter.setSerializeNulls(serializeNulls);
    try
    {
      Streams.write(paramJsonElement, paramJsonWriter);
      return;
    }
    catch (IOException paramJsonElement)
    {
      throw new JsonIOException(paramJsonElement);
    }
    finally
    {
      paramJsonWriter.setLenient(bool1);
      paramJsonWriter.setHtmlSafe(bool2);
      paramJsonWriter.setSerializeNulls(bool3);
    }
  }
  
  public final void toJson(JsonElement paramJsonElement, Appendable paramAppendable)
  {
    try
    {
      toJson(paramJsonElement, newJsonWriter(Streams.writerForAppendable(paramAppendable)));
      return;
    }
    catch (IOException paramJsonElement)
    {
      throw new RuntimeException(paramJsonElement);
    }
  }
  
  public final void toJson(Object paramObject, Appendable paramAppendable)
  {
    if (paramObject != null)
    {
      toJson(paramObject, paramObject.getClass(), paramAppendable);
      return;
    }
    toJson(JsonNull.INSTANCE, paramAppendable);
  }
  
  public final void toJson(Object paramObject, Type paramType, JsonWriter paramJsonWriter)
  {
    paramType = getAdapter(TypeToken.get(paramType));
    boolean bool1 = paramJsonWriter.isLenient();
    paramJsonWriter.setLenient(true);
    boolean bool2 = paramJsonWriter.isHtmlSafe();
    paramJsonWriter.setHtmlSafe(htmlSafe);
    boolean bool3 = paramJsonWriter.getSerializeNulls();
    paramJsonWriter.setSerializeNulls(serializeNulls);
    try
    {
      paramType.write(paramJsonWriter, paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      throw new JsonIOException((Throwable)paramObject);
    }
    finally
    {
      paramJsonWriter.setLenient(bool1);
      paramJsonWriter.setHtmlSafe(bool2);
      paramJsonWriter.setSerializeNulls(bool3);
    }
  }
  
  public final void toJson(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      toJson(paramObject, paramType, newJsonWriter(Streams.writerForAppendable(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new JsonIOException((Throwable)paramObject);
    }
  }
  
  public final JsonElement toJsonTree(Object paramObject)
  {
    if (paramObject == null) {
      return JsonNull.INSTANCE;
    }
    return toJsonTree(paramObject, paramObject.getClass());
  }
  
  public final JsonElement toJsonTree(Object paramObject, Type paramType)
  {
    JsonTreeWriter localJsonTreeWriter = new JsonTreeWriter();
    toJson(paramObject, paramType, localJsonTreeWriter);
    return localJsonTreeWriter.get();
  }
  
  public final String toString()
  {
    return "{serializeNulls:" + serializeNulls + "factories:" + factories + ",instanceCreators:" + constructorConstructor + "}";
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.google.gson.Gson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */