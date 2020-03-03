package br.com.totustuus.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.totustuus.aluraviagens.model.Pacote;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

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
    public static Drawable devolveDrawable(String imagem, Context context) {
        Resources resources = context.getResources();
        int drawableID = resources.getIdentifier(imagem, DRAWABLE, context.getPackageName());
        return resources.getDrawable(drawableID);
    }
}
