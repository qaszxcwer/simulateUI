package personal.simulateui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import personal.simulateui.databinding.ActivityServicesRemindBinding;

import android.os.Bundle;

public class ServicesRemindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityServicesRemindBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_services_remind);
        binding.txtHelloWorld.setText(R.string.activity_name_AL_service_remind);
    }
}
