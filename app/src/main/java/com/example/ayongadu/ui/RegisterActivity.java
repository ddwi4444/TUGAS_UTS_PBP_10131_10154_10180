package com.example.ayongadu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ayongadu.R;
import com.example.ayongadu.databinding.ActivityRegisterBinding;
import com.example.ayongadu.model.User;
import com.example.ayongadu.util.AppSharedPreference;

public class RegisterActivity extends AppCompatActivity {

    private AppSharedPreference preference;
    private ActivityRegisterBinding binding;
    private User user;

    public View.OnClickListener onLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    };

    public View.OnClickListener onRegisterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Harap isi form!", Toast.LENGTH_SHORT).show();
            } else {
                register(user.getName(), user.getPhone(), user.getEmail(), user.getPassword());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        preference = new AppSharedPreference(this);
        user = new User();
        binding.setActivity(this);
        binding.setUser(user);
    }

    private void register(String name, String phone, String email, String pass) {
        preference.setUser(name, email, phone, pass);
        Toast.makeText(RegisterActivity.this, "Berhasil mendaftar!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}