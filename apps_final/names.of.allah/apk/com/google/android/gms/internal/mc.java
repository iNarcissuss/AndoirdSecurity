package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class mc<M extends mb<M>, T>
{
  protected final Class<T> amV;
  protected final boolean amW;
  protected final int tag;
  protected final int type;
  
  private mc(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    type = paramInt1;
    amV = paramClass;
    tag = paramInt2;
    amW = paramBoolean;
  }
  
  public static <M extends mb<M>, T extends mf> mc<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new mc(paramInt1, paramClass, paramInt2, false);
  }
  
  protected void a(mh parammh, List<Object> paramList)
  {
    paramList.add(u(lz.p(amZ)));
  }
  
  protected boolean eM(int paramInt)
  {
    return paramInt == tag;
  }
  
  final T i(List<mh> paramList)
  {
    int j = 0;
    if (paramList == null)
    {
      paramList = null;
      return paramList;
    }
    Object localObject2;
    if (amW)
    {
      localObject2 = new ArrayList();
      i = 0;
      while (i < paramList.size())
      {
        localObject1 = (mh)paramList.get(i);
        if ((eM(tag)) && (amZ.length != 0)) {
          a((mh)localObject1, (List)localObject2);
        }
        i += 1;
      }
      int k = ((List)localObject2).size();
      if (k == 0) {
        return null;
      }
      localObject1 = amV.cast(Array.newInstance(amV.getComponentType(), k));
      i = j;
      for (;;)
      {
        paramList = (List<mh>)localObject1;
        if (i >= k) {
          break;
        }
        Array.set(localObject1, i, ((List)localObject2).get(i));
        i += 1;
      }
    }
    int i = paramList.size() - 1;
    Object localObject1 = null;
    if ((localObject1 == null) && (i >= 0))
    {
      localObject2 = (mh)paramList.get(i);
      if ((!eM(tag)) || (amZ.length == 0)) {
        break label245;
      }
      localObject1 = localObject2;
    }
    label245:
    for (;;)
    {
      i -= 1;
      break;
      if (localObject1 == null) {
        return null;
      }
      return (T)amV.cast(u(lz.p(amZ)));
    }
  }
  
  protected Object u(lz paramlz)
  {
    Class localClass;
    if (amW) {
      localClass = amV.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + type);
        }
      }
      catch (InstantiationException paramlz)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramlz);
        localClass = amV;
        continue;
        mf localmf = (mf)localClass.newInstance();
        paramlz.a(localmf, mi.eO(tag));
        return localmf;
        localmf = (mf)localClass.newInstance();
        paramlz.a(localmf);
        return localmf;
      }
      catch (IllegalAccessException paramlz)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramlz);
      }
      catch (IOException paramlz)
      {
        throw new IllegalArgumentException("Error reading extension field", paramlz);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.mc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */