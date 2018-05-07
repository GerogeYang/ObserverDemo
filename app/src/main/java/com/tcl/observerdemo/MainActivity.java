package com.tcl.observerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Observer{
    private static final String TAG = MainActivity.class.getName();
    private Button btnRegister, btnUnRegister, btnSendMessage;
    private TextView textView;
    private ButtonListener listener;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = findViewById(R.id.register);
        btnRegister.setOnClickListener(this);
        btnUnRegister = findViewById(R.id.unregister);
        btnUnRegister.setOnClickListener(this);
        btnSendMessage = findViewById(R.id.sendmessage);
        btnSendMessage.setOnClickListener(this);
        textView = findViewById(R.id.textview);
        listener = new ButtonListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                listener.registerObserver(this);
                Toast.makeText(MainActivity.this,"观察者注册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.unregister:
                textView.setText("");
                listener.removeObserver(this);
                Toast.makeText(MainActivity.this,"取消注册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sendmessage:
                message = "My name is Mr Yang";
                listener.sendMessage(message);
                Toast.makeText(MainActivity.this,"发送消息："+message,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void update(String message) {
        textView.setText(message);
    }
}
