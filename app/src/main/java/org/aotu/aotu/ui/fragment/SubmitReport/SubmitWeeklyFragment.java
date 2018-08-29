package org.aotu.aotu.ui.fragment.SubmitReport;

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

public class SubmitWeeklyFragment extends Fragment{

    private Button submit_weekly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit_report_weekly,container,false);
        initView(view);
        initClickListener();
        return view;
    }

    private void initClickListener(){
        submit_weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast("提交周报");
            }
        });
    }

    private void initView(View view) {
        submit_weekly = view.findViewById(R.id.bt_submit_weekly);
    }
}
