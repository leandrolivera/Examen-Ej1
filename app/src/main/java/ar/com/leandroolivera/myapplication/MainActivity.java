package ar.com.leandroolivera.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titulo = findViewById(R.id.tvTitulo);
        EditText nombre = findViewById(R.id.etNombre), apellido = findViewById(R.id.etApellido),
                calle = findViewById(R.id.etCalle), numero = findViewById(R.id.etNumero);

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch swBoton = findViewById(R.id.swHabilitar);
        Button btnSiguiente = findViewById(R.id.btnSiguiente), btnTitulo = findViewById(R.id.btnTitulo);

        swBoton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnSiguiente.setEnabled(swBoton.isChecked());
            }
        });


        btnTitulo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese su nombre.", Toast.LENGTH_SHORT).show();
                }
                else {
                    titulo.setText("Hola "+nombre.getText().toString());
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese su nombre.", Toast.LENGTH_SHORT).show();
                } else if (apellido.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese su apellido.", Toast.LENGTH_SHORT).show();
                } else if (calle.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese el nombre de la calle de su domicilio.", Toast.LENGTH_SHORT).show();
                } else if (numero.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese sel número de calle de su domicilio.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usted presionó siguiente! Gracias", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}