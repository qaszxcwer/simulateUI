package personal.simulateui.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import personal.simulateui.R;
import personal.simulateui.adapter.ChatAdapter;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.bean.ItemChat;
import personal.simulateui.databinding.ActivityChatBinding;

/**
 * 仿微信聊天界面
 *
 * 作者：qaszxcwer
 * 日期：2020/6/28
 */
public class ChatActivity extends BaseActivity {
    ActivityChatBinding binding;

    List<ItemChat> itemChatList = new ArrayList<>();

    ChatAdapter chatAdapter;

    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);

        initView();
        initOther();
    }

    private void initOther() {
        CountDownTimer timer = new CountDownTimer(10 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // 模拟对方发消息过来
                itemChatList.add(new ItemChat("新消息" + (millisUntilFinished / 1000), ItemChat.TYPE_OTHER));
                binding.recChatContent.scrollToPosition(itemChatList.size() - 1);
            }

            @Override
            public void onFinish() {
                //
            }
        };
        timer.start();
    }

    private void initView() {
        binding.txtChatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.txtChatTitle.setText("聊天名称");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recChatContent.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(getData());
        binding.recChatContent.setAdapter(chatAdapter);

        binding.edtChat.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 按下回车键发送消息
                    itemChatList.add(new ItemChat(binding.edtChat.getText().toString(), ItemChat.TYPE_USER));
                    binding.recChatContent.scrollToPosition(itemChatList.size() - 1);
                    binding.edtChat.setText(null);
                    // 拦截回车键，否则会换行
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * 模拟历史消息
     *
     * @return List<ItemChat>
     */
    private List<ItemChat> getData() {
        for (int i = 0; i < 10 ; i++) {
            itemChatList.add(new ItemChat("历史消息" + i, i % 2 == 0 ? ItemChat.TYPE_USER : ItemChat.TYPE_OTHER));
        }
        return itemChatList;
    }
}
