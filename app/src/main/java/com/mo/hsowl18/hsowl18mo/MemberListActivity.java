package com.mo.hsowl18.hsowl18mo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import objects.Member;

public class MemberListActivity extends AppCompatActivity {

    public static final String TEXTFILE = "myfile";
    FileInputStream inputStream;
    ObjectInputStream objectInputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        populateListView();
        registerClickCallback();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.member_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_addNewMember:
                Intent intent = new Intent(this, MemberEditActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuItem_showInactivMembers:
                intent = new Intent(this, MemberEditActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void populateListView() {

        /*TreeMap<Integer, Member> memList = new TreeMap<Integer, Member>();
        Member me = new Member("Daniel", "Wolf");
        memList.put(0, me);
        String[] stringMembers = new String[10];
        Member member;

        try {
            inputStream = new FileInputStream(TEXTFILE);
            objectInputStream = new ObjectInputStream(inputStream);
            member = (Member) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            member = null;
            e.printStackTrace();
        }

        memList.put(member.getId(),  member);

        for (int x = 0; x < memList.size(); x++) {

            //stringMembers = new String[stringMembers.length+1];

            stringMembers[x] = memList.get(x).getFirstname() + " " + memList.get(x).getSecondname();

        }*/

        String[] myItems = {"Blue", "Green", "Purple", "Red"};

        ArrayAdapter<String> adapterColor = new ArrayAdapter<String>
                (this, R.layout.memberlistview, myItems);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>
        //        (this, R.layout.memberlistview, stringMembers);

        ListView list = (ListView) findViewById(R.id.memberListView);
        list.setAdapter(adapterColor);

    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.memberListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "You clicked # " + position + ", which is string: " + textView.getText();
                Toast.makeText(MemberListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }


}
