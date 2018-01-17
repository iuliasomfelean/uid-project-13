package project.uid13.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.uid13.R;
import project.uid13.entities.ChatMessage;
import project.uid13.entities.GroupModel;

/**
 * Created by Razvan on 1/16/2018.
 */

public class ChatAdapter extends BaseAdapter {

    private final String TAG = "ChatMessage Adapter";


    public List<ChatMessage> items;
    private Context context;

    public ChatAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ChatMessage getItem(int i) {
        return items.get(i);
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i(TAG,"here1");

        // get a reference to the LayoutInflater service
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // check if we can reuse a previously defined cell which now is not visible anymore
        View myRow = (convertView == null) ? inflater.inflate(R.layout.chat_layout, parent, false) : convertView;
        // get the visual elements and update them with the information from the model

        ChatMessage element = (ChatMessage) items.get(position);

        Log.i("asd",element.toString());


        TextView chat_message =  myRow.findViewById(R.id.chat_message);
        chat_message.setText(element.getMessage());



        return myRow;
    }

}
