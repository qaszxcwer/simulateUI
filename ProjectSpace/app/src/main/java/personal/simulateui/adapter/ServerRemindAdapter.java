package personal.simulateui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import personal.simulateui.R;
import personal.simulateui.api.ServerRemindConstants;
import personal.simulateui.bean.ItemServerRemind;
import personal.simulateui.bean.ItemServerRemind_Express;
import personal.simulateui.bean.ItemServerRemind_Pay;
import personal.simulateui.util.Logger;

/**
 * 作者：qaszxcwer，日期：2020/5/27
 */
public class ServerRemindAdapter extends BaseMultiItemQuickAdapter<ItemServerRemind, BaseViewHolder> {
    private String getTag() {
        return ServerRemindConstants.tag + "ServerRemindAdapter";
    }
    public ServerRemindAdapter(@NotNull List<ItemServerRemind> data) {
        super(data);
        Logger.i(getTag(), "data size = " + data.size());
        addItemType(ServerRemindConstants.SERVER_PAY, R.layout.item_services_remind_pay);
        addItemType(ServerRemindConstants.SERVER_EXPRESS, R.layout.item_services_remind_express);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemServerRemind item) {
        switch (baseViewHolder.getItemViewType()) {
            case ServerRemindConstants.SERVER_PAY:
                ItemServerRemind_Pay itemPay = (ItemServerRemind_Pay) item;
                baseViewHolder.setText(R.id.txtServerName, itemPay.getName());
                baseViewHolder.setText(R.id.txtServerTime, itemPay.getTime());
                baseViewHolder.setText(R.id.txtMoney, itemPay.getMoney());
                baseViewHolder.setText(R.id.txtAddress, itemPay.getAddress());
                break;
            case ServerRemindConstants.SERVER_EXPRESS:
                ItemServerRemind_Express itemExpress = (ItemServerRemind_Express) item;
                baseViewHolder.setText(R.id.txtServerName, itemExpress.getName());
                baseViewHolder.setText(R.id.txtServerTime, itemExpress.getTime());
                baseViewHolder.setText(R.id.txtItemStatus, itemExpress.getStatus());
                baseViewHolder.setText(R.id.txtItemName, itemExpress.getGoodsName());
                baseViewHolder.setText(R.id.txtItemExpressNo, itemExpress.getExpressNo());
                break;
            default:
                Logger.i(getTag(), "new type = " + baseViewHolder.getItemViewType());
                break;
        }
    }
}
