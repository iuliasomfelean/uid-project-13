package project.uid13;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.uid13.adapters.GroupAdapter;
import project.uid13.adapters.NewsfeedAdapter;
import project.uid13.chat.ChatActivity;
import project.uid13.chat.ContactsActivity;
import project.uid13.entities.NewsfeedPostModel;
import project.uid13.service.GroupService;
import project.uid13.service.NewsfeedService;

public class HomepageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //for newsfeed
    private NewsfeedAdapter newsfeedAdapter;
    private ListView newsfeedList;
    private NewsfeedService newsFeedService;

    private Button addPost;
    private Button cancelPost;
    private EditText postContent;

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //

        newsfeedList = findViewById(R.id.newsfeedList);
        newsFeedService = new NewsfeedService();

        newsfeedAdapter = new NewsfeedAdapter(this);
        newsfeedAdapter.setItems(newsFeedService.getNewsfeedList());

        newsfeedList.setAdapter(newsfeedAdapter);

        newsfeedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView profilePic = findViewById(R.id.posted_by_user_picture);
                TextView postedContent = findViewById(R.id.posted_content);
                TextView postedBy = findViewById(R.id.posted_by_user);
                TextView postedWhen = findViewById(R.id.posted_at_time);

                Intent intent = new Intent(HomepageActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });

        postContent = findViewById(R.id.postBox);


        addPost = findViewById(R.id.btnAdd);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<NewsfeedPostModel> newsfeedPostModelList = newsFeedService.getNewsfeedList();
                List<NewsfeedPostModel> newsfeedPostModelListNew = new ArrayList<>();

                int i = 0;
                newsfeedPostModelListNew.add(new NewsfeedPostModel(Constants.USER_1_NAME, R.drawable.anca_pop_pic, "Now", postContent.getText().toString()));
                for(NewsfeedPostModel m: newsfeedPostModelList){
                    newsfeedPostModelListNew.add(m);
                    if(i == newsfeedPostModelList.size()/2-1)
                        break;
                    i++;
                }

                newsfeedAdapter.setItems(newsfeedPostModelListNew);
                newsfeedAdapter.notifyDataSetChanged();
            }
        });

        cancelPost = findViewById(R.id.btnCancel);
        cancelPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postContent.setText("");

            }
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(HomepageActivity.this, SearchedUserActivity.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                AlertDialog.Builder dialog = new AlertDialog.Builder(HomepageActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                dialog.setCancelable(false);
                dialog.setTitle("Event notification");
                dialog.setMessage("Your event Prezentare AROBS starts in 3 hours." );
                dialog.setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Action for "Delete".
                    }
                })
                        .setNegativeButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Action for "Cancel".
                            }
                        });

                final AlertDialog alert = dialog.create();
                alert.show();


            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            startActivity( new Intent(this, SettingsActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notifications) {

            // Handle
        } else if (id == R.id.nav_settings) {

            startActivity(new Intent(getBaseContext(), SettingsActivity.class));

        } else if (id == R.id.nav_groups) {


            startActivity( new Intent(this, GroupAtivity.class));

        } else if (id == R.id.nav_events) {

            startActivity( new Intent(this, EventsListActivity.class));

        }
        else if ( id == R.id.chat_menu)
        {
            startActivity(new Intent(this, ContactsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
