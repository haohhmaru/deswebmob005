package br.usjt.desmob.geodata;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class SectionIndexBuilder {
    public static Object[] buildSectionHeaders(Country[] countries) {
        ArrayList<String> result = new ArrayList<>();
        TreeSet<String> useds = new TreeSet<>();
        for (Country country : countries) {
            String letter = country.getName().substring(0, 1);
            if ((!useds.contains(letter))) {
                result.add(letter);
            }
            useds.add(letter);
        }
        return result.toArray(new Object[0]);
    }
    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Country[] countries) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> useds = new TreeSet<>();

        int section = -1;

        for (int i = 0; i < countries.length; i++) {
            String letter = countries[i].getName().substring(0, 1);

            if (!useds.contains(letter)) {
                section++;
                useds.add(letter);
            }
            results.put(i, section);
        }
        return results;
    }
    public static Hashtable <Integer, Integer> buildPositionForSectionMap (Country[]countries){
        Hashtable <Integer, Integer> results = new Hashtable<>();
        TreeSet<String> useds = new TreeSet<>();

        int section = -1;

        for (int i = 0; i < countries.length; i++) {
            String letter = countries[i].getName().substring(0, 1);

            if (!useds.contains(letter)) {
                section++;
                useds.add(letter);
                results.put(section, i);
            }
        }
        return results;
    }
}
