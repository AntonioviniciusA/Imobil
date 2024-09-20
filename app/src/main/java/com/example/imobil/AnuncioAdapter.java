package com.example.imobil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.imobil.Activity.MainActivity;

import java.util.List;

public class AnuncioAdapter extends ArrayAdapter<Anuncio> {
    public AnuncioAdapter(MainActivity context, List<Anuncio> anuncios) {
        super(context, 0, anuncios);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Verifica se a visão reciclada está disponível, caso contrário infla uma nova visão
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_anuncio, parent, false);
        }

        // Obtém a instância do objeto Anuncio para a posição atual
        Anuncio anuncio = getItem(position);

        // Referencia as views e define os dados
        TextView titulo = convertView.findViewById(R.id.TituloAnuncio);
        TextView descricao = convertView.findViewById(R.id.DescricaoDebitos);
        TextView valor = convertView.findViewById(R.id.valorAnuncio);

        titulo.setText(anuncio.getTituloImo());
        descricao.setText(anuncio.getEndereco());
        valor.setText(anuncio.getValor());

        return convertView;
    }
}

