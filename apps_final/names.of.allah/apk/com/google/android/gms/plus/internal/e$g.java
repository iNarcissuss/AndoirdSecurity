package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

final class e$g
  extends a
{
  private final a.d<Status> abI;
  
  public e$g(a.d<Status> paramd)
  {
    a.d locald;
    abI = locald;
  }
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
    {
      paramBundle = new Status(paramInt, null, paramBundle);
      abJ.a(new e.h(abJ, abI, paramBundle));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.plus.internal.e.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */