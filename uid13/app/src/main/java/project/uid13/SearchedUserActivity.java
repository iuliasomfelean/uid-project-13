package project.uid13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import project.uid13.adapters.NewsfeedAdapter;
import project.uid13.service.NewsfeedService;

public class SearchedUserActivity extends AppCompatActivity {

    //for newsfeed
    private NewsfeedAdapter newsfeedAdapter;
    private ListView newsfeedList;
    private NewsfeedService newsFeedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_user);

        newsfeedList = findViewById(R.id.searchedUserPosts);
        newsFeedService = new NewsfeedService();

        newsfeedAdapter = new NewsfeedAdapter(this);
        newsfeedAdapter.setItems(newsFeedService.getSearchedUserNewsfeedList());

        newsfeedList.setAdapter(newsfeedAdapter);

    }
}
