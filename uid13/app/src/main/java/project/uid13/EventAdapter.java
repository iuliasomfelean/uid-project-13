package project.uid13;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by cosmi on 1/16/2018.
 */

public class EventAdapter extends BaseAdapter {

    List<EventModel> events;
    Context context;
    EventModel event;

    TextView eventTitle;
    ImageView eventImage;

    public EventAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return events.indexOf(events.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = (view==null)?inflater.inflate(R.layout.event_list_element, viewGroup, false):view;

        event = events.get(i);

        eventTitle = row.findViewById(R.id.eventTitle);
        eventImage = row.findViewById(R.id.eventImage);

        eventTitle.setText(event.getEventTitle());

        eventImage.setImageResource(event.getEventImage());

        return row;
    }
}
