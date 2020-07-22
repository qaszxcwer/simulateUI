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
public class RegionsPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_some_regions, parent, false);
        return new RegionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        RegionsViewHolder regionsViewHolder = (RegionsViewHolder) viewHolder;
        RegionListBean regionListBean = (RegionListBean) item;
        regionsViewHolder.regionCode.setText(regionListBean.getRegionCode());
        regionsViewHolder.initView(regionListBean.getRegionList());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    public class RegionsViewHolder extends Presenter.ViewHolder {
        public TextView regionCode;

        public HorizontalGridView hgRegions;

        private int itemNumPreLine = 3;

        public RegionsViewHolder(View view) {
            super(view);
            regionCode = view.findViewById(R.id.txtRegionsCode);
            hgRegions = view.findViewById(R.id.hgRegions);
        }

        public void initView(List<String> list) {
            ArrayObjectAdapter adapter = new ArrayObjectAdapter(new ItemRegionsPresenter());
            ItemBridgeAdapter itemBridgeAdapter = new ItemBridgeAdapter(adapter);
            hgRegions.setAdapter(itemBridgeAdapter);
            // 3个一行
            int lines = list.size()/itemNumPreLine + (list.size() % itemNumPreLine == 0 ? 0 : 1);
            hgRegions.setNumRows(lines);
            ViewGroup.LayoutParams layoutParams = hgRegions.getLayoutParams();
            // 每行50像素高
            layoutParams.height = lines * 50;
            adapter.addAll(0, list);
        }
    }
}
