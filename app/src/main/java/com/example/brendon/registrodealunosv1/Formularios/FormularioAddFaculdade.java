package com.example.brendon.registrodealunosv1.Formularios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brendon.registrodealunosv1.Adapters.FaculdadeAdapter;
import com.example.brendon.registrodealunosv1.Models.Faculdade;
import com.example.brendon.registrodealunosv1.R;
import com.example.brendon.registrodealunosv1.dal.App;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class FormularioAddFaculdade extends AppCompatActivity {
    EditText nome_faculdade, email, contato;
    Box<Faculdade> boxFaculdades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_add_faculdade);

        boxFaculdades = ((App)getApplication()).getBoxStore().boxFor(Faculdade.class);

        nome_faculdade = findViewById(R.id.edt_nome_faculdade);
        email = findViewById(R.id.edt_email);
        contato = findViewById(R.id.edt_contato);
    }

    public void confirmar_nova_faculdade(View view) {
        String nome_da_faculdade = nome_faculdade.getText().toString();
        String email_faculdade = email.getText().toString();
        String contato_faculdade = contato.getText().toString();


        if (nome_da_faculdade.equals("") || email_faculdade.equals("")){
            Toast.makeText(this, "Dados insuficientes", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent();
            boxFaculdades.put(new Faculdade(nome_da_faculdade,email_faculdade,contato_faculdade));
            Toast.makeText(this, "Nova Faculdade adicionada", Toast.LENGTH_LONG).show();
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
