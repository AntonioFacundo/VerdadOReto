package com.ute.verda.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ute.verda.Model.Frase;
import com.ute.verda.R;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Antonio Facundo on 18/10/2017.
 */

public class MiAdaptador extends BaseAdapter {

    private final Context activity;
    private final ArrayList<Frase> lista;

    public MiAdaptador(Context activity, ArrayList<Frase> lista) {
        super();
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view, null, true);

        ImageView image = (ImageView) convertView.findViewById(R.id.icono);
        image.setImageResource(R.mipmap.ic_launcher);

        TextView titulo = (TextView) convertView.findViewById(R.id.txtTituloLista);
        if(lista.get(position).getId() == 1) {
            titulo.setText(R.string.verdad);
        }else{
            titulo.setText(R.string.reto);
        }

        TextView fraseLista = (TextView) convertView.findViewById(R.id.txtFraseLista);
        fraseLista.setText(lista.get(position).getFrase());

        return convertView;
    }

}
