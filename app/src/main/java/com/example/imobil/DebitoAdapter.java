package com.example.imobil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DebitoAdapter extends ArrayAdapter<Debito> {

    public DebitoAdapter(Context context, List<Debito> debitos) {
        super(context, 0, debitos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Debito Debito = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_debitos, parent, false);
        }

        TextView titulo = convertView.findViewById(R.id.TituloDebito);
        TextView descricao = convertView.findViewById(R.id.DescricaoDebitos);
        TextView valor = convertView.findViewById(R.id.valorDebitos);

        titulo.setText(Debito.getTitulo());
        descricao.setText(Debito.getDescricao());
        valor.setText(String.valueOf(Debito.getValor()));

        return convertView;
    }

}
