package com.example.db_stud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import static com.example.db_stud.DatabaseHelper.TABLE_NAME1;

public class fragment_personal extends Fragment {

    DatabaseHelper myDb;
    EditText eName,eEmail,ePassword,eBranch,eRoll, eMobilenumber,eDateofBirth,eGender,eAddress;
    Button add,bview,update;
    PagerViewadpater pagerViewadpater;
    SQLiteDatabase sqLiteDatabase;
    CallBackInterface callBackInterface;
    Context context;
    Boolean bundle ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_personal,null);
        myDb = new DatabaseHelper(getActivity());

        eName = (EditText)view.findViewById(R.id.etNamefull);
        eEmail = (EditText)view.findViewById(R.id.etEmail);
        ePassword = (EditText)view.findViewById(R.id.etPassword);
        eBranch = (EditText)view.findViewById(R.id.etBranch);
        eRoll = (EditText)view.findViewById(R.id.etRoll);
        eMobilenumber = (EditText)view.findViewById(R.id.etBatch);
        eDateofBirth = (EditText)view.findViewById(R.id.etDateofBirth);
        eGender = (EditText)view.findViewById(R.id.etGender);
        eAddress = (EditText)view.findViewById(R.id.etAddress);
        add = (Button)view.findViewById(R.id.btAdd);
        bview = (Button)view.findViewById(R.id.btView);
        update = (Button)view.findViewById(R.id.btUpdate);
//        Fragment fra = (Fragment)getFragmentManager().findFragmentById(R.id.frag_edu);

        update.setEnabled(false);
        update.setText("Don't update");
        update.setVisibility(View.GONE);
        context = getContext();
//        bundle = false;
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(callBackInterface!=null){
//                    callBackInterface.callBackMethod1();
//                }
//            }
//        });


// Intent intent = new Intent(getActivity().getIntent());
// Integer bundle1 = intent.getExtras().getInt("Check");
        Bundle bundle1 = getActivity().getIntent().getExtras();
        if(bundle1 != null){
        Integer i = bundle1.getInt("Check");
if(i == 4){
    add.setEnabled(false);
    add.setText("Don't Add");
    add.setVisibility(View.GONE);
    update.setEnabled(true);
    update.setText("Update the Data");
    update.setVisibility(View.VISIBLE);
    Cursor res = myDb.getRoll();
    res.moveToFirst();
    eRoll.setText(res.getString(0));
    eRoll.setEnabled(false);
    UpdateData();
}}else {
    AddData();
}
        viewAll();
//        UpdateData();

        pagerViewadpater = new PagerViewadpater(getFragmentManager());
//        .setAdapter(pagerViewadpater);

        return view;
    }

    private void AddData() {

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eName.getText().toString().trim().length() == 0 || eEmail.getText().toString().trim().length() == 0 ||  ePassword.getText().toString().trim().length() == 0 ||eBranch.getText().toString().trim().length() == 0 ||eRoll.getText().toString().trim().length() == 0 ||eMobilenumber.getText().toString().trim().length() == 0 ||eDateofBirth.getText().toString().trim().length() == 0 ||eGender.getText().toString().trim().length() == 0 ||eAddress.getText().toString().trim().length() == 0 ) {
                    Toast.makeText(getActivity(), "Please fill the details properly.", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted1 = myDb.insertData1(eName.getText().toString(), eEmail.getText().toString(), ePassword.getText().toString(), eBranch.getText().toString(), eRoll.getText().toString(), eMobilenumber.getText().toString(), eDateofBirth.getText().toString(), eGender.getText().toString(), eAddress.getText().toString());
//                boolean isInserted2 = myDb.insertData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isInserted1 == true) {
                        if (callBackInterface != null) {
                            callBackInterface.callBackMethod1();
                        }
                        Toast.makeText(getActivity(), "Data Inserted.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Data not Inserted.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("FragmentsDemo"+"->Select Country");
    }

    public void setCallBackInterface(CallBackInterface callBackInterface){
        this.callBackInterface = callBackInterface;
    }
//    private void AddData(){
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.commit();
//            }
//
//        });
//    }
    private void viewAll() {
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res1 = myDb.getAllData1();
                if(res1.getCount() == 0){
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res1.moveToNext()){
                    buffer.append("Id :"+res1.getString(0)+"\n");
                    buffer.append("Name :"+res1.getString(1)+"\n");
                    buffer.append("Email :"+res1.getString(2)+"\n");
                    buffer.append("Branch Name :"+res1.getString(4)+"\n");
                    buffer.append("Roll number :"+res1.getString(5)+"\n");
                    buffer.append("Batch duration :"+res1.getString(6)+"\n");
                    buffer.append("Date of birth :"+res1.getString(7)+"\n");
                    buffer.append("Gender :"+res1.getString(8)+"\n");
                    buffer.append("Home Address :"+res1.getString(9)+"\n\n");
                }

                showMessage("Data",buffer.toString());
            }
        });

    }

    private void UpdateData() {

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdate = myDb.updateData1(eName.getText().toString(), eEmail.getText().toString(), ePassword.getText().toString(), eBranch.getText().toString(), eRoll.getText().toString(), eMobilenumber.getText().toString(), eDateofBirth.getText().toString(), eGender.getText().toString(), eAddress.getText().toString());
//                boolean isUpdate2 = myDb.updateData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isUpdate == true) {
                        if (callBackInterface != null) {
                            callBackInterface.callBackMethod1();
                        }
                        Toast.makeText(getActivity(), "Data updated.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Data not updated.", Toast.LENGTH_SHORT).show();
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
