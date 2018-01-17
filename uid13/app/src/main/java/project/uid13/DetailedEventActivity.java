package project.uid13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedEventActivity extends AppCompatActivity {

    ImageView eventImageDetailed;
    TextView eventTitleDetailed;
    TextView eventDescriptionDetailed;
    Button joinButtonDetailed;

    EventService service;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_event);

        service = EventService.getInstance();

        Intent myIntent = getIntent();
        String indexValue = myIntent.getStringExtra("index");

        index = Integer.valueOf(indexValue);

        eventTitleDetailed = findViewById(R.id.eventTitleDetailed);
        eventDescriptionDetailed = findViewById(R.id.eventDesctiptionDetailed);
        eventImageDetailed = (ImageView) findViewById(R.id.eventImageDetailed);
        joinButtonDetailed = findViewById(R.id.joinButtonDetailed);

        if(service.getEvents().get(index).isJoin()){
            joinButtonDetailed.setText("Leave");
        }
        else{
            joinButtonDetailed.setText("JOIN");
        }
        eventTitleDetailed.setText(service.getEvents().get(index).getEventTitle());
        eventDescriptionDetailed.setText(service.getEvents().get(index).getEventDescription());
        eventImageDetailed.setImageResource(service.getEvents().get(index).getEventImage());

        joinButtonDetailed.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                service.setJoin(index, !service.getEvents().get(index).isJoin());
                if(service.getEvents().get(index).isJoin()){
                    joinButtonDetailed.setText("Leave");
                }
                else{
                    joinButtonDetailed.setText("JOIN");
                }
            }
        });
    }
}
