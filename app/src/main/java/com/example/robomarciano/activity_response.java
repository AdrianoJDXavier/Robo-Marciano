package com.example.robomarciano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_response extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String pergunta = params.getString("pergunta");

                TextView resposta = findViewById(R.id.resposta);
                Log.d(pergunta, "onCreate: ");
                resposta.setText(pergunta);
            }
        }
        Button retorno = findViewById(R.id.retorno);
        retorno.setOnClickListener(v -> {
            retornaView(v);
        });
    }

    public void retornaView(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
