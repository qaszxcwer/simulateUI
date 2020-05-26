package personal.simulateui.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import personal.simulateui.util.UIUtil;

/**
 * 作者：qaszxcwer，日期：2020/5/26
 */
public abstract class BaseActivity extends Activity {
    /**
     * 设置是否需要状态栏透明<BR>
     * 同时UI全屏显示
     */
    protected abstract boolean isNeedStatusChange();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUIFullScreenTransparent(isNeedStatusChange());
    }

    private void setUIFullScreenTransparent(boolean isFullScreen) {
        if (isFullScreen) {
            UIUtil.setStatusBarTransparent(this);
            return;
        }
    }
}
