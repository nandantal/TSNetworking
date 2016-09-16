package com.talentica.tsnetworking.util;

import android.util.Log;

/**
 * Utility class.
 *
 * @author nandan.dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class Util {
    public static boolean isVolley = false;
    public static boolean isRetro = false;
    public static final boolean VERBOSE = true;
    private static final String TAG = "tslog";

    /**
     * Check if a package name exist inside the application
     *
     * @param packageName : name of the package
     * @return : boolean
     */
    public static boolean isPackageExist(String packageName) {
        Class mClass = null;

        try {
            mClass = Class.forName(packageName);
        } catch (ClassNotFoundException e) {
            //ignore
        }

        if (mClass != null)
            return true;

        return false;
    }

    public static void log(String msg, String className) {
        Log.v(TAG, msg + " : Class : " + className);
    }

}
