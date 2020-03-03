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
import java.util.List;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

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

        TextView local = view.findViewById(R.id.item_pacote_local);
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        TextView preco = view.findViewById(R.id.item_pacote_preco);
        ImageView imagem = view.findViewById(R.id.item_pacote_imagem);


        local.setText(pacote.getLocal());
        dias.setText(pacote.getDias() + " dias");
        preco.setText(" R$ " + pacote.getPreco().setScale(2, RoundingMode.CEILING).toString());


          /*
        Se utilizarmos getImagem() da nossa classe Pacote, teremos uma string, e não um drawable ou bitmap
        a ser acrescentado, isto é, um valor acessível via ImageView.

        Sendo assim, é preciso tornar possível transformar esta string em um drawable, por exemplo.
        Para isto, poderemos utilizar o próprio context do Android, que já está acessível como atributo da classe.

        Para utilizá-lo, pediremos recursos a partir dele, com getResources(), e com isto pegaremos
        suas variáveis.
        Assim, seremos capazes de pegar algum recurso a partir de uma string de algum valor, por exemplo.
        Chamaremos o resources novamente e pegaremos um identificador com getIdentifier(),
        a partir de um valor existente, que no caso é uma string.

        Ele nos pede alguns parâmetros:
        1) o nome do recurso que queremos;
        2) seu tipo;
        3) e o pacote em que ele se encontra.

        O que vamos preencher:
        1) O nome esperado para este recurso é justamente aquele localizado no nosso pacote;
        2) a string será "drawable";
        3) e o pacote raiz poderá ser enviado manualmente. No entanto, uma técnica mais
        sucinta envolve o acesso ao pacote por meio do contexto.

        Tendo-se o identificador, poderemos fazer a atribuição a uma variável e
        assim será devolvido o id com valor inteiro, por ele se referir ao drawable esperado.

        Com o ID em mãos, basta usar resources para buscar o drawable pelo ID. Teremos como retorno um Drawable.
        Com o Drawable em mãos, agora é colocar na ImageView com .setImageDrawable(drawable).
         */
        Resources resources = context.getResources();
        int drawableID = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(drawableID);
        imagem.setImageDrawable(drawable);



        return view;
    }
}
