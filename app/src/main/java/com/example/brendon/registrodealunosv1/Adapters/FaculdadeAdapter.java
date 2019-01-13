package com.example.brendon.registrodealunosv1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brendon.registrodealunosv1.Models.Faculdade;
import com.example.brendon.registrodealunosv1.R;

import java.util.List;

import io.objectbox.Box;

public class FaculdadeAdapter extends RecyclerView.Adapter<FaculdadeAdapter.FaculdadeViewHolder> {

    private Context context;
    private Box<Faculdade> listFaculdades;

    public FaculdadeAdapter(Context context, Box<Faculdade> listFaculdades) {
        this.listFaculdades = listFaculdades;
        this.context = context;
    }

    @NonNull
    @Override
    public FaculdadeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_faculdade, viewGroup, false);
        return new FaculdadeViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FaculdadeViewHolder holder, int position) {
        Faculdade faculdadeAtual = this.listFaculdades.getAll().get(position);

        holder.txtNome.setText("Nome: " + faculdadeAtual.getNome());
        holder.txtEmail.setText("Email: " + faculdadeAtual.getEmail());
        holder.txtContato.setText("Contato " + faculdadeAtual.getContatoPrincipal());
    }

    @Override
    public int getItemCount() {
        return this.listFaculdades.getAll().size();
    }

    public class FaculdadeViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtEmail, txtContato;

        public FaculdadeViewHolder(View view) {
            super(view);
            txtNome = view.findViewById(R.id.view_nome_faculdade);
            txtEmail = view.findViewById(R.id.view_email);
            txtContato = view.findViewById(R.id.view_contato);
        }
}
}
