package com.example.calculator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup;
    RadioButton radioButton, rb_on, rb_off;

    TextView InputText, OutputText;
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b_c, b_percent, b_multiple, b_subtract, b_add, b_div, b_equal, b_power, b_point,b_root,b_00_0;

    String Input, Output, NewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InputText = (TextView) findViewById(R.id.id_input_txt);
        OutputText = (TextView) findViewById(R.id.id_output_txt);

        b0 = (Button) findViewById(R.id.id_0);
        b1 = (Button) findViewById(R.id.id_1);
        b2 = (Button) findViewById(R.id.id_2);
        b3 = (Button) findViewById(R.id.id_3);
        b4 = (Button) findViewById(R.id.id_4);
        b5 = (Button) findViewById(R.id.id_5);
        b6 = (Button) findViewById(R.id.id_6);
        b7 = (Button) findViewById(R.id.id_7);
        b8 = (Button) findViewById(R.id.id_8);
        b9 = (Button) findViewById(R.id.id_9);
        b_c = (Button) findViewById(R.id.id_c);
        b_percent = (Button) findViewById(R.id.id_percent);
        b_power = (Button) findViewById(R.id.id_power);
        b_multiple = (Button) findViewById(R.id.id_mul);
        b_div = (Button) findViewById(R.id.id_div);
        b_subtract = (Button) findViewById(R.id.id_sub);
        b_add = (Button) findViewById(R.id.id_add);
        b_equal = (Button) findViewById(R.id.id_equal);
        b_power = (Button) findViewById(R.id.id_power);
        b_point = (Button) findViewById(R.id.id_point);
        b_root= (Button) findViewById(R.id.id_root);
        b_00_0= (Button) findViewById(R.id.id_00_0);


        rb_off = (RadioButton) findViewById(R.id.id_off);
        rb_on = (RadioButton) findViewById(R.id.id_on);


        ///of when open app-->start--------------
        radioGroup = (RadioGroup) findViewById(R.id.id_radiogroup);
        int Select = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(Select);
        String Result_ = radioButton.getText().toString();
        if (Result_.equalsIgnoreCase("off")) {
            On_OFF(false);
            InputText.setText("");
            OutputText.setText("");
        } else {
            On_OFF(true);
        }
        //Off when open ap--->end---------------

        rb_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_OFF(true);
                OutputText.setText("0");
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

        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputText.setText("");
                OutputText.setText("");
            }
        });
        b_00_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text=InputText.getText().toString();
                int Length=((Take_Text.length())-1);
                if(Take_Text.equalsIgnoreCase("")){}else {
                    Take_Text=Take_Text.substring(0,Length);
                    InputText.setText(Take_Text);
                }
            }
        });
        b_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text=InputText.getText().toString();
                int Length= ((Take_Text.length())-1);
                if (Take_Text.equalsIgnoreCase("")) {} else {
                    double Take_Text_ = Double.parseDouble(Take_Text);
                    Take_Text_ = Math.sqrt(Take_Text_);
                    OutputText.setText(Take_Text_ + "");
                    InputText.setText(Take_Text_+"");
                }
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                if (Take_text.equalsIgnoreCase("")) {

                } else {
                    Take_text += 0;
                }
                InputText.setText(Take_text);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 1;
                InputText.setText(Take_text);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 2;
                InputText.setText(Take_text);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 3;
                InputText.setText(Take_text);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 4;
                InputText.setText(Take_text);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 5;
                InputText.setText(Take_text);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 6;
                InputText.setText(Take_text);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 7;
                InputText.setText(Take_text);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 8;
                InputText.setText(Take_text);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_text = InputText.getText().toString();
                Take_text += 9;
                InputText.setText(Take_text);
            }
        });
        b_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chek_pont = 0;
                String Take_Text = InputText.getText().toString();
                for (int i = 0; i < Take_Text.length(); i++) {
                    if (Take_Text.charAt(i) == '.') {
                        chek_pont++;
                        break;
                    }
                }

                if (chek_pont == 0) {
                    Take_Text += ".";
                    InputText.setText(Take_Text);
                }
            }
        });
        b_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if (Take_Text.equals("")) {
                } else {
                    double Take_Text_ = Double.parseDouble(Take_Text);
                    Take_Text_ = Take_Text_ / 100;
                    OutputText.setText(Take_Text_ + "");
                }
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if(Take_Text.equalsIgnoreCase("")){}else {
                    String str = ChekFunction(Take_Text, '+');
                    InputText.setText(str);
                }
            }
        });
        b_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if(Take_Text.equalsIgnoreCase("")){}else {
                    String str = ChekFunction(Take_Text, '-');
                    InputText.setText(str);
                }
            }
        });
        b_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if(Take_Text.equalsIgnoreCase("")){}else {
                    String str = ChekFunction(Take_Text, '*');
                    InputText.setText(str);
                }
            }
        });
        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if(Take_Text.equalsIgnoreCase("")){}else {
                    String str = ChekFunction(Take_Text, '/');
                    InputText.setText(str);
                }
            }
        });
        b_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Take_Text = InputText.getText().toString();
                if(Take_Text.equalsIgnoreCase("")){}else {
                    String str=ChekFunction(Take_Text,'^');
                    InputText.setText(str);
                }
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y=0;
                String Take_Text = InputText.getText().toString();
                int Length=(Take_Text.length())-1;
                if(Take_Text.equalsIgnoreCase("")){
                    OutputText.setText("0");
                }else {

                    if (Take_Text.charAt(Length) == '+' || Take_Text.charAt(Length) == '-' || Take_Text.charAt(Length) == '*' || Take_Text.charAt(Length) == '/' || Take_Text.charAt(Length) == '^') {
                        Take_Text = Take_Text.substring(0, Length);
                        OutputText.setText(Take_Text);
                    }
                    else if (Take_Text.charAt(Length) == '0' || Take_Text.charAt(Length) == '1' || Take_Text.charAt(Length) == '2' || Take_Text.charAt(Length) == '3' || Take_Text.charAt(Length) == '3'
                            || Take_Text.charAt(Length) == '4' || Take_Text.charAt(Length) == '5' || Take_Text.charAt(Length) == '5' || Take_Text.charAt(Length) == '6' || Take_Text.charAt(Length) == '7'
                            || Take_Text.charAt(Length) == '8' || Take_Text.charAt(Length) == '9') {

                        OutputText.setText(Take_Text);

                    }
                    for(int i=0;i<Take_Text.length();i++){
                        if(Take_Text.charAt(i)=='+' || Take_Text.charAt(i)=='-' || Take_Text.charAt(i)=='*' || Take_Text.charAt(i)=='/'|| Take_Text.charAt(i)=='^' ){
                            y++;
                        }
                    }


                    if(y>0){
                        String Ans= Solve1(Take_Text);
                        OutputText.setText(Ans);
                    }
                }

            }
        });


    }

    String ChekFunction(String Take_Text, char operator) {
        int Check = 0;

        for (int i = 0; i < Take_Text.length(); i++) {
            if (Take_Text.charAt(i) == '+' || Take_Text.charAt(i) == '-' || Take_Text.charAt(i) == '*' || Take_Text.charAt(i) == '/'|| Take_Text.charAt(i) == '^') {
                Check++;
                break;
            }
        }
        if (Check == 0) {
            Take_Text += operator;
            return Take_Text;
        } else {
            String xx = Solve1(Take_Text);
            Take_Text = xx;
            OutputText.setText(Take_Text);
            return Take_Text+operator;
        }

    }

    private String Solve1(String Take_Text) {
        double d = 0;
        if (Take_Text.split("\\+").length == 2) {
            String[] Numbers = Take_Text.split("\\+");
            try {
                d = Double.parseDouble(Numbers[0]) + Double.parseDouble(Numbers[1]);
            } catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }


        if (Take_Text.split("\\-").length == 2) {
            String[] Numbers = Take_Text.split("\\-");
            try {
                d = Double.parseDouble(Numbers[0]) - Double.parseDouble(Numbers[1]);
            } catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }


        if (Take_Text.split("\\*").length == 2) {
            String[] Numbers = Take_Text.split("\\*");
            try {
                d = Double.parseDouble(Numbers[0]) * Double.parseDouble(Numbers[1]);
            } catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }


        if (Take_Text.split("\\/").length == 2) {
            String[] Numbers = Take_Text.split("\\/");
            try {
                d = Double.parseDouble(Numbers[0]) / Double.parseDouble(Numbers[1]);
            } catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        if (Take_Text.split("\\^").length == 2) {
            String[] Numbers = Take_Text.split("\\^");
            try {
                d = Math.pow(Double.parseDouble(Numbers[0]) , Double.parseDouble(Numbers[1]));
            } catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        return String.valueOf(d);
    }




    private void solve(String Input){
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
        int Length=((str.length())-1);
        if(str.charAt(Length)=='+' || str.charAt(Length)=='-' || str.charAt(Length)=='*' || str.charAt(Length)=='/'){
            str=str.substring(0,2);
        }
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