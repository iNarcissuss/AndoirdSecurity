package com.google.zxing.client.result;

abstract class AbstractDoCoMoResultParser
  extends ResultParser
{
  static String[] matchDoCoMoPrefixedField(String paramString1, String paramString2, boolean paramBoolean)
  {
    return matchPrefixedField(paramString1, paramString2, ';', paramBoolean);
  }
  
  static String matchSingleDoCoMoPrefixedField(String paramString1, String paramString2, boolean paramBoolean)
  {
    return matchSinglePrefixedField(paramString1, paramString2, ';', paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.client.result.AbstractDoCoMoResultParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */