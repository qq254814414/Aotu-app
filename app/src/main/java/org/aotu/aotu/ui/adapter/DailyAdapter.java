package org.aotu.aotu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Daily;

import java.util.List;

public class DailyAdapter extends BaseAdapter{

    private List<Daily> list;
    private LayoutInflater inflater;

    public DailyAdapter(Context context, List<Daily> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
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
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_daily,null);
            holder = new ViewHolder();
            holder.time = convertView.findViewById(R.id.tv_daily_time);
            holder.item  = convertView.findViewById(R.id.tv_daily_item);
            holder.value = convertView.findViewById(R.id.et_daily_value);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.time.setText(list.get(position).getTime());
        holder.item.setText(list.get(position).getItem());
        holder.value.setText(list.get(position).getValue() + "");
        return convertView;
    }

    class ViewHolder{
        TextView time;
        TextView item;
        EditText value;
    }

}
