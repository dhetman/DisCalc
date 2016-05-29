package uk.dhetman.discountcalculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RevDiscount extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revcalc);
        Intent intent = getIntent();
        String result = intent.getStringExtra(MainActivity.RESULT);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(result);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

    }
}
