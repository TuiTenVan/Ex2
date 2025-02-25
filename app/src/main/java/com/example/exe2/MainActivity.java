package com.example.exe2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3;
    TextView txtKq;
    Button btnSubmit;
    RadioButton radioButton1, radioButton2;
    RatingBar ratingBar;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main1);
        initGUI();

        //TODO: tao spinner
//        String[] arrays = {"GT1", "VL1", "CSDL", "Triet"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                R.layout.item_spinner, arrays);
//        spinner.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String response = "";
                response += "Type: ";
                if (checkBox1.isChecked()){
                    response += checkBox1.getText() + " ";
                }
                if (checkBox2.isChecked()){
                    response += checkBox2.getText() + " ";
                }
                if (checkBox3.isChecked()){
                    response += checkBox3.getText() + " ";
                }
                response += "\nGender: ";
                if(radioButton1.isChecked()){
                    response += radioButton1.getText() + " ";
                }
                if(radioButton2.isChecked()){
                    response += radioButton2.getText() + " ";
                }
                response += "\nService: " + ratingBar.getRating();
                response += "\nSpinner: " + spinner.getSelectedItem().toString();
                response += "\nSubject: " + spinner.getSelectedItem().toString();
                txtKq.setText(response);
            }
        });
    }

    private void initGUI(){
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        txtKq = findViewById(R.id.txtKq);
        btnSubmit = findViewById(R.id.button);
        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);
        ratingBar = findViewById(R.id.ratingBar);
        spinner = findViewById(R.id.spinner1);
    }
}