package com.mo.hsowl18.hsowl18mo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMembersActivity(View view) {
        Intent intent = new Intent(this, MemberListActivity.class);
        startActivity(intent);
    }

    public void showActivitiesActivity(View view) {
        Intent intent = new Intent(this, ActivitiesListActivity.class);
        startActivity(intent);
    }

}
