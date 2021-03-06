package com.inmobi.commons.internal;

public class CommonsException
  extends Exception
{
  public static final int APPLICATION_NOT_SET = 1;
  public static final int PRODUCT_NOT_FOUND = 2;
  private static final long serialVersionUID = 3805362231723549913L;
  private int a;
  
  public CommonsException(int paramInt)
  {
    a = paramInt;
  }
  
  public int getCode()
  {
    return a;
  }
  
  public String toString()
  {
    switch (a)
    {
    default: 
      return "Unknown.";
    case 1: 
      return "Application not set/initialize not called.";
    }
    return "Product not found.";
  }
}

/* Location:
 * Qualified Name:     com.inmobi.commons.internal.CommonsException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */