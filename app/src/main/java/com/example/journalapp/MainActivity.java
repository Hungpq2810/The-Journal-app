package com.example.journalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button create_account_btn, email_signin_btn;
    private EditText email_login, password_login;

    // Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_signin_btn = findViewById(R.id.email_signin_btn);
        create_account_btn = findViewById(R.id.create_account_btn);
        email_login = findViewById(R.id.email);
        password_login = findViewById(R.id.password);

        create_account_btn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(i);
        });

        

        // Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email_signin_btn.setOnClickListener(v-> {
            logEmailPassUser(
                    email_login.getText().toString().trim(),
                    password_login.getText().toString().trim()
            );

        });
    }

    private void logEmailPassUser(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {
                        Intent i = new Intent(MainActivity.this, JournalListActivity.class);
                        startActivity(i);
                    }
                }
            });
    }
}
