package com.ute.verda.Model;

/**
 * Created by Antonio Facundo on 09/11/2017.
 */

public class Verdad {
    public static String frase;

    public static String darVerdad(int random){
        switch (random){
            case 1:
                frase = "Verdad 1";
                break;
            case 2:
                frase = "Verdad 2";
                break;
            case 3:
                frase = "Verdad 3";
                break;
            case 4:
                frase = "Verdad 4";
                break;
        }//cierra el switch
        return frase;
    }
}
