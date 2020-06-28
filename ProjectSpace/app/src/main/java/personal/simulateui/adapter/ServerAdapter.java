package personal.simulateui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import personal.simulateui.R;
import personal.simulateui.bean.ItemServer;

/**
 * 作者：qaszxcwer，日期：2020/5/31
 */
public class ServerAdapter extends BaseQuickAdapter<ItemServer, BaseViewHolder> {

    public ServerAdapter(@NonNull List<ItemServer> data){
        super(R.layout.item_services, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemServer item) {
        baseViewHolder.setText(R.id.txtItemServerName, item.getName());
    }
}
