package personal.simulateui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import personal.simulateui.R;
import personal.simulateui.bean.ItemApp;

/**
 * 作者：qaszxcwer，日期：2020/6/8
 */
public class AppAdapter extends BaseAdapter {

    List<ItemApp> list = new ArrayList<>();

    public void setList(List<ItemApp> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.txtAppName);
        textView.setText(list.get(position).getName());
        return convertView;
    }
}
