package com.mo.hsowl18.hsowl18mo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import objects.Member;

public class MemberEditActivity extends AppCompatActivity {

    public static final String DEBUGTAG = "DW";
    public static final String TEXTFILE = "myfile";
    FileOutputStream outputStream;
    ObjectOutputStream objectOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_edit);
    }

    public void saveMember(View view) {

        EditText firstname = findViewById(R.id.editText_member_firstname);
        EditText secondname = findViewById(R.id.editText_member_secondname);

        Member member = new Member(firstname.getText().toString(), secondname.getText().toString());

        try {
            outputStream = new FileOutputStream(TEXTFILE);
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(member);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MemberListActivity.class);
        startActivity(intent);

        Log.d(DEBUGTAG, "Save button clicked: " + member.getFirstname() + " " + member.getSecondname());
    }
}
