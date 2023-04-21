package th.ac.kmutnb.idrs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.editText);
        passwordInput = findViewById(R.id.editText3);
        loginButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            if (isInputValid(email, password)) {
                // Send login request to server

                openHome(view);

            } else {
                // Display error message
            }
        });


    }

    public void openHome(View V) {
        Intent itn1 = new Intent(this,ScanCam.class);
        startActivity(itn1);
    }

    private boolean isInputValid(String email, String password) {
        // Validate email and password
        if (email.equals("admin") && password.equals("1234")){
            return true;
        }
        else{return false;}
    }


}