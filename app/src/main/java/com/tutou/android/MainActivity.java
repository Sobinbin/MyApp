package com.tutou.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Sobinbin
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        Switch toggle = findViewById(R.id.toggle);
        final ImageView imageView = findViewById(R.id.imageView);

        // button 监听事件，将editText中字符串转发到activity_web_view中并跳转
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,WebViewActivity.class);
                intent.putExtra("url",str);
                Log.d("MainActivity","Jump to "+str);
                startActivity(intent);
            }
        });

        // switch 监听事件，切换imageView 图片src
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Log.d("MainActivity","switch on the button");
                    imageView.setImageResource(R.mipmap.wuhan);
                } else {
                    Log.d("MainActivity","switch off the button");
                    imageView.setImageResource(R.mipmap.mmexport1550417122856);
                }
            }
        });
    }
}
