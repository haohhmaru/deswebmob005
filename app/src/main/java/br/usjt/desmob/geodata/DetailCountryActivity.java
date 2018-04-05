package br.usjt.desmob.geodata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class DetailCountryActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_detail_activity);
        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra(ListCountryActivity.COUNTRY);

        ImageView flag = (ImageView)findViewById(R.id.img_country_flag);
        flag.setImageDrawable(Util.getDrawable(this, country.getCode3().toLowerCase()));

        TextView name = (TextView)findViewById(R.id.country_text_name);
        name.setText(country.getName());

        TextView capital = (TextView)findViewById(R.id.txt_capital);
        capital.setText(country.getCapital());

        TextView region = (TextView)findViewById(R.id.txt_region);
        region.setText(country.getRegion());

        TextView subregion = (TextView)findViewById(R.id.txt_subregion);
        subregion.setText(country.getSubRegion());

        TextView demonym = (TextView)findViewById(R.id.txt_demonym);
        demonym.setText(country.getDemonym());

        TextView area = (TextView)findViewById(R.id.txt_area);
        area.setText(String.format("%1$,d km\u00B2", country.getArea()));

        TextView population = (TextView)findViewById(R.id.txt_population);
        population.setText(String.format("%1$,d", country.getPopulation()));

        TextView gini = (TextView)findViewById(R.id.txt_gini);
        gini.setText(String.format("%.2f", country.getGini()));

        TextView latitude = (TextView)findViewById(R.id.txt_latitude);
        latitude.setText(String.format("%.2f", country.getLatitude()));

        TextView longitude = (TextView)findViewById(R.id.txt_longitude);
        longitude.setText(String.format("%.2f", country.getLongitude()));
    }
}
