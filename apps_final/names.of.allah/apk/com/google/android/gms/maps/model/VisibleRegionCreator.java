package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class VisibleRegionCreator
  implements Parcelable.Creator<VisibleRegion>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.getVersionCode());
    b.a(paramParcel, 2, nearLeft, paramInt, false);
    b.a(paramParcel, 3, nearRight, paramInt, false);
    b.a(paramParcel, 4, farLeft, paramInt, false);
    b.a(paramParcel, 5, farRight, paramInt, false);
    b.a(paramParcel, 6, latLngBounds, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public VisibleRegion createFromParcel(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int j = a.B(paramParcel);
    int i = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
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
        localLatLng4 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        localLatLng3 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 4: 
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, k, LatLngBounds.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new VisibleRegion(i, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }
  
  public VisibleRegion[] newArray(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegionCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */