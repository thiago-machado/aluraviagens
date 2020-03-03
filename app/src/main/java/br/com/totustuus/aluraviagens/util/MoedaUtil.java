package br.com.totustuus.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PT = "pt";
    public static final String BR = "br";
    public static final String REAL_NAO_FORMATADO = "R$";
    public static final String REAL_FORMATADO = "R$ ";

    public static String formataParaReal(BigDecimal valor) {

        // transformando bigdecimal em moeda no formato brasileiro
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale(PT, BR));

        return formatoBrasileiro.format(valor).replace(REAL_NAO_FORMATADO, REAL_FORMATADO);
    }
}
