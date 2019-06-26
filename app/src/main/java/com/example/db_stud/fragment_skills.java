package com.example.db_stud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fragment_skills extends Fragment {

    DatabaseHelper myDb;
    private EditText mRollnumber,mSkillsText;
    private Button mSave,mupdate;
    CallBackInterface callBackInterface;
    PagerViewadpater pagerViewadpater;
    Context context;
    Boolean bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills,null);
        myDb = new DatabaseHelper(getActivity());

        mRollnumber = (EditText)view.findViewById(R.id.etRollSkills);
        mSkillsText = (EditText)view.findViewById(R.id.etSkill);
        mSave = (Button)view.findViewById(R.id.btSave);
        mupdate = (Button)view.findViewById(R.id.btUpateskills);

        Cursor res = myDb.getRoll();
        res.moveToFirst();
        mRollnumber.setText(res.getString(0));
        mRollnumber.setEnabled(false);
        mupdate.setEnabled(false);
        mupdate.setText("Don't update");
        mupdate.setVisibility(View.GONE);
//        mSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),LoginAcitivity.class);
//                startActivity(intent);
//                getActivity().finish();
////               getFragmentManager().beginTransaction().remove(getTargetFragment()).commitAllowingStateLoss();
//            }
//        });

        Bundle bundle1 = getActivity().getIntent().getExtras();
        if(bundle1 != null){
        Integer i = bundle1.getInt("Check");
        if(i == 4){
            mSave.setEnabled(false);
            mSave.setText("Don't Add");
            mSave.setVisibility(View.GONE);
            mupdate.setEnabled(true);
            mupdate.setText("Update the Data");
            mupdate.setVisibility(View.VISIBLE);
            mRollnumber.setEnabled(false);
            UpdateData();
        }}else{
            AddData();
        }

//        AddData();
        viewAll();
//        UpdateData();
        pagerViewadpater = new PagerViewadpater(getFragmentManager());

        return view;
    }

    private void UpdateData() {

            mupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isUpdate = myDb.updateData3(mRollnumber.getText().toString(), mSkillsText.getText().toString());
//                boolean isUpdate2 = myDb.updateData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isUpdate == true) {
                        Intent intent = new Intent(getActivity(), LoginAcitivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        Toast.makeText(getActivity(), "Data updated.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Data not updated.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }

    private void viewAll() {

    }

    private void AddData() {
        Cursor res = myDb.getRoll();
        res.moveToFirst();
        mRollnumber.setText(res.getString(0));
        mRollnumber.setEnabled(false);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRollnumber.getText().toString().trim().length() == 0 ||mSkillsText.getText().toString().trim().length() == 0 ) {
                    Toast.makeText(getActivity(), "Please fill the details properly.", Toast.LENGTH_SHORT).show();

                } else {
                    boolean isInserted3 = myDb.insertData3(mRollnumber.getText().toString(), mSkillsText.getText().toString());
//                boolean isInserted2 = myDb.insertData2(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());


                    if (isInserted3 == true) {
                        Toast.makeText(getActivity(), "Data Inserted.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), LoginAcitivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), "Data not Inserted.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}
