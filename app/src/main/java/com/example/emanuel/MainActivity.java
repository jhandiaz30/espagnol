package com.example.emanuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    TableRow tr;
    RadioGroup rg;
String sex ="";
    EditText txt;
    TextView tx;
    Button btn;
    Button btn12;
    Button btn13;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ConstraintLayout cs = findViewById(R.id.welcome);

        btn12=findViewById(R.id.button12);
        btn13=findViewById(R.id.button13);

        rg = findViewById(R.id.rg);
        txt = findViewById(R.id.editText);

        btn = findViewById(R.id.button11);
        tx = findViewById(R.id.textView9);
        tr = findViewById(R.id.table);

        final String name = "persona2";
        final Button button1 = findViewById(R.id.button9);
        Button button2 = findViewById(R.id.button3);
        Button button3 = findViewById(R.id.button8);
        Button button4 = findViewById(R.id.button7);

        ArrayList<Button>  buttons= new ArrayList<>();
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File rout = new File(sdCard.getPath(), name);
            InputStreamReader openFile = new InputStreamReader(openFileInput(name));

            BufferedReader read = new BufferedReader(openFile);
            String linea = read.readLine();
            String contenidoCompleto = "";

            while (linea != null) {
                contenidoCompleto = contenidoCompleto + linea + "\n";
                linea = read.readLine();
            }


            read.close();
            openFile.close();
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            String var = "";
            buttons.add(button1); buttons.add(button2); buttons.add(button3); buttons.add(button4);

            if (contenidoCompleto.contains("Hombre")) {
for (int i=0;i<buttons.size();i++){
    buttons.get(i).setBackgroundColor(getResources().getColor(R.color.man3));
    buttons.get(i).setTextColor(getResources().getColor(R.color.black));
}
                cs.setBackgroundColor(getResources().getColor(R.color.man1));
txt.setTextColor(getResources().getColor(R.color.man2));

                for (int i = 6; i < contenidoCompleto.length(); i++) {
                    var = var+contenidoCompleto.charAt(i) + "";
                }
                tx.setVisibility(View.VISIBLE);
                tx.setText("Bienvenido " + var);
            } else {
                for (int i=0;i<buttons.size();i++){
                    buttons.get(i).setBackgroundColor(getResources().getColor(R.color.woman3));
                    buttons.get(i).setTextColor(getResources().getColor(R.color.woman4));
                }
                cs.setBackgroundColor(getResources().getColor(R.color.woman1));
                txt.setTextColor(getResources().getColor(R.color.woman4));

                for (int i = 5; i < contenidoCompleto.length(); i++) {
                    var = var+contenidoCompleto.charAt(i) + "";
                }
                tx.setVisibility(View.VISIBLE);
                tx.setText("Bienvenida " + var);

            }


        } catch (IOException e) {

            cs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            tr.setVisibility(View.VISIBLE);


        }

btn12.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sex ="Mujer";
        btn.setVisibility(View.VISIBLE);
        btn12.setBackgroundColor(getResources().getColor(R.color.woman1));
        btn13.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

    }

});
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex ="Hombre";
                btn.setVisibility(View.VISIBLE);
                btn13.setBackgroundColor(getResources().getColor(R.color.a));
                btn12.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, abc.class);

                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, learn.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cards.class);

                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, records.class);

                startActivity(intent);
            }
        });


    }

    public  void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    }
    public void Guardar(View view) {
        String nombre = txt.getText().toString();
        String nombre2 = "persona2";
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre2);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre2, Activity.MODE_PRIVATE));

            crearArchivo.write(sex +""+nombre);
            crearArchivo.flush();
            crearArchivo.close();

            Toast.makeText(this, "Guardado correctamente"+ sex +""+nombre, Toast.LENGTH_SHORT).show();
            txt.setText("");
            tr.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (IOException e) {
            Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }
}





