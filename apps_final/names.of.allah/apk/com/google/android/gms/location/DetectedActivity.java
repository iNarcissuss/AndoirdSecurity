package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  int UV;
  int UW;
  private final int xJ;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    xJ = 1;
    UV = paramInt1;
    UW = paramInt2;
  }
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    xJ = paramInt1;
    UV = paramInt2;
    UW = paramInt3;
  }
  
  private int cF(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 8) {
      i = 4;
    }
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getConfidence()
  {
    return UW;
  }
  
  public int getType()
  {
    return cF(UV);
  }
  
  public int getVersionCode()
  {
    return xJ;
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + getType() + ", confidence=" + UW + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */