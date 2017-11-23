package com.ute.verda.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ute.verda.DBHelper.DBHelper;
import com.ute.verda.Model.Frase;
import com.ute.verda.Model.Rellenar;
import com.ute.verda.R;
import com.ute.verda.Utilities.Utility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtTitulo, txtFrases;


    private DBHelper conn;
    private SQLiteDatabase db;
    private Cursor cursor;

    private ArrayList<Frase> listaVerdad;
    private ArrayList<Frase> listaReto;
    private Frase frase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular las variables locales con las vistas
        txtTitulo = (TextView) findViewById(R.id.txtVerdadOReto);
        txtFrases = (TextView) findViewById(R.id.txtFrases);

        Button btnLista = (Button) findViewById(R.id.btnLista);
        Button btnAgregar = (Button) findViewById(R.id.btnAgregar);
        Button btnVerdad = (Button) findViewById(R.id.btnVerdad);
        Button btnReto = (Button) findViewById(R.id.btnReto);

        btnLista.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
        btnVerdad.setOnClickListener(this);
        btnReto.setOnClickListener(this);

    }



    @Override
    protected void onResume() {
        super.onResume();
        conn = new DBHelper(this, Utility.getNombreDb(), null, 1);
        consultarDatos();
    }

    private void consultarDatos() {

        try{
            db = conn.getReadableDatabase();
            cursor = db.rawQuery(Utility.getReadDb(),null);

            listaVerdad = new ArrayList<>();
            listaReto = new ArrayList<>();
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                frase = new Frase(cursor.getInt(0), cursor.getString(1));
                if(frase.getId() == 1){
                    listaVerdad.add(frase);
                }else{
                    listaReto.add(frase);
                }
            }



        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error: "+ex, Toast.LENGTH_LONG).show();
        }finally {

            if(conn != null){
                conn.close();
            }

            if(cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
        }

        for(Frase f: Rellenar.darLista()){
            if(f.getId() == 1){
                listaVerdad.add(f);
            }else{
                listaReto.add(f);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLista:
                navToLista();
                break;
            case R.id.btnAgregar:
                navToAgregar();
                break;
            case R.id.btnVerdad:
                ponerVerdad();
                break;
            case R.id.btnReto:
                ponerReto();
                break;
        }
    }

    private void navToLista() {
        startActivity(new Intent(getApplicationContext(), ListActivity.class));
    }
    private void navToAgregar() {
        startActivity(new Intent(getApplicationContext(), AgregarActivity.class));
    }
    private void ponerVerdad() {
        int random = (int) (Math.random() * (listaVerdad.size()));
        txtFrases.setText(listaVerdad.get(random).getFrase());
    }
    private void ponerReto() {
        int random = (int) (Math.random() * (listaReto.size()));
        txtFrases.setText(listaReto.get(random).getFrase());
    }
}
