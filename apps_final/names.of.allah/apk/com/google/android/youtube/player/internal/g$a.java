package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class g$a
  extends Binder
  implements g
{
  public g$a()
  {
    attachInterface(this, "com.google.android.youtube.player.internal.IPlayerStateChangeListener");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      b();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      c();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
      d();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
    b(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.youtube.player.internal.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */