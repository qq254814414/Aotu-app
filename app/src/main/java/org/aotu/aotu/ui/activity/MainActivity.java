package org.aotu.aotu.ui.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.aotu.aotu.R;
import org.aotu.aotu.ui.fragment.ApplyMeetingFragment;
import org.aotu.aotu.ui.fragment.GradeReport.GradeDailyFragment;
import org.aotu.aotu.ui.fragment.GradeReport.GradeWeeklyFragment;
import org.aotu.aotu.ui.fragment.MyMeeting.MyMeetingFragment;
import org.aotu.aotu.ui.fragment.MyWork.MyWorkFragment;
import org.aotu.aotu.ui.fragment.SubmitReport.SubmitReportFragment;
import org.aotu.aotu.utils.PageChangeUtil;
import org.aotu.aotu.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initClickListener();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        actionBar = getSupportActionBar();
        PageChangeUtil.replaceFragment(this,R.id.activity_main_content,new MyWorkFragment());
    }

    private void initClickListener(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_my_work :
                        actionBar.setTitle("我的工作");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new MyWorkFragment());
                        break;
                    case R.id.nav_my_meeting :
                        actionBar.setTitle("我的会议");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new MyMeetingFragment());
                        break;
                    case R.id.nav_submit_report :
                        actionBar.setTitle("提交报表");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new SubmitReportFragment());
                        break;
                    case R.id.nav_apply_meeting :
                        actionBar.setTitle("发布会议");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new ApplyMeetingFragment());
                        break;
                    case R.id.nav_grade_daily :
                        actionBar.setTitle("日报管理");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new GradeDailyFragment());
                        break;
                    case R.id.nav_grade_weekly :
                        actionBar.setTitle("周报管理");
                        PageChangeUtil.replaceFragment(context,R.id.activity_main_content,new GradeWeeklyFragment());
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void initView(){
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        int i = 0;
        //ToolBar    Title居中
        while (i < toolbar.getChildCount()){
            Object temp = toolbar.getChildAt(i);
            if (temp instanceof TextView){
                TextView view = (TextView)temp;
                Toolbar.LayoutParams params = new Toolbar.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
                params.gravity = Gravity.CENTER_HORIZONTAL;
                view.setTextSize(18.0F);
                view.setLayoutParams(params);
            }
            i++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.bar_notice){
            ToastUtil.shortToast("通知按钮点击");
        }
        return true;
    }
}