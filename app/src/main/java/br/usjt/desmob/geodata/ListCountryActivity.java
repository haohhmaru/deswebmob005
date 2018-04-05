package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/*
   Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class ListCountryActivity extends Activity {
    public static final String COUNTRY = "br.usjt.desmob.geodata.country";
    Activity activity;
    Country[] countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_countries_activity);
        activity = this;
        Intent intent = getIntent();

        countries = (Country[]) intent.getSerializableExtra(MainActivity.COUNTRIES);

        ListView listView = (ListView) findViewById(R.id.list_countries);
        CountryAdapter adapter = new CountryAdapter(countries, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(activity, DetailCountryActivity.class);
                intent.putExtra(COUNTRY, countries[position]);

                startActivity(intent);
            }

        });
    }
}
