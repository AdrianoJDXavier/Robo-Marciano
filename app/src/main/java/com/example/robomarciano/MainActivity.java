package com.example.robomarciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public static final int CONSTANTE_TELA_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.add);
        Button calc = findViewById(R.id.calc);
        add.setOnClickListener(v -> {
            enviarDados(v);
        });

        calc.setOnClickListener(v -> {
            AcessarCalc(v);
        });


    }

    public void enviarDados(View view){
        EditText disp = findViewById(R.id.pergunta);
        String resposta = disp.getText().toString();
        robo rb = new robo();
        String responda = rb.responda(resposta);
        Bundle params = new Bundle();
        params.putString("pergunta", responda);

        Intent intent = new Intent(this, activity_response.class);
        intent.putExtras(params);
        startActivityForResult(intent, CONSTANTE_TELA_1);
    }

    public void AcessarCalc(View view){
        Intent intent = new Intent(this, activity_calc.class);
        startActivityForResult(intent, CONSTANTE_TELA_1);
    }
    
}