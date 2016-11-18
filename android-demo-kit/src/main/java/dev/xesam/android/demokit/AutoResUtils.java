package dev.xesam.android.demokit;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by xesamguo@gmail.com on 16-3-15.
 */
public class AutoResUtils {
    static final int INVALID_RES = 0;

    static int getLayoutId(Fragment fragment) {
        Context context = fragment.getContext();
        String canonicalName = fragment.getClass().getCanonicalName();
        return getLayoutId(context, canonicalName, "fg");
    }

    static int getLayoutId(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        return getLayoutId(activity, canonicalName, "act");
    }

    private static int getLayoutId(Context context, String canonicalName, String prefix) {
        String[] packages = canonicalName.split("\\.");
        String pkgPrefix = packages[packages.length - 2];
        String rawName = packages[packages.length - 1].replace("Demo", "");
        String resName = prefix + UNDERLINE + pkgPrefix + camelToUnderline(rawName);
        return context.getResources().getIdentifier(resName, "layout", context.getPackageName());
    }

    public static final char UNDERLINE = '_';

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
