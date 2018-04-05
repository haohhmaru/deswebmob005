package br.usjt.desmob.geodata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
   Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class CountriesDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Countries.db";
    public static final String SQL_CREATE_COUNTRY =
            "CREATE TABLE " + CountriesContract.CountryEntry.TABLE_NAME + "(" +
                    CountriesContract.CountryEntry._ID + " INTEGER PRIMARY KEY,"+
                    CountriesContract.CountryEntry.COLUMN_NAME_NAME + " TEXT," +
                    CountriesContract.CountryEntry.COLUMN_NAME_REGION + " TEXT," +
                    CountriesContract.CountryEntry.COLUMN_NAME_CAPITAL + " TEXT," +
                    CountriesContract.CountryEntry.COLUMN_NAME_FLAG + " TEXT," +
                    CountriesContract.CountryEntry.COLUMN_NAME_CODE3 + " TEXT)";
    public static final String SQL_DROP_COUNTRY =
            "DROP TABLE IF EXISTS " + CountriesContract.CountryEntry.TABLE_NAME;

    public CountriesDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_COUNTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_COUNTRY);
        db.execSQL(SQL_CREATE_COUNTRY);
    }
}
