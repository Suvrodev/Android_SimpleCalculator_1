package com.example.calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup;
    RadioButton radioButton,rb_on,rb_off;

    TextView InputText,OutputText;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_c,b_percent,b_multiple,b_subtract,b_add,b_div,b_equal,b_power,b_point;

    String Input,Output,NewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        InputText= (TextView) findViewById(R.id.id_input_txt);
        OutputText= (TextView) findViewById(R.id.id_output_txt);

        b0= (Button) findViewById(R.id.id_0);
        b1= (Button) findViewById(R.id.id_1);
        b2= (Button) findViewById(R.id.id_2);
        b3= (Button) findViewById(R.id.id_3);
        b4= (Button) findViewById(R.id.id_4);
        b5= (Button) findViewById(R.id.id_5);
        b6= (Button) findViewById(R.id.id_6);
        b7= (Button) findViewById(R.id.id_7);
        b8= (Button) findViewById(R.id.id_8);
        b9= (Button) findViewById(R.id.id_9);
        b_c= (Button) findViewById(R.id.id_c);
        b_percent= (Button) findViewById(R.id.id_percent);
        b_power= (Button) findViewById(R.id.id_power);
        b_multiple= (Button) findViewById(R.id.id_mul);
        b_div= (Button) findViewById(R.id.id_div);
        b_subtract= (Button) findViewById(R.id.id_sub);
        b_add= (Button) findViewById(R.id.id_add);
        b_equal= (Button) findViewById(R.id.id_equal);
        b_power= (Button) findViewById(R.id.id_power);
        b_point= (Button) findViewById(R.id.id_point);



        rb_off= (RadioButton) findViewById(R.id.id_off);
        rb_on= (RadioButton) findViewById(R.id.id_on);


        ///of when open app-->start--------------
        radioGroup= (RadioGroup) findViewById(R.id.id_radiogroup);
        int Select=radioGroup.getCheckedRadioButtonId();
        radioButton=(RadioButton)findViewById(Select);
        String Result_=radioButton.getText().toString();
        if(Result_.equalsIgnoreCase("off")){
            On_OFF(false);
            InputText.setText("");
            OutputText.setText("");
        }else {
            On_OFF(true);
        }
        //Off when open ap--->end---------------

        rb_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_OFF(true);
            }
        });
        rb_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_OFF(false);
                InputText.setText("");
                OutputText.setText("");
            }
        });


    }

    public void onButtonClick(View view){
        Button button=(Button) view;
        String Data=button.getText().toString();
        switch (Data){
            case "C":
                Input=null;
                Output=null;
                NewOutput=null;
                OutputText.setText("0");
                break;

            case "^":
                solve();
                Input+="^";

                break;
            case "*":
                solve();
                Input+="*";

                break;
            case "=":
                solve();
                break;
            case "%":
                Input+="%";
                double d=Double.parseDouble(InputText.getText().toString())/100;
                OutputText.setText(String.valueOf(d));
                break;
            case "0":
                if(InputText.getText().equals("")){}else {
                    Input+="0";
                }
                break;
            default:
                if(Input==null){
                    Input="";
                }
                if(Data.equals("+") || Data.equals("/") || Data.equals("-")){
                    solve();
                }
                ///I mean if any digit
                Input+=Data;



        }
        InputText.setText(Input);
    }

    private void solve(){
        DecimalFormat decimalFormat=new DecimalFormat("#.######");

        if(Input.split("\\+").length==2){
           String numbers[]=Input.split("\\+");
           try {
               double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
               String d_value=decimalFormat.format(d);
               d=Double.parseDouble(d_value);
               Output = Double.toString(d);
               NewOutput=CutDecimal(Output);

               OutputText.setText(NewOutput);
               Input = d + "";
           }catch (Exception e){
               OutputText.setError(e.getMessage().toString());
           }
        }

        if(Input.split("\\*").length==2){
           String numbers[]=Input.split("\\*");
           try {
               double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
               String d_value=decimalFormat.format(d);
               d=Double.parseDouble(d_value);

               Output = Double.toString(d);
               NewOutput=CutDecimal(Output);
               OutputText.setText(NewOutput);
               Input = d + "";
           }catch (Exception e){
               OutputText.setError(e.getMessage().toString());
           }
        }

        if(Input.split("\\/").length==2){
           String[] numbers=Input.split("\\/");
           try {
               double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
               Output = Double.toString(d);
               NewOutput=CutDecimal(Output);

               OutputText.setText(NewOutput);
               Input = d + "";
           }catch (Exception e){
               OutputText.setError(e.getMessage().toString());
           }
        }

        if(Input.split("\\-").length==2){
            String numbers[]=Input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                Output = Double.toString(d);
                NewOutput=CutDecimal(Output);

                OutputText.setText(NewOutput);
                Input = d + "";
            }catch (Exception e){
               // OutputText.setError(e.getMessage().toString());
            }
        }

        if(Input.split("\\^").length==2){
           String numbers[]=Input.split("\\^");
           try {
               double d =Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
               Output = Double.toString(d);
               NewOutput=CutDecimal(Output);

               OutputText.setText(NewOutput);
               Input = d + "";
           }catch (Exception e){
               OutputText.setError(e.getMessage().toString());
           }
        }
    }

    private String CutDecimal(String number){
        double double_number=0;
        String Number="";
        String n[]=number.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                number=n[0];
            }
//            else {
//                String str=n[0]+n[1];
//                Number=decimalFormat.format(str);
//            }
        }

        return number;
    }

    String OnMoreOperator(String str){
        return  str;
    }


    void On_OFF(boolean result){
        b0.setEnabled(result);
        b1.setEnabled(result);
        b2.setEnabled(result);
        b3.setEnabled(result);
        b4.setEnabled(result);
        b5.setEnabled(result);
        b6.setEnabled(result);
        b7.setEnabled(result);
        b8.setEnabled(result);
        b9.setEnabled(result);
        b_c.setEnabled(result);
        b_point.setEnabled(result);
        b_percent.setEnabled(result);
        b_power.setEnabled(result);
        b_equal.setEnabled(result);
        b_add.setEnabled(result);
        b_subtract.setEnabled(result);
        b_div.setEnabled(result);
        b0.setEnabled(result);
        b_multiple.setEnabled(result);
    }
}