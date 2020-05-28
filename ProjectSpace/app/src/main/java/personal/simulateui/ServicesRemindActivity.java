package personal.simulateui;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import personal.simulateui.adapter.ServerRemindAdapter;
import personal.simulateui.api.ServerRemindConstants;
import personal.simulateui.base.BaseActivity;
import personal.simulateui.bean.ItemServerRemind;
import personal.simulateui.bean.ItemServerRemind_Express;
import personal.simulateui.bean.ItemServerRemind_Pay;
import personal.simulateui.databinding.ActivityServicesRemindBinding;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：qaszxcwer，日期：2020/5/26
 * 仿支付宝服务提醒页面
 */
public class ServicesRemindActivity extends BaseActivity {
    @Override
    protected boolean isNeedStatusChange() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityServicesRemindBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_services_remind);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recServicesRemind.setLayoutManager(layoutManager);
        ServerRemindAdapter adapter = new ServerRemindAdapter(getData());
        binding.recServicesRemind.setAdapter(adapter);
    }

    private List<ItemServerRemind> getData() {
        List list = new ArrayList<ItemServerRemind>();
        list.add(new ItemServerRemind_Express(ServerRemindConstants.SERVER_EXPRESS, "我的快递", "19:29", "已签收", "商品名称XXXX", "XX快递：123456789"));
        list.add(new ItemServerRemind_Pay(ServerRemindConstants.SERVER_PAY, "支付助手", "19:21", "￥17.00", "XX家常菜-AA路店"));
        list.add(new ItemServerRemind_Express(ServerRemindConstants.SERVER_EXPRESS, "我的快递", "19:15", "已签收", "商品名称YYYY", "YY快递：987654321"));
        list.add(new ItemServerRemind_Pay(ServerRemindConstants.SERVER_PAY, "支付助手", "19:09", "￥3.00", "XX小卖部"));
        list.add(new ItemServerRemind_Express(ServerRemindConstants.SERVER_EXPRESS, "我的快递", "19:04", "已签收", "商品名称ZZZZ", "YY快递：741852963"));
        list.add(new ItemServerRemind_Pay(ServerRemindConstants.SERVER_PAY, "支付助手", "19:01", "￥2.00", "XX小卖部"));

        return list;
    }
}
