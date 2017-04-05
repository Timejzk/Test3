package com.example.administrator.test3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        initView();
        listViewShow();
        setListviewLisener();

    }

    private void initView() {

        listView=(ListView)findViewById(R.id.lv_simpleAdapter);

    }

    private void listViewShow(){
        ArrayList<HashMap<String ,Object>> list=new ArrayList<HashMap<String ,Object>>();//泛型定义只支持Integer
        String[] desString={"Lion","Tiger","Monkey","Dog","Cat"};
        Integer[] phoInt={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};
        for(int i=0;i<5;i++){
            HashMap<String ,Object> map=new  HashMap<String ,Object>();
            map.put("description",desString[i]);
            map.put("photo",phoInt[i]);
            list.add(map);
        }
        listView.setAdapter(new SimpleAdapter(
                this,
                list,
                R.layout.main_listview_item,
                new String[] {"description","photo"},
                new int[] {R.id.tv_lvitem_description,R.id.iv_lvitem_photo}));
    }
    private void setListviewLisener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleAdapterActivity.this,
                        ((TextView) view.findViewById(R.id.tv_lvitem_description)).getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
