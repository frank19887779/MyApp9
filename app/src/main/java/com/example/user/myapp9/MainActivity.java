package com.example.user.myapp9;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{
    private TextView m_tv_message;
    private int mChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        m_tv_message = findViewById(R.id.tv_message);
    }

    public void click(View view) {
        new AlertDialog.Builder(this)
                .setMessage("你好帥")
                .setPositiveButton("我知道", this)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which ) {
        m_tv_message.setText("我知道");
    }

    public void click2(View view) {
        打招呼 xxx = new 打招呼();
        new AlertDialog.Builder(this)
                .setMessage("面試官你/妳好")
                .setPositiveButton("女生", xxx)
                .setNegativeButton("男生", xxx)
                .show();
    }

    private class 打招呼  implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    m_tv_message.setText("面試官妳好美");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    m_tv_message.setText("面試官你好帥");
                    break;
            }
        }
    }

    public void click3(View view) {
        new AlertDialog.Builder(this)
                .setMessage("你好帥")
                .setPositiveButton("謝謝讚美", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("謝謝讚美");
                    }
                })
                .setNegativeButton("太狗腿了吧", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("太狗腿了吧");
                    }
                })
                .setNeutralButton("不知道該說什麼", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("不知道該說什麼");
                    }
                })
                .show();
    }

    public void click4(View view) {
        final String[] response = getResources().getStringArray(R.array.response);
        new AlertDialog.Builder(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar)
                .setTitle("你好帥")
                .setItems(response, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText(response[which]);
                    }
                })
                .show();
    }

    public void click5(View view) {
        final String[] response = getResources().getStringArray(R.array.response);
        final boolean[] selected = new boolean[response.length];

        new AlertDialog.Builder(this)
                .setTitle("你好帥")
                .setMultiChoiceItems(response, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder result = new StringBuilder();
                        for(int i=0; i<selected.length; i++){
                            if(selected[i]){
                                result.append(response[i]).append("\n");
                            }
                        }
                        m_tv_message.setText(result);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("無言");
                    }
                })
                .show();
    }

    public void click6(View view) {
        final String[] response = getResources().getStringArray(R.array.response);
        mChoice = 0;
        new AlertDialog.Builder(this)
                .setTitle("你好帥")
                .setSingleChoiceItems(response, mChoice, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mChoice = which;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText(response[mChoice]);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_tv_message.setText("無言");
                    }
                })
                .show();
    }
}
