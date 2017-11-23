package com.ute.verda.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ute.verda.Adapter.MiAdaptador;
import com.ute.verda.DBHelper.DBHelper;
import com.ute.verda.Model.Frase;
import com.ute.verda.Model.Rellenar;
import com.ute.verda.R;
import com.ute.verda.Utilities.Utility;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity{

    public MiAdaptador adaptador;
    ListView lista;

    private DBHelper conn;
    private SQLiteDatabase db;
    private Cursor cursor;

    private ArrayList<Frase> listaFrases;
    private Frase frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = (ListView) findViewById(R.id.listLista);

    }

    @Override
    protected void onResume() {
        super.onResume();
        conn = new DBHelper(this, Utility.getNombreDb(), null, 1);
        consultarDatos();
        adaptador = new MiAdaptador(this, listaFrases);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),
                        ""+listaFrases.get(position).getFrase(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void consultarDatos() {

        try{
            db = conn.getReadableDatabase();
            cursor = db.rawQuery(Utility.getReadDb(),null);

            listaFrases = new ArrayList<>();
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                frase = new Frase(cursor.getInt(0), cursor.getString(1));
                listaFrases.add(frase);

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

                listaFrases.add(f);
        }
    }
}
