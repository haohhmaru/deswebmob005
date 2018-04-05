package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import static br.usjt.desmob.geodata.R.drawable.flag;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class CountryAdapter extends BaseAdapter implements SectionIndexer {
    private Country[] countries;
    private Activity activity;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public CountryAdapter(Country[] countries, Activity activity) {
        this.countries = countries;
        this.activity = activity;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(countries);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(countries);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(countries);
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.country_line, parent, false);
            ImageView flag = (ImageView) view.findViewById(R.id.country_picture);
            TextView name = (TextView) view.findViewById(R.id.country_text_name);
            TextView detail = (TextView) view.findViewById(R.id.country_text_detail);
            ViewHolder viewHolder = new ViewHolder(flag, name, detail);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getName().setText(countries[position].getName());
        viewHolder.getDetail().setText(String.format(
                activity.getResources().getString(R.string.lbl_region)+
                        " %s - "+
                        activity.getResources().getString(R.string.lbl_capital)+
                        " %s",
                countries[position].getRegion(),
                countries[position].getCapital()));
        Drawable drawable = Util.getDrawable(activity, countries[position].getCode3().toLowerCase());
        if(drawable == null){
            drawable = activity.getDrawable(flag);
        }
        viewHolder.getFlag().setImageDrawable(drawable);

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
