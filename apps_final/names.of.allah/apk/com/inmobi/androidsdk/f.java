package com.inmobi.androidsdk;

import android.os.Message;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NetworkEventType;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.Response;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import org.json.JSONException;
import org.json.JSONObject;

class f
  implements HttpRequestCallback
{
  f(InterstitialView paramInterstitialView) {}
  
  public void notifyResult(int paramInt, Object paramObject)
  {
    Log.debug("[InMobi]-[Network]-4.4.1", ">>> Got HTTP REQUEST callback. Status: " + paramInt);
    if (paramInt == 0)
    {
      InterstitialView.a(a, ((Response)paramObject).getAdResponse());
      InterstitialView.b(a, ((Response)paramObject).getImpressionId());
      InterstitialView.b(a).sendEmptyMessage(308);
    }
    while (paramInt != 1) {
      return;
    }
    long l = System.currentTimeMillis() - InterstitialView.c(a);
    Message localMessage = InterstitialView.b(a).obtainMessage(309);
    AdException localAdException;
    Object localObject;
    if ((paramObject instanceof AdException))
    {
      localAdException = (AdException)paramObject;
      paramObject = localAdException.getErrorCode();
      if (InterstitialView.d(a)) {
        localObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("ad", localAdException.getImpressionId());
        ((JSONObject)localObject).put("t", l);
        ((JSONObject)localObject).put("m", localAdException.getHttpCode());
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RESPONSE_ERROR, (JSONObject)localObject));
        obj = paramObject;
        localMessage.sendToTarget();
        return;
      }
      catch (JSONException localJSONException1)
      {
        Log.internal("[InMobi]-[Network]-4.4.1", "Error creating metric logs for error at " + System.currentTimeMillis());
        continue;
      }
      localObject = (AdRequest.ErrorCode)paramObject;
      paramInt = ((AdRequest.ErrorCode)localObject).getErrorCode();
      paramObject = localObject;
      if (!InterstitialView.d(a)) {
        continue;
      }
      paramObject = new JSONObject();
      try
      {
        ((JSONObject)paramObject).put("t", l);
        ((JSONObject)paramObject).put("m", paramInt);
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, (JSONObject)paramObject));
        paramObject = localObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.4.1", "Error creating metric logs for error at " + System.currentTimeMillis());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.inmobi.androidsdk.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */