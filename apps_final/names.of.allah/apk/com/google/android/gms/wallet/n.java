package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n
  implements Parcelable.Creator<OfferWalletObject>
{
  static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOfferWalletObject.getVersionCode());
    b.a(paramParcel, 2, eC, false);
    b.a(paramParcel, 3, ajQ, false);
    b.a(paramParcel, 4, ajR, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OfferWalletObject cc(Parcel paramParcel)
  {
    CommonWalletObject localCommonWalletObject = null;
    int j = a.B(paramParcel);
    String str1 = null;
    int i = 0;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localCommonWalletObject = (CommonWalletObject)a.a(paramParcel, k, CommonWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OfferWalletObject(i, str1, str2, localCommonWalletObject);
  }
  
  public OfferWalletObject[] dI(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */