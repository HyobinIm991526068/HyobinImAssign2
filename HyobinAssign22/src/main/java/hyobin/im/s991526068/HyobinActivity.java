package hyobin.im.s991526068;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HyobinActivity extends AppCompatActivity {

    public static final String store = "";

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
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.hyobinPizzaStores);

        switch (view.getId()) {
            case R.id.button_next:
                if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinGinos) {
                    intent = new Intent(this, ImActivity.class);
                    TextView textView = (TextView) findViewById(R.id.hyobinGinos);
                    String message = textView.getText().toString();
                    intent.putExtra(store, message);
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinDominos) {
                    intent = new Intent(this, ImActivity.class);
                    TextView textView = (TextView) findViewById(R.id.hyobinDominos);
                    String message = textView.getText().toString();
                    intent.putExtra(store, message);
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.hyobinPizzaPizza) {
                    intent = new Intent(this, ImActivity.class);
                    TextView textView = (TextView) findViewById(R.id.hyobinPizzaPizza);
                    String message = textView.getText().toString();
                    intent.putExtra(store, message);
                } else {

                }
        }
        startActivity(intent);
    }
}