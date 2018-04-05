package br.usjt.desmob.geodata;

import android.provider.BaseColumns;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class CountriesContract {

    public static abstract class CountryEntry implements BaseColumns{
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_REGION = "region";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_FLAG = "flag";
        public static final String COLUMN_NAME_CODE3 = "code3";


    }
}
