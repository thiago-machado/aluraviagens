package br.com.totustuus.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.model.Pacote;
import br.com.totustuus.aluraviagens.util.MoedaUtil;

import static br.com.totustuus.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {

        if(getIntent().hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote.getPreco());
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {

        Button finalizarCompra = findViewById(R.id.pagamento_botao_finalizar_compra);

        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaResumoCompra(pacote);
            }
        });
    }

    private void chamaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(BigDecimal valor) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaReal(valor);
        preco.setText(moedaBrasileira);
    }
}
