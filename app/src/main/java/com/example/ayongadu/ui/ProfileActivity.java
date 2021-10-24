package com.example.ayongadu.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ayongadu.R;
import com.example.ayongadu.databinding.ActivityProfileBinding;
import com.example.ayongadu.model.User;
import com.example.ayongadu.util.AppSharedPreference;

public class ProfileActivity extends AppCompatActivity {
    private AppSharedPreference preference;
    private ActivityProfileBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);

        preference = new AppSharedPreference(this);

        user = preference.getUser();
        binding.setActivity(this);
        binding.setUser(user);
    }

    public View.OnClickListener onBackClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    public View.OnClickListener onUpdateClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (user.getName().isEmpty() || user.getPhone().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
                Toast.makeText(ProfileActivity.this, "Harap isi form!", Toast.LENGTH_SHORT).show();
            } else {
                save(user.getName(), user.getPhone(), user.getEmail(), user.getPassword());
            }
        }
    };

    private void save(String name, String phone, String email, String pass) {
        preference.setUser(name, email, phone, pass);
        Toast.makeText(ProfileActivity.this, "Berhasil mengubah profil!", Toast.LENGTH_SHORT).show();
    }
}