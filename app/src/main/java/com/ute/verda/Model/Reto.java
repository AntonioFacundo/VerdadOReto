package com.ute.verda.Model;

/**
 * Created by Antonio Facundo on 09/11/2017.
 */

public class Reto {

    public static String frase;

    public static String darReto(int random){
        switch (random){
            case 1:
                frase = "Reto 1";
                break;
            case 2:
                frase = "Reto 2";
                break;
            case 3:
                frase = "Reto 3";
                break;
            case 4:
                frase = "Reto 4";
                break;
        }//cierra el switch
        return frase;
    }
}
