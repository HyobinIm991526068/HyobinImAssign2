package hyobin.im.s991526068;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ImActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerProvince;
    String[] provinces;

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

        spinnerProvince = findViewById(R.id.hyobinProvinces);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.provinces, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        spinnerProvince.setAdapter(adapter);
        spinnerProvince.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long wee){
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void paymentPage(View view) {
        EditText name = (EditText)findViewById(R.id.hyobinName);
        EditText address = (EditText)findViewById(R.id.hyobinAddress);
        EditText phoneNumber = (EditText)findViewById(R.id.hyobinPhoneNumber);
        EditText creditCard = (EditText)findViewById(R.id.hyobinCreditCard);

        if(name.getText().toString().trim().equalsIgnoreCase("")){
            name.setError("This Field Cannot Be Blank");
        }

        if(address.getText().toString().trim().equalsIgnoreCase("")){
            address.setError("This Field Cannot Be Blank");
        }

        if(phoneNumber.getText().toString().trim().equalsIgnoreCase("")){
            phoneNumber.setError("This Field Cannot Be Blank");
        }

        if(creditCard.getText().toString().trim().equalsIgnoreCase("")){
            creditCard.setError("This Field Cannot Be Blank");
        }
    }


}