package com.millennialmedia.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$2
  extends UnsafeAllocator
{
  UnsafeAllocator$2(Method paramMethod) {}
  
  public final <T> T newInstance(Class<T> paramClass)
  {
    return (T)val$newInstance.invoke(null, new Object[] { paramClass, Object.class });
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.google.gson.internal.UnsafeAllocator.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */