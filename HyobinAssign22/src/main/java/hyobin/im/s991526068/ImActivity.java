package hyobin.im.s991526068;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im);

        Intent intent = getIntent();
        String message = intent.getStringExtra(HyobinActivity.store);
        TextView textView = findViewById(R.id.hyobinStore);
        textView.setText(message);

        if(message == "Ginos Pizza"){
            ImageView img = (ImageView) findViewById(R.id.hyobinStoreImg);
            img.setImageResource(R.drawable.ginos);
        }else if (message == "Dominos Pizza"){
            ImageView img = (ImageView) findViewById(R.id.hyobinStoreImg);
            img.setImageResource(R.drawable.dominos);
        }else if (message == "Pizza Pizza"){
            ImageView img = (ImageView) findViewById(R.id.hyobinStoreImg);
            img.setImageResource(R.drawable.pizzapizza);
        }


    }
}