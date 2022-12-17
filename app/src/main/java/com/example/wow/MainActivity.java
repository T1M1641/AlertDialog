package com.example.wow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openRegistrationDialog = findViewById(R.id.btn1);



        openRegistrationDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlertDialog();
            }
            });
    }
    private void showCustomAlertDialog() {
        Dialog dialog = new Dialog(MainActivity.this, R.style.dialog);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.registration);

        EditText loginInput = dialog.findViewById(R.id.ed1);
        EditText passwordInput = dialog.findViewById(R.id.ed2);

        Button submitButton = dialog.findViewById(R.id.btn2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginContent = loginInput.getText().toString();
                String passwordContent = passwordInput.getText().toString();

                setRegistrationInfo(loginContent, passwordContent);

                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void setRegistrationInfo(String loginContent, String passwordContent) {
        TextView appTitle = findViewById(R.id.txt1);

        String userInfo = "Спасибо за регистрацию!" + "\n" +
                "Ваш логин: " + loginContent + "\n" +
                "Ваш пароль: " + passwordContent;

        appTitle.setText(userInfo);
    }

}