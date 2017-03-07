package com.gui.abc.eventbustest;

/**
 * Created by guizhongyun on 17/3/6.
 */

public class MyEvent {
    private String content;
    public MyEvent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
