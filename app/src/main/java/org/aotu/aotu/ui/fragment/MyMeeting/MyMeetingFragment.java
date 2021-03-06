package org.aotu.aotu.ui.fragment.MyMeeting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.aotu.aotu.R;

public class MyMeetingFragment extends Fragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("我的会议");
        View view = inflater.inflate(R.layout.fragment_my_meeting,container,false);
        initView(view);
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(this.getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void initView(View view){
        tabLayout = view.findViewById(R.id.tl_my_meeting);
        viewPager = view.findViewById(R.id.vp_content);
    }

    private class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        private final String[] titles = { "未开会议", "已开会议" };

        private TabFragmentPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public int getCount() {
            return this.titles.length;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new OnGoingMeetingFragment();
                case 1:
                    return new CompleteMeetingFragment();
            }
            return null;
        }

        @Nullable
        public CharSequence getPageTitle(int paramInt) {
            return this.titles[paramInt];
        }
    }
}
