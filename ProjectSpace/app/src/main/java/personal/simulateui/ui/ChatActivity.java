package personal.simulateui.ui;

import android.os.Bundle;
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
    }

    private void initView() {
        binding.txtChatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.txtChatTitle.setText("聊天名称11111111111111111111111111111111111111111111");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recChatContent.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(getData());
        binding.recChatContent.setAdapter(chatAdapter);
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
