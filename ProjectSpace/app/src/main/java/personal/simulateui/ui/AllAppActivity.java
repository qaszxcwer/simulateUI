package personal.simulateui.ui;

import androidx.databinding.DataBindingUtil;
import personal.simulateui.R;
import personal.simulateui.adapter.AppAdapter;
import personal.simulateui.api.AllAppsConstants;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.bean.ItemApp;
import personal.simulateui.databinding.ActivityAllAppBinding;
import personal.simulateui.defindView.AppsGridView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        List<ItemApp> appData = getData();
        adapter.setList(appData);

        initNewAppsView(binding.linAllAppsRoot, "最近使用", adapter);
        initNewAppsView(binding.linAllAppsRoot, "便民生活", adapter);
        initNewAppsView(binding.linAllAppsRoot, "财富管理", adapter);
        initNewAppsView(binding.linAllAppsRoot, "资金往来", adapter);
        initNewAppsView(binding.linAllAppsRoot, "教育公益", adapter);
    }

    private void initNewAppsView(LinearLayout rootView, String name, AppAdapter adapter) {
        if (rootView == null) {
            return;
        }
        if (TextUtils.isEmpty(name)) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_apps, null);
        TextView textView = view.findViewById(R.id.txtTypeName);
        textView.setText(name);
        AppsGridView gridView = view.findViewById(R.id.gridApps);
        gridView.setAdapter(adapter);
        rootView.addView(view, layoutParams);
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
