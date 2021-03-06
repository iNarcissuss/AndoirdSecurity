package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnStorageStatsResponse> CREATOR = new ap();
  StorageStats JA;
  final int xJ;
  
  OnStorageStatsResponse(int paramInt, StorageStats paramStorageStats)
  {
    xJ = paramInt;
    JA = paramStorageStats;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ap.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnStorageStatsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */