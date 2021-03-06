package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;

class r
  extends af
{
  private static final Object tQ = new Object();
  private static r uc;
  private Context mContext;
  private Handler mHandler;
  private d tR;
  private volatile f tS;
  private int tT = 1800;
  private boolean tU = true;
  private boolean tV;
  private String tW;
  private boolean tX = true;
  private boolean tY = true;
  private e tZ = new r.1(this);
  private q ua;
  private boolean ub = false;
  
  private void cA()
  {
    ua = new q(this);
    ua.s(mContext);
  }
  
  private void cB()
  {
    mHandler = new Handler(mContext.getMainLooper(), new r.2(this));
    if (tT > 0) {
      mHandler.sendMessageDelayed(mHandler.obtainMessage(1, tQ), tT * 1000);
    }
  }
  
  public static r cz()
  {
    if (uc == null) {
      uc = new r();
    }
    return uc;
  }
  
  /* Error */
  void a(Context paramContext, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 73	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 118	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 118	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   34: aload_0
    //   35: getfield 45	com/google/android/gms/analytics/r:tU	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 121	com/google/android/gms/analytics/r:dispatchLocalHits	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 45	com/google/android/gms/analytics/r:tU	Z
    //   50: aload_0
    //   51: getfield 123	com/google/android/gms/analytics/r:tV	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 126	com/google/android/gms/analytics/r:cn	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 123	com/google/android/gms/analytics/r:tV	Z
    //   66: goto -55 -> 11
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	r
    //   0	74	1	paramContext	Context
    //   0	74	2	paramf	f
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   14	50	69	finally
    //   50	66	69	finally
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (ub == paramBoolean1)
        {
          boolean bool = tX;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (tT > 0)) {
          mHandler.removeMessages(1, tQ);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (tT > 0)) {
          mHandler.sendMessageDelayed(mHandler.obtainMessage(1, tQ), tT * 1000);
        }
        localStringBuilder = new StringBuilder("PowerSaveMode ");
        if (paramBoolean1) {
          break label152;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      aa.C(str1);
      ub = paramBoolean1;
      tX = paramBoolean2;
      continue;
      label146:
      String str2 = "terminated.";
      continue;
      label152:
      str2 = "initiated.";
    }
  }
  
  d cC()
  {
    try
    {
      if (tR != null) {
        break label80;
      }
      if (mContext == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    tR = new ac(tZ, mContext);
    if (tW != null)
    {
      tR.cm().M(tW);
      tW = null;
    }
    label80:
    if (mHandler == null) {
      cB();
    }
    if ((ua == null) && (tY)) {
      cA();
    }
    d locald = tR;
    return locald;
  }
  
  void cD()
  {
    try
    {
      if ((!ub) && (tX) && (tT > 0))
      {
        mHandler.removeMessages(1, tQ);
        mHandler.sendMessage(mHandler.obtainMessage(1, tQ));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void cn()
  {
    if (tS == null)
    {
      aa.C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      tV = true;
      return;
    }
    u.cP().a(u.a.vY);
    tS.cn();
  }
  
  /* Error */
  void dispatchLocalHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -43
    //   11: invokestatic 151	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 45	com/google/android/gms/analytics/r:tU	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 199	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 216	com/google/android/gms/analytics/u$a:vL	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 208	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 118	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   35: invokeinterface 219 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	r
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  /* Error */
  void setLocalDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc -33
    //   11: invokestatic 151	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 43	com/google/android/gms/analytics/r:tT	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 199	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 226	com/google/android/gms/analytics/u$a:vM	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 208	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 58	com/google/android/gms/analytics/r:ub	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 47	com/google/android/gms/analytics/r:tX	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 43	com/google/android/gms/analytics/r:tT	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 94	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 39	com/google/android/gms/analytics/r:tQ	Ljava/lang/Object;
    //   60: invokevirtual 131	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 43	com/google/android/gms/analytics/r:tT	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 58	com/google/android/gms/analytics/r:ub	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 47	com/google/android/gms/analytics/r:tX	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 94	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 94	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 39	com/google/android/gms/analytics/r:tQ	Ljava/lang/Object;
    //   98: invokevirtual 98	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 102	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	r
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	63	114	finally
    //   63	68	114	finally
    //   72	111	114	finally
  }
  
  void t(boolean paramBoolean)
  {
    try
    {
      a(ub, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.analytics.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */