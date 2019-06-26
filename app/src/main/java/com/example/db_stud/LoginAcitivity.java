package com.example.db_stud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAcitivity extends AppCompatActivity {
    EditText user,password;
    TextView newUser;
    Button login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitivity);

        db = new DatabaseHelper(this);
        user = (EditText)findViewById(R.id.etUserEmail);
        password = (EditText)findViewById(R.id.etUserPassword);
        login = (Button)findViewById(R.id.btLogin);
        newUser = (TextView)findViewById(R.id.tvRegister);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginAcitivity.this,what.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User= user.getText().toString().trim();
                String Password = password.getText().toString().trim();
                Boolean res = db.checkUser(User,Password);
                if(res==true){
                    Toast.makeText(LoginAcitivity.this,"Successfully registered.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginAcitivity.this,pdfAcitivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginAcitivity.this,"Successfully not registered.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
