package com.example.exe2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Main1 extends AppCompatActivity {

    EditText txt1, txt2, txtTime, txtDate;
    Spinner spTinh;
    TextView txtKq;

    ListView listView;
    AutoCompleteTextView autoTp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main2);
        initGUI();
        spTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String st = tinh(txt1.getText().toString(), txt2.getText().toString(),
                        spTinh.getSelectedItem().toString());
                txtKq.setText(st);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog pickerDialog = new TimePickerDialog(Main1.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String time = (hourOfDay < 10 ? ("0" + hourOfDay) : hourOfDay) + ":" + (minute < 10 ? ("0" + minute) : minute);
                                txtTime.setText(time);
                            }
                        }
                        , 3, 53, false);
                pickerDialog.show();
            }
        });

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog pickerDialog = new DatePickerDialog(Main1.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                                txtDate.setText(date);
                            }
                        }
                        , 2025, 1, 19);
                pickerDialog.show();
            }
        });
        String[] arr = {"Toan", "Triet", "The chat", "Code", "Xac suat thong ke"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.uni));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st = adapter.getItem(position);
                Toast.makeText(Main1.this, st, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tpho));
        autoTp.setAdapter(adapter1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.mFile:
//                Toast.makeText(this, "Selected File", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.mEmail:
//                Toast.makeText(this, "Selected Email", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.mPhone:
//                Toast.makeText(this, "Selected Phone", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.mExit:
//                finish(); // Thoát ứng dụng một cách an toàn
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }



    private String tinh(String nn1, String nn2, String p){
        String response = "";
        try{
            double n1, n2;
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);
            switch(p){
                case "+":
                    response += "Tong :" + (n1 + n2);
                    break;
                case "-":
                    response += "Tru :" + (n1 - n2);
                    break;
                case "*":
                    response += "Tich :" + (n1 * n2);
                    break;
                case "/":
                    if(n2 == 0 ){
                        response += "Khong the chia";
                    }
                    else {
                        response += "Thuong: " + (n1 / n2);
                    }
                    break;
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        return response;
    }

    private void initGUI(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txtKq = findViewById(R.id.txtKq);
        spTinh = findViewById(R.id.spTinh);
        txtTime = findViewById(R.id.txt3);
        txtDate = findViewById(R.id.txt4);
        listView = findViewById(R.id.listItem);
        autoTp = findViewById(R.id.autoTP);
    }
}
