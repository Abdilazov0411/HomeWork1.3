package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.homework1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSendMessage.setOnClickListener(view -> {
            String message = binding.etMessage.getText().toString();

            if (!message.isEmpty()){
                openEmailPicker(message);

                passMessageToAnotherActivity(message);
            }
        });
    }

    private void openEmailPicker(String message){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Example");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        Intent chooser = Intent.createChooser(emailIntent, "Send Email Using: ");
        startActivity(chooser);
    }

    private void passMessageToAnotherActivity(String message) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}