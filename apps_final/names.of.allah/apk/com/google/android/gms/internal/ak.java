package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ak
  implements Parcelable.Creator<aj>
{
  static void a(aj paramaj, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, versionCode);
    b.a(paramParcel, 2, lQ);
    b.a(paramParcel, 3, extras, false);
    b.c(paramParcel, 4, lR);
    b.a(paramParcel, 5, lS, false);
    b.a(paramParcel, 6, lT);
    b.c(paramParcel, 7, lU);
    b.a(paramParcel, 8, lV);
    b.a(paramParcel, 9, lW, false);
    b.a(paramParcel, 10, lX, paramInt, false);
    b.a(paramParcel, 11, lY, paramInt, false);
    b.a(paramParcel, 12, lZ, false);
    b.a(paramParcel, 13, ma, false);
    b.G(paramParcel, i);
  }
  
  public aj b(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle2 = null;
    int j = 0;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str2 = null;
    ax localax = null;
    Location localLocation = null;
    String str1 = null;
    Bundle localBundle1 = null;
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
        l = a.i(paramParcel, n);
        break;
      case 3: 
        localBundle2 = a.q(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        localArrayList = a.B(paramParcel, n);
        break;
      case 6: 
        bool2 = a.c(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
        break;
      case 8: 
        bool1 = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.o(paramParcel, n);
        break;
      case 10: 
        localax = (ax)a.a(paramParcel, n, ax.CREATOR);
        break;
      case 11: 
        localLocation = (Location)a.a(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str1 = a.o(paramParcel, n);
        break;
      case 13: 
        localBundle1 = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new aj(k, l, localBundle2, j, localArrayList, bool2, i, bool1, str2, localax, localLocation, str1, localBundle1);
  }
  
  public aj[] c(int paramInt)
  {
    return new aj[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.ak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */