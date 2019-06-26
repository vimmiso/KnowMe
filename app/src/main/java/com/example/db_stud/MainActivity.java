package com.example.db_stud;

import android.database.Cursor;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks,editId;
    Button btnAddData ,btnViewData ,btnUpdate;
    ViewPager viewPager;
    PagerViewadpater pagerViewadpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.etNamefull);
        editSurname = (EditText)findViewById(R.id.etSrname);
        editMarks = (EditText)findViewById(R.id.etMarks);
        editId = (EditText)findViewById(R.id.etId);

        btnAddData = (Button)findViewById(R.id.btAddData);
        btnViewData = (Button)findViewById(R.id.btnView);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
//        AddData();
//        viewAll();
//        UpdateData();
    }

//    public void UpdateData(){
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isUpdate1 = myDb.updateData1(editId.getText().toString(),editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
//                boolean isUpdate2 = myDb.updateData2(editId.getText().toString(),editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
//
//
//                if(isUpdate1==true && isUpdate2==true){
//                    Toast.makeText(MainActivity.this,"Data updated.",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this,"Data not updated.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//    public void AddData(){
//        btnAddData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isInserted1 = myDb.insertData1(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
//                boolean isInserted2 = myDb.insertData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
//
//
//                if(isInserted1 == true && isInserted2 == true){
//                    Toast.makeText(MainActivity.this,"Data Inserted.",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this,"Data not Inserted.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    public void viewAll(){
//        btnViewData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor res1 = myDb.getAllData1();
//                Cursor res2 = myDb.getAllData2();
//
//                if(res1.getCount() == 0 && res2.getCount()==0){
//                    showMessage("Error","Nothing found");
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//                while (res1.moveToNext()){
//                    buffer.append("Id :"+res1.getString(0)+"\n");
//                    buffer.append("Name :"+res1.getString(1)+"\n");
//                    buffer.append("Surname :"+res1.getString(2)+"\n");
//                    buffer.append("Marks :"+res1.getString(3)+"\n\n");
//
//                }
//
//
//                while (res2.moveToNext()){
//                    buffer.append("Id2 :"+res2.getString(0)+"\n");
//                    buffer.append("Name2 :"+res2.getString(1)+"\n");
//                    buffer.append("Surname2 :"+res2.getString(2)+"\n");
//                    buffer.append("Marks2 :"+res2.getString(3)+"\n\n");
//
//                }
//                showMessage("Data",buffer.toString());
//            }
//        });
//    }


    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
