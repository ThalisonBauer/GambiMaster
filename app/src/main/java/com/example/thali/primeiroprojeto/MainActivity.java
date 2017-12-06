package com.example.thali.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado;
    EditText edtValue;
    Spinner spinner;
    Spinner spinner2;
    Button btnResultado;

    //Conversao de Moedas
    EditText edtValue2;
    Spinner spinner3;
    Spinner spinner4;
    TextView txtResultado2;
    Button btnResultado2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        btnResultado = findViewById(R.id.btnResultado);
        edtValue = findViewById(R.id.edtValue);
        txtResultado = findViewById(R.id.txtResultado);
        //Conversão de Moedas
            edtValue2 = findViewById(R.id.edtValue2);
            spinner3 = findViewById(R.id.spinner3);
            spinner4 = findViewById(R.id.spinner4);
            txtResultado2 = findViewById(R.id.txtResultado2);
            btnResultado2 = findViewById(R.id.btnResultado2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);
        spinner.setAdapter(adapter);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.moedas_array,android.R.layout.simple_spinner_item);
            spinner3.setAdapter(adapter1);
            spinner4.setAdapter(adapter1);

                btnResultado.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String entrada = spinner.getSelectedItem().toString();
                        String saida = spinner2.getSelectedItem().toString();
                        double resultado = 0 ,numero;
                        numero  = Double.parseDouble(edtValue.getText().toString());
                        switch (entrada){
                            case "Milhas":
                                switch (saida){
                                    case "Milhas":
                                        txtResultado.setText(""+numero);break;
                                    case "Km":
                                        resultado = numero * 1.60934;
                                        txtResultado.setText(""+resultado);break;
                                    case "Pes":
                                        resultado = numero * 5280;
                                        txtResultado.setText(""+resultado);break;

                                }break;
                            case "Km":
                                switch (saida){
                                    case "Milhas":
                                        resultado = numero * 0.621371;
                                        txtResultado.setText(""+numero);break;
                                    case "Km":
                                        txtResultado.setText(""+numero);break;
                                    case "Pes":
                                        resultado = numero * 3280.84;
                                        txtResultado.setText(""+resultado);break;

                                }break;
                            case "Pes":
                                switch (saida){
                                    case "Milhas":
                                        resultado = numero * 0.000189394;
                                        txtResultado.setText(""+numero);break;
                                    case "Km":
                                        resultado = numero * 0.0003048;
                                        txtResultado.setText(""+numero);break;
                                    case "Pes":
                                        txtResultado.setText(""+numero);break;

                                }break;
                        }
                    }
                });
            btnResultado2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        String entrada = spinner3.getSelectedItem().toString();
                        String saida = spinner4.getSelectedItem().toString();
                        double resultado = 0 , numero  = 0;
                            numero = Double.parseDouble(edtValue2.getText().toString());
                            switch (entrada){
                                case "Dolar":
                                    switch (saida){
                                        case "Dolar":
                                            txtResultado2.setText(""+numero);break;
                                        case "Real":
                                            resultado = numero * 3.24443579;
                                            txtResultado2.setText(""+resultado);break;
                                        case "Euro":
                                            resultado = numero * 0.842459983;
                                            txtResultado2.setText(""+resultado);break;
                                    }break;
                                case "Real":
                                    switch (saida){
                                        case "Dolar":
                                            resultado = numero * 0.30825;
                                            txtResultado2.setText(""+resultado);break;
                                        case "Real":
                                            txtResultado2.setText(""+numero);break;
                                        case "Euro":
                                            resultado = numero * 0.25968829;
                                            txtResultado2.setText(""+resultado);break;
                                    }break;
                                case "Euro":
                                    switch (saida){
                                        case "Dolar":
                                            resultado = numero * 1.18700;
                                            txtResultado2.setText(""+resultado);break;
                                        case "Real":
                                            resultado = numero * 3.85228084;
                                            txtResultado2.setText(""+resultado);break;
                                        case "Euro":
                                            txtResultado2.setText(""+numero);break;
                                    }break;

                            }
                }
            });


        }
    }

