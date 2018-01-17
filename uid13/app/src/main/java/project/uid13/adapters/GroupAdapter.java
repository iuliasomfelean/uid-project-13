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
import project.uid13.R;

import java.util.List;

import project.uid13.entities.GroupModel;

/**
 * Created by Razvan on 1/8/2018.
 */

public class GroupAdapter extends BaseAdapter
{
    private final String TAG = "Adapter";


    public List<GroupModel> items;
    private Context context;

    public GroupAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public GroupModel getItem(int i) {
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
        View myRow = (convertView == null) ? inflater.inflate(R.layout.group_layout, parent, false) : convertView;
        // get the visual elements and update them with the information from the model

        GroupModel element = (GroupModel) items.get(position);

        Log.i("asd",element.toString());



        ImageView groupImage = myRow.findViewById(R.id.groupImage);
        groupImage.setImageResource(element.getImageId());


        TextView title =  myRow.findViewById(R.id.groupTitle);
        title.setText(element.getTitle());
        title.setTextSize(25);

        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        title.setTypeface(boldTypeface);
        /*

        TextView content = myRow.findViewById(R.id.groupContent);
        content.setText(element.getTextContent());


        TextView groupUser = myRow.findViewById(R.id.groupUser);
        groupUser.setText(element.getUser());
        groupUser.setTypeface(boldTypeface);*/

        return myRow;
    }
}