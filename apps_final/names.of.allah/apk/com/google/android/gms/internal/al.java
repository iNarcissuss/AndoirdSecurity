package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class al
{
  public static final al mb = new al();
  
  public static al aA()
  {
    return mb;
  }
  
  public aj a(Context paramContext, au paramau)
  {
    Object localObject = paramau.getBirthday();
    long l;
    String str1;
    int i;
    label53:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject != null)
    {
      l = ((Date)localObject).getTime();
      str1 = paramau.getContentUrl();
      i = paramau.getGender();
      localObject = paramau.getKeywords();
      if (((Set)localObject).isEmpty()) {
        break label151;
      }
      localObject = Collections.unmodifiableList(new ArrayList((Collection)localObject));
      bool1 = paramau.isTestDevice(paramContext);
      j = paramau.aF();
      localLocation = paramau.getLocation();
      localBundle = paramau.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramau.getManualImpressionsEnabled();
      str2 = paramau.getPublisherProvidedId();
      paramContext = paramau.aC();
      if (paramContext == null) {
        break label156;
      }
    }
    label151:
    label156:
    for (paramContext = new ax(paramContext);; paramContext = null)
    {
      return new aj(4, l, localBundle, i, (List)localObject, bool1, j, bool2, str2, paramContext, localLocation, str1, paramau.aE());
      l = -1L;
      break;
      localObject = null;
      break label53;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.al
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */