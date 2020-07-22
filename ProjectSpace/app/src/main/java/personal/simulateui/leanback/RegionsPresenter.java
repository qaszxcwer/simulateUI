package personal.simulateui.leanback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    public class RegionsViewHolder extends Presenter.ViewHolder {
        public TextView regionCode;

        public RegionsViewHolder(View view) {
            super(view);
            regionCode = view.findViewById(R.id.txtRegionsCode);
        }
    }
}
