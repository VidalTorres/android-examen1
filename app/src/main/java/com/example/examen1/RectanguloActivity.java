package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class RectanguloActivity extends AppCompatActivity {

    private TextView lblAltura, lblNombre, lblBase, lblRadio, lblResultado;
    private RadioButton rdbArea, rdnPerimetro;
    private Button btnRegresar, btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        lblAltura = (TextView) findViewById(R.id.lblAltura);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblRadio = (TextView) findViewById(R.id.lblRadio);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        rdbArea = (RadioButton) findViewById(R.id.rdbArea);
        rdnPerimetro = (RadioButton) findViewById(R.id.rdbPerimetro);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);


        Bundle datos = getIntent().getExtras();
        Rectangulo rectangulo = (Rectangulo) datos.getSerializable("Rectangulo");

        lblNombre.setText("Nombre: "+datos.getString("nombre"));
        lblAltura.setText("Altura: " + rectangulo.getAltura());
        lblBase.setText("Base: " + rectangulo.getBase());

        lblRadio.setText("Que desea calcular:");

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdbArea.isChecked()==true){
                    lblResultado.setText("El area es: " + rectangulo.calculoArea());
                }

                if (rdnPerimetro.isChecked()==true){
                    lblResultado.setText("El perimetro es: " + rectangulo.calculoPerimetro());
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(RectanguloActivity.this);
                confirmar.setTitle("Desea regresar?");
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