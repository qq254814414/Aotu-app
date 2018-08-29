package org.aotu.aotu.ui.fragment.MyWork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.WorkPlan;
import org.aotu.aotu.ui.adapter.WorkPlanAdapter;
import org.aotu.aotu.ui.fragment.ApplyMeetingFragment;
import org.aotu.aotu.utils.PageChangeUtil;

import java.util.ArrayList;
import java.util.List;

public class WorkPlanFragment extends Fragment{

    private Context context;
    private TextView cycle;
    private ListView workPlan;
    private WorkPlanAdapter adapter;
    private Button submit_daily;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_my_work_plan,container,false);
        initView(view);
        initData();
        initClickListener();
        return view;
    }

    private void initClickListener(){
        submit_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new ApplyMeetingFragment());
            }
        });
    }

    private void initData(){
        List<WorkPlan> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            WorkPlan temp = new WorkPlan();
            temp.setModule("日志APP");
            temp.setHead("测试");
            temp.setFunction("工作计划");
            temp.setIntroduction("工作计划介绍");
            list.add(temp);
        }
        list.get(5).setIntroduction("工作计划介绍，工作计划介绍，工作计划介绍，工作计划介绍");
        list.get(2).setHead("测试，测试，测试");
        list.get(8).setFunction("工作计划，工作计划");
        adapter = new WorkPlanAdapter(context,list);
        workPlan.setAdapter(adapter);
    }

    private void initView(View view) {
        cycle = view.findViewById(R.id.tv_plan_cycle);
        workPlan = view.findViewById(R.id.lv_work_plan);
        submit_daily = view.findViewById(R.id.bt_submit_daily);
    }
}
