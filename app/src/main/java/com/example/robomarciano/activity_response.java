package com.example.robomarciano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class activity_response extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        List<String> lista = null;
        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String pergunta = params.getString("pergunta");
                lista = params.getStringArrayList("array");
                TextView resposta = findViewById(R.id.resposta);
                resposta.setText(pergunta);
            }
        }
        Button retorno = findViewById(R.id.retorno);
        List<String> finalLista = lista;
        retorno.setOnClickListener(v -> {
            retornaView(v, finalLista);
        });
    }

    public void retornaView(View view, List<String> lista){
        Bundle params = new Bundle();
        params.putStringArrayList("array", (ArrayList<String>) lista);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }
}
