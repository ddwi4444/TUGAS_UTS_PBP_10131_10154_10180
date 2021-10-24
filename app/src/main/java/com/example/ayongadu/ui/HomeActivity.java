package com.example.ayongadu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ayongadu.R;
import com.example.ayongadu.databinding.ActivityHomeBinding;
import com.example.ayongadu.util.AppSharedPreference;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding.cardCallAmbulance.setOnClickListener(this);
        binding.cardComplain.setOnClickListener(this);
        binding.cardContactList.setOnClickListener(this);
        binding.cardEditProfile.setOnClickListener(this);
        binding.cardHistory.setOnClickListener(this);
        binding.cardAbout.setOnClickListener(this);
    }

    private void setName() {
        binding.setName(new AppSharedPreference(this).getUser().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        setName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setName();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.card_call_ambulance) {
            startActivity(new Intent(HomeActivity.this, CallAmbulanceActivity.class));
        } else if (v.getId() == R.id.card_complain) {
            startActivity(new Intent(HomeActivity.this, ComplainActivity.class));
        } else if (v.getId() == R.id.card_contact_list) {
            startActivity(new Intent(HomeActivity.this, ContactActivity.class));
        } else if (v.getId() == R.id.card_edit_profile) {
            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        } else if (v.getId() == R.id.card_history) {
            startActivity(new Intent(HomeActivity.this, HistoryActivity.class));
        } else if (v.getId() == R.id.card_about) {
            startActivity(new Intent(HomeActivity.this, AboutActivity.class));
        }
    }
}