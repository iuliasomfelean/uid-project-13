package project.uid13;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import project.uid13.adapters.NewsfeedAdapter;
import project.uid13.entities.NewsfeedPostModel;
import project.uid13.service.NewsfeedService;

public class CommentActivity extends AppCompatActivity {

    //for newsfeed
    private NewsfeedAdapter commentAdapter;
    private ListView commentList;
    private NewsfeedService newsFeedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NewsfeedPostModel l1 = new NewsfeedPostModel("Daniel Crisan", R.drawable.daniel_crisan, "1 hour ago", "I found a very interesting article about the future of user interfaces. You should definetely check it out: https://webdesign.tutsplus.com/articles/the-future-of-user-interfaces--webdesign-13246");

        ImageView profilePic_comment = findViewById(R.id.posted_by_user_picture_for_comment);
        TextView postedContent_comment = findViewById(R.id.posted_content_for_comment);
        TextView postedBy_comment = findViewById(R.id.posted_by_user_for_comment);
        TextView postedWhen_comment = findViewById(R.id.posted_at_time_for_comment);

        profilePic_comment.setImageResource(l1.getUserPictureName());
        postedBy_comment.setText(l1.getUserName());
        postedWhen_comment.setText(l1.getDateTimeOfPost());
        postedContent_comment.setText(l1.getContentOfPost());

        commentList = findViewById(R.id.commentsList);
        newsFeedService = new NewsfeedService();

        commentAdapter = new NewsfeedAdapter(this);
        commentAdapter.setItems(newsFeedService.getCommentList());

        commentList.setAdapter(commentAdapter);

        Button btnAddComment = findViewById(R.id.btnAddComment);
        Button btnCancelComment = findViewById(R.id.btnCancelComment);
        final EditText commentBox = findViewById(R.id.commentBox);

        btnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<NewsfeedPostModel> list = newsFeedService.getCommentsList();
                list.add(new NewsfeedPostModel(Constants.USER_1_NAME, R.drawable.ancaa, "Now", commentBox.getText().toString()));

                commentAdapter.notifyDataSetChanged();
            }
        });

        btnCancelComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentBox.setText("");
            }
        });
    }

}
