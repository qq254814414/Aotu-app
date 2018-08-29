package org.aotu.aotu.ui.fragment.GradeReport;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Daily;
import org.aotu.aotu.ui.adapter.DailyAdapter;

import java.util.ArrayList;
import java.util.List;

public class GradeDailyFragment extends Fragment{

    private Context context;
    private ListView dailyList;
    private DailyAdapter adapter;
    private ArrayAdapter adapter_sp_people;
    private ArrayAdapter adapter_sp_time;
    private Spinner sp_people;
    private Spinner sp_time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("日报管理");
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
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list1.add("测试人");
        }
        adapter_sp_people = new ArrayAdapter<>(context,R.layout.item_spinner,list1);

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list2.add("36周 8.27—9.1");
        }
        adapter_sp_time = new ArrayAdapter<>(context,R.layout.item_spinner,list2);
        sp_people.setAdapter(adapter_sp_people);
        sp_time.setAdapter(adapter_sp_time);
    }

    private void initView(View view) {
        dailyList = view.findViewById(R.id.lv_daily);
        sp_people = view.findViewById(R.id.sp_people);
        sp_time = view.findViewById(R.id.sp_time);
    }
}
