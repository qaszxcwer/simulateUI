package personal.simulateui;

import androidx.databinding.DataBindingUtil;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.databinding.ActivityServicesRemindBinding;

import android.app.Activity;
import android.os.Bundle;

/**
 * 作者：qaszxcwer，日期：2020/5/26
 */
public class ServicesRemindActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityServicesRemindBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_services_remind);
        binding.txtHelloWorld.setText(R.string.activity_name_AL_service_remind);
    }
}
