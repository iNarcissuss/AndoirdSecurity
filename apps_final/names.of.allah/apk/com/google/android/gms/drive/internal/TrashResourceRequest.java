package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new ax();
  final DriveId Ir;
  final int xJ;
  
  TrashResourceRequest(int paramInt, DriveId paramDriveId)
  {
    xJ = paramInt;
    Ir = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ax.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.TrashResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */