package com.salsabeelapp.duaquranandhadith.recyclerviewfiles;

/**
 * Created by zashiq on 21-Aug-16.
 */
public class GetandSet {

    String arabictext;
    String tamiltext;
    String reference;

    public GetandSet(String arabictext, String tamiltext, String reference) {
        this.arabictext = arabictext;
        this.tamiltext = tamiltext;
        this.reference = reference;
    }

    /*public GetandSet(String arabictext, String tamiltext, String reference) {
        this.setArabictext(arabictext);
        this.setTamiltext(tamiltext);
        this.setReference(reference);
    }*/

    public String getArabictext() {
        return arabictext;
    }

    public void setArabictext(String arabictext) {
        this.arabictext = arabictext;
    }

    public String getTamiltext() {
        return tamiltext;
    }

    public void setTamiltext(String tamiltext) {
        this.tamiltext = tamiltext;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
