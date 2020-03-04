package br.com.totustuus.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        mostraPreco();

        startActivity(new Intent(this, ResumoCompraActivity.class));
    }

    private void mostraPreco() {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil
                .formataParaReal(new BigDecimal("123.99"));
        preco.setText(moedaBrasileira);
    }
}
