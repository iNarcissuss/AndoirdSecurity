package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
  List<DetectedActivity> US;
  long UT;
  long UU;
  private final int xJ;
  
  public ActivityRecognitionResult(int paramInt, List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    xJ = 1;
    US = paramList;
    UT = paramLong1;
    UU = paramLong2;
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      hn.b(bool1, "Must have at least 1 detected activity");
      bool1 = bool2;
      if (paramLong1 > 0L)
      {
        bool1 = bool2;
        if (paramLong2 > 0L) {
          bool1 = true;
        }
      }
      hn.b(bool1, "Must set times");
      xJ = 1;
      US = paramList;
      UT = paramLong1;
      UU = paramLong2;
      return;
    }
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    return (ActivityRecognitionResult)paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = US.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return UU;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)US.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return US;
  }
  
  public long getTime()
  {
    return UT;
  }
  
  public int getVersionCode()
  {
    return xJ;
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + US + ", timeMillis=" + UT + ", elapsedRealtimeMillis=" + UU + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */