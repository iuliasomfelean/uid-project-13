package project.uid13.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import project.uid13.R;

import project.uid13.adapters.ChatAdapter;
import project.uid13.entities.ChatMessage;
import project.uid13.entities.Contact;

public class ChatActivity extends AppCompatActivity {

    private static String TAG = "ChatActivity";
    private FirebaseListAdapter<ChatMessage> adapter;

    DatabaseReference myRef;
    FirebaseDatabase database;
    ChatAdapter listAdapter;
    Contact userToTalk;

    public void sendMessage(View view) {


        EditText to_send = findViewById(R.id.to_send);

        // Read the input field and push a new instance
        // of ChatMessage to the Firebase database
        // Write a message to the database

        // myRef.setValue("take");
        myRef = database.getReference().push();
        myRef.setValue(new ChatMessage("Asdsda",to_send.getText().toString()));

        to_send.setText("");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chat);

        Intent contactIntent = getIntent();
        userToTalk = (Contact) contactIntent.getSerializableExtra("contact");

        setTitle(userToTalk.getContactName());

        ListView listChatView = (ListView) findViewById(R.id.listChatView);
        listAdapter = new ChatAdapter(this);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().push();
        // Read from the database

        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class,
                R.layout.chat_layout, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.chat_message);
                TextView userText = (TextView)v.findViewById(R.id.chat_user);

                LinearLayout linearLayout = (LinearLayout)v.findViewById(R.id.layout_for_chat);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);


                if(model.getUser().equals("Razvan")) {

                    linearLayout.removeView(userText);
                    linearLayout.removeView(messageText);

                    linearLayout.addView(messageText);
                    linearLayout.addView(userText);


                    params.weight = 1.0f;
                    params.gravity = Gravity.RIGHT;
                    linearLayout.setLayoutParams(params);
                }
                else
                {
                    linearLayout.removeView(userText);
                    linearLayout.removeView(messageText);

                    linearLayout.addView(userText);
                    linearLayout.addView(messageText);



                    params.weight = 1.0f;
                    params.gravity = Gravity.LEFT;
                    linearLayout.setLayoutParams(params);
                }

                String a = "" + model.getUser().charAt(0);

                // Set their text
                messageText.setText(model.getMessage());
                userText.setText(a);

            }
        };

        listChatView.setAdapter(adapter);




    }


}
