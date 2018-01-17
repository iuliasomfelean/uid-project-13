package project.uid13;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {

    EditText eventTitleCreate;
    EditText eventDescriptionCreate;
    Spinner eventPrivacyCreate;
    TextView cancelEventCreate;
    TextView eventTitleError;
    Button createEventButton;

    EventService service;
    EventPrivacy chosenPrivacy;

    EventPrivacy[] options = new EventPrivacy[] {EventPrivacy.PUBLIC, EventPrivacy.PRIVATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        service = EventService.getInstance();

        eventTitleCreate = findViewById(R.id.eventTitleCreate);
        eventDescriptionCreate = findViewById(R.id.eventDescriptionCreate);
        eventPrivacyCreate = findViewById(R.id.eventPrivacyCreate);
        cancelEventCreate = findViewById(R.id.cancelEventCreate);
        createEventButton = findViewById(R.id.createEventButton);
        eventTitleError = findViewById(R.id.eventTitleError);

        ArrayAdapter<EventPrivacy> adapter = new ArrayAdapter<EventPrivacy>(this,
                android.R.layout.simple_spinner_item, options);
        eventPrivacyCreate.setAdapter(adapter);

        eventPrivacyCreate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                chosenPrivacy = (EventPrivacy)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        cancelEventCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EventsListActivity.class);
                startActivity(intent);
            }
        });

        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(eventTitleCreate.getText())){
                    eventTitleError.setTextColor(Color.rgb(255,0,0));
                    eventTitleError.setText("Title cannot be null");
                }
                else{
                    service.addEvent(eventTitleCreate.getText().toString(), eventDescriptionCreate.getText().toString(), chosenPrivacy );
                    Intent intent = new Intent(getBaseContext(), EventsListActivity.class);
                    Toast.makeText(getBaseContext(), "Event was created successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }


            }
        });
    }
}
