package project.uid13;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class EventsListActivity extends AppCompatActivity {

    ListView eventsListView;
    EventService service;
    Context context;

    EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        context = this;

        eventsListView = findViewById(R.id.eventsListView);

        service = EventService.getInstance();

        adapter = new EventAdapter(context);
        adapter.events = service.getEvents();

        eventsListView.setAdapter(adapter);

        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int offerIndex = i;

                Intent intent = new Intent(view.getContext(), DetailedEventActivity.class);
                intent.putExtra("index", String.valueOf(i));
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.event_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.newEvent:

                Intent intent = new Intent(context, CreateEventActivity.class);
                startActivity(intent);

        }
        return true;
    }
}
