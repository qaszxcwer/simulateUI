package personal.simulateui.util;

import android.util.Log;

/**
 * 作者：qaszxcwer，日期：2020/5/26
 */
public class Logger {
    private static String getTag() {
        return "DefaultLogTag";
    }

    public static void i(String logString) {
        Log.i(getTag(), logString);
    }

    public static void i(String tag, String logString) {
        Log.i(tag, logString);
    }

    public static void w(String logString) {
        Log.i(getTag(), logString);
    }

    public static void w(String tag, String logString) {
        Log.i(tag, logString);
    }
}
