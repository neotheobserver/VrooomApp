package com.example.vrooooom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editDate,editTime;
    Button btnAdd,btnDel,btnUpd,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);

        editName=(EditText) findViewById(R.id.editTextName);
        editDate=(EditText)findViewById(R.id.editTextDate);
        editTime=(EditText)findViewById(R.id.editTextTime);
        btnAdd=(Button)findViewById(R.id.buttonAdd);
        AddData();
    }
    public void AddData(){
        btnAdd.setOnClickListener(
            new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    boolean isInserted= myDb.insertData(editName.getText().toString(),editDate.getText().toString(),editTime.getText().toString());
                    if (isInserted==true){
                        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Data not INserted",Toast.LENGTH_LONG).show();
                }
            }
        );
    }
}