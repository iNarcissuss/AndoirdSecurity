package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class e
  implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest>
{
  static void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, xJ);
    b.a(paramParcel, 2, Ir, paramInt, false);
    b.a(paramParcel, 3, Is, paramInt, false);
    b.a(paramParcel, 4, It, paramInt, false);
    b.a(paramParcel, 5, Iu);
    b.a(paramParcel, 6, Iv, false);
    b.G(paramParcel, i);
  }
  
  public CloseContentsAndUpdateMetadataRequest U(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int j = a.B(paramParcel);
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int i = 0;
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
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        break;
      case 5: 
        bool = a.c(paramParcel, k);
        break;
      case 6: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CloseContentsAndUpdateMetadataRequest(i, localDriveId, localMetadataBundle, localContents, bool, str);
  }
  
  public CloseContentsAndUpdateMetadataRequest[] aP(int paramInt)
  {
    return new CloseContentsAndUpdateMetadataRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */