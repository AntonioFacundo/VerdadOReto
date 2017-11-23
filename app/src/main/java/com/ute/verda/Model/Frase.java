package com.ute.verda.Model;

/**
 * Created by lab2 on 12/10/2017.
 */

public class Frase {
    private int id;
    private String frase;

    public Frase(int id, String frase) {
        this.id = id;
        this.frase = frase;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }


}
