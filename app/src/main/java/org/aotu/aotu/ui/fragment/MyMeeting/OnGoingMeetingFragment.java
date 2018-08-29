package org.aotu.aotu.ui.fragment.MyMeeting;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.aotu.aotu.R;
import org.aotu.aotu.entity.Meeting;
import org.aotu.aotu.ui.adapter.MeetingAdapter;
import org.aotu.aotu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class OnGoingMeetingFragment extends Fragment{

    private Context context;
    private ListView meetings;
    private MeetingAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_my_meeting_on_going,container,false);
        initView(view);
        initData();
        initClickListener();
        return view;
    }

    private void initClickListener(){
        meetings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.shortToast("进入会议详情");
            }
        });
    }

    private void initData(){
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Meeting temp = new Meeting();
            temp.setTheme("日志APP—" + i);
            temp.setPeople("测试人员");
            temp.setId(i);
            list.add(temp);
        }
        list.get(5).setPeople("测试人员,测试人员,测试人员,测试人员,测试人员");
        list.get(9).setTheme("日志APP,日志APP,日志APP,日志APP,日志APP,日志APP,日志APP");
        adapter = new MeetingAdapter(context,list,1);
        meetings.setAdapter(adapter);
    }

    private void initView(View view) {
        meetings = view.findViewById(R.id.lv_on_going_meeting);
    }
}
