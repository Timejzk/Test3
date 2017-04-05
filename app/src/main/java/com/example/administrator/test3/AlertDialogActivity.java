package com.example.administrator.test3;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }
    public void onDialog(View view){
        AlertDialog alertDialog= new AlertDialog.Builder(this)
                .setTitle("ANDROID APP")
                .setNegativeButton("cancel",null)
                .setPositiveButton("ok",null)
                .setView(R.layout.definebyme_alert_dialog)
                .show();
    }
}
