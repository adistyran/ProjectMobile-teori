package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelapp.database.UserDao;
import com.example.travelapp.database.UserDatabase;
import com.example.travelapp.model.User;

public class MainActivity extends AppCompatActivity {

    private Button btnsignin;
    private Button btnsignup;
    private EditText et_email;
    private EditText et_password;
    private UserDatabase database;

    private UserDao userDao;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        database = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();

        btnsignin = findViewById(R.id.btn_signin);
        btnsignup = findViewById(R.id.btn_signup);

        et_email = findViewById(R.id.et_emailinput);
        et_password = findViewById(R.id.et_passwordinput);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(et_email.getText().toString(), et_password.getText().toString());
                            if (user != null) {
                                Intent i = new Intent(MainActivity.this, UserActivity.class);
                                i.putExtra("User", user);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Unregistered or Incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);
                } else {
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private boolean emptyValidation() {
        if (TextUtils.isEmpty(et_email.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString())){
            return true;
        } else{
            return false;
        }
    }
}