package com.google.android.gms.plus;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

class PlusClient$4
  implements a.d<People.LoadPeopleResult>
{
  PlusClient$4(PlusClient paramPlusClient, PlusClient.OnPeopleLoadedListener paramOnPeopleLoadedListener) {}
  
  public void a(People.LoadPeopleResult paramLoadPeopleResult)
  {
    abt.onPeopleLoaded(paramLoadPeopleResult.getStatus().eM(), paramLoadPeopleResult.getPersonBuffer(), paramLoadPeopleResult.getNextPageToken());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.plus.PlusClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */