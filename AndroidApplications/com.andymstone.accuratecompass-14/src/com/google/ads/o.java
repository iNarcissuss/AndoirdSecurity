package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class o implements n {
    public void a(d dVar, HashMap hashMap, WebView webView) {
        String str = (String) hashMap.get("name");
        if (str == null) {
            b.b("Error: App event with no name parameter.");
        } else {
            dVar.a(str, (String) hashMap.get("info"));
        }
    }
}