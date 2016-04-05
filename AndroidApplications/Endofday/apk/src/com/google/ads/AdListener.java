package com.google.ads;

public abstract interface AdListener
{
  public abstract void onDismissScreen(Ad paramAd);
  
  public abstract void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(Ad paramAd);
  
  public abstract void onPresentScreen(Ad paramAd);
  
  public abstract void onReceiveAd(Ad paramAd);
}

/* Location:
 * Qualified Name:     com.google.ads.AdListener
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */