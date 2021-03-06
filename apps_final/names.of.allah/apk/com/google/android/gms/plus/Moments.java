package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.Moment;

public abstract interface Moments
{
  public abstract PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient paramGoogleApiClient, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3);
  
  public abstract PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Status> write(GoogleApiClient paramGoogleApiClient, Moment paramMoment);
}

/* Location:
 * Qualified Name:     com.google.android.gms.plus.Moments
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */