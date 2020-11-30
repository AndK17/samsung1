package dev.andk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    Button solve;
    EditText num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solve = findViewById(R.id.solve);
        text = findViewById(R.id.textView);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        solve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();
        String s3 = num3.getText().toString();
        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = Double.parseDouble(s3);
        if (a != 0)
        {
            double D = b * b - 4 * a * c;
            if (D < 0)
            {
                text.setText("Уравнение не имеет решений");
                return;
            }
            double x1 = ((-b + Math.sqrt(D))/(2*a));
            double x2 = (-b - Math.sqrt(D))/(2*a);
            if (D == 0)
            {
                text.setText(String.valueOf(x1));
            }
            else
            {
                text.setText(String.format(Locale.US, "x1 = %.2f\nx2 = %.2f", x1, x2));
            }
        }
        else
        {
            text.setText("a не может быть равно 0");
        }
    }
}