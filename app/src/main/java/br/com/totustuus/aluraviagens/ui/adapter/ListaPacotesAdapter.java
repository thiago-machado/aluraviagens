package br.com.totustuus.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.model.Pacote;
import br.com.totustuus.aluraviagens.util.MoedaUtil;
import br.com.totustuus.aluraviagens.util.ResourcesUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    public static final String DIAS_PLURAL = " dias";
    public static final String DIA_SINGULAR = " dia";
    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context= context;
    }

    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return this.pacotes.get(position);
    }

    /*
    Não temos ID
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = getItem(position);

        configuraLocal(view, pacote);
        configuraDias(view, pacote);
        configuraPreco(view, pacote);
        configuraImagem(view, pacote);


        return view;
    }

    private void configuraImagem(View view, Pacote pacote) {

        ImageView imagem = view.findViewById(R.id.item_pacote_imagem);
        Drawable drawable = ResourcesUtil.devolveDrawable(pacote.getImagem(), context);
        imagem.setImageDrawable(drawable);
    }


    private void configuraPreco(View view, Pacote pacote) {

        TextView preco = view.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaReal(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void configuraDias(View view, Pacote pacote) {
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        dias.setText((pacote.getDias() > 1) ? (pacote.getDias() + DIAS_PLURAL) : (pacote.getDias() + DIA_SINGULAR));
    }

    private void configuraLocal(View view, Pacote pacote) {
        TextView local = view.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
