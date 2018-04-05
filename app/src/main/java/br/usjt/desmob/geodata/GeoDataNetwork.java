package br.usjt.desmob.geodata;

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class GeoDataNetwork {

    public static Country[] searchCountries(String url, String region) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ArrayList<Country> countries = new ArrayList<>();

        Request request = new Request.Builder()
                .url(url+region)
                .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();

        try {
            JSONArray vector = new JSONArray(result);
            for(int i = 0; i < vector.length(); i++){
                JSONObject item = (JSONObject) vector.get(i);
                Country country = new Country();
                try {
                    country.setArea(item.getInt("area"));
                } catch (Exception e){
                    country.setArea(0);
                }
                country.setFlag(item.getString("flag"));
                country.setCapital(item.getString("capital"));
                country.setName(item.getString("name"));
                country.setRegion(item.getString("region"));
                country.setCode3(item.getString("alpha3Code"));
                try {
                    country.setGini(item.getDouble("gini"));
                } catch (Exception e) {
                    country.setGini(0.0);
                }
                try {
                    country.setPopulation(item.getInt("population"));
                } catch (Exception e) {
                    country.setPopulation(0);
                }
                country.setDemonym(item.getString("demonym"));
                country.setSubRegion(item.getString("subregion"));

                JSONArray latlng = item.getJSONArray("latlng");

                try {
                    country.setLatitude(latlng.getDouble(0));
                } catch (Exception e) {
                    country.setLatitude(0);
                }
                try {
                    country.setLongitude(latlng.getDouble(1));
                } catch (Exception e) {
                    country.setLongitude(0);
                }
                countries.add(country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return countries.toArray(new Country[0]);
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
