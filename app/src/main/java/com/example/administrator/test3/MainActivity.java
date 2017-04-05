package com.example.administrator.test3;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtn_toSimpleAdapter;
    private Button mbtn_toAlertDialog;
    private Button mbtn_toXMlMenu;
    private Button mbtn_toActionMode;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initListener();
    }



    private void initView() {
        mbtn_toSimpleAdapter=bindView(R.id.btn_toSimpleAdapter);
        mbtn_toAlertDialog=bindView(R.id.btn_toAlertDialog);
        mbtn_toXMlMenu=bindView(R.id.btn_toXMlMenu);
        mbtn_toActionMode=bindView(R.id.btn_toActionMode);
    }
    private void initListener() {
        mbtn_toSimpleAdapter.setOnClickListener(this);
        mbtn_toAlertDialog.setOnClickListener(this);
        mbtn_toXMlMenu.setOnClickListener(this);
        mbtn_toActionMode.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_toSimpleAdapter:
                startActivity(new Intent(MainActivity.this,SimpleAdapterActivity.class));break;
            case R.id.btn_toAlertDialog:
                startActivity(new Intent(MainActivity.this,AlertDialogActivity.class));break;
            case R.id.btn_toXMlMenu:
                startActivity(new Intent(MainActivity.this,XMLMenuActivity.class));break;
            case R.id.btn_toActionMode:
                startActivity(new Intent(MainActivity.this,ActionModeActivity.class));break;

        }
    }
    //用泛型解决每次绑定ID需要转换类型
    private <T extends View> T bindView(@IdRes int id){
        View viewById=findViewById(id);
        return (T) viewById;//个人猜测：运行时“=”号前对象类型告诉此函数转换成什么类型
    }
}
