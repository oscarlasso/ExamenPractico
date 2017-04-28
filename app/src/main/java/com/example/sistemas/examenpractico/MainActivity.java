package com.example.sistemas.examenpractico;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText primer;
    private EditText segundo;
    private EditText tercer;

    private EditText res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        primer= (EditText) findViewById(R.id.primer);
        segundo= (EditText) findViewById(R.id.segundo);
        tercer= (EditText) findViewById(R.id.tercer);
        res = (EditText) findViewById(R.id.resultado);

        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        primer.setText(prefe.getString("primer nota",""));
        segundo.setText(prefe.getString("segunda nota",""));
        tercer.setText(prefe.getString("tercer nota",""));
        res.setText(prefe.getString("resultado",""));
    }

    public void calcular(View v) {

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("primer nota", primer.getText().toString());
        editor.putString("segunda nota", segundo.getText().toString());
        editor.putString("tercer nota", tercer.getText().toString());
        editor.putString("resultado", res.getText().toString());
        editor.commit();

        float v1= Float.parseFloat(primer.getText().toString());
        float v2= Float.parseFloat(segundo.getText().toString());
        float v3= Float.parseFloat(tercer.getText().toString());
        double promedio = ((v1*0.3) + (v2*0.3) + (v3*0.4));
        double total= (promedio / 3);




    }

    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }


}
