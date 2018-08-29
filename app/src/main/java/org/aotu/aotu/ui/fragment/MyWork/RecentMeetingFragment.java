package org.aotu.aotu.ui.fragment.MyWork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Meeting;
import org.aotu.aotu.ui.adapter.MeetingAdapter;
import org.aotu.aotu.ui.fragment.ApplyMeetingFragment;
import org.aotu.aotu.ui.fragment.MeetingIntroduceFragment;
import org.aotu.aotu.utils.PageChangeUtil;
import org.aotu.aotu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class RecentMeetingFragment extends Fragment{

    private Context context;
    private ListView recentMeeting;
    private MeetingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_my_work_recent_meeting,container,false);
        initView(view);
        initData();
        initClickListener();
        return view;
    }

    private void initClickListener(){
        recentMeeting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new MeetingIntroduceFragment());
            }
        });
    }

    private void initData(){
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Meeting temp = new Meeting();
            temp.setTheme("日志APP—" + i);
            temp.setPeople("测试人员");
            list.add(temp);
        }
        list.get(5).setPeople("测试人员,测试人员,测试人员,测试人员,测试人员");
        list.get(9).setTheme("日志APP,日志APP,日志APP,日志APP,日志APP,日志APP,日志APP");
        adapter = new MeetingAdapter(context,list,0);
        recentMeeting.setAdapter(adapter);
    }

    private void initView(View view) {
        recentMeeting = view.findViewById(R.id.lv_recent_meeting);
    }
}
