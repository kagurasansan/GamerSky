package com.gamersky.kagurasansan.base.util;

import android.text.TextUtils;

public class Util {
    public static boolean isNull(String... args) {
        if (args == null) return true;
        for (String item : args) {
            if (TextUtils.isEmpty(item)) return true;
        }
        return false;
    }
}
