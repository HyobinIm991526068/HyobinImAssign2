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
import android.widget.RadioButton;
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
        Bundle extras = new Bundle();
        String message = "";
        RadioButton selectedRadioButton;
        RadioButton selectedRadioButton2;
        RadioGroup radioGroupCrust = (RadioGroup) findViewById(R.id.hyobinCrust);
        RadioGroup radioGroupSize = (RadioGroup) findViewById(R.id.hyobinPizzaSize);
        CheckBox cbBacon = (CheckBox) findViewById(R.id.hyobinBacon);
        CheckBox cbCheese = (CheckBox) findViewById(R.id.hyobinCheese);
        CheckBox cbMushroom = (CheckBox) findViewById(R.id.hyobinMushroom);
        CheckBox cbPepperoni = (CheckBox) findViewById(R.id.hyobinPepperoni);
        CheckBox cbOlives = (CheckBox) findViewById(R.id.hyobinOlives);
        CheckBox cbPineapple = (CheckBox) findViewById(R.id.hyobinPineapple);
        ArrayList<String> selectedToppings = new ArrayList<String>();

        //check which toppings are selected and put into arraylist

        if (cbBacon.isChecked()) {
            selectedToppings.add("bacon");
        }
        if (cbCheese.isChecked()) {
            selectedToppings.add("extra cheese");
        }
        if (cbMushroom.isChecked()) {
            selectedToppings.add("mushroom");
        }
        if (cbPepperoni.isChecked()) {
            selectedToppings.add("pepperoni");
        }
        if (cbOlives.isChecked()) {
            selectedToppings.add("olives");
        }
        if (cbPineapple.isChecked()) {
            selectedToppings.add("pineapple");
        }

        //checks to see if radiobuttons are selected and if toppings list is empty
        if (radioGroupCrust.getCheckedRadioButtonId() == -1 &&
                radioGroupSize.getCheckedRadioButtonId() == -1 &&
                (selectedToppings.isEmpty())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your crust type, pizza size and at least 1 topping");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else if (radioGroupSize.getCheckedRadioButtonId() == -1 && (selectedToppings.isEmpty())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your pizza size and at least 1 topping");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else if (radioGroupCrust.getCheckedRadioButtonId() == -1 && (selectedToppings.isEmpty())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your crust type and at least 1 topping");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else if (radioGroupCrust.getCheckedRadioButtonId() == -1 &&
                radioGroupSize.getCheckedRadioButtonId() == -1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your crust type and pizza size");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        }else if (radioGroupCrust.getCheckedRadioButtonId() == -1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your crust type");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else if (radioGroupSize.getCheckedRadioButtonId() == -1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick your pizza size");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else if ((selectedToppings.isEmpty())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Please pick at least 1 topping");
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else {
            intent = new Intent(this, ImActivity2.class);
            int selectedRadioButtonCrustId = radioGroupCrust.getCheckedRadioButtonId();
            selectedRadioButton = findViewById(selectedRadioButtonCrustId);
            String selectedRbCrustText = selectedRadioButton.getText().toString();

            int selectedRadioButtonSizeId = radioGroupSize.getCheckedRadioButtonId();
            selectedRadioButton2 = findViewById(selectedRadioButtonSizeId);
            String selectedRbSizeText = selectedRadioButton2.getText().toString();


            intent.putExtra("crust", selectedRbCrustText);
            intent.putExtra("size", selectedRbSizeText);
            intent.putExtra("toppings", selectedToppings);
            startActivity(intent);
        }

    }
}