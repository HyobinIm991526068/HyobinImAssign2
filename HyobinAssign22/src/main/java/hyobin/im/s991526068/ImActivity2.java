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
        Bundle extras = getIntent().getExtras();
        ArrayList<String> toppings = (ArrayList<String>)getIntent().getSerializableExtra("toppings");

        TextView textView = new TextView(this);
        for (int i = 0; i<toppings.size();i++){
            textView.append(toppings.get(i));
            textView.append("\n");
        }

    }
}