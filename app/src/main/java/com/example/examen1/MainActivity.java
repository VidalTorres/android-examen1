package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;

    private Button btnSiguiente;
    private Button btnLimpiar;
    private Button btnCerrar;

    private Rectangulo rectangulo = new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtBase = (EditText) findViewById(R.id.txtBase);

        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dato faltante: Nombre",Toast.LENGTH_SHORT).show();
                }
                else if(txtBase.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dato faltante: Base",Toast.LENGTH_SHORT).show();
                }
                else if(txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Dato faltante: Altura",Toast.LENGTH_SHORT).show();
                }
                else{
                    float altura = Float.parseFloat(txtAltura.getText().toString());
                    rectangulo.setAltura(altura);

                    float base = Float.parseFloat(txtBase.getText().toString());
                    rectangulo.setBase(base);

                    Intent intent = new Intent(MainActivity.this,RectanguloActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Rectangulo",rectangulo);
                    intent.putExtra("nombre", txtNombre.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtBase.setText("");
                txtAltura.setText("");
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("Cerrar aplicación?");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                });
                confirmar.show();
            }
        });
    }
}