package com.ute.verda.Model;

import com.ute.verda.R;

import java.util.ArrayList;

/**
 * Created by lab2 on 13/10/2017.
 */

public class Rellenar {
    private static ArrayList<Frase> lista;

    public static ArrayList<Frase> darLista(){
        lista = new ArrayList<>();
        lista.add(new Frase(1,"Verdad 1"));
        lista.add(new Frase(1,"Verdad 2"));
        lista.add(new Frase(1,"Verdad 3"));
        lista.add(new Frase(1,"Verdad 4"));
        lista.add(new Frase(2,"Reto 1"));
        lista.add(new Frase(2,"Reto 2"));
        lista.add(new Frase(2,"Reto 3"));
        lista.add(new Frase(2,"Reto 4"));

        lista.add(new Frase(1, "Salvado"));
        lista.add(new Frase(2, "Salvado"));
        return lista;
    }

}
