package project.uid13;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SettingsActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText phoneNr;
    EditText password;
    EditText newPassword;
    TextView nameError;
    TextView emailError;
    TextView phoneError;
    TextView passwordError;
    TextView cancelSettings;
    Button doneButton;

    boolean nameOk, phoneOk, emailOk, passwordOk, newPasswordOk;

    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        name = findViewById(R.id.name);
        nameError = findViewById(R.id.nameError);
        email = findViewById(R.id.email);
        emailError = findViewById(R.id.emailError);
        phoneNr = findViewById(R.id.phone);
        phoneError = findViewById(R.id.phoneError);
        password = findViewById(R.id.password);
        newPassword = findViewById(R.id.newPassword);
        passwordError = findViewById(R.id.passwordError);
        cancelSettings = findViewById(R.id.cancelSettings);
        doneButton = findViewById(R.id.doneButton);

        name.setText(Constants.USER_1_NAME);
        email.setText(Constants.USER_1_EMAIL);
        phoneNr.setText(Constants.USER_1_PHONENR);

        if(TextUtils.isEmpty(name.getText())){
            nameError.setTextColor(Color.rgb(255,0,0));
            nameError.setText("Name cannot be null");
        }else{
            nameError.setText("");
            nameOk = true;
        }
        if(!PhoneNumberUtils.isGlobalPhoneNumber(phoneNr.getText().toString()))
        {
            phoneError.setTextColor(Color.rgb(255,0,0));
            phoneError.setText("Invalid phone number");
        }else{
            phoneError.setText("");
            phoneOk = true;
        }
        if(Pattern.compile(expression, Pattern.CASE_INSENSITIVE).matcher(email.getText().toString()).matches()){
            emailError.setText("");
            emailOk = true;

        }else{
            emailError.setTextColor(Color.rgb(255,0,0));
            emailError.setText("Invalid email address");
        }


        cancelSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                startActivity(intent);
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nameOk && emailOk &&phoneOk){
                    if(!TextUtils.isEmpty(newPassword.getText())){
                        Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                        Toast.makeText(getBaseContext(), "Changes saved", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                    Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                    Toast.makeText(getBaseContext(), "Changes saved", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                Toast.makeText(getBaseContext(), "Changes saved", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
