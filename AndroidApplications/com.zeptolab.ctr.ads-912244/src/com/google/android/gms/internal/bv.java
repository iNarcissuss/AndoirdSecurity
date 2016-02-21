package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;

public final class bv extends e {
    private static final bv nL;

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    static {
        nL = new bv();
    }

    private bv() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bw a(Activity activity) {
        try {
            if (!b(activity)) {
                return nL.c(activity);
            }
            da.s("Using AdOverlay from the client jar.");
            return new bo(activity);
        } catch (a e) {
            da.w(e.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private bw c(Activity activity) {
        bw bwVar = null;
        try {
            return com.google.android.gms.internal.bw.a.m(((bx) z(activity)).a(c.h(activity)));
        } catch (RemoteException e) {
            da.b("Could not create remote AdOverlay.", e);
            return bwVar;
        } catch (com.google.android.gms.dynamic.e.a e2) {
            da.b("Could not create remote AdOverlay.", e2);
            return bwVar;
        }
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return l(iBinder);
    }

    protected bx l(IBinder iBinder) {
        return com.google.android.gms.internal.bx.a.n(iBinder);
    }
}