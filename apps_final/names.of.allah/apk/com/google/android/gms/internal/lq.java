package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public abstract interface lq
  extends IInterface
{
  public abstract void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle);
  
  public abstract void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle);
  
  public abstract void a(int paramInt, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void a(Status paramStatus, lj paramlj, Bundle paramBundle);
  
  public abstract void i(int paramInt, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.lq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */