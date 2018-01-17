package project.uid13.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.uid13.R;
import project.uid13.entities.NewsfeedPostModel;

import static android.content.ContentValues.TAG;

public class NewsfeedAdapter extends BaseAdapter {

    private List<NewsfeedPostModel> items = new ArrayList<>();
    private Context context;

    public NewsfeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View myRow = (convertView == null) ? inflater.inflate(R.layout.newsfeed_element, parent, false) : convertView;
        Log.i(TAG,"in the adapter");
        NewsfeedPostModel newsfeedPostModel = items.get(position);

        TextView username = (TextView) myRow.findViewById(R.id.posted_by_user);
        username.setText(newsfeedPostModel.getUserName());

        TextView content = (TextView) myRow.findViewById(R.id.posted_content);
        content.setText(newsfeedPostModel.getContentOfPost());

        TextView datetime = (TextView) myRow.findViewById(R.id.posted_at_time);
        datetime.setText(newsfeedPostModel.getDateTimeOfPost());

        ImageView profilePic = (ImageView) myRow.findViewById(R.id.posted_by_user_picture);
        profilePic.setImageResource(newsfeedPostModel.getUserPictureName());

        return myRow;
    }

    public List<NewsfeedPostModel> getItems() {
        return items;
    }

    public void setItems(List<NewsfeedPostModel> items) {
        this.items = items;
    }
}
