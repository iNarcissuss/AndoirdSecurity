package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<g>
{
  static void a(g paramg, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramg.getVersionCode());
    b.c(paramParcel, 2, akQ);
    b.a(paramParcel, 3, akR, false);
    b.a(paramParcel, 4, akS);
    b.a(paramParcel, 5, akT, false);
    b.a(paramParcel, 6, akU);
    b.c(paramParcel, 7, akV);
    b.G(paramParcel, paramInt);
  }
  
  public g cm(Parcel paramParcel)
  {
    String str1 = null;
    int j = 0;
    int m = a.B(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int i = -1;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        str2 = a.o(paramParcel, n);
        break;
      case 4: 
        d = a.m(paramParcel, n);
        break;
      case 5: 
        str1 = a.o(paramParcel, n);
        break;
      case 6: 
        l = a.i(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new g(k, j, str2, d, str1, l, i);
  }
  
  public g[] dU(int paramInt)
  {
    return new g[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */