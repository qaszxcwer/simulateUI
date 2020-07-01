package personal.simulateui.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/1
 */
public class ItemChat implements MultiItemEntity {
    public static final int TYPE_USER = 0;
    public static final int TYPE_OTHER = 1;

    @Override
    public int getItemType() {
        return type;
    }

    public ItemChat(String text, int type) {
        this.text = text;
        this.type = type;
    }

    private String text = "";

    private int type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setItemType(int type) {
        this.type = type;
    }
}
