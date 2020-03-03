package br.com.totustuus.aluraviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.totustuus.aluraviagens.R;
import br.com.totustuus.aluraviagens.dao.PacoteDAO;
import br.com.totustuus.aluraviagens.model.Pacote;
import br.com.totustuus.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle("Pacotes");
        
        /*
        Há uma certa diferença em relação ao que víamos nos cursos anteriores de Android:
        neste tipo de atribuição, ocorria um erro de compilação pois se devolvia apenas
        a View, e tínhamos que fazer um Cast indicando que se tratava de uma classe
        específica - neste caso um ListView.

        A partir da versão 26 da API do Android, isto deixou de ser necessário, pois o
        processo é feito automaticamente usando-se um conceito chamado Generics.
         */
        ListView listView = findViewById(R.id.activity_list_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();
        listView.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
