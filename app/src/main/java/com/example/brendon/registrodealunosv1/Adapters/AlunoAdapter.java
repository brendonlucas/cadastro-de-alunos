package com.example.brendon.registrodealunosv1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brendon.registrodealunosv1.Models.Aluno;
import com.example.brendon.registrodealunosv1.Models.Faculdade;
import com.example.brendon.registrodealunosv1.R;

import io.objectbox.Box;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder> {

    private Context context;
    private Box<Aluno> listAlunos;


    public AlunoAdapter(Context context, Box<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
        this.context = context;
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_aluno, viewGroup, false);
        return new AlunoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        Aluno alunoAtual = this.listAlunos.getAll().get(position);

        holder.txtNome.setText("Nome: " + alunoAtual.getNome());
        holder.txtCurso.setText("Curso: " + alunoAtual.getCurso());
        holder.txtFaculdade.setText("Faculdade " + alunoAtual.getFaculdade());
    }

    @Override
    public int getItemCount() {
        return this.listAlunos.getAll().size();
    }

    public class AlunoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtCurso, txtFaculdade;

        public AlunoViewHolder(View view) {
            super(view);
            txtNome = view.findViewById(R.id.view_nome_aluno);
            txtCurso = view.findViewById(R.id.view_curso);
            txtFaculdade = view.findViewById(R.id.view_faculdade);
        }
    }
}




