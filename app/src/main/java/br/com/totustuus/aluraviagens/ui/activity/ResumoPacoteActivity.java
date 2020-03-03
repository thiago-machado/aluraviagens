package br.com.totustuus.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.model.Pacote;
import br.com.totustuus.aluraviagens.util.MoedaUtil;
import br.com.totustuus.aluraviagens.util.ResourcesUtil;

import static br.com.totustuus.aluraviagens.ui.adapter.ListaPacotesAdapter.DIAS_PLURAL;
import static br.com.totustuus.aluraviagens.ui.adapter.ListaPacotesAdapter.DIA_SINGULAR;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(pacoteSaoPaulo.getImagem(), this);
        imagem.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText((pacoteSaoPaulo.getDias() > 1) ? (pacoteSaoPaulo.getDias() + DIAS_PLURAL) : (pacoteSaoPaulo.getDias() + DIA_SINGULAR));

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaReal(pacoteSaoPaulo.getPreco());

        preco.setText(moedaBrasileira);

    }
}
