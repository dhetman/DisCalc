package uk.dhetman.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void applyDiscount(View view){
        EditText priceText = (EditText) findViewById(R.id.price);
        EditText percentageText = (EditText) findViewById(R.id.percentage);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        if (priceText.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Price field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (percentageText.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Discount field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (Double.valueOf(percentageText.getText().toString()) >= 101) {
            Toast.makeText(MainActivity.this, "You cannot discount beyond 101%", Toast.LENGTH_SHORT).show();
        }
        else {
            double price = Double.valueOf(priceText.getText().toString());
            double percentage = Double.valueOf(percentageText.getText().toString());
            double onePerc = price / 100;
            double PercOff = 100 - percentage;
            double result = onePerc * PercOff;
            double finalResult = Math.round(result * 100.0) / 100.0;
            calcResult.setText(String.valueOf("Discounted price:" + '\n' + finalResult));
        }
    }

    public void reverseDiscount(View view){
        EditText priceText = (EditText) findViewById(R.id.price);
        EditText percentageText = (EditText) findViewById(R.id.percentage);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        if (priceText.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Price field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (percentageText.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Discount field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (Double.valueOf(percentageText.getText().toString()) >= 100){
            Toast.makeText(MainActivity.this, "You cannot revert a discount beyond 100%", Toast.LENGTH_SHORT).show();
        }
        else {
            double DiscPrice = Double.valueOf(priceText.getText().toString());
            double OrigPercent = Double.valueOf(percentageText.getText().toString());
            double PercentDifference = 100 - OrigPercent;
            double OnePercPrice = DiscPrice / PercentDifference;
            double result = OnePercPrice * 100;
            double finalResult = Math.round(result * 100.0) / 100.0;
            calcResult.setText(String.valueOf("Original price:" + '\n' + finalResult));
        }
    }
}
