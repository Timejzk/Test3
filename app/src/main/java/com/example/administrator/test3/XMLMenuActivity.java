package com.example.administrator.test3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class XMLMenuActivity extends AppCompatActivity {

    private TextView tv_TestTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlmenu);
        tv_TestTxt=(TextView)findViewById(R.id.tv_test_txt);//把这行放在setContentView之前会崩，证明setContentView函数执行完才加载出xml


    }
    /*
* XML菜单
* */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exam3_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.font_size_item10:tv_TestTxt.setTextSize(10);break;
            case R.id.font_size_item16:tv_TestTxt.setTextSize(16);break;
            case R.id.font_size_item20:tv_TestTxt.setTextSize(20);break;
            case R.id.font_color_red:tv_TestTxt.setTextColor(Color.parseColor("#ffff6666"));break;
            case R.id.font_color_green:tv_TestTxt.setTextColor(Color.parseColor("#ffccffff"));break;
        }
        return super.onOptionsItemSelected(item);
    }
}
