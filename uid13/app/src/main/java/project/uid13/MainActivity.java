package project.uid13;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static project.uid13.Constants.*;

public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private ProgressDialog progressDialogAtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialogAtLogin = new ProgressDialog(this);
        String titleId = "Logging in...";
        progressDialogAtLogin.setTitle(titleId);
        progressDialogAtLogin.setMessage("Please Wait...");
        progressDialogAtLogin.setCancelable(false);
        progressDialogAtLogin.setIndeterminate(true);


        btnLogIn = (Button) findViewById(R.id.logIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialogAtLogin.show();
                CountDownTimer progressTimer = new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        boolean emailValid = false, passwordValid = false;
                        EditText txtUsername = (EditText) findViewById(R.id.email);
                        EditText txtPassword = (EditText) findViewById(R.id.password);

                        //final TextView loginStatus = (TextView) findViewById(R.id.textViewLogStatus);
                        //TextView emailValidity = (TextView) findViewById(R.id.textViewUsernameValidity);
                        //TextView passwordValidity = (TextView) findViewById(R.id.textViewPasswordValidity);

                        final String email = txtUsername.getText().toString();
                        final String password = txtPassword.getText().toString();

                        if (email.equals("")) {
                            //emailValidity.setText("Username cannot be empty!");
                            //emailValidity.setTextColor(Color.RED);
                        } else if (email.length() < 3) {
                           // emailValidity.setText("Username is too short!");
                            //emailValidity.setTextColor(Color.RED);
                        } else
                            emailValid = USER_1_EMAIL.equals(email);

                        if (password.equals("")) {
//                            passwordValidity.setText("Password cannot be empty!");
//                            passwordValidity.setTextColor(Color.RED);
                        } else if (password.length() < 3) {
//                            passwordValidity.setText("Password is too short!");
//                            passwordValidity.setTextColor(Color.RED);
                        } else
                            passwordValid = USER_1_PASSWORD.equals(password);

                        if (emailValid && passwordValid) {
//                        if(true){
                            Toast.makeText(getApplicationContext(), "Log in successful!", Toast.LENGTH_SHORT).show();
//                            passwordValidity.setText("");
//                            emailValidity.setText("");
//                            loginStatus.setText("Login succesful");
//                            loginStatus.setTextColor(Color.GREEN);

                            Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
//                            intent.putExtra("email", email);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Log in failed!", Toast.LENGTH_SHORT).show();
//                            loginStatus.setText("Login unsuccesful");
//                            loginStatus.setTextColor(Color.RED);
                        }
                        progressDialogAtLogin.dismiss();

                    }
                }.start();

            }
        });
    }
}
