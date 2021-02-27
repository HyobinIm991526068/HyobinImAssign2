package hyobin.im.s991526068;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImActivity extends AppCompatActivity {

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
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String message = intent.getStringExtra(HyobinActivity.store);

        int res = extras.getInt("resourceInt");
        TextView textView = findViewById(R.id.hyobinStore);
        textView.setText(message);
        ImageView imgView = (ImageView) findViewById(R.id.hyobinStoreImg);
        imgView.setImageResource(res);

    }

    public void paymentPage(View view){
        Intent intent = null;
        String message = "";
        RadioGroup radioGroupCrust = (RadioGroup) findViewById(R.id.hyobinCrust);
        RadioGroup radioGroupSize = (RadioGroup) findViewById(R.id.hyobinPizzaSize);
        boolean checked = ((CheckBox) view).isChecked();
        ArrayList<String> toppings = new ArrayList<String>();

        if (radioGroupCrust.getCheckedRadioButtonId() == -1 ||
                radioGroupSize.getCheckedRadioButtonId() == -1 ||
                toppings == null) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick crust, pizza size and at least 1 topping");
            alertDialogBuilder
                    .setMessage("Click yes to exit")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }

        //check which toppings are checked
        switch(view.getId()) {
            case R.id.hyobinBacon: {
                if (checked){
                    toppings.add("Bacon");
                }
                break;
            }
            case R.id.hyobinCheese: {
                if (checked){
                    toppings.add("Extra Cheese");
                }
                break;
            }
            case R.id.hyobinPepperoni: {
                if (checked){
                    toppings.add("Pepperoni");
                }
                break;
            }
            case R.id.hyobinMushroom: {
                if (checked){
                    toppings.add("Mushroom");
                }
                break;
            }
            case R.id.hyobinOlives: {
                if (checked){
                    toppings.add("Olives");
                }
                break;
            }
            case R.id.hyobinPineapple:{
                if (checked){
                    toppings.add("Pineapple");
                }
            }
        }
        intent = new Intent(this, ImActivity2.class);
        intent.putExtra("toppings", toppings);
        startActivity(intent);
    }
}