package project.uid13.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import project.uid13.EventsListActivity;
import project.uid13.GroupAtivity;
import project.uid13.R;
import project.uid13.adapters.ContactsAdapter;
import project.uid13.adapters.GroupAdapter;
import project.uid13.entities.ChatMessage;
import project.uid13.entities.Contact;
import project.uid13.service.ContactService;
import project.uid13.service.GroupService;

public class ContactsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    ListView listView;
    ContactsAdapter listAdapter;
    ContactService contactService;
    TextView yourGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        final Intent createContact	=	new	Intent(this, CreateContact.class);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Add a new contact", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                startActivityForResult(createContact,1);
              // startActivity(createContact);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);


        listView = findViewById(R.id.contactsList);
        contactService = new ContactService();

        listAdapter = new ContactsAdapter(this);
        listAdapter.items =  contactService.getGroupInfo();
        listView.setAdapter(listAdapter);


        final Intent chatDetails	=	new	Intent(this, ChatActivity.class);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Contact o = (Contact) listView.getAdapter().getItem(i);

                chatDetails.putExtra("contact",o);
                startActivity(chatDetails);



            }

        });
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


            return true;
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==1) {
            if (resultCode == Activity.RESULT_OK)
            {
                // extract the information from the Intent


                String contactName = data.getStringExtra("contact_name");
                Toast.makeText(this,"Contact added",Toast.LENGTH_SHORT).show();
                listAdapter.items =contactService.addModel(new Contact(contactName,R.drawable.pawn));
                listAdapter.notifyDataSetChanged();

            }
            if (resultCode == Activity.RESULT_CANCELED)
            {
                // write your code if there's no result
            }
        }
    }

}
