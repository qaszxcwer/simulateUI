package personal.simulateui.leanbackPresenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import personal.simulateui.R;
import personal.simulateui.bean.RegionListBean;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/22
 */
public class ItemRegionsPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_regions, parent, false);
        return new ItemRegionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ItemRegionsViewHolder itemRegionsViewHolder = (ItemRegionsViewHolder) viewHolder;
        String string = (String) item;
        itemRegionsViewHolder.regionName.setText(string);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    public class ItemRegionsViewHolder extends ViewHolder {
        public TextView regionName;

        public ItemRegionsViewHolder(View view) {
            super(view);
            regionName = view.findViewById(R.id.txtRegionName);
        }
    }
}
