//Hyobin Im s991526068
//This is assignment #2 - pizza ordering application
package hyobin.im.s991526068;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImActivity3 extends AppCompatActivity {

    final Context context = this;

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        Intent intent = null;

        //Handle item selection
        switch (item.getItemId()){
            case R.id.help:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.site_label)));
                startActivity(intent);
                break;
            case R.id.pizza:


                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void checkout (View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(R.string.checkout_alert_title);
        alertDialogBuilder
                .setMessage("Click OK to exit")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, HyobinActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }
}

