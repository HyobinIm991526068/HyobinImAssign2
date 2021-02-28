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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im2);
        Intent intent = getIntent();

        String message = intent.getStringExtra("crust");
        String message2 = intent.getStringExtra("size");


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
        String selected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }

    public void checkoutPage(View view) {
        Intent intent = null;
        EditText nameEditText = (EditText)findViewById(R.id.hyobinName);
        EditText addressEditText = (EditText)findViewById(R.id.hyobinAddress);
        EditText phoneNumberEditText = (EditText)findViewById(R.id.hyobinPhoneNumber);
        EditText creditCardEditText = (EditText)findViewById(R.id.hyobinCreditCard);
        TextView selectedTextView = (TextView)spinnerProvince.getSelectedView();
        final String selected = selectedTextView.getText().toString();
        final String name = nameEditText.getText().toString();
        final String address = addressEditText.getText().toString();
        final String phoneNumber = phoneNumberEditText.getText().toString();
        final String creditCard = creditCardEditText.getText().toString();

        if (isName(name) && isAddress(address) &&
                isPhoneNumber(phoneNumber) && isCreditNumber(creditCard)){
            intent = new Intent(this, ImActivity3.class);

            intent.putExtra("crust", getIntent().getStringExtra("crust"));
            intent.putExtra("size", getIntent().getStringExtra("size"));
            intent.putExtra("toppings", getIntent().getSerializableExtra("toppings"));
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("phoneNumber", phoneNumber);
            intent.putExtra("creditCard", creditCard);
            intent.putExtra("selectedProvince", selected);

            startActivity(intent);
        }

    }

    public boolean isName(String name){
        EditText nameEditText = (EditText)findViewById(R.id.hyobinName);
        if(name.length() == 0){
            nameEditText.setError("This Field Cannot Be Blank");
            return false;
        } else if (name.length() < 3 || name.length() > 20){
            nameEditText.setError("Name should be between 3-20 characters");
            return false;
        } else if (!name.matches("[a-zA-Z]+")){
            nameEditText.setError("Enter only alphabetical characters");
            return false;
        }else {
            return true;
        }
    }

    public boolean isAddress(String address){
        EditText addressEditText = (EditText)findViewById(R.id.hyobinAddress);
        if (address.length() == 0){
            addressEditText.setError("This Field Cannot Be Blank");
            return false;
        } else {
            return true;
        }
    }

    public boolean isPhoneNumber(String phoneNumber){
        EditText phoneNumberEditText = (EditText)findViewById(R.id.hyobinPhoneNumber);
        if(phoneNumber.length() == 0){
            phoneNumberEditText.setError("This Field Cannot Be Blank");
            return false;
        } else if (phoneNumber.length() != 10){
            phoneNumberEditText.setError("This Field should be 10 digits");
            return false;
        } else if (!phoneNumber.matches("^[0-9]*$")){
            phoneNumberEditText.setError("This Field should be numbers only");
            return false;
        } else {
            return true;
        }
    }

    public boolean isCreditNumber(String creditCard){
        EditText creditCardEditText = (EditText)findViewById(R.id.hyobinCreditCard);
        if(creditCard.length() == 0){
            creditCardEditText.setError("This Field Cannot Be Blank");
            return false;
        } else if (creditCard.length() != 16){
            creditCardEditText.setError("Credit card is 16 digits");
            return false;
        } else if (!creditCard.matches("^[0-9]*$")){
            creditCardEditText.setError("Credit card should be numbers only");
            return false;
        } else {
            return true;
        }
    }



}