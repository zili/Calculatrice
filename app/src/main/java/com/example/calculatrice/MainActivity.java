package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView grandEcran, petitEcran;
    double a,b,c;
    String op;
    boolean opDone = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grandEcran = findViewById(R.id.tv);
        petitEcran = findViewById(R.id.ptv);
    }

    public void afficher(View view) {

        Button btn =(Button) view;
        String chiffre = btn.getText().toString();
        String nbrStr = grandEcran.getText().toString();

        nbrStr = nbrStr.trim().equals("0") || opDone ?
                chiffre: nbrStr.trim()+chiffre;
        grandEcran.setText(nbrStr);
        String pNbrStr = nbrStr;
        petitEcran.setText(opDone? chiffre:
                petitEcran.getText()+chiffre);
        opDone = false;
    }

    public void egal(View view){
        String nbrStr = grandEcran.getText().toString();
        b = Double.parseDouble(nbrStr);
        switch (op){
            case "+": c = a+b; break;
            case "-": c = a-b; break;
            case "X": c = a*b; break;
            case "/": c = a/b; break;
        }
        petitEcran.setText(petitEcran.getText()+"=");
        grandEcran.setText(Double.toString(c));
        opDone = true;
    }
    public void SelectOperator(View view){
        String nbrStr = grandEcran.getText().toString();
        a = Double.parseDouble(nbrStr);
        Button btn =(Button) view;
        op =  btn.getText().toString();
        grandEcran.setText("");
        petitEcran.setText(petitEcran.getText()+op);

    }
    public void clean(View v){
        petitEcran.setText("0");
        grandEcran.setText("0");
    }
}