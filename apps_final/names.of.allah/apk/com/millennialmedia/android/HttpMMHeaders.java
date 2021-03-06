package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.Map;
import org.apache.http.Header;

class HttpMMHeaders
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<HttpMMHeaders> CREATOR = new HttpMMHeaders.1();
  private static final String HEADER_MM_CUSTOM_CLOSE = "X-MM-USE-CUSTOM-CLOSE";
  private static final String HEADER_MM_ENABLE_HARDWARE_ACCEL = "X-MM-ENABLE-HARDWARE-ACCELERATION";
  private static final String HEADER_MM_TRANSITION = "X-MM-TRANSITION";
  private static final String HEADER_MM_TRANSITION_DURATION = "X-MM-TRANSITION-DURATION";
  private static final String HEADER_MM_TRANSPARENT = "X-MM-TRANSPARENT";
  static final long serialVersionUID = 3168621112125974L;
  boolean enableHardwareAccel;
  boolean isTransparent;
  String transition;
  long transitionTimeInMillis;
  boolean useCustomClose;
  
  public HttpMMHeaders(Parcel paramParcel)
  {
    try
    {
      boolean[] arrayOfBoolean = new boolean[3];
      paramParcel.readBooleanArray(arrayOfBoolean);
      isTransparent = arrayOfBoolean[0];
      useCustomClose = arrayOfBoolean[1];
      enableHardwareAccel = arrayOfBoolean[2];
      transition = paramParcel.readString();
      transitionTimeInMillis = paramParcel.readLong();
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public HttpMMHeaders(Header[] paramArrayOfHeader)
  {
    int j = paramArrayOfHeader.length;
    int i = 0;
    while (i < j)
    {
      Header localHeader = paramArrayOfHeader[i];
      checkTransparent(localHeader);
      checkTransition(localHeader);
      checkTransitionDuration(localHeader);
      checkUseCustomClose(localHeader);
      checkEnableHardwareAccel(localHeader);
      i += 1;
    }
  }
  
  private void checkEnableHardwareAccel(Header paramHeader)
  {
    if ("X-MM-ENABLE-HARDWARE-ACCELERATION".equalsIgnoreCase(paramHeader.getName())) {
      enableHardwareAccel = Boolean.parseBoolean(paramHeader.getValue());
    }
  }
  
  private void checkTransition(Header paramHeader)
  {
    if ("X-MM-TRANSITION".equalsIgnoreCase(paramHeader.getName())) {
      transition = paramHeader.getValue();
    }
  }
  
  private void checkTransitionDuration(Header paramHeader)
  {
    if ("X-MM-TRANSITION-DURATION".equalsIgnoreCase(paramHeader.getName()))
    {
      paramHeader = paramHeader.getValue();
      if (paramHeader != null) {
        transitionTimeInMillis = ((Float.parseFloat(paramHeader) * 1000.0F));
      }
    }
  }
  
  private void checkTransparent(Header paramHeader)
  {
    if ("X-MM-TRANSPARENT".equalsIgnoreCase(paramHeader.getName()))
    {
      paramHeader = paramHeader.getValue();
      if (paramHeader != null) {
        isTransparent = Boolean.parseBoolean(paramHeader);
      }
    }
  }
  
  private void checkUseCustomClose(Header paramHeader)
  {
    if ("X-MM-USE-CUSTOM-CLOSE".equalsIgnoreCase(paramHeader.getName())) {
      useCustomClose = Boolean.parseBoolean(paramHeader.getValue());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void updateArgumentsWithSettings(Map<String, String> paramMap)
  {
    paramMap.put("transparent", String.valueOf(isTransparent));
    paramMap.put("transition", String.valueOf(transition));
    paramMap.put("transitionDuration", String.valueOf(transitionTimeInMillis));
    paramMap.put("useCustomClose", String.valueOf(useCustomClose));
    paramMap.put("enableHardwareAccel", String.valueOf(enableHardwareAccel));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { isTransparent, useCustomClose, enableHardwareAccel });
    paramParcel.writeString(transition);
    paramParcel.writeLong(transitionTimeInMillis);
  }
}

/* Location:
 * Qualified Name:     com.millennialmedia.android.HttpMMHeaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */