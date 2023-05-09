package com.example.emanuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class records extends AppCompatActivity implements recycler.ItemClickListener{
    Button btnT;
    Button btnC;
    recycler recycler;
    ArrayList<auxiliar2> aux;

    Integer [] image2;
    private ArrayList<String> time;
    private ArrayList<String> clicks;
    Integer [] image = {R.drawable.primero,R.drawable.segundo,R.drawable.tercer,R.drawable.cuarto,R.drawable.quinto};
    
    RecyclerView objets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secciones2);
        objets = findViewById(R.id.recycler2);
        aux = new ArrayList<>();
        btnT= findViewById(R.id.button14);
        btnC= findViewById(R.id.button10);

        recycler = new recycler(this,aux);
time =new ArrayList<>();
        clicks=new ArrayList<>();
            }
public void time(View view){
time.clear();
        aux.clear();
    recycler.setClickListener(this);
    objets.setLayoutManager(new LinearLayoutManager(this));
    objets.setAdapter(recycler);
    final String name = "records1";
    try {
        File sd = Environment.getExternalStorageDirectory();
        File file = new File(sd.getPath(), name);
        InputStreamReader open = new InputStreamReader(openFileInput(name));
        BufferedReader read = new BufferedReader(open);
        String line = read.readLine();
        String content = "";

        while (line != null) {
            content = content + line + "\n";
            line = read.readLine();
        }


        read.close();
        open.close();

        time(content);
        clicks(content);
        image2 = new Integer[time.size()];
        for(int i = 0; i< time.size(); i++){
            if(i<5){
                image2[i]= image[i];
            }
            else{
                image2[i]=R.drawable.otros;
            }
        }
        sort(time);

    } catch (IOException e) {
        Toast.makeText(records.this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        btnC.setVisibility(View.INVISIBLE);
        btnT.setVisibility(View.INVISIBLE);
    }

}
public void clicks(View view){
clicks.clear();
    aux.clear();
    recycler.setClickListener(this);
    objets.setLayoutManager(new LinearLayoutManager(this));
    objets.setAdapter(recycler);
    final String name = "records1";

    try {
        File tarjetaSD = Environment.getExternalStorageDirectory();
        File rutaArchivo = new File(tarjetaSD.getPath(), name);
        InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(name));

        BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
        String linea = leerArchivo.readLine();
        String contenidoCompleto = "";

        while (linea != null) {
            contenidoCompleto = contenidoCompleto + linea + "\n";
            linea = leerArchivo.readLine();
        }


        leerArchivo.close();
        abrirArchivo.close();

        time(contenidoCompleto);
        clicks(contenidoCompleto);
        image2 = new Integer[clicks.size()];
        for(int i=0;i<clicks.size();i++){
            if(i<5){
                image2[i]= image[i];
            }
            else{
                image2[i]=R.drawable.otros;
            }
        }
        sortClicks(clicks);


        for (int j = 0; j < clicks.size(); j++) {
            Log.i("texto",clicks.get(j)+"");

        }




    } catch (IOException e) {
        Toast.makeText(records.this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        btnC.setVisibility(View.INVISIBLE);
        btnT.setVisibility(View.INVISIBLE);
    }
}

    @Override
    public Looper getMainLooper() {
        return super.getMainLooper();
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, " on row number " + position, Toast.LENGTH_SHORT).show();
    }



    public void sort(final ArrayList list) {




        int num = list.size();
        ArrayList<Integer>integers= new ArrayList<>();
        String texto ="";
        String textoN ="";
        for (int i=0;i<num;i++) {
            texto = time.get(i);
            for (int j = 0; j < texto.length(); j++) {
                if (texto.charAt(j)!=':'){
                    textoN=textoN+texto.charAt(j);
                }
            }

            integers.add(Integer.valueOf(textoN));
            textoN="";
        }

        int [] list1 = new int[integers.size()];
        for(int i=0;i<integers.size();i++){
            list1[i]=integers.get(i);

        }
        integers.clear();
        list1= sort2(list1);
        int x;
        for(int i=0;i<list1.length;i++){
            x= list1[i];

            integers.add(x);

        }
        ArrayList<String>nuevo2= new ArrayList<>();
        for(int i=0;i<integers.size();i++){
            String texto2=integers.get(i)+"";
            if(texto2.length()==5){
                texto2="00"+texto2;
                nuevo2.add(texto2);
                Log.i("texto2",nuevo2.get(i)+"");
            }
            else{
                if(texto2.length()==6){
                    texto2="0"+texto2;
                    nuevo2.add(texto2);
                    Log.i("texto2",nuevo2.get(i)+"");
                }
            }

        }
        ArrayList<String>nuevo3= new ArrayList<>();
        String var=":";

        for(int i=0;i<nuevo2.size();i++){
            String texto2=nuevo2.get(i)+"";
            nuevo3.add(texto2.charAt(0)+""+texto2.charAt(1)+""+var+texto2.charAt(2)+texto2.charAt(3)+var+texto2.charAt(4)+texto2.charAt(5)+texto2.charAt(6));
            Log.i("texto3",nuevo3.get(i)+"");
        }
        for(int i=0;i<nuevo3.size();i++){
            String x2=nuevo3.get(i);
            Log.i("texto4",x2+"");
            for(int j = 0; j< time.size(); j++){
                Log.i("texto5", time.get(j)+"");
                if(time.get(j).equals(x2)){

                    aux.add(new auxiliar2(image2[i], clicks.get(j), x2));




                }
                else{
                    Log.i("texto4","yes");

                }



            }
        }

    }

    public void sortClicks(ArrayList lista){

        int num = lista.size();
        ArrayList<Integer>nuevo= new ArrayList<>();
        String texto ="";
        String textoN ="";
        for (int i=0;i<num;i++) {
            texto = clicks.get(i);
            for (int j = 0; j < texto.length(); j++) {
                if (texto.charAt(j)!=':'){
                    textoN=textoN+texto.charAt(j);
                }
            }

            nuevo.add(Integer.valueOf(textoN));
            textoN="";
        }

        int [] lista1 = new int[nuevo.size()];
        for(int i=0;i<nuevo.size();i++){
            lista1[i]=nuevo.get(i);

        }
        nuevo.clear();
        lista1= sort2(lista1);
        int x;


        ArrayList<String>nuevo2= new ArrayList<>();
        for(int i=0;i<lista1.length;i++){
            x= lista1[i];

            nuevo2.add(x+"");

        }

        for(int i=0;i<nuevo2.size();i++){
            String x2=nuevo2.get(i);
            Log.i("texto4",x2+"");
            for(int j=0;j<clicks.size();j++){
                Log.i("texto5",clicks.get(j)+"");
                if(clicks.get(j).equals(x2)){

                    aux.add(new auxiliar2(image2[i], x2, time.get(j)));




                }
                else{
                    Log.i("texto4","yes");

                }



            }
        }
    }




    public int[] sort2(int[] array) {

        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) // Looping through the array length
        {

            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {

                    //swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                }

            }
        }
        return array;
    }
public void time(String s){
    String texto;
    String resultado="";
    int var=0;
    texto=s;

    int tam =texto.length();
    System.out.println(tam);
    for(int i=0;i<tam;i++){
        if(texto.charAt(i)=='*'){
            var++;
        }
        else if(var==1){

            resultado=resultado+texto.charAt(i);
        }
        else if(var==2){
            var=0;
            time.add(resultado);

            resultado="";
        }
    }

}

public void clicks(String s){
    String texto;
    String resultado="";

    int var=0;
    texto=s;
    int tam =texto.length();
    System.out.println(tam);


    for(int i=0;i<tam;i++){
        if(texto.charAt(i)=='-'){
            var++;
        }
        else if(var==1){

            resultado=resultado+texto.charAt(i);

        }
        else if(var==2){

            var=0;
            clicks.add(resultado);
            resultado="";
        }

    }








}
}




