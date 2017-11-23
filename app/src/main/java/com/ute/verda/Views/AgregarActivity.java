package com.ute.verda.Views;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ute.verda.DBHelper.DBHelper;
import com.ute.verda.Model.Frase;
import com.ute.verda.R;
import com.ute.verda.Utilities.Utility;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editAgregar;
    private Button btnAgregar;
    RadioButton rdVerdad, rdReto;
    SQLiteDatabase db;
    Frase frase;
    DBHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        editAgregar = (EditText) findViewById(R.id.edtAgregar);
        btnAgregar = (Button) findViewById(R.id.btnAgregarFrase);
        rdVerdad = (RadioButton) findViewById(R.id.rdVerdad);
        rdReto = (RadioButton) findViewById(R.id.rdReto);

        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregarFrase:
                agregarFrase();
                break;
        }
    }

    private void agregarFrase() {

        int id;
        if(rdVerdad.isChecked()){
            id = 1;
        }else{
            id = 2;
        }

        frase = new Frase(id,editAgregar.getText().toString());

        try{
            conn = new DBHelper(this, Utility.getNombreDb(), null, 1);

            db = conn.getWritableDatabase();

            String insert = "INSERT INTO "+ Utility.getTABLE()+" ("+Utility.getCampoId()+", "+Utility.getCampoFrases()+")" +
                    "VALUES ("+frase.getId()+", '"+
                    frase.getFrase()+"')";
            db.execSQL(insert);

            Toast.makeText(getApplicationContext(), "La frase fue registrado exitosamente.", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El error fue: "+ e, Toast.LENGTH_LONG).show();
        }finally {
            conn.close();
            db.close();
        }
    }
}
