package com.example.db_stud;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class pdfAcitivity extends AppCompatActivity {

    private static final int STORAGE_CODE = 1000;

//    static {
//        STORAGE_CODE = 1000;
//    }
    DatabaseHelper myDb;
    EditText mTextEt,mSearch;
    Button mSaveBtn,mSearchButton,mupdt;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_acitivity);
        myDb = new DatabaseHelper(this);


        mSearch = (EditText)findViewById(R.id.etSearch);
        mSearchButton =(Button)findViewById(R.id.btShow);
        mTextEt = (EditText)findViewById(R.id.etText);
        mSaveBtn = (Button)findViewById(R.id.btSave);
        mupdt = (Button)findViewById(R.id.btUpdateInformation);



        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextEt.setText(viewAll((mSearch.getText().toString().trim()),sqLiteDatabase));
            }
        });


        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String permissions = (Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        requestPermissions(new String[]{permissions}, STORAGE_CODE);
                    } else {
                        savePdf();
                    }
                } else {
                    savePdf();
                }
            }

//            private void savePdf() {
//            }


        });

        mupdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String check = "Check";
                Intent intent = new Intent(pdfAcitivity.this,what.class);
                intent.putExtra("Check",4);
                startActivity(intent);
                finish();
            }
        });

    }

    private StringBuilder viewAll(String Roll,SQLiteDatabase sqLiteDatabase) {
                Cursor res1 = myDb.getAllData11(Roll);
                Cursor res2 = myDb.getAllData22(Roll);
                Cursor res3 = myDb.getAllData33(Roll);
                if(res1.getCount() == 0 || res2.getCount() == 0 || res3.getCount() == 0){
                    StringBuilder sorry = new StringBuilder();
                    sorry.append("sorry...");
//                    showMessage("Error","Nothing found");
                    return sorry;
                }

                String IdCard = mSearch.getText().toString().trim();
        StringBuilder buffer = new StringBuilder();

//        if(mSearch.getText().toString().trim() == res1.getString(0)) {

                    while (res1.moveToNext()) {
//                        buffer.append("Id :" + res1.getString(0) + "\n");
                        buffer.append("Name :" + res1.getString(1) + "\n");
                        buffer.append("Email :" + res1.getString(2) + "\n");
                        buffer.append("Branch Name :" + res1.getString(4) + "\n");
                        buffer.append("Roll number :" + res1.getString(5) + "\n");
                        buffer.append("Batch duration :" + res1.getString(6) + "\n");
                        buffer.append("Date of birth :" + res1.getString(7) + "\n");
                        buffer.append("Gender :" + res1.getString(8) + "\n");
                        buffer.append("Home Address :" + res1.getString(9) + "\n\n");
                    }
                    while (res2.moveToNext()) {
//                        buffer.append("Roll number :" + res2.getString(0) + "\n");
                        buffer.append("School name(for 10th exam) :" + res2.getString(1) + "\n");
                        buffer.append("Results of 10th exam :" + res2.getString(2) + "\n");
                        buffer.append("School name(for 12th exam) :" + res2.getString(3) + "\n");
                        buffer.append("Results of 12th exam:" + res2.getString(4) + "\n");
                        buffer.append("Competitive exam and respective results :" + res2.getString(5) + "\n");
                    }
                    while (res3.moveToNext()) {
//                        buffer.append("Roll number:" + res3.getString(0) + "\n");
                        buffer.append("Skills and hobbies :" + res3.getString(2) + "\n");

                    }

//                }else{
//            Toast.makeText(this,"Please provide Id to get the data.",Toast.LENGTH_SHORT).show();
//        }

//                showMessage("Data",buffer.toString());
                return buffer;
            }



    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void savePdf() {

        Document mDoc = new Document();

        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath = Environment.getExternalStorageDirectory() + "/" + mFileName + ".pdf";
        try{
            PdfWriter.getInstance(mDoc,new FileOutputStream(mFilePath));
            mDoc.open();

            String mText = mTextEt.getText().toString();

            mDoc.addAuthor("Sourav kumar");
            mDoc.add(new Paragraph(mText));
            mDoc.close();
            Toast.makeText(this,mFileName+ ".pdf\n is saved to\n"+mFilePath,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case STORAGE_CODE:
                if(grantResults.length> 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    savePdf();
                }else{
                    Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();
                }
        }
    }
}
