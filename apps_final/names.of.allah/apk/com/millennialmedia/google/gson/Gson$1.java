package com.millennialmedia.google.gson;

import java.lang.reflect.Type;

class Gson$1
  implements JsonDeserializationContext
{
  Gson$1(Gson paramGson) {}
  
  public <T> T deserialize(JsonElement paramJsonElement, Type paramType)
  {
    return (T)this$0.fromJson(paramJsonElement, paramType);
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.google.gson.Gson.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */