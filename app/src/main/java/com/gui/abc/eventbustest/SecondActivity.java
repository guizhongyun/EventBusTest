package com.gui.abc.eventbustest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by guizhongyun on 17/3/6.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void passOther(View view) {
        EventBus.getDefault().post(new MyEvent("传递消息给其他线程"));
    }
}
