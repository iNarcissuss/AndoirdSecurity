package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class as
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, xJ);
    b.a(paramParcel, 2, HV, false);
    b.a(paramParcel, 3, HW, false);
    b.a(paramParcel, 4, HX, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OpenFileIntentSenderRequest at(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int j = a.B(paramParcel);
    String str = null;
    int i = 0;
    String[] arrayOfString = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 4: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId);
  }
  
  public OpenFileIntentSenderRequest[] bp(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.as
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */