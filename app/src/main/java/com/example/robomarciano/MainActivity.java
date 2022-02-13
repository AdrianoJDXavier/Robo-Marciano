package com.example.robomarciano;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> spinnerArray =  new ArrayList<String>();
        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                spinnerArray = params.getStringArrayList("array");
            }
        }
        //Verificando se array for vazio Spinner não é exibido ao usuario
        if(spinnerArray.isEmpty()) {
            Spinner disp = findViewById(R.id.spiner2);
            disp.setVisibility(View.INVISIBLE);
        }else{
            Spinner(spinnerArray);
        }

        Button add = findViewById(R.id.add);
        Button calc = findViewById(R.id.calc);
        List<String> finalSpinnerArray = spinnerArray;
        add.setOnClickListener(v -> {
            enviarDados(v, finalSpinnerArray);
        });

        calc.setOnClickListener(v -> {
            AcessarCalc(v, finalSpinnerArray);
        });
    }

    public void enviarDados(View view, List<String> spinnerArray){
        EditText disp = findViewById(R.id.pergunta);
        String resposta = disp.getText().toString();
        if(spinnerArray.contains(resposta)){
        }else spinnerArray.add(resposta);
        robo rb = new robo();
        String responda = rb.responda(resposta);
        Bundle params = new Bundle();
        params.putString("pergunta", responda);
        params.putStringArrayList("array", (ArrayList<String>) spinnerArray);

        Intent intent = new Intent(this, activity_response.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    public void AcessarCalc(View view, List<String> spinnerArray){
        Bundle params = new Bundle();
        params.putStringArrayList("array", (ArrayList<String>) spinnerArray);
        Intent intent = new Intent(this, activity_calc.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void Spinner(List<String> spinnerArray) {
        final String[] value = new String[1];
        EditText texto = findViewById(R.id.pergunta);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner sItems = findViewById(R.id.spiner2);
        sItems.setAdapter(adapter);
        sItems.setSelection(0,false);
        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nome = sItems.getSelectedItem().toString();
                texto.setText(nome);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}