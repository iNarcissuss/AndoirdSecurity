package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class ds
  extends hc<dx>
{
  final int pT;
  
  public ds(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    pT = paramInt;
  }
  
  protected void a(hj paramhj, hc.e parame)
  {
    Bundle localBundle = new Bundle();
    paramhj.g(parame, pT, getContext().getPackageName(), localBundle);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public dx br()
  {
    return (dx)super.fo();
  }
  
  protected dx w(IBinder paramIBinder)
  {
    return dx.a.y(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.ds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */