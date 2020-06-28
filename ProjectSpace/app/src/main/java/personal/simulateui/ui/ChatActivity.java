package personal.simulateui.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import personal.simulateui.R;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.databinding.ActivityChatBinding;

/**
 * 仿微信聊天界面
 *
 * 作者：qaszxcwer
 * 日期：2020/6/28
 */
public class ChatActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        binding.txtChatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
