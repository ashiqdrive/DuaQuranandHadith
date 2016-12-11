package com.salsabeelapp.duaquranandhadith;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.salsabeelapp.duaquranandhadith.databasefiles.DataBaseAdapter;
import com.salsabeelapp.duaquranandhadith.recyclerviewfiles.GetandSet;
import com.salsabeelapp.duaquranandhadith.recyclerviewfiles.RecyclerAdapterMy;

import java.util.ArrayList;

public class QuranDua extends AppCompatActivity {

    DataBaseAdapter DA;
    private static final String TAG = "QuranDua tag";

    ArrayList<GetandSet> duaList;
    RecyclerView rvQuranDua;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterMy adapterMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_dua);

        duaList = new ArrayList<GetandSet>();

        openMethod();
        populatingDua();

    }

    private void openMethod() {
        DA = new DataBaseAdapter(this);
        DA.open();
        Log.i(TAG, TAG + " open method Sucessfull");
    }

    public void populatingDua() {
        Cursor cursor = DA.getAllRows(DA.TABLE_QURAN, DA.ALL_QURAN_TABLE_KEYS);

        for (int i = 0; i < cursor.getCount(); i++) {
            String arabictext = cursor.getString(cursor.getColumnIndex(DataBaseAdapter.ROW_QURAN_ARABIC_DUA));
            String tamiltext = cursor.getString(cursor.getColumnIndex(DataBaseAdapter.ROW_QURAN_TAMIL_DUA));
            String referencetext = cursor.getString(cursor.getColumnIndex(DataBaseAdapter.ROW_QURAN_REFERENCE));
            GetandSet getandSet = new GetandSet(arabictext, tamiltext, referencetext);
            duaList.add(getandSet);
            cursor.moveToNext();
        }
        recyclerViewPopulation();
    }

    public void recyclerViewPopulation() {
        rvQuranDua = (RecyclerView) findViewById(R.id.rvQuranDua);
        adapterMy = new RecyclerAdapterMy(duaList, this);
        rvQuranDua.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvQuranDua.setLayoutManager(layoutManager);
        rvQuranDua.setAdapter(adapterMy);
    }
}
