package com.example.wz.litepaldemo;

import org.litepal.crud.DataSupport;

/**
 * Created by 王正 on 2019/2/6.
 */

public class student extends DataSupport{

    private String name;
    private int core;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCore() {
        return core;
    }
    public void setCore(int core) {
        this.core = core;
    }

}
