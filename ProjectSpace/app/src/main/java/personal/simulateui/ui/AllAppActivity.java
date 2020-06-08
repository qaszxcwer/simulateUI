package personal.simulateui.ui;

import androidx.databinding.DataBindingUtil;
import personal.simulateui.R;
import personal.simulateui.adapter.AppAdapter;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.bean.ItemApp;
import personal.simulateui.databinding.ActivityAllAppBinding;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：qaszxcwer，日期：2020/6/4
 * 全部应用页面
 */
public class AllAppActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAllAppBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_all_app);
        AppAdapter adapter = new AppAdapter();
        adapter.setList(getData());

        binding.gridApps.setAdapter(adapter);
    }

    private List<ItemApp> getData() {
        List list = new ArrayList<ItemApp>();
        list.add(new ItemApp("充值中心"));
        list.add(new ItemApp("信用卡还款"));
        list.add(new ItemApp("生活缴费"));
        list.add(new ItemApp("市民中心"));
        list.add(new ItemApp("生活号"));

        list.add(new ItemApp("我的快递"));
        list.add(new ItemApp("医疗健康"));
        list.add(new ItemApp("记账本"));
        list.add(new ItemApp("发票管家"));
        list.add(new ItemApp("车主服务"));

        list.add(new ItemApp("交通出行"));
        list.add(new ItemApp("体育服务"));
        list.add(new ItemApp("安全备忘"));
        list.add(new ItemApp("健康码"));

        return list;
    }
}
