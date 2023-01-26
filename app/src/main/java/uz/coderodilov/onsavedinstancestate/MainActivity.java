package uz.coderodilov.onsavedinstancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uz.coderodilov.onsavedinstancestate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt("number");
            binding.tvNumber.setText(String.valueOf(counter));
        }

        binding.btnIncrement.setOnClickListener(v -> {
            counter++;
            binding.tvNumber.setText(String.valueOf(counter));
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("number", counter);
        super.onSaveInstanceState(outState);
    }
}