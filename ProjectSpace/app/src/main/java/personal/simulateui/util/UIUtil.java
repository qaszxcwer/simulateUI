package personal.simulateui.util;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * 作者：qaszxcwer，日期：2020/5/26
 */
public class UIUtil {
    /**
     * 设置状态栏透明、UI全屏显示
     *
     * @param activity 上下文
     */
    public static void setStatusBarTransparent(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            Logger.w("window is null");
            return;
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}
