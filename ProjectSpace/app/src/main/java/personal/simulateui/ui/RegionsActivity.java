package personal.simulateui.ui;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.VerticalGridView;
import personal.simulateui.R;
import personal.simulateui.bean.RegionBean;
import personal.simulateui.bean.RegionListBean;
import personal.simulateui.leanbackPresenter.RegionsPresenter;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/22
 *
 * 省份选择界面（非界面模仿，工作中将要用到，先预研）
 * 给电视机用的，不完全支持触屏
 */
public class RegionsActivity extends Activity {

    /**
     * 假装是服务端返回的数据
     * @return list
     */
    private List<RegionBean> getData() {
        List<RegionBean> list = new ArrayList<>();
        list.add(new RegionBean("J", "江苏"));
        list.add(new RegionBean("J", "江西"));

        list.add(new RegionBean("H", "湖南"));
        list.add(new RegionBean("H", "湖北"));
        list.add(new RegionBean("H", "河北"));
        list.add(new RegionBean("H", "河南"));
        list.add(new RegionBean("H", "海南"));

        list.add(new RegionBean("S", "山西"));
        list.add(new RegionBean("S", "陕西"));

        return list;
    }

    private VerticalGridView verticalGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regions);
        verticalGridView = findViewById(R.id.vgRegions);
        showData();
    }

    private void showData() {
        List<RegionListBean> regionListBeans = prepareData();
        /**
         * Presenter 某一类型数据的处理
         * PresenterSelector 根据类型选择不同的presenter，只在多类型的时候才需要写
         * ObjectAdapter 数据管理
         * ItemBridgeAdapter 链接view和上面3个
         */
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(new RegionsPresenter());
        ItemBridgeAdapter itemBridgeAdapter = new ItemBridgeAdapter(adapter);
        verticalGridView.setAdapter(itemBridgeAdapter);
        adapter.addAll(0, regionListBeans);
    }

    private List<RegionListBean> prepareData() {
        List<RegionBean> regionBeans = getData();
        String code = "";
        List<RegionListBean> regionListBeans = new ArrayList<>();
        int size = regionListBeans.size();
        for (RegionBean bean : regionBeans) {
            if (!code.equals(bean.getRegionCode())) {
                regionListBeans.add(new RegionListBean(bean.getRegionCode()));
                size++;
                code = bean.getRegionCode();
            }
            regionListBeans.get(size - 1).addRegion(bean.getRegionsName());
        }
        return regionListBeans;
    }
}
