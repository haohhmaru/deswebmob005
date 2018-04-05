package br.usjt.desmob.geodata;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.Collator;

/*
    Haohhmaru (c) 03/31/2018
    Alessandro Lima da silva
    RA: 201522705
    Turma: CCP3AN-MCA2
 */

public class Country implements Serializable, Comparable {
    private String name;
    private String code3;
    private String capital;
    private String region;
    private String subRegion;
    private String demonym;
    private int population;
    private int area;
    private String flag;
    private double gini;
    private ArrayList<String> languages;
    private ArrayList<String> currency;
    private ArrayList<String> domains;
    private ArrayList<String> timeZone;
    private ArrayList<String> borders;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public ArrayList<String> getCurrency() {
        return currency;
    }

    public void setCurrency(ArrayList<String> currency) {
        this.currency = currency;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }

    public ArrayList<String> getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ArrayList<String> timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public void setBorders(ArrayList<String> borders) {
        this.borders = borders;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Country{" +
                "\nname='" + name + '\'' +
                "\ncode3='" + code3 + '\'' +
                "\ncapital='" + capital + '\'' +
                "\nregion='" + region + '\'' +
                "\nsubRegion='" + subRegion + '\'' +
                "\ndemonym='" + demonym + '\'' +
                "\npopulation=" + population +
                "\narea=" + area +
                "\nflag='" + flag + '\'' +
                "\ngini=" + gini +
                "\nlanguages=" + languages +
                "\ncurrency=" + currency +
                "\ndomains=" + domains +
                "\ntimeZone=" + timeZone +
                "\nborders=" + borders +
                "\nlatitude=" + latitude +
                "\nlongitude=" + longitude +
                "\n}";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return 0;
        } else {
            Country country = (Country) o;
            Collator c = Collator.getInstance();
            c.setStrength(Collator.PRIMARY);
            return c.compare(this.name, country.getName());
        }
    }
}
