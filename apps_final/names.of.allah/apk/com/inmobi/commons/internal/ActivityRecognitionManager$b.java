package com.inmobi.commons.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ActivityRecognitionManager$b
  implements InvocationHandler
{
  public void a(Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent(InternalSDKUtil.getContext().getApplicationContext(), ActivityRecognitionManager.class);
      paramBundle = PendingIntent.getService(InternalSDKUtil.getContext().getApplicationContext(), 0, paramBundle, 134217728);
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
      if (i == 0) {
        try
        {
          Class.forName("com.google.android.gms.location.ActivityRecognitionClient").getMethod("requestActivityUpdates", new Class[] { Integer.class, PendingIntent.class }).invoke(ActivityRecognitionManager.b, new Object[] { Integer.valueOf(1000), paramBundle });
          return;
        }
        catch (Exception paramBundle)
        {
          Log.internal("[InMobi]-4.4.1", "Unable to request activity updates from ActivityRecognition client");
          Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
          return;
        }
      }
      Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
    }
    catch (Exception paramBundle)
    {
      Log.internal("[InMobi]-4.4.1", "Unable to request activity updates from ActivityRecognition client");
      return;
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {}
    try
    {
      if (paramMethod.getName().equals("onConnected")) {
        a((Bundle)paramArrayOfObject[0]);
      }
      return null;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.4.1", "Unable to invoke method", (Throwable)paramObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.inmobi.commons.internal.ActivityRecognitionManager.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */