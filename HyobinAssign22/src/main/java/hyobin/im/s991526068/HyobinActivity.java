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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

    public void orderPage(View view) {
        Intent intent = null;
        String message = "";
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.hyobinPizzaStores);

        if (radioGroup.getCheckedRadioButtonId() == -1){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Select store");
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
                        intent.putExtra(store, message);
                        intent.putExtra("resourceInt", R.drawable.ginos);
                    } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinDominos) {
                        intent = new Intent(this, ImActivity.class);
                        TextView textView = (TextView) findViewById(R.id.hyobinDominos);
                        message = textView.getText().toString();
                        intent.putExtra(store, message);
                        intent.putExtra("resourceInt", R.drawable.dominos);
                    } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinPizzaPizza) {
                        intent = new Intent(this, ImActivity.class);
                        TextView textView = (TextView) findViewById(R.id.hyobinPizzaPizza);
                        message = textView.getText().toString();
                        intent.putExtra(store, message);
                        intent.putExtra("resourceInt", R.drawable.pizzapizza);
                    }
            }
            startActivity(intent);
        }
    }
}