package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class MainActivity extends Activity {
    Spinner spinnerContinent;
    String continent = "all";
    public static final String URL = "https://restcountries.eu/rest/v2/";
    public static final String COUNTRIES = "br.usjt.desmob.geodata.countries";
    Country[] countries;
    Intent intent;
    ProgressBar timer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinent = (Spinner) findViewById(R.id.spinnerContinent);
        spinnerContinent.setOnItemSelectedListener(new SelectedRegion());
        timer = (ProgressBar)findViewById(R.id.timer);
        timer.setVisibility(View.INVISIBLE);
        context = this;
    }

    public void listCountries(View view) {
        intent = new Intent(this, ListCountryActivity.class);
        if(GeoDataNetwork.isConnected(this)) {
            timer.setVisibility(View.VISIBLE);
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                countries = GeoDataNetwork.searchCountries(URL, continent);
                                CountriesDb db = new CountriesDb(context);
                                db.insertCountries(countries);
                                runOnUiThread(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      intent.putExtra(COUNTRIES, countries);
                                                      startActivity(intent);
                                                      timer.setVisibility(View.INVISIBLE);
                                                  }
                                              }
                                );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
        } else {
            Toast.makeText(this, getApplicationContext().getResources().
                            getString(R.string.msg_network),
                    Toast.LENGTH_SHORT).show();
            new LoadCountriesFromDB().execute("country");
        }
    }

    private class SelectedRegion implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continent = (String) parent.getItemAtPosition(position);
            String[] continents = getApplicationContext().getResources().
                    getStringArray(R.array.continents);
            if (continent.equals(continents[0])) {
                continent = "all";
            } else {
                continent = "region/"+continent.toLowerCase();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class LoadCountriesFromDB extends AsyncTask<String, Void, Country[]>{

        @Override
        protected Country[] doInBackground(String... params) {
            CountriesDb db = new CountriesDb(context);
            Country[] countries = db.selectCountries();
            return countries;
        }

        public void onPostExecute(Country[] countries){
            intent.putExtra(COUNTRIES, countries);
            startActivity(intent);
        }
    }
}
