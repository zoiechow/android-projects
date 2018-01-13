package com.w1982.triangletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edgeA;
    private EditText edgeB;
    private EditText edgeC;
    private Button buttonSubmit;
    private TextView outputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edgeA =(EditText)findViewById(R.id.edgeA);
        edgeB =(EditText)findViewById(R.id.edgeB);
        edgeC =(EditText)findViewById(R.id.edgeC);

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        outputText = (TextView)findViewById(R.id.outputText);

        ButtonListener myButtonlistener = new ButtonListener();
        buttonSubmit.setOnClickListener(myButtonlistener);
    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String valueA = edgeA.getText().toString().trim();
            String valueB = edgeB.getText().toString().trim();
            String valueC = edgeC.getText().toString().trim();

            if (valueA.length()<1 || valueA.length()>3 ||valueB.length()<1 || valueB.length()>3||valueC.length()<1 || valueC.length()>3 ){
                outputText.setText("输入的长度不正确！");
            }else if (!valueA.matches("^[0-9]*$")){
                outputText.setText("A不是整数！");
            }else if (!valueB.matches("^[0-9]*$")){
                outputText.setText("B不是整数！");
            }else if (!valueC.matches("^[0-9]*$")){
                outputText.setText("C不是整数！");
            }else if((valueA.equals(valueB)) & (valueB.equals(valueC))){
                outputText.setText("等边三角形！");
            }else if(valueA.equals(valueB) | valueA.equals(valueC)|valueB.equals(valueC)){
                outputText.setText("等腰三角形！");
            }else{
                outputText.setText("其他三角形！");
            }



        }
    }
}
