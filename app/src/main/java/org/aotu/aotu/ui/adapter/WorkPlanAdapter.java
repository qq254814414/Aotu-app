package org.aotu.aotu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.WorkPlan;

import java.util.List;

public class WorkPlanAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<WorkPlan> list;

    public WorkPlanAdapter(Context context, List<WorkPlan> list) {
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
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_work_plan,null);
            holder = new ViewHolder();
            holder.module = convertView.findViewById(R.id.tv_item_work_plan_module);
            holder.function = convertView.findViewById(R.id.tv_item_work_plan_function);
            holder.head = convertView.findViewById(R.id.tv_item_work_plan_head);
            holder.introduction = convertView.findViewById(R.id.tv_item_work_plan_introduction);
            holder.targetDate = convertView.findViewById(R.id.tv_item_work_plan_targetDate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        WorkPlan temp = list.get(position);
        holder.module.setText(temp.getModule());
        holder.function.setText(temp.getFunction());
        holder.introduction.setText(temp.getIntroduction());
        holder.head.setText(temp.getHead());
//        holder.targetDate.setText(temp.getTargetDate());
        holder.targetDate.setText("8/28");
        return convertView;
    }

    class ViewHolder {
        TextView module;
        TextView function;
        TextView introduction;
        TextView head;
        TextView targetDate;
    }

}
