package com.example.emanuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class score extends AppCompatActivity {
int num;
String time;
    String  clicks2;

    String content = "";
Boolean prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        final String clicks = getIntent().getStringExtra("toques").toString();
        final String total = getIntent().getStringExtra("tiempo").toString();
        time =total;
        clicks2=clicks;
        Log.i("texto", clicks + "");


    }

    public  void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    }
    public void guardar(){

                String records = "records1";
                String txt = time +" con "+clicks2+" clicks"+" ";

                try {

                    File tarjetaSD = Environment.getExternalStorageDirectory();
                    Toast.makeText(score.this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
                    File rutaArchivo = new File(tarjetaSD.getPath(), records);
                    OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(records , Activity.MODE_PRIVATE));
                    Log.i("texto",txt+"");
                    crearArchivo.write(txt);
                    crearArchivo.flush();
                    crearArchivo.close();

                    Toast.makeText(score.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();

                }catch (IOException e){
                    Toast.makeText(score.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }





    }
    //Método consultar
    public void Consultar(View view){
        String nombre = "records1";


        try{
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();


            while (linea != null){
                content = content + linea + "\n";
                linea = leerArchivo.readLine();
            }
            sobreEscribir();
            leerArchivo.close();
            abrirArchivo.close();


        }catch (IOException e){
                guardar();
        }


        Intent cambio = new Intent(score.this, MainActivity.class);
        startActivity(cambio);
    }


    public  void sobreEscribir(){

        String records = "records1";
        String txt = content +""+""+ time +" con "+clicks2+" clicks"+"";


        try {

            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(score.this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(), records);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(records , Activity.MODE_PRIVATE));
            crearArchivo.write(txt);
            crearArchivo.flush();
            crearArchivo.close();

            Toast.makeText(score.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();

        }catch (IOException e){
            Toast.makeText(score.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }
}


