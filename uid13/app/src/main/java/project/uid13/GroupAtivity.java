package project.uid13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import project.uid13.R;
import project.uid13.adapters.GroupAdapter;
import project.uid13.chat.ChatActivity;
import project.uid13.entities.Contact;
import project.uid13.entities.GroupModel;
import project.uid13.service.GroupService;

public class GroupAtivity extends AppCompatActivity {

    ListView listView;
    GroupAdapter listAdapter;
    GroupService groupService;
    TextView yourGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_ativity);

        listView = findViewById(R.id.listView);
        groupService = new GroupService();

        listAdapter = new GroupAdapter(this);
        listAdapter.items =  groupService.getEmptyGroups();
        listView.setAdapter(listAdapter);

        listAdapter.items =  groupService.getGroupInfo();
        listAdapter.notifyDataSetChanged();

        final Intent groupDetails	=	new	Intent(this, GroupDetails.class);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                GroupModel o = (GroupModel) listView.getAdapter().getItem(i);

                groupDetails.putExtra("group",o);
                startActivity(groupDetails);


            }

        });
    }
}
