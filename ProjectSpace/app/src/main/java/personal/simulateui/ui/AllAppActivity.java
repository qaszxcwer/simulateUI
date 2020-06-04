package personal.simulateui.ui;

import androidx.databinding.DataBindingUtil;
import personal.simulateui.R;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.databinding.ActivityAllAppBinding;

import android.os.Bundle;

/**
 * 作者：qaszxcwer，日期：2020/6/4
 * 全部应用页面
 */
public class AllAppActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAllAppBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_all_app);
    }
}
