package com.example.robomarciano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class activity_calc extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        String[] tipo = Spinner();
        Button retorno = findViewById(R.id.retorno);
        Button calcular = findViewById(R.id.calcular);
        retorno.setOnClickListener(v -> {
            retornaView(v);
        });

        calcular.setOnClickListener(v -> {
            TextView text = findViewById(R.id.resultcalc);
            EditText num1String = findViewById(R.id.number1);
            EditText num2String = findViewById(R.id.number2);
            if(TextUtils.isEmpty(num1String.getText().toString()) || TextUtils.isEmpty(num2String.getText().toString())){
                text.setText(R.string.msg_error);
            } else {
                float num1 = Float.parseFloat(num1String.getText().toString());
                float num2 = Float.parseFloat(num2String.getText().toString());
                roboMat roboMat = new roboMat();
                float resultado = roboMat.responda(tipo[0], num1, num2);
                Log.d(String.valueOf(resultado), "onCreate: ");
                text.setText("Essa eu sei. O resultado é ".concat(String.valueOf(resultado)));
            }
        });

    }

    public void retornaView(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public String[] Spinner(){
        final String[] value = new String[1];
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("SOMAR");
        spinnerArray.add("SUBTRAIR");
        spinnerArray.add("MULTIPLICAR");
        spinnerArray.add("DIVIDIR");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        Spinner sItems = findViewById(R.id.spiner1);
        sItems.setAdapter(adapter);
        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nome = sItems.getSelectedItem().toString();
                switch(nome)
                {
                    case "SOMAR" : value[0] ="some";break;
                    case "SUBTRAIR"   : value[0] ="subtrai";break;
                    case "MULTIPLICAR" : value[0] ="multiplique";break;
                    case "DIVIDIR" : value[0] ="divide";break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return value;
    }
}