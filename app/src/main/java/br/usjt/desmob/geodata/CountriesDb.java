package br.usjt.desmob.geodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class CountriesDb {
    CountriesDbHelper dbHelper;

    public CountriesDb(Context context){
        dbHelper = new CountriesDbHelper(context);
    }

    public void insertCountries(Country[] countries){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(CountriesContract.CountryEntry.TABLE_NAME, null, null);

        for(Country country:countries){
            ContentValues values = new ContentValues();
            values.put(CountriesContract.CountryEntry.COLUMN_NAME_NAME, country.getName());
            values.put(CountriesContract.CountryEntry.COLUMN_NAME_REGION, country.getRegion());
            values.put(CountriesContract.CountryEntry.COLUMN_NAME_CAPITAL, country.getCapital());
            values.put(CountriesContract.CountryEntry.COLUMN_NAME_FLAG, country.getFlag());
            values.put(CountriesContract.CountryEntry.COLUMN_NAME_CODE3, country.getCode3());

            db.insert(CountriesContract.CountryEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    public Country[] selectCountries(){
        ArrayList<Country> countries = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = { CountriesContract.CountryEntry.COLUMN_NAME_NAME,
                CountriesContract.CountryEntry.COLUMN_NAME_REGION,
                CountriesContract.CountryEntry.COLUMN_NAME_CAPITAL,
                CountriesContract.CountryEntry.COLUMN_NAME_FLAG,
                CountriesContract.CountryEntry.COLUMN_NAME_CODE3};
        String ordem = CountriesContract.CountryEntry.COLUMN_NAME_NAME;

        Cursor c = db.query(CountriesContract.CountryEntry.TABLE_NAME, columns, null, null,
                ordem, null, null);
        while(c.moveToNext()) {
            Country country = new Country();
            country.setName(c.getString(c.getColumnIndex(CountriesContract.CountryEntry.COLUMN_NAME_NAME)));
            country.setRegion(c.getString(c.getColumnIndex(CountriesContract.CountryEntry.COLUMN_NAME_REGION)));
            country.setCapital(c.getString(c.getColumnIndex(CountriesContract.CountryEntry.COLUMN_NAME_CAPITAL)));
            country.setFlag(c.getString(c.getColumnIndex(CountriesContract.CountryEntry.COLUMN_NAME_FLAG)));
            country.setCode3(c.getString(c.getColumnIndex(CountriesContract.CountryEntry.COLUMN_NAME_CODE3)));

            countries.add(country);
        }
        c.close();
        db.close();
        if(countries.size()> 0) {
            return countries.toArray(new Country[0]);
        } else {
            return new Country[0];
        }
    }
}
