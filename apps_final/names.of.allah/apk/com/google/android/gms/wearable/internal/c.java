package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class c
  implements Parcelable.Creator<b>
{
  static void a(b paramb, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramb.nj(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, alx, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public b cv(Parcel paramParcel)
  {
    IntentFilter[] arrayOfIntentFilter = null;
    int j = a.B(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localIBinder = a.p(paramParcel, k);
        break;
      case 3: 
        arrayOfIntentFilter = (IntentFilter[])a.b(paramParcel, k, IntentFilter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new b(i, localIBinder, arrayOfIntentFilter);
  }
  
  public b[] ee(int paramInt)
  {
    return new b[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */