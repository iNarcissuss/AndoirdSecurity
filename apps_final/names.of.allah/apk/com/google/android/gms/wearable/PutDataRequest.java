package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new e();
  public static final String WEAR_URI_SCHEME = "wear";
  private static final Random alk = new SecureRandom();
  private byte[] TC;
  private final Bundle all;
  private final Uri mUri;
  final int xJ;
  
  private PutDataRequest(int paramInt, Uri paramUri)
  {
    this(paramInt, paramUri, new Bundle(), null);
  }
  
  PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    xJ = paramInt;
    mUri = paramUri;
    all = paramBundle;
    all.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    TC = paramArrayOfByte;
  }
  
  public static PutDataRequest create(String paramString)
  {
    return j(cx(paramString));
  }
  
  public static PutDataRequest createFromDataItem(DataItem paramDataItem)
  {
    PutDataRequest localPutDataRequest = j(paramDataItem.getUri());
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((DataItemAsset)localEntry.getValue()).getId() == null) {
        throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + (String)localEntry.getKey());
      }
      localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromRef(((DataItemAsset)localEntry.getValue()).getId()));
    }
    localPutDataRequest.setData(paramDataItem.getData());
    return localPutDataRequest;
  }
  
  public static PutDataRequest createWithAutoAppendedId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.endsWith("/")) {
      localStringBuilder.append("/");
    }
    localStringBuilder.append("PN").append(alk.nextLong());
    return new PutDataRequest(1, cx(localStringBuilder.toString()));
  }
  
  private static Uri cx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("An empty path was supplied.");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    if (paramString.startsWith("//")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    return new Uri.Builder().scheme("wear").path(paramString).build();
  }
  
  public static PutDataRequest j(Uri paramUri)
  {
    return new PutDataRequest(1, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Asset getAsset(String paramString)
  {
    return (Asset)all.getParcelable(paramString);
  }
  
  public Map<String, Asset> getAssets()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = all.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)all.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public byte[] getData()
  {
    return TC;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
  
  public boolean hasAsset(String paramString)
  {
    return all.containsKey(paramString);
  }
  
  public Bundle nh()
  {
    return all;
  }
  
  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    hn.f(paramString);
    hn.f(paramAsset);
    all.putParcelable(paramString, paramAsset);
    return this;
  }
  
  public PutDataRequest removeAsset(String paramString)
  {
    all.remove(paramString);
    return this;
  }
  
  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    TC = paramArrayOfByte;
    return this;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    Object localObject2 = new StringBuilder("dataSz=");
    if (TC == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(TC.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + all.size());
      localStringBuilder.append(", uri=" + mUri);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject1 = all.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localStringBuilder.append("\n    " + (String)localObject2 + ": " + all.getParcelable((String)localObject2));
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */