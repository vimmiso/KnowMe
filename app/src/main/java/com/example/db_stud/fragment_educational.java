package com.example.db_stud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fragment_educational extends Fragment {

    DatabaseHelper myDb;
    EditText Erollnumber,School10,Result10,School12,Result12,competitive;
    Button bteadd,bteview,bteupdate;
    PagerViewadpater pagerViewadpater;
    CallBackInterface callBackInterface;
    Context context;
    Boolean bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_educational,null);
        myDb = new DatabaseHelper(getActivity());

        School10 = (EditText)view.findViewById(R.id.et10School);
        Result10 = (EditText)view.findViewById(R.id.et10Result);
        School12 = (EditText)view.findViewById(R.id.et12School);
        Result12 = (EditText)view.findViewById(R.id.et12Result);
        Erollnumber = (EditText)view.findViewById(R.id.etEroll);
        competitive = (EditText)view.findViewById(R.id.etCompetitive);

        bteadd = (Button)view.findViewById(R.id.btEadd);
        bteview = (Button)view.findViewById(R.id.btEview);
        bteupdate = (Button)view.findViewById(R.id.btEupdate);
        Cursor res = myDb.getRoll();
        res.moveToFirst();
        Erollnumber.setText(res.getString(0));
        Erollnumber.setEnabled(false);
        bteupdate.setEnabled(false);
        bteupdate.setText("Don't update");
        bteupdate.setVisibility(View.GONE);
        context = getContext();

//        bteadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(callBackInterface!=null){
//                    callBackInterface.callBackMethod2();
//                }
//            }
//        });
//
//

        Bundle bundle1 = getActivity().getIntent().getExtras();
        if(bundle1 != null){
        Integer i = bundle1.getInt("Check");
        if(i == 4){
            bteadd.setEnabled(false);
            bteadd.setText("Don't Add");
            bteadd.setVisibility(View.GONE);
            bteupdate.setEnabled(true);
            bteupdate.setText("Update the Data");
            bteupdate.setVisibility(View.VISIBLE);
//            Cursor res = myDb.getRoll();
//            res.moveToFirst();
//            Erollnumber.setText(res.getString(0));
//            Erollnumber.setEnabled(false);
            UpdateData();
        }}else {
            AddData();
        }
        viewAll();
//        UpdateData();
        pagerViewadpater = new PagerViewadpater(getFragmentManager());


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("FragmentsDemo"+"->Select Country");
    }

    public void setCallBackInterface(CallBackInterface callBackInterface){
        this.callBackInterface = callBackInterface;
    }

    private void UpdateData() {

            bteupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isUpdate = myDb.updateData2(Erollnumber.getText().toString(), School10.getText().toString(), Result10.getText().toString(), School12.getText().toString(), Result12.getText().toString(), competitive.getText().toString());
//                boolean isUpdate2 = myDb.updateData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isUpdate == true) {
                        if (callBackInterface != null) {
                            callBackInterface.callBackMethod2();
                        }
                        Toast.makeText(getActivity(), "Data updated.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Data not updated.", Toast.LENGTH_SHORT).show();
                    }
                }
            });


    }

    private void viewAll() {

        bteview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res2 = myDb.getAllData2();

                if(res2.getCount() == 0){
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res2.moveToNext()){
                    buffer.append("Id :"+res2.getString(0)+"\n");
                    buffer.append("School name for 10th education :"+res2.getString(1)+"\n");
                    buffer.append("Result of 10th examination :"+res2.getString(2)+"\n");
                    buffer.append("School name for 12th education :"+res2.getString(4)+"\n");
                    buffer.append("Result of 12th examination :"+res2.getString(5)+"\n");
                    buffer.append("Competitive exam attempted and respective results:"+res2.getString(6)+"\n\n");

                }

                showMessage("Educational Data",buffer.toString());
            }
        });
    }

    private void AddData() {
        Cursor res = myDb.getRoll();
        res.moveToFirst();
        Erollnumber.setText(res.getString(0));
        Erollnumber.setEnabled(false);
        bteadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Erollnumber.getText().toString().trim().length() == 0 ||School10.getText().toString().trim().length() == 0 ||Result10.getText().toString().trim().length() == 0 || School12.getText().toString().trim().length() == 0 ||Result12.getText().toString().trim().length() == 0 ||competitive.getText().toString().trim().length() == 0 ) {
                    Toast.makeText(getActivity(), "Please fill the details properly.", Toast.LENGTH_SHORT).show();

                } else {
                    boolean isInserted2 = myDb.insertData2(Erollnumber.getText().toString(), School10.getText().toString(), Result10.getText().toString(), School12.getText().toString(), Result12.getText().toString(), competitive.getText().toString());
//                boolean isInserted2 = myDb.insertData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isInserted2 == true) {
                        if (callBackInterface != null) {
                            callBackInterface.callBackMethod2();
                        }
                        Toast.makeText(getActivity(), "Data Inserted.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Data not Inserted.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
