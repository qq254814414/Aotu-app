package org.aotu.aotu.ui.fragment.GradeReport;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Daily;
import org.aotu.aotu.ui.adapter.DailyAdapter;

import java.util.ArrayList;
import java.util.List;

public class GradeDailyFragment extends Fragment{

    private Context context;
    private ListView dailyList;
    private DailyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_grade_daily,container,false);
        initView(view);
        initData();
        return view;
    }

    private void initData(){
        List<Daily> list = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            Daily temp = new Daily();
            temp.setTime("星期一" + "\n" + "(8月27日)");
            temp.setItem("整体事项");
            temp.setValue(0);
            list.add(temp);
        }
        list.get(1).setTime("星期二" + "\n" + "(8月28日)");
        list.get(2).setTime("星期三" + "\n" + "(8月29日)");
        list.get(3).setTime("星期四" + "\n" + "(8月30日)");
        list.get(4).setTime("星期五" + "\n" + "(8月31日)");
        list.get(5).setTime("星期六" + "\n" + "(9月1日)");
        adapter = new DailyAdapter(context,list);
        dailyList.setAdapter(adapter);
    }

    private void initView(View view) {
        dailyList = view.findViewById(R.id.lv_daily);
    }
}
