package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Locale;
import java.util.Map;

class bc
  extends aj
{
  private static final String ID = a.L.toString();
  
  public bc()
  {
    super(ID, new String[0]);
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return dh.mY();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return dh.mY();
    }
    return dh.r(paramMap.toLowerCase());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.tagmanager.bc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */