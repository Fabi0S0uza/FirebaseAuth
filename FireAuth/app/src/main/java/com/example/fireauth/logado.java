package com.example.fireauth;

import static com.google.android.material.datepicker.DateValidatorPointBackward.before;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logado extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView emailTextView;
    private Button logoutButton;
    private ImageButton beforeButton;
    private ImageButton nextButton;

    private TextView textFrase;
    private String[] text = {"A jornada pode ser longa, mas cada passo te leva mais perto do seu sonho.", "Sorria para a vida e ela te devolverá motivos para ser feliz.", "A mudança começa dentro de você. O mundo reflete aquilo que você acredita ser possível.", "O que parece impossível hoje será sua maior conquista amanhã."};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        mAuth = FirebaseAuth.getInstance();

        emailTextView = findViewById(R.id.emailTextView);
        logoutButton = findViewById(R.id.logoutButton);
        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);
        textFrase = findViewById(R.id.textFrase);


        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            emailTextView.setText("Email logado: " + email);
        } else {
            Intent intent = new Intent(logado.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        textFrase.setText(text[currentIndex]);


        logoutButton.setOnClickListener(v -> {
            mAuth.signOut();
            Intent intent = new Intent(logado.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        nextButton.setOnClickListener(v -> next());


        beforeButton.setOnClickListener(v -> before());
    }


    public void next() {
        if (currentIndex < text.length - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        textFrase.setText(text[currentIndex]);
    }


    public void before() {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            currentIndex = text.length - 1;
        }
        textFrase.setText(text[currentIndex]);
    }
}
