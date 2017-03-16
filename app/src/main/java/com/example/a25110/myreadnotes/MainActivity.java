package com.example.a25110.myreadnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String msg = savedInstanceState != null ? "true" : "false";
        Log.e("TAG", "onCreate,hasSaveInstance : " + msg);


    }

    public void handleInfo(View view) {
        Dog target = new GunDog();
        MyInvocationHandler ih = new MyInvocationHandler();
        ih.setTarget(target);
        Dog dog = (Dog) Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), ih);
        dog.info();
    }

    private class MyInvocationHandler implements InvocationHandler {
        private Object target;

        public void setTarget(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            DogUtils.methoid1();
            Object result = method.invoke(target, objects);
            DogUtils.methoid2();
            return result;
        }
    }

    ;

    public void openThreadPool(View view) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Log.e("TAG", Thread.currentThread().getName() + "的i值为：" + i);
                }
            }
        };
        executorService.submit(target);
        executorService.submit(target);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("TAG", "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("TAG", "onRestoreInstanceState: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy: ");
    }
}
