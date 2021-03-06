package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract class bv$a
  extends Binder
  implements bv
{
  public bv$a()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
  }
  
  public static bv j(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    if ((localIInterface != null) && ((localIInterface instanceof bv))) {
      return (bv)localIInterface;
    }
    return new bv.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    d locald;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locald = d.a.ag(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = am.CREATOR.c(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label194;
        }
      }
      for (localObject2 = aj.CREATOR.b(paramParcel1);; localObject2 = null)
      {
        a(locald, (am)localObject1, (aj)localObject2, paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      localObject2 = getView();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject1;
      if (localObject2 != null) {
        paramParcel1 = ((d)localObject2).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locald = d.a.ag(paramParcel1.readStrongBinder());
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = aj.CREATOR.b(paramParcel1);
      }
      a(locald, (aj)localObject1, paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      showInterstitial();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      destroy();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locald = d.a.ag(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = am.CREATOR.c(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label415;
        }
      }
      for (localObject2 = aj.CREATOR.b(paramParcel1);; localObject2 = null)
      {
        a(locald, (am)localObject1, (aj)localObject2, paramParcel1.readString(), paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      localObject2 = d.a.ag(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = aj.CREATOR.b(paramParcel1);; localObject1 = null)
      {
        a((d)localObject2, (aj)localObject1, paramParcel1.readString(), paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 8: 
      label194:
      label415:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      pause();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    resume();
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.bv.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */