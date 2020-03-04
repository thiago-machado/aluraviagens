package br.com.totustuus.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.model.Pacote;
import br.com.totustuus.aluraviagens.util.DataUtil;
import br.com.totustuus.aluraviagens.util.MoedaUtil;
import br.com.totustuus.aluraviagens.util.ResourcesUtil;

import static br.com.totustuus.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.totustuus.aluraviagens.ui.adapter.ListaPacotesAdapter.DIAS_PLURAL;
import static br.com.totustuus.aluraviagens.ui.adapter.ListaPacotesAdapter.DIA_SINGULAR;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {

        if(getIntent().hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button realizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);

        realizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPagamentoActivity(pacote);
            }
        });
    }

    private void chamaPagamentoActivity(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {

        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaReal(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText((pacote.getDias() > 1) ? (pacote.getDias() + DIAS_PLURAL) : (pacote.getDias() + DIA_SINGULAR));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(pacote.getImagem(), this);
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
