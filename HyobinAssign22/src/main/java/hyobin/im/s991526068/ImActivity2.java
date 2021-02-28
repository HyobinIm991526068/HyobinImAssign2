package hyobin.im.s991526068;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ImActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im2);
        Intent intent = getIntent();

        String message = intent.getStringExtra(ImActivity.crust);
        String message2 = intent.getStringExtra(ImActivity.size);


        ArrayList<String> toppings = (ArrayList<String>)getIntent().getSerializableExtra("toppings");
        TextView textView = findViewById(R.id.hyobinFinalToppings);
        textView.setText(String.valueOf(toppings));

        TextView textView2 = findViewById(R.id.hyobinFinalCrustType);
        textView2.setText(message);

        TextView textView3 = findViewById(R.id.hyobinFinalPizzaSize);
        textView3.setText(message2);
    }
}