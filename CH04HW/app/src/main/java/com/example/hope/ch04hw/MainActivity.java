package com.example.hope.ch04hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inName;
    private Button button1;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inName=(EditText)findViewById( R.id.inName);
        button1=(Button)findViewById(R.id.button1);
        outputText=(TextView)findViewById(R.id.outputText);

        ButtonListener mbt=new ButtonListener();
        button1.setOnClickListener(mbt);

    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String valueName=inName.getText().toString();
            outputText.setText("你好"+valueName);
        }
    }

}
