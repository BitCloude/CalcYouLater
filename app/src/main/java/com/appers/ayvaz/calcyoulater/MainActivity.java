package com.appers.ayvaz.calcyoulater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
Stack<String> stack = new Stack<>();//stack of numbers and operations
    TextView textView;  //the results
    StringBuilder entry = new StringBuilder();//composes string that is displayed
    Button zero,one,two,three,four,five,six,seven,eight,nine,plus,minus,divide,modulus,equals,clear,clear_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        modulus = (Button) findViewById(R.id.modulus);
        equals = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);
        clear_all = (Button) findViewById(R.id.clear_all);
        textView = (TextView) findViewById(R.id.screen);

        //textView.setText(R.string.user_name);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Zero", Toast.LENGTH_SHORT).show();
                entry.append("0");
                textView.setText(entry.toString());
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "One", Toast.LENGTH_SHORT).show();
                entry.append("1");
                textView.setText(entry.toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Two", Toast.LENGTH_SHORT).show();
                entry.append("2");
                textView.setText(entry.toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Three", Toast.LENGTH_SHORT).show();
                entry.append("3");
                textView.setText(entry.toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Four", Toast.LENGTH_SHORT).show();
                entry.append("4");
                textView.setText(entry.toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Five", Toast.LENGTH_SHORT).show();
                entry.append("5");
                textView.setText(entry.toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Six", Toast.LENGTH_SHORT).show();
                entry.append("6");
                textView.setText(entry.toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Seven", Toast.LENGTH_SHORT).show();
                entry.append("7");
                textView.setText(entry.toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Eight", Toast.LENGTH_SHORT).show();
                entry.append("8");
                textView.setText(entry.toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Nine", Toast.LENGTH_SHORT).show();
                entry.append("9");
                textView.setText(entry.toString());
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Plus", Toast.LENGTH_SHORT).show();
                stack.push(textView.getText().toString());  //push number from text to stack
                stack.push("+");                            //push operation to stack
                entry.delete(0,entry.length());              //empty stringbuilder
                textView.setText(entry.toString());         //basically clear screen

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Minus", Toast.LENGTH_SHORT).show();
                stack.push(textView.getText().toString());
                stack.push("-");
                entry.delete(0, entry.length());
                textView.setText(entry.toString());
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "The Great Divide", Toast.LENGTH_SHORT).show();
                stack.push(textView.getText().toString());
                stack.push("/");
                entry.delete(0, entry.length());
                textView.setText(entry.toString());
            }
        });
        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Modulus", Toast.LENGTH_SHORT).show();
                stack.push(textView.getText().toString());
                stack.push("%");
                entry.delete(0, entry.length());
                textView.setText(entry.toString());
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Equals", Toast.LENGTH_SHORT).show();
                stack.push(textView.getText().toString());      //push number to stack
                entry.delete(0, entry.length());                //clear stringbuilder
                textView.setText(Integer.toString(calculate()));//show calculation result on screen
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT).show();
                if(entry.length() != 0)
                    entry.deleteCharAt(entry.length() - 1);     //delete latest addition to stringbuilder

                textView.setText(entry.toString());
            }
        });
        clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Terminated with extreme prejudice", Toast.LENGTH_SHORT).show();
                //Reset method(pop whole stack, reset String builder)

                while(!stack.empty()) {                 //empty stack
                    stack.pop();
                }
                entry.delete(0,entry.length());         //empty string builder
                textView.setText(entry.toString());
            }
        });
    }
    //pop stack and calculate
    public int calculate(){
        int firstNum,secondNum,result =0;
        String temp;
        String operation;
        if(stack.size()>2){
            temp = stack.pop(); //below is at the moment a failed attempt to stop app crashing on incorrect input. To be changed
            if(!temp.equals("+") && !temp.equals("+") && !temp.equals("+") && !temp.equals("+"))  //failed:check that it is a number
            firstNum = Integer.parseInt(temp);
            else
            return 0;

            operation = stack.pop();

            temp = stack.pop();
            if(!temp.equals("+") && !temp.equals("+") && !temp.equals("+") && !temp.equals("+"))
            secondNum = Integer.parseInt(temp);
            else
            return 0;

            switch(operation) {             //find out which operation to do
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = secondNum - firstNum;
                    break;
                case "/":
                    if(firstNum !=0)        //check for 0 division
                    result = (secondNum/firstNum);
                    else
                    result =0;
                    break;
                case "%":
                    result = (secondNum%firstNum);
                    break;
                default:
                    result = 0;
            }
            while(!stack.empty()) {         //just pop the rest of the stack...we only need to do 1 operation at a time
                stack.pop();
            }
            stack.push(Integer.toString(result));           //push the result to stack so we can chain operations
        }
        return  result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
