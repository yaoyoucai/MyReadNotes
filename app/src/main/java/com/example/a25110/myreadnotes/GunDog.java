package com.example.a25110.myreadnotes;

import android.util.Log;

/**
 * 项目名称：MyReadNotes
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/11 7:30
 * 修改人：yh
 * 修改时间：2017/3/11 7:30
 * 修改备注：
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        Log.e("TAG", "我是一只狗狗");
    }

    @Override
    public void run() {
        Log.e("TAG", "我跑得很快");
    }
}
