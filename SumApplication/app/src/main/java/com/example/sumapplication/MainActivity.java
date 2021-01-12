package com.example.sumapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // define the global variable

    // variable number1, number2 for input input number
    // Add_button, result textView

    EditText number1;
    EditText number2;
    Button add_button;
    TextView result;
    int ans=0;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // by ID we can use each component which id is assign in xml file
        number1=(EditText) findViewById(R.id.editText_first_no);
        number2=(EditText) findViewById(R.id.editText_second_no);

        add_button =(Button) findViewById(R.id.add_button);

        result = (TextView) findViewById(R.id.textView_answer);


        // Add_button add clicklistener
        add_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                long num1 = Long.parseLong(number1.getText().toString());
                long num2 = Long.parseLong(number2.getText().toString());
                // set it ot result textview
                result.setText("" + sumFromJNI(num1,num2));
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int sumFromJNI(long num1,long num2);
}
