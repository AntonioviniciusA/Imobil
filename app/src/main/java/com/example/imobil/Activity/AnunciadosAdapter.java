package com.example.imobil.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.imobil.Anuncio;
import com.example.imobil.R;

import java.util.List;

public class AnunciadosAdapter  extends ArrayAdapter<Anunciados> {
    public AnunciadosAdapter(MainActivityImobiliaria mainActivityImobiliaria, List<Anunciados> anunciados) {
        super(context, 0, anunciados);
    }
    @Override
    public View getView(int position, View converterView, ViewGroup parent) {
        if (converterView == null) {
            converterView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_anunciados, parent, false);
        }
        Anunciados anunciados = getItem(position);

        TextView titulo = converterView.findViewById(R.id.TituloAnunciados);
        TextView descricao = converterView.findViewById(R.id.descricaoAnunciados);
        TextView valor = converterView.findViewById(R.id.valorAnunciados);

        titulo.setText(anunciados.getTitulo());
        descricao.setText(anunciados.getEndereco());
        valor.setText(anunciados);


        return converterView;
    }
}
