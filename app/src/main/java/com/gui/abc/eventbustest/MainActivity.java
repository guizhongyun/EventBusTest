package com.gui.abc.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    public void startSecond(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        EventBus.getDefault().unregister(this);
    }

    //接收事件
    @Subscribe
    public void onEventMainThread(MyEvent MyEvent){
        Toast.makeText(this, MyEvent.getContent(), Toast.LENGTH_SHORT).show();
    }

    public void passSelf(View view){
        //取消注册
        EventBus.getDefault().post(new MyEvent("传递给当前线程"));
    }
}
