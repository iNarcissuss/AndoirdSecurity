package com.inmobi.commons.analytics.iat.impl;

import java.io.Serializable;

public class Goal
  implements Serializable
{
  private int a;
  private String b;
  private long c;
  private int d;
  private boolean e;
  
  public Goal()
  {
    setGoalCount(0);
    setGoalName(null);
    setRetryTime(0L);
    setRetryCount(0);
    setDuplicateGoal(false);
  }
  
  public Goal(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < 0)
    {
      setGoalCount(0);
      if (paramLong >= 0L) {
        break label54;
      }
      setRetryTime(0L);
      label24:
      if (paramInt2 >= 0) {
        break label62;
      }
      setRetryCount(0);
    }
    for (;;)
    {
      setGoalName(paramString);
      setDuplicateGoal(paramBoolean);
      return;
      setGoalCount(paramInt1);
      break;
      label54:
      setRetryTime(paramLong);
      break label24;
      label62:
      setRetryCount(paramInt2);
    }
  }
  
  public int getGoalCount()
  {
    return a;
  }
  
  public String getGoalName()
  {
    return b;
  }
  
  public int getRetryCount()
  {
    return d;
  }
  
  public long getRetryTime()
  {
    return c;
  }
  
  public boolean isDuplicateGoal()
  {
    return e;
  }
  
  public final void setDuplicateGoal(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public final void setGoalCount(int paramInt)
  {
    a = paramInt;
  }
  
  public final void setGoalName(String paramString)
  {
    b = paramString;
  }
  
  public final void setRetryCount(int paramInt)
  {
    d = paramInt;
  }
  
  public final void setRetryTime(long paramLong)
  {
    c = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.inmobi.commons.analytics.iat.impl.Goal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */