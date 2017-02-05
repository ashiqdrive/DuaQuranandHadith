package com.salsabeelapp.duaquranandhadith;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.salsabeelapp.duaquranandhadith.databasefiles.DataBaseAdapter;


public class MainActivity extends AppCompatActivity {

    DataBaseAdapter DA;
    private static final String TAG = "MainActivity tag";

    ListView lvMain;
    RecyclerView.LayoutManager layoutManager;

    public static String[] MAINLISTITEMS = {"Introduction", "Quran Dua", "Hadith Dua", "Settings"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openMethod();
        tableInsertCheck();

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MAINLISTITEMS);
        lvMain = (ListView) findViewById(R.id.lvMainActivity);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listItemClick(position);
            }
        });
    }


    private void openMethod() {
        DA = new DataBaseAdapter(this);
        DA.open();
        Log.i(TAG, "open method Sucessfull");
    }

    public void tableInsertCheck() {

        //CHECKING INSERT FOR QURAN TABLE
        if (DA.getRowCount(DA.TABLE_QURAN, DA.ALL_QURAN_TABLE_KEYS) == 0) {
            DA.insertQuranDuaTable();
        } else {
            Log.d(TAG, "QURAN table already inserted its more than 0");
        }

        //CHECKING INSERT FOR HADITH TABLE
        if (DA.getRowCount(DA.TABLE_HADITH, DA.ALL_HADITH_TABLE_KEYS) == 0) {
            DA.insertHadithDuaTable();
        } else {
            Log.d(TAG, "HADITH table already inserted its more than 0");
        }
    }

    public void listItemClick(int itemSelected) {

        if (itemSelected == 0) {
            Intent intent = new Intent(this, Introduction.class);
            startActivity(intent);
        } else if (itemSelected == 1) {
            Intent intent = new Intent(this, QuranDua.class);
            startActivity(intent);
        } else if (itemSelected == 2) {
            Intent intent = new Intent(this, HadithDua.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, SettngsMainPage.class);
            startActivity(intent);
        }
    }


}
