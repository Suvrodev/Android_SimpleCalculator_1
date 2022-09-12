package com.example.calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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


    }

    public void onButtonClick(View view){
        Button button=(Button) view;
        String Data=button.getText().toString();
        switch (Data){
            case "C":
                Input=null;
                Output=null;
                NewOutput=null;
                OutputText.setText("");
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
            default:
                if(Input==null){
                    Input="";
                }
                if(Data.equals("+") || Data.equals("/") || Data.equals("-")){
                    solve();
                }
                Input+=Data;



        }
        InputText.setText(Input);
    }

    private void solve(){
        if(Input.split("\\+").length==2){
           String numbers[]=Input.split("\\+");
           try {
               double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
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
               Output = Double.toString(d);
               NewOutput=CutDecimal(Output);

               OutputText.setText(NewOutput);
               Input = d + "";
           }catch (Exception e){
               OutputText.setError(e.getMessage().toString());
           }
        }

        if(Input.split("\\/").length==2){
           String numbers[]=Input.split("\\/");
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
        String n[]=number.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                number=n[0];
            }
        }

        return number;
    }
}