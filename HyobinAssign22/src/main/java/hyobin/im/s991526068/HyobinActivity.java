//Hyobin Im s991526068
//This is assignment #2 - pizza ordering application
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HyobinActivity extends AppCompatActivity {

    public static final String store = "";
    final Context context = this;
    MenuItem mi;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.hyobinPizzaStores);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.hyobinGinos){
                    mi.setIcon(R.drawable.ginos);
                    selected = "ginos";
                } else if (checkedId == R.id.hyobinDominos){
                    mi.setIcon(R.drawable.dominos);
                    selected = "dominos";
                } else if (checkedId == R.id.hyobinPizzaPizza){
                    mi.setIcon(R.drawable.pizzapizza);
                    selected = "pizzapizza";
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        mi = menu.findItem(R.id.pizza);
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
                if (selected == "ginos"){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ginospizza.ca"));
                    startActivity(intent);
                }else if (selected == "dominos"){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dominos.ca"));
                    startActivity(intent);
                }else if (selected ==  "pizzapizza"){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pizzapizza.ca"));
                    startActivity(intent);
                }
                break;

            case R.id.name:

                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void orderPage(View view) {
        Intent intent = null;
        String message = "";
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.hyobinPizzaStores);


        if (radioGroup.getCheckedRadioButtonId() == -1){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle(R.string.alert_home);
            alertDialogBuilder
                    .setMessage("Click yes to exit")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(getApplicationContext(), "Please select a store",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else {
            switch (view.getId()) {
                case R.id.button_next:
                    if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinGinos) {
                        intent = new Intent(this, ImActivity.class);
                        TextView textView = (TextView) findViewById(R.id.hyobinGinos);
                        message = textView.getText().toString();
                        intent.putExtra("resourceInt", R.drawable.ginos);
                    } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinDominos) {
                        intent = new Intent(this, ImActivity.class);
                        TextView textView = (TextView) findViewById(R.id.hyobinDominos);
                        message = textView.getText().toString();
                        intent.putExtra("resourceInt", R.drawable.dominos);
                    } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinPizzaPizza) {
                        intent = new Intent(this, ImActivity.class);
                        TextView textView = (TextView) findViewById(R.id.hyobinPizzaPizza);
                        message = textView.getText().toString();
                        intent.putExtra("resourceInt", R.drawable.pizzapizza);
                    }
            }

            intent.putExtra(store, message);
            startActivity(intent);
        }
    }
}