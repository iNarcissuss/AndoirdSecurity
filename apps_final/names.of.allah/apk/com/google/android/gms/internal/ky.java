package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ky
  implements Parcelable.Creator<kt.b.b>
{
  static void a(kt.b.b paramb, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    Set localSet = paramb.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, paramb.getHeight());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.getWidth());
    }
    b.G(paramParcel, paramInt);
  }
  
  public kt.b.b bK(Parcel paramParcel)
  {
    int i = 0;
    int m = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.o(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new kt.b.b(localHashSet, k, j, str, i);
  }
  
  public kt.b.b[] dh(int paramInt)
  {
    return new kt.b.b[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.ky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */