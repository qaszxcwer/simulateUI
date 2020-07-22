package personal.simulateui.ui;

import androidx.databinding.DataBindingUtil;
import personal.simulateui.R;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.databinding.ActivityLaucherBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 作者：qaszxcwer，日期：2020/6/4
 * 启动页，将来会作为首页
 */
public class LaucherActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLaucherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_laucher);
        binding.btnServicesRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaucherActivity.this, ServicesRemindActivity.class);
                startActivity(intent);
            }
        });
        binding.btnAllApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaucherActivity.this, AllAppActivity.class);
                startActivity(intent);
            }
        });
        binding.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaucherActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
        binding.btnRegions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaucherActivity.this, RegionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
