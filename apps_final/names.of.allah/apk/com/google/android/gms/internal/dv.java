package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class dv
  implements SafeParcelable
{
  public static final dw CREATOR = new dw();
  public final int errorCode;
  public final List<String> nr;
  public final List<String> ns;
  public final long nv;
  public final int orientation;
  public final String oy;
  public final String qb;
  public final long qc;
  public final boolean qd;
  public final long qe;
  public final List<String> qf;
  public final String qg;
  public final long qh;
  public final String qi;
  public final boolean qj;
  public final String qk;
  public final String ql;
  public final int versionCode;
  
  public dv(int paramInt)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
  }
  
  public dv(int paramInt, long paramLong)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null);
  }
  
  dv(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    versionCode = paramInt1;
    oy = paramString1;
    qb = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      nr = paramString1;
      errorCode = paramInt2;
      if (paramList2 == null) {
        break label145;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      ns = paramString1;
      qc = paramLong1;
      qd = paramBoolean1;
      qe = paramLong2;
      if (paramList3 == null) {
        break label150;
      }
    }
    label145:
    label150:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      qf = paramString1;
      nv = paramLong3;
      orientation = paramInt3;
      qg = paramString3;
      qh = paramLong4;
      qi = paramString4;
      qj = paramBoolean2;
      qk = paramString5;
      ql = paramString6;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public dv(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5);
  }
  
  public dv(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dw.a(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.dv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */