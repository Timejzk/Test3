package com.example.administrator.test3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionModeActivity extends AppCompatActivity {

    private View v;
    private ListView listView;
    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);
        initView();
        listViewShow();
    }

    private void initView() {
        listView=(ListView)findViewById(R.id.lv_actionMode);
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
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (actionMode != null) {
                    Log.d("action",actionMode+"false");
                    return false;//false为事件继续响应，比如后面还有单击事件  true为事件终止，后面事件不响应
                }
                Log.d("action",actionMode+"");
                AppCompatActivity activity = ActionModeActivity.this;
                actionMode=activity.startSupportActionMode(actionmodecallback);
                actionMode.setSubtitle(position+1+"selected");
                view.setBackgroundColor(Color.parseColor("#0000ff"));
                view.setSelected(true);
                v=view;
                return true;
            }
        });
    }

    private ActionMode.Callback actionmodecallback= new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.exam3_actionmode_menu,menu);//inflate把R.menu装载到menu中
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                boolean ret=false;
                switch (item.getItemId()){

                    case R.id.action_delete:
                        mode.finish();
                        ret=true;
                        break;
                }
                return ret;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                if(v!=null){
                    v.setBackgroundColor(Color.parseColor("#ffffff"));
                    v.setSelected(false);
                }
            }
        };

}
