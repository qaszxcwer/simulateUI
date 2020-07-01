package personal.simulateui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import personal.simulateui.R;
import personal.simulateui.bean.ItemChat;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/1
 */
public class ChatAdapter extends BaseMultiItemQuickAdapter<ItemChat, BaseViewHolder> {
    public ChatAdapter(List<ItemChat> list) {
        super(list);
        addItemType(ItemChat.TYPE_USER, R.layout.item_chat_user);
        addItemType(ItemChat.TYPE_OTHER, R.layout.item_chat_other);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemChat itemChat) {
        baseViewHolder.setText(R.id.txtChatItemText, itemChat.getText());
    }
}
