package com.example.fireauth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    private Button sendPassword;
    private TextView emailSend;
    private EditText emailEdit;
    private FirebaseAuth mAuth;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sendPassword = findViewById(R.id.sendPassword);
        emailSend = findViewById(R.id.viewTitulo);
        emailEdit = findViewById(R.id.editTextEmailPass);
        mAuth = FirebaseAuth.getInstance();

        sendPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString().trim();

                if (!email.isEmpty()) {
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(forgotPassword.this, "Email enviado", Toast.LENGTH_SHORT).show();
                                    startTimer();
                                } else {
                                    Toast.makeText(forgotPassword.this, "Falha para enviar email", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(forgotPassword.this, "Por favor insira um email valido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startTimer() {
        sendPassword.setEnabled(false);

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sendPassword.setText("Aguarde " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                sendPassword.setEnabled(true);
                sendPassword.setText("Enviar novamente");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
