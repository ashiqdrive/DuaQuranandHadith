package com.salsabeelapp.duaquranandhadith;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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

    public static Boolean viewBothBoolean;
    public static Boolean viewArabicBoolean;
    public static Boolean viewTamilBoolean;

    public static int TAMILFONTSIZE;
    public static int ARABICFONTSIZE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_dua);

        duaList = new ArrayList<GetandSet>();

        openMethod();
        reviewSharedPref();
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

    public void reviewSharedPref() {

        String s = "-";
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.PREF_FILE_SETTINGS), Context.MODE_PRIVATE);

        Boolean b1 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewBoth), true);
        Boolean b2 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewArabic), false);
        Boolean b3 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewTamil), false);

        TAMILFONTSIZE = sharedPreferences.getInt(getString(R.string.PREF_Font_Size_Tamil), 20);

        viewBothBoolean = b1;
        viewArabicBoolean = b2;
        viewTamilBoolean = b3;

        if (b1) {
            s = s + "View Both True";
        } else if (b2) {
            s = s + "Arabic True";
        } else if (b3) {
            s = s + "Tamil True";
        }

        Toast.makeText(getBaseContext(), "the String is : " + s, Toast.LENGTH_SHORT).show();

        Toast.makeText(getBaseContext(), "Tamil Font Size is " + TAMILFONTSIZE, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Tamil Font Size" + TAMILFONTSIZE);


    }
}
