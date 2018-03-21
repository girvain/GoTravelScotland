package com.example.gavinross.gotravelscotland;

import android.util.Log;

import java.util.Locale;

/**
 * Created by gavin on 21/03/18.
 *
 * This class must have the variables set after initialized otherwise it won't work.
 */

public class AudioLangSelector {

    private int englishAudio;
    private int frenchAudio;
    private int germanAudio;
    private int spanishAudio;
    private int italianAudio;

    /*
    Method to get the right language audio file to go with the current language
    being used. Uses a variable current lang to get the code of the current language
    then uses a switch to check for a match.
    NOTE: returns -1 if language not recognised.
     */
    public int getCurrentLangAudio() {
        String currentLang = Locale.getDefault().getLanguage();
        int currentLangRes = -1;
        switch(currentLang) {
            case "en" : currentLangRes = englishAudio;
            break;
            case "ge" : currentLangRes = germanAudio;
            break;
            case "fr" : currentLangRes = frenchAudio;
            break;
            case "it" : currentLangRes = italianAudio;
            break;
            case "es" : currentLangRes = spanishAudio;
            break;
        }

        return currentLangRes;
    }

    public int getEnglishAudio() {
        return englishAudio;
    }

    public void setEnglishAudio(int englishAudio) {
        this.englishAudio = englishAudio;
    }

    public int getFrenchAudio() {
        return frenchAudio;
    }

    public void setFrenchAudio(int frenchAudio) {
        this.frenchAudio = frenchAudio;
    }

    public int getGermanAudio() {
        return germanAudio;
    }

    public void setGermanAudio(int germanAudio) {
        this.germanAudio = germanAudio;
    }

    public int getSpanishAudio() {
        return spanishAudio;
    }

    public void setSpanishAudio(int spanishAudio) {
        this.spanishAudio = spanishAudio;
    }

    public int getItalianAudio() {
        return italianAudio;
    }

    public void setItalianAudio(int italianAudio) {
        this.italianAudio = italianAudio;
    }
}
