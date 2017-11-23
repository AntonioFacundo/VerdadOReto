package com.ute.verda.Utilities;

/**
 * Created by lab2 on 12/10/2017.
 */

public class Utility {

    private static String TABLE = "frases";
    private static String CAMPO_ID = "id";
    private static String CAMPO_FRASES = "frase";
    private static String NOMBRE_DB = "db_frases";



    private static String CREATE_DB = "CREATE TABLE "+ TABLE +"( "+ CAMPO_ID + " INTEGER, "+ CAMPO_FRASES+" TEXT)";
    private static String UPDATE_DB = "DROP TABLE ID EXIST "+TABLE;


    private static String READ_DB = "SELECT * FROM "+ TABLE;

    public static String getTABLE() {
        return TABLE;
    }

    public static String getCampoId() {
        return CAMPO_ID;
    }

    public static String getCampoFrases() {
        return CAMPO_FRASES;
    }

    public static String getCreateDb() {
        return CREATE_DB;
    }

    public static String getUpdateDb() {
        return UPDATE_DB;
    }

    public static String getNombreDb() {
        return NOMBRE_DB;
    }
    public static String getReadDb() {
        return READ_DB;
    }
}
