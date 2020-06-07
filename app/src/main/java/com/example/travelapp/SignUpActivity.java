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


public class SignUpActivity extends AppCompatActivity {

    private EditText et_nama;
    private EditText et_namabelakang;
    private EditText et_email;
    private EditText et_password;

    private Button btnCancel;
    private Button btnRegister;

    private UserDao userDao;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        btnCancel = findViewById(R.id.btn_cancel);
        btnRegister = findViewById(R.id.btn_register);

        et_nama = findViewById(R.id.et_namainput);
        et_namabelakang = findViewById(R.id.et_namabelakanginput);
        et_email = findViewById(R.id.et_emailinput);
        et_password = findViewById(R.id.et_passwordinput);

        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user;
                            user = new User(et_nama.getText().toString(), et_namabelakang.getText().toString(),
                                    et_email.getText().toString(), et_password.getText().toString());
                            userDao.insert(user);
                            progressDialog.dismiss();
                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                        }
                    }, 1000);
                } else {
                    Toast.makeText(SignUpActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(et_email.getText().toString()) ||
                TextUtils.isEmpty(et_password.getText().toString()) ||
                TextUtils.isEmpty(et_nama.getText().toString()) ||
                TextUtils.isEmpty(et_namabelakang.getText().toString())) {
            return (true);
        } else {
            return (false);
        }
    }
}