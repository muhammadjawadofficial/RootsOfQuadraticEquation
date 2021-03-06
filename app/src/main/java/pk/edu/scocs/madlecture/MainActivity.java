package pk.edu.scocs.madlecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean againPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButton();
    }

    private void setUpButton() {
        Button btn = findViewById(R.id.calculateButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et;
                String data;
                int num;

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                et = findViewById(R.id.num1);
                if(!(et.getText().toString().equals(""))) {
                    data = et.getText().toString();
                    num = Integer.parseInt(data);
                    intent.putExtra("parameter1", num);
                    et = findViewById(R.id.num2);
                    if(!(et.getText().toString().equals(""))) {
                        data = et.getText().toString();
                        num = Integer.parseInt(data);
                        intent.putExtra("parameter2", num);
                        et = findViewById(R.id.num3);
                        if(!(et.getText().toString().equals(""))) {
                            data = et.getText().toString();
                            num = Integer.parseInt(data);
                            intent.putExtra("parameter3", num);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(MainActivity.this, "Enter Value of c", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Enter Value of b", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Enter Value of a", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void calculate(View view) {
//        Intent i = new Intent(this, ResultActivity.class);
//
//        TextView num1 = findViewById(R.id.num1);
////        TextView num2 = findViewById(R.id.num2);
//        String strNum1 = num1.getText().toString();
//        i.putExtra("num1" , strNum1);
////        String strNum2 = num2.getText().toString();
////        i.putExtra("num2" , strNum2);
//        startActivity(i);
//    }

    public void onBackPressed() {
        if (!againPressed) {
            againPressed = true;
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_LONG).show();
        } else {
            finish();
        }
//            startActivity(new Intent(this,SecondActivity.class));
//            super.onBackPressed();
    }
}