package com.example.thali.primeiroprojeto;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void msn(){
        Context contex = getApplicationContext();
        int tempo = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contex,"PREENCHA O CAMPO",tempo);
        toast.show();
    }
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

    //Conversao Angulo
    EditText edtAngulo;
    Button btnAngulo;
    TextView txtAngulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Conversao medidas
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

        //Convesao Angulo
        txtAngulo = findViewById(R.id.txtAngulo);
        edtAngulo = findViewById(R.id.edtAngulo);
        btnAngulo = findViewById(R.id.btnAngulo);


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
                        conversaoMedidas medidas = new conversaoMedidas();
                        double resultado = 0 ,numero;
                        if(!edtValue.getText().toString().isEmpty()) {
                            numero = Double.parseDouble(edtValue.getText().toString());
                            switch (entrada) {
                                case "Milhas":
                                    switch (saida) {
                                        case "Milhas":
                                            txtResultado.setText("" + numero);
                                            break;
                                        case "Km":
                                            txtResultado.setText("" +medidas.milhasKm(numero));
                                            break;
                                    }
                                    break;
                                case "Km":
                                    switch (saida) {
                                        case "Milhas":
                                            txtResultado.setText("" + medidas.kmMilhas(numero));
                                            break;
                                        case "Km":
                                            txtResultado.setText("" + numero);
                                            break;
                                    }
                                    break;

                            }
                        }else{
                            msn();
                        }
                    }
                });
            btnResultado2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        String entrada = spinner3.getSelectedItem().toString();
                        String saida = spinner4.getSelectedItem().toString();
                        conversaoMoedas conversao = new conversaoMoedas();
                        double resultado = 0 , numero  = 0;
                            if(!edtValue2.getText().toString().isEmpty()){
                            numero = Double.parseDouble(edtValue2.getText().toString());
                            switch (entrada){
                                case "Dolar":
                                    switch (saida){
                                        case "Dolar":
                                            txtResultado2.setText("US"+numero);break;
                                        case "Real":
                                            txtResultado2.setText("R$"+conversao.dolarReal(numero));break;

                                    }break;
                                case "Real":
                                    switch (saida){
                                        case "Dolar":
                                            txtResultado2.setText("US"+conversao.realDolar(numero));break;
                                        case "Real":
                                            txtResultado2.setText("R$"+numero);break;

                                    }break;
                            }
                            }else{
                            msn();
                            }
                }
            });
            btnAngulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    conversaoAngulo angulo = new conversaoAngulo();
                   double numero = 0;
                    if(!edtAngulo.getText().toString().isEmpty()) {
                        numero = Double.parseDouble(edtAngulo.getText().toString());
                        txtAngulo.setText("" + angulo.tangente(numero));
                    }else{
                        msn();
                    }
                }
            });
        }
    }

