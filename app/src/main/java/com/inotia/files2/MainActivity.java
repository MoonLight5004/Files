package com.inotia.files2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public final class MainActivity extends Activity {
    public void onCreate(Bundle bundle) {
        boolean active1;
        boolean active2;
        boolean active3;
        super.onCreate(bundle);
        boolean active4 = true;
		Toast errorToast = Toast.makeText(this.getApplicationContext(), R.string.error, Toast.LENGTH_SHORT);
        try {
            Uri parse = Uri.parse("content://com.android.externalstorage.documents/root/primary");
            if (parse != null) {
                startActivity(new Intent("android.intent.action.VIEW", parse));
                active1 = true;
                if (!active1) {
                    try {
                        if (parse != null) {
                            startActivity(new Intent("android.provider.action.BROWSE", parse));
                            active2 = true;
                            if (!active2) {
                                try {
                                    if (parse != null) {
                                        startActivity(new Intent("android.provider.action.BROWSE_DOCUMENT_ROOT", parse));
                                        active3 = true;
                                        if (!active3) {
                                            active4 = false;
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
                                    }
                                } catch (RuntimeException unused) {
                                    active3 = false;
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
                        }
                    } catch (RuntimeException unused2) {
                        active2 = false;
                    }
                }
                if (!active4) {
                    errorToast.show();
                }
                finish();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
        } catch (RuntimeException unused3) {
            active1 = false;
        }
    }
}
