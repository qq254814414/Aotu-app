package org.aotu.aotu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.aotu.aotu.R;
import org.aotu.aotu.utils.ToastUtil;

public class ApplyMeetingFragment extends Fragment{

    private Button apply_meeting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apply_meeting,container,false);
        initView(view);
        initClickListener();
        return view;
    }

    private void initClickListener(){
        apply_meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast("发布会议");
            }
        });
    }

    private void initView(View view) {
        apply_meeting = view.findViewById(R.id.bt_apply_meeting);
    }
}
