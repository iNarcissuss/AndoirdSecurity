package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class bx
  extends cc
{
  public bx(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    parama1 = dh.k(parama1);
    parama2 = dh.k(parama2);
    if ((parama1 == dh.mW()) || (parama2 == dh.mW())) {
      return false;
    }
    return a(parama1, parama2, paramMap);
  }
  
  protected abstract boolean a(dg paramdg1, dg paramdg2, Map<String, d.a> paramMap);
}

/* Location:
 * Qualified Name:     com.google.android.gms.tagmanager.bx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */