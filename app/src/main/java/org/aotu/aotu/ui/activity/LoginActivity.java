package org.aotu.aotu.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.aotu.aotu.R;
import org.aotu.aotu.ui.fragment.LoginFragment;
import org.aotu.aotu.utils.PageChangeUtil;

public class LoginActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        PageChangeUtil.replaceFragment(this,R.id.activity_fragment,new LoginFragment());
    }
}
