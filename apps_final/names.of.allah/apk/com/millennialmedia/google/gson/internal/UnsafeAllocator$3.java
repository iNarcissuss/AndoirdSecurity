package com.millennialmedia.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$3
  extends UnsafeAllocator
{
  UnsafeAllocator$3(Method paramMethod, int paramInt) {}
  
  public final <T> T newInstance(Class<T> paramClass)
  {
    return (T)val$newInstance.invoke(null, new Object[] { paramClass, Integer.valueOf(val$constructorId) });
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.google.gson.internal.UnsafeAllocator.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */