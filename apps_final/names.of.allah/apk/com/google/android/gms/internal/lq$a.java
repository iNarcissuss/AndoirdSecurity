package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public abstract class lq$a
  extends Binder
  implements lq
{
  public lq$a()
  {
    attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
  }
  
  public static lq bt(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof lq))) {
      return (lq)localIInterface;
    }
    return new lq.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label150;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, (MaskedWallet)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (FullWallet)FullWallet.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label227;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, (FullWallet)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label293;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 4: 
      label150:
      label227:
      label293:
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        i(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    lj locallj;
    if (paramParcel1.readInt() != 0)
    {
      localObject = Status.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label430;
      }
      locallj = (lj)lj.CREATOR.createFromParcel(paramParcel1);
      label389:
      if (paramParcel1.readInt() == 0) {
        break label436;
      }
    }
    label430:
    label436:
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a((Status)localObject, locallj, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localObject = null;
      break;
      locallj = null;
      break label389;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.lq.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */