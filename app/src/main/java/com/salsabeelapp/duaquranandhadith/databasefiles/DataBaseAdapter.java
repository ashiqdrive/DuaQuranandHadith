package com.salsabeelapp.duaquranandhadith.databasefiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ashiq on 06-Dec-16.
 */

public class DataBaseAdapter {

    private static final String TAG = "DataBaseAdapterTag"; //used for logging database version changes

    public static final String DATABASE_NAME = "salsabeelduaquranandhadith.db";
    public static final int DATABASE_VERSION = 4;//should be updated every time when application is updated


    //Table Names
    public static final String TABLE_QURAN = "tablequrandua";
    public static final String TABLE_HADITH = "tablehadithdua";

    //Constructors below
    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public DataBaseAdapter(Context context) {
        this.context = context;
        myDBHelper = new DatabaseHelper(context);
    }

    public DataBaseAdapter open() {
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        myDBHelper.close();
    }

    //===Row NAMES=============

    // Quran Table Row Names
    public static final String ROW_QURAN_ID = "_id";
    public static final String ROW_QURAN_TAMIL_DUA = "qurantamildua";
    public static final String ROW_QURAN_ARABIC_DUA = "quranarabicdua";
    public static final String ROW_QURAN_REFERENCE = "quranreference";


    // Hadith Table Row Names
    public static final String ROW_HADITH_ID = "_id";
    public static final String ROW_HADITH_TAMIL_DUA = "hadithtamildua";
    public static final String ROW_HADITH_ARABIC_DUA = "haditharabicdua";
    public static final String ROW_HADITH_REFERENCE = "hadithreference";


    // ALL_KEYS__ALL_KEYS__ALL_KEYS__ALL_KEYS __ALL_KEYS __ALL_KEYS __ALL_KEYS __ALL_KEYS
    public static final String ALL_QURAN_TABLE_KEYS[] = {ROW_QURAN_ID, ROW_QURAN_TAMIL_DUA, ROW_QURAN_ARABIC_DUA, ROW_QURAN_REFERENCE};
    public static final String ALL_HADITH_TABLE_KEYS[] = {ROW_HADITH_ID, ROW_HADITH_TAMIL_DUA, ROW_HADITH_ARABIC_DUA, ROW_HADITH_REFERENCE};


    //*************CREATE STATEMENTS*******************

    // Create SQL statement for Quran table
    private static final String CREATE_QURAN_SQL =
            "CREATE TABLE " + TABLE_QURAN
                    + " (" + ROW_QURAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ROW_QURAN_TAMIL_DUA + " TEXT, "
                    + ROW_QURAN_ARABIC_DUA + " TEXT, "
                    + ROW_QURAN_REFERENCE + " TEXT "
                    + ");";

    // Create SQL statement for Hadith table
    private static final String CREATE_HADITH_SQL =
            "CREATE TABLE " + TABLE_HADITH
                    + " (" + ROW_HADITH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ROW_HADITH_TAMIL_DUA + " TEXT, "
                    + ROW_HADITH_ARABIC_DUA + " TEXT, "
                    + ROW_HADITH_REFERENCE + " TEXT "
                    + ");";
    //_________CREATE STATEMENTS______ENDS_______ENDS__________________


    //**********INSERT STATEMENTS****STARTS****STARTS****STARTS****
    //**************************************************************************************************

    public void insertQuranDuaTable() {

        String quranTamilDuaArray[] = {
                //1
                "எங்கள் இறைவனே! எங்களுக்கு நாங்களே தீங்கிழைத்துக் கொண்டோம். நீ எங்களை மன்னித்து எங்களுக்கு அருள் புரியாவிட்டால் நிச்சயமாக நாங்கள் நஷ்டமடைந்தவர்களில் ஆகி விடுவோம்.",
                //2
                "என் இறைவனே! நான் அறியாத விஷயங்களைப் பற்றி (இனி) உன்னிடம் கேட்காதபடி என்னைப் பாதுகாக்குமாறு நான் உன்னிடம் பிரார்த்திக்கிறேன். நீ என்னை மன்னித்து எனக்கு நீ கிருபை செய்யாவிட்டால் நிச்சயமாக நானும் நஷ்டமடைந்தவர்களில் ஆகிவிடுவேன்.",
                //3
                "என் இறைவனே! எனக்கும் என்னுடைய தாய் தந்தைக்கும், நம்பிக்கைக் கொண்டவராக என்னுடைய வீட்டில் நுழைந்தவருக்கும், (வீட்டில் நுழையாத மற்ற) நம்பிக்கை கொண்ட ஆண்களுக்கும், நம்பிக்கை கொண்ட பெண்களுக்கும் நீ மன்னிப்பு வழங்கு!",
                //4
                "எங்களுடைய இறைவனே! (உனக்காக நாங்கள் செய்த அமல்களை) எங்களிடமிருந்து ஏற்றுக்கொள்! நிச்சயமாக நீ (எங்களுடைய இந்தப் பிரார்த்தனையைச்) செவியுறுபவனாகவும் அறிந்தவனாகவும் இருக்கின்றாய். எங்களை நீ மன்னித்துவிடு! நிச்சயமாக நீ மிக மன்னிப்பவனும், நிகரற்ற அன்புடையவனுமாக இருக்கின்றாய்.",
                //5
                "என் இறைவனே! என்னையும், என் சந்ததிகளையும் (உன்னைத்) தொழுது வருபவர்களாக ஆக்கி வை. எங்கள் இறைவனே! மேலும் என்னுடைய பிரார்த்தனையை அங்கீகரித்துக் கொள்!"
        };

        String quranArabicDuaArray[] = {
                //1
                " رَبَّنَا ظَلَمْنَآ أَنفُسَنَا وَإِن لَّمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ ٱلْخَسِرِينَ",
                //2
                "رَبِّ إِنِّىٓ أَعُوذُ بِكَ أَنْ أَسْـَٔلَكَ مَا لَيْسَ لِى بِهِۦ عِلْمٌۭ ۖ وَإِلَّا تَغْفِرْ لِى وَتَرْحَمْنِىٓ أَكُن مِّنَ ٱلْخَسِرِينَ",
                //3
                "رَّبِّ ٱغْفِرْ لِى وَلِوَلِدَىَّ وَلِمَن دَخَلَ بَيْتِىَ مُؤْمِنًۭا وَلِلْمُؤْمِنِينَ وَٱلْمُؤْمِنَتِ وَلَا تَزِدِ ٱلظَّلِمِينَ إِلَّا تَبَارًۢا",
                //4
                "رَبَّنَا تَقَبَّلْ مِنَّآ ۖ إِنَّكَ أَنتَ ٱلسَّمِيعُ ٱلْعَلِيمُ رَبَّنَا وَٱجْعَلْنَا مُسْلِمَيْنِ لَكَ وَمِن ذُرِّيَّتِنَآ أُمَّةًۭ مُّسْلِمَةًۭ لَّكَ وَأَرِنَا مَنَاسِكَنَا وَتُبْ عَلَيْنَآ ۖ إِنَّكَ أَنتَ ٱلتَّوَّابُ ٱلرَّحِيمُ",
                //5
                "رَبِّ ٱجْعَلْنِى مُقِيمَ ٱلصَّلَوٰةِ وَمِن ذُرِّيَّتِى ۚ رَبَّنَا وَتَقَبَّلْ دُعَآءِ"
        };

        String quranReferenceArray[] = {
                //1
                "(அல் அஃராஃப் 7:23)",
                //2
                "(ஹூது 11:47)",
                //3
                "(நூஹ் 71:28)",
                //4
                "(அல்பகறா 2:127,128)",
                //5
                "(இப்ராஹீம் 14:40)"
        };


        ContentValues cv = new ContentValues();
        try {
            for (int i = 0; i < quranTamilDuaArray.length; i++) {
                cv.put(ROW_QURAN_TAMIL_DUA, quranTamilDuaArray[i]);
                cv.put(ROW_QURAN_ARABIC_DUA, quranArabicDuaArray[i]);
                cv.put(ROW_QURAN_REFERENCE,quranReferenceArray[i]);
                db.insert(TABLE_QURAN, null, cv);
            }
            Log.e(TAG, "Quran Dua table inserted");
        } catch (SQLException e) {
            Log.e(TAG, "Sql Exception in Quran Dua Insertion\n" + e);
        }
    }

    public void insertHadithDuaTable() {

        String quranTamilDuaArray[] = {
                //1
                "HADITH எங்கள் இறைவனே! எங்களுக்கு நாங்களே தீங்கிழைத்துக் கொண்டோம். நீ எங்களை மன்னித்து எங்களுக்கு அருள் புரியாவிட்டால் நிச்சயமாக நாங்கள் நஷ்டமடைந்தவர்களில் ஆகி விடுவோம்.",
                //2
                "HADITH என் இறைவனே! நான் அறியாத விஷயங்களைப் பற்றி (இனி) உன்னிடம் கேட்காதபடி என்னைப் பாதுகாக்குமாறு நான் உன்னிடம் பிரார்த்திக்கிறேன். நீ என்னை மன்னித்து எனக்கு நீ கிருபை செய்யாவிட்டால் நிச்சயமாக நானும் நஷ்டமடைந்தவர்களில் ஆகிவிடுவேன்.",
                //3
                "HADITH என் இறைவனே! எனக்கும் என்னுடைய தாய் தந்தைக்கும், நம்பிக்கைக் கொண்டவராக என்னுடைய வீட்டில் நுழைந்தவருக்கும், (வீட்டில் நுழையாத மற்ற) நம்பிக்கை கொண்ட ஆண்களுக்கும், நம்பிக்கை கொண்ட பெண்களுக்கும் நீ மன்னிப்பு வழங்கு!",
                //4
                "HADITH எங்களுடைய இறைவனே! (உனக்காக நாங்கள் செய்த அமல்களை) எங்களிடமிருந்து ஏற்றுக்கொள்! நிச்சயமாக நீ (எங்களுடைய இந்தப் பிரார்த்தனையைச்) செவியுறுபவனாகவும் அறிந்தவனாகவும் இருக்கின்றாய். எங்களை நீ மன்னித்துவிடு! நிச்சயமாக நீ மிக மன்னிப்பவனும், நிகரற்ற அன்புடையவனுமாக இருக்கின்றாய்.",
                //5
                "HADITH என் இறைவனே! என்னையும், என் சந்ததிகளையும் (உன்னைத்) தொழுது வருபவர்களாக ஆக்கி வை. எங்கள் இறைவனே! மேலும் என்னுடைய பிரார்த்தனையை அங்கீகரித்துக் கொள்!"
        };

        String quranArabicDuaArray[] = {
                //1
                " رَبَّنَا ظَلَمْنَآ أَنفُسَنَا وَإِن لَّمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ ٱلْخَسِرِينَ",
                //2
                "رَبِّ إِنِّىٓ أَعُوذُ بِكَ أَنْ أَسْـَٔلَكَ مَا لَيْسَ لِى بِهِۦ عِلْمٌۭ ۖ وَإِلَّا تَغْفِرْ لِى وَتَرْحَمْنِىٓ أَكُن مِّنَ ٱلْخَسِرِينَ",
                //3
                "رَّبِّ ٱغْفِرْ لِى وَلِوَلِدَىَّ وَلِمَن دَخَلَ بَيْتِىَ مُؤْمِنًۭا وَلِلْمُؤْمِنِينَ وَٱلْمُؤْمِنَتِ وَلَا تَزِدِ ٱلظَّلِمِينَ إِلَّا تَبَارًۢا",
                //4
                "رَبَّنَا تَقَبَّلْ مِنَّآ ۖ إِنَّكَ أَنتَ ٱلسَّمِيعُ ٱلْعَلِيمُ رَبَّنَا وَٱجْعَلْنَا مُسْلِمَيْنِ لَكَ وَمِن ذُرِّيَّتِنَآ أُمَّةًۭ مُّسْلِمَةًۭ لَّكَ وَأَرِنَا مَنَاسِكَنَا وَتُبْ عَلَيْنَآ ۖ إِنَّكَ أَنتَ ٱلتَّوَّابُ ٱلرَّحِيمُ",
                //5
                "رَبِّ ٱجْعَلْنِى مُقِيمَ ٱلصَّلَوٰةِ وَمِن ذُرِّيَّتِى ۚ رَبَّنَا وَتَقَبَّلْ دُعَآءِ"
        };


        String quranReferenceArray[] = {
                //1
                "(அல் அஃராஃப் 7:23)",
                //2
                "(ஹூது 11:47)",
                //3
                "(நூஹ் 71:28)",
                //4
                "(அல்பகறா 2:127,128)",
                //5
                "(இப்ராஹீம் 14:40)"
        };


        ContentValues cv = new ContentValues();
        try {
            for (int i = 0; i < quranTamilDuaArray.length; i++) {
                cv.put(ROW_HADITH_TAMIL_DUA, quranTamilDuaArray[i]);
                cv.put(ROW_HADITH_ARABIC_DUA, quranArabicDuaArray[i]);
                cv.put(ROW_HADITH_REFERENCE,quranReferenceArray[i]);
                db.insert(TABLE_HADITH, null, cv);
            }
            Log.e(TAG, "Hadith Dua table inserted");
        } catch (SQLException e) {
            Log.e(TAG, "Sql Exception in Hadith Dua Insertion\n" + e);
        }
    }

    //___________ INSERT ENDS _________________  INSERT ENDS _______________________________________________________

    /*the below method is used to check whether the values are inserted in the table @ FirstTime and Update
    this can be used for all tables
    simply pass the tableName as 1st argument and All_KEYS (of appropirate table) array as 2nd argument*/
    public int getRowCount(String tableName, String[] Rowkeys) {
        Cursor c = db.query(true, tableName, Rowkeys, null, null, null, null, null, null);
        int count = c.getCount();
        return count;
    }

    public Cursor getAllRows(String tableName, String[] allKeysName) {
        String where = null;
        Cursor c = db.query(true,tableName,allKeysName,where,null,null,null,null,null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


    //****************************************************************************************************
    //_______ Separate Class but Main for DataBase Adapter class ____________________________________
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DataBaseAdapter DAC; //object for DataBaseAdapterC class

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(CREATE_QURAN_SQL);
            _db.execSQL(CREATE_HADITH_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application's database from version " + oldVersion
                    + " to " + newVersion + ", which will destroy all old data !");

            // Destroy old database:
            _db.execSQL("DROP TABLE IF EXISTS " + TABLE_QURAN);
            _db.execSQL("DROP TABLE IF EXISTS " + TABLE_HADITH);


            // Recreate new database:
            onCreate(_db);
        }
    }
}
