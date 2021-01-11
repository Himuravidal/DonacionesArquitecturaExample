package com.example.donacionesarquitectura.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.donacionesarquitectura.R;
import com.example.donacionesarquitectura.databinding.ActivityMainBinding;
import com.example.donacionesarquitectura.presenter.DonationPresenter;
import com.example.donacionesarquitectura.presenter.IViewPresenter;

public class MainActivity extends AppCompatActivity implements IViewPresenter {

    private ActivityMainBinding binding;
    private DonationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //instanciar el presenter
        presenter = new DonationPresenter(this);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeDonation();
            }
        });
    }

    @Override
    public void updateTotalDonation(int totalDonation) {
        String donationString = getString(R.string.donacion, String.valueOf(totalDonation));
        binding.tVdonacion.setText(donationString);
    }

    @Override
    public void displayConfirmationMessage() {
        Toast.makeText(this, "Donación Realizada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "No se registro la donación", Toast.LENGTH_SHORT).show();
    }

    public void makeDonation() {
        presenter.saveDonation(binding.etDonacion.getText().toString());
        binding.etDonacion.setText("");
    }


}