package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus;
import com.inmobi.commons.internal.Log;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class AnalyticsUtils
{
  public static final String ANALYTICS_LOGGING_TAG = "[InMobi]-[Analytics]-4.4.1";
  public static final String INITIALIZE_NOT_CALLED = "Please call InMobi.initialize or startSession before calling any events API";
  private static String a;
  private static boolean b;
  
  /* Error */
  public static void asyncPingInternal(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: aload_0
    //   7: ldc 25
    //   9: ldc 27
    //   11: invokevirtual 33	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_0
    //   15: aload_3
    //   16: astore_1
    //   17: ldc 8
    //   19: new 35	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 37
    //   25: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 53	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: astore_1
    //   40: new 55	java/net/URL
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   51: checkcast 62	java/net/HttpURLConnection
    //   54: astore_0
    //   55: aload_0
    //   56: sipush 20000
    //   59: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   62: aload_0
    //   63: ldc 68
    //   65: invokevirtual 71	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: invokestatic 77	com/inmobi/commons/internal/InternalSDKUtil:addCommonPropertiesToConnection	(Ljava/net/HttpURLConnection;)V
    //   72: ldc 8
    //   74: new 35	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 79
    //   80: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: invokevirtual 83	java/net/HttpURLConnection:getResponseCode	()I
    //   87: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 53	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   104: return
    //   105: astore_1
    //   106: aload_2
    //   107: astore_0
    //   108: aload_1
    //   109: astore_2
    //   110: aload_0
    //   111: astore_1
    //   112: ldc 8
    //   114: ldc 91
    //   116: aload_2
    //   117: invokestatic 94	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: ifnull -17 -> 104
    //   124: aload_0
    //   125: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   128: return
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: goto -11 -> 134
    //   148: astore_2
    //   149: goto -39 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   5	35	1	localObject1	Object
    //   105	4	1	localException1	Exception
    //   111	32	1	localObject2	Object
    //   144	1	1	localObject3	Object
    //   3	114	2	localObject4	Object
    //   129	4	2	localObject5	Object
    //   148	1	2	localException2	Exception
    //   1	38	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	105	java/lang/Exception
    //   17	38	105	java/lang/Exception
    //   40	55	105	java/lang/Exception
    //   6	15	129	finally
    //   17	38	129	finally
    //   40	55	129	finally
    //   112	120	129	finally
    //   55	96	144	finally
    //   55	96	148	java/lang/Exception
  }
  
  public static String compressPayload(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Base64OutputStream localBase64OutputStream = new Base64OutputStream(localByteArrayOutputStream, 0);
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localBase64OutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.close();
      localBase64OutputStream.close();
      paramString = localByteArrayOutputStream.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception compress sdk payload.", paramString);
    }
    return null;
  }
  
  public static String convertItemType(AnalyticsEventsWrapper.IMItemType paramIMItemType)
  {
    String str = null;
    if (paramIMItemType == AnalyticsEventsWrapper.IMItemType.CONSUMABLE) {
      str = "1";
    }
    do
    {
      return str;
      if (paramIMItemType == AnalyticsEventsWrapper.IMItemType.DURABLE) {
        return "2";
      }
    } while (paramIMItemType != AnalyticsEventsWrapper.IMItemType.PERSONALIZATION);
    return "3";
  }
  
  public static String convertLevelStatus(AnalyticsEventsWrapper.IMSectionStatus paramIMSectionStatus)
  {
    String str = null;
    if (paramIMSectionStatus == AnalyticsEventsWrapper.IMSectionStatus.COMPLETED) {
      str = "1";
    }
    do
    {
      return str;
      if (paramIMSectionStatus == AnalyticsEventsWrapper.IMSectionStatus.FAILED) {
        return "2";
      }
    } while (paramIMSectionStatus != AnalyticsEventsWrapper.IMSectionStatus.CANCELED);
    return "3";
  }
  
  public static String convertToJSON(Map<String, String> paramMap)
  {
    if (paramMap.size() > getExtraParamsLimit())
    {
      Log.verbose("[InMobi]-[Analytics]-4.4.1", "Analytics events - number of key-value pairs in attribute map exceeds " + getExtraParamsLimit());
      return null;
    }
    JSONObject localJSONObject;
    String str1;
    String str2;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if ((str1.length() > 0) && (str1.length() <= getMaxparamskey()))
          {
            str2 = (String)paramMap.get(str1);
            if (str2.length() <= getMaxstring())
            {
              localJSONObject.put(str1, paramMap.get(str1));
              continue;
              paramMap = null;
            }
          }
        }
      }
    }
    catch (Exception paramMap)
    {
      Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to convert map to JSON");
    }
    for (;;)
    {
      return paramMap;
      Log.verbose("[InMobi]-[Analytics]-4.4.1", "Analytics events - value : " + str2 + " ,exceeds inmobi's limitation of " + getMaxstring() + " characters.");
      return null;
      Log.verbose("[InMobi]-[Analytics]-4.4.1", "Analytics events - key : " + str1 + " ,exceeds inmobi's limitation of " + getMaxparamskey() + " characters.");
      return null;
      if (localJSONObject.length() > 0) {
        paramMap = localJSONObject.toString();
      }
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = getPackageManagergetPackageInfogetPackageName0versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[Analytics]-4.4.1", "Error retrieving application version");
    }
    return null;
  }
  
  public static String getApplicationName(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[Analytics]-4.4.1", "Error retrieving application name");
    }
    return null;
  }
  
  public static Object getCountryISO(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager.getNetworkCountryIso().equals("")) {
      return getResourcesgetConfigurationlocale.getISO3Country();
    }
    return localTelephonyManager.getNetworkCountryIso();
  }
  
  public static float getDeviceDensity(Context paramContext)
  {
    return getResourcesgetDisplayMetricsdensity;
  }
  
  public static String getEventUrl()
  {
    return AnalyticsInitializer.getConfigParams().getEndPoints().getEventsUrl();
  }
  
  public static int getExtraParamsLimit()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getExtraParamsLimit();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxRetryBeforeDiscard()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxRetryBeforeCacheDiscard();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static long getMaxdbcount()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxDbEvents();
      long l = i;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getMaxevents()
  {
    try
    {
      String str = AnalyticsInitializer.getConfigParams().getGetParamsLimit();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxparamskey()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxKeyLength();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxstring()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxValLength();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getScreenHeight(Context paramContext)
  {
    int i = getResourcesgetDisplayMetricsheightPixels;
    return i;
  }
  
  public static String getScreenWidth(Context paramContext)
  {
    int i = getResourcesgetDisplayMetricswidthPixels;
    return i;
  }
  
  public static boolean getStartHandle()
  {
    try
    {
      boolean bool = b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static long getTimeinterval()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getPingInterval();
      long l = i;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getWebviewUserAgent()
  {
    return a;
  }
  
  public static void setStartHandle(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setWebviewUserAgent(String paramString)
  {
    a = paramString;
  }
}

/* Location:
 * Qualified Name:     com.inmobi.commons.analytics.util.AnalyticsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */