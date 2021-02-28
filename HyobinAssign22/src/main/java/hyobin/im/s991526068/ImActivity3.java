package hyobin.im.s991526068;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ImActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im3);

        Intent intent = getIntent();

        String message = intent.getStringExtra("crust");
        String message2 = intent.getStringExtra("size");
        String message4 = intent.getStringExtra("name");
        String message5 = intent.getStringExtra("address");
        String message6 = intent.getStringExtra("phoneNumber");
        String message7 = intent.getStringExtra("creditCard");
        String message8 = intent.getStringExtra("selectedProvince");

        TextView textView = findViewById(R.id.hyobinCheckoutType);
        textView.setText(message);

        TextView textView2 = findViewById(R.id.hyobinCheckoutSize);
        textView2.setText(message2);

        ArrayList<String> toppings = (ArrayList<String>)getIntent().getSerializableExtra("toppings");
        TextView textView3 = findViewById(R.id.hyobinCheckoutToppings);
        textView3.setText(String.valueOf(toppings));

        TextView textView4 = findViewById(R.id.hyobinCheckoutName);
        textView4.setText(message4);

        TextView textView5 = findViewById(R.id.hyobinCheckoutAddress);
        textView5.setText(message5);

        TextView textView6 = findViewById(R.id.hyobinCheckoutPhoneNumber);
        textView6.setText(message6);

        TextView textView7 = findViewById(R.id.hyobinCheckoutCreditCard);
        textView7.setText(message7);

        TextView textView8 = findViewById(R.id.hyobinCheckoutProvince);
        textView8.setText(message8);

    }
}