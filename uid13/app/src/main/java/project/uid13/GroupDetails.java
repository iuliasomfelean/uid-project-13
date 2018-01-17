package project.uid13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import project.uid13.adapters.NewsfeedAdapter;
import project.uid13.entities.GroupModel;
import project.uid13.service.NewsfeedService;

public class GroupDetails extends AppCompatActivity {

    //for newsfeed
    private NewsfeedAdapter newsfeedAdapter;
    private ListView newsfeedList;
    private NewsfeedService newsFeedService;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detais);

        Intent intent  = getIntent();

        GroupModel groupModel = (GroupModel) intent.getSerializableExtra("group");

        textView  = findViewById(R.id.group_details_title);


        String s = textView.getText() + groupModel.getTitle() ;

        textView.setText(s);


       // Toast.makeText(this,groupModel.getTitle(),Toast.LENGTH_SHORT).show();



        newsfeedList = findViewById(R.id.post_list_group);
        newsFeedService = new NewsfeedService();

        newsfeedAdapter = new NewsfeedAdapter(this);
        newsfeedAdapter.setItems(newsFeedService.getNewsfeedList());

        newsfeedList.setAdapter(newsfeedAdapter);





    }
}
