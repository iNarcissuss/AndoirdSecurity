package com.google.android.gms.drive.realtime.internal;

import android.os.IBinder;
import android.os.Parcel;

class e$a$a
  implements e
{
  private IBinder ko;
  
  e$a$a(IBinder paramIBinder)
  {
    ko = paramIBinder;
  }
  
  public void a(ParcelableCollaborator[] paramArrayOfParcelableCollaborator)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
      localParcel1.writeTypedArray(paramArrayOfParcelableCollaborator, 0);
      ko.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return ko;
  }
  
  /* Error */
  public void o(com.google.android.gms.common.api.Status paramStatus)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 26
    //   11: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 60	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/drive/realtime/internal/e$a$a:ko	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 40 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 43	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 46	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 46	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 46	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 46	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramStatus	com.google.android.gms.common.api.Status
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */