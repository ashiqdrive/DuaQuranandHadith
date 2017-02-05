package com.salsabeelapp.duaquranandhadith;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class SettngsMainPage extends AppCompatActivity {

    String TAG = "SettingsMainPAge TAg";

    public Boolean toViewBoth;
    public Boolean toViewArabic;
    public Boolean toViewTamil;

    public int fontSizeTamilInt;
    public int fontSizeArabicInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settngs_main_page);
        checkSharedPrefToShowRadioGroup();
        checkSharedPrefTamilFontSize();
    }

    @Override
    public void onBackPressed() {

        //Each Radio Group are Inserted Separately
        try {
            saveRadioToShow();
        } catch (Exception e) {
            Log.e(TAG, "To Show Not edited "+e);
        }

        try {
            saveTamilFont();
        } catch (Exception e) {
            Log.e(TAG, "tamil Font Not Edited "+e);
        }

        //Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    //Method which is Called by the Radio buttons inside What to Show Group
    public void changeDuaView(View view) {

        switch (view.getId()) {
            case R.id.rbBothArabicAndTamil:
                Toast.makeText(getBaseContext(), "Both Arabic and Tamil", Toast.LENGTH_SHORT).show();
                this.toViewBoth = true;
                this.toViewArabic = false;
                this.toViewTamil = false;
                break;
            case R.id.rbOnlyArabic:
                Toast.makeText(getBaseContext(), "Only Arabic ", Toast.LENGTH_SHORT).show();
                this.toViewBoth = false;
                this.toViewArabic = true;
                this.toViewTamil = false;
                break;
            case R.id.rbOnlyTamil:
                Toast.makeText(getBaseContext(), "Only Tamil", Toast.LENGTH_SHORT).show();
                this.toViewBoth = false;
                this.toViewArabic = false;
                this.toViewTamil = true;
                break;
        }
    }

    //Method Called by the Radio buttons under Tamil Font size Change Group
    public void changeTamilFontSizeRadioGroup(View view) {

        switch (view.getId()) {
            case R.id.rbTSize20:
                this.fontSizeTamilInt = 20;
                Toast.makeText(getBaseContext(), "Tamil FontSize Changed " + fontSizeTamilInt, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbTSize22:
                this.fontSizeTamilInt = 22;
                Toast.makeText(getBaseContext(), "Tamil FontSize Changed " + fontSizeTamilInt, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbTSize24:
                this.fontSizeTamilInt = 24;
                Toast.makeText(getBaseContext(), "Tamil FontSize Changed " + fontSizeTamilInt, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbTSize26:
                this.fontSizeTamilInt = 26;
                Toast.makeText(getBaseContext(), "Tamil FontSize Changed " + fontSizeTamilInt, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void saveRadioToShow() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.PREF_FILE_SETTINGS), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(getString(R.string.PREF_toViewBoth), this.toViewBoth);
        editor.putBoolean(getString(R.string.PREF_toViewArabic), this.toViewArabic);
        editor.putBoolean(getString(R.string.PREF_toViewTamil), this.toViewTamil);


        editor.commit();
        editor.apply();
        Log.d(TAG, "inserted");
    }

    public void saveTamilFont() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.PREF_FILE_SETTINGS), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.PREF_Font_Size_Tamil), this.fontSizeTamilInt);

        editor.commit();
        editor.apply();
        Log.d(TAG, "inserted TamilFont Size Changed");

    }

    //Method Called in the beginning to make sure
    //that Correct Radio buttons are Checked for the To Show radio Group
    public void checkSharedPrefToShowRadioGroup() {

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.PREF_FILE_SETTINGS), Context.MODE_PRIVATE);

        RadioButton rbBoth = (RadioButton) findViewById(R.id.rbBothArabicAndTamil);
        RadioButton rbArabic = (RadioButton) findViewById(R.id.rbOnlyArabic);
        RadioButton rbTamil = (RadioButton) findViewById(R.id.rbOnlyTamil);

        Boolean b1 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewBoth), true);
        Boolean b2 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewArabic), false);
        Boolean b3 = sharedPreferences.getBoolean(getString(R.string.PREF_toViewTamil), false);

        rbBoth.setChecked(b1);
        rbArabic.setChecked(b2);
        rbTamil.setChecked(b3);
    }

    public void checkSharedPrefTamilFontSize(){

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.PREF_FILE_SETTINGS), Context.MODE_PRIVATE);

        RadioButton rbTSize20 = (RadioButton) findViewById(R.id.rbTSize20);
        RadioButton rbTSize22 = (RadioButton) findViewById(R.id.rbTSize22);
        RadioButton rbTSize24 = (RadioButton) findViewById(R.id.rbTSize24);
        RadioButton rbTSize26 = (RadioButton) findViewById(R.id.rbTSize26);

        fontSizeTamilInt = sharedPreferences.getInt(getString(R.string.PREF_Font_Size_Tamil), 20);


        switch (fontSizeTamilInt) {
            case 20:
                rbTSize20.setChecked(true);
                rbTSize22.setChecked(false);
                rbTSize24.setChecked(false);
                rbTSize26.setChecked(false);
                break;
            case 22:
                rbTSize20.setChecked(false);
                rbTSize22.setChecked(true);
                rbTSize24.setChecked(false);
                rbTSize26.setChecked(false);
                break;
            case 24:
                rbTSize20.setChecked(false);
                rbTSize22.setChecked(false);
                rbTSize24.setChecked(true);
                rbTSize26.setChecked(false);
                break;
            case 26:
                rbTSize20.setChecked(false);
                rbTSize22.setChecked(false);
                rbTSize24.setChecked(false);
                rbTSize26.setChecked(true);
                break;
        }
    }
}
