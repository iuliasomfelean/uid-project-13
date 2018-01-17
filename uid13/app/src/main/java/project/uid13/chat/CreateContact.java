package project.uid13.chat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import project.uid13.R;
import project.uid13.entities.ChatMessage;

public class CreateContact extends AppCompatActivity {
    Intent myIntent;

    public void addContact(View view) {


        EditText name = findViewById(R.id.add_contact_name);

        EditText phoneNumber = findViewById(R.id.phone_number);

        EditText eMail = findViewById(R.id.add_e_mail);


        myIntent.putExtra("contact_name", name.getText().toString());

        setResult(Activity.RESULT_OK, myIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        myIntent	=	getIntent();


    }
}
