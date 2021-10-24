package com.example.ayongadu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayongadu.R;
import com.example.ayongadu.databinding.ActivityLoginBinding;
import com.example.ayongadu.model.User;
import com.example.ayongadu.util.AppSharedPreference;

public class LoginActivity extends AppCompatActivity {
    private AppSharedPreference preference;
    private ActivityLoginBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        preference = new AppSharedPreference(this);

        user = new User();
        binding.setActivity(this);
        binding.setUser(user);
    }

    public View.OnClickListener onLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Harap isi form!", Toast.LENGTH_SHORT).show();
            } else {
                login(user.getEmail(), user.getPassword());
            }
        }
    };

    public View.OnClickListener onRegisterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }
    };

    private void login(String email, String pass) {
        if (preference.getUser().getEmail().equals(email) && preference.getUser().getPassword().equals(pass)) {
            preference.setIsLogin(true);
            Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            Toast.makeText(LoginActivity.this, "Login gagal, email atau password salah!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (preference.isLogin()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (preference.isLogin()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }
}