package org.aotu.aotu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Meeting;
import org.aotu.aotu.ui.fragment.MeetingIntroduceFragment;
import org.aotu.aotu.utils.PageChangeUtil;
import org.aotu.aotu.utils.ToastUtil;

import java.util.List;

public class MeetingAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private List<Meeting> list;
    private int type;

    /**
     *
     * @param context
     * @param list
     * @param type  0为不显示编辑，1为显示
     */
    public MeetingAdapter(Context context, List<Meeting> list, int type) {
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.type = type;
        this.context = context;
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
            convertView = inflater.inflate(R.layout.item_meeting,null);
            holder = new ViewHolder();
            holder.theme = convertView.findViewById(R.id.tv_meeting_theme);
            holder.people = convertView.findViewById(R.id.tv_meeting_people);
            holder.time = convertView.findViewById(R.id.tv_meeting_time);
            holder.edit = convertView.findViewById(R.id.bt_edit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        Meeting temp = list.get(position);
        if (type == 1){
            if (temp.getId() == 6){
                holder.edit.setVisibility(View.VISIBLE);
                holder.edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new MeetingIntroduceFragment());
                    }
                });
            } else {
                holder.edit.setVisibility(View.INVISIBLE);
            }
        } else {
            holder.edit.setVisibility(View.INVISIBLE);
        }
        holder.theme.setText(temp.getTheme());
        holder.people.setText(temp.getPeople());
        holder.time.setText("2018/08/28 15:30—16:30");
        return convertView;
    }

    class ViewHolder {
        TextView theme;
        TextView people;
        TextView time;
        Button edit;
    }
}
