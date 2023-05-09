package com.example.emanuel;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class learn extends AppCompatActivity {
private static  final int reg=100;
private ImageButton speak;
    int num;
String texto;

    voz voz=null;
    ImageView imageView;
    char [] abc={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    Integer [] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.gn, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};
ArrayList <String> letter =new ArrayList<>();
    ArrayList <Integer> imgs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        voz=new voz();
        voz.init(this);
        imageView = findViewById(R.id.imageView2);
for (int i=0;i<abc.length;i++){
    letter.add(abc[i]+"");
    imgs.add(images[i]);

}

size();
        speak = findViewById(R.id.botonHablar);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }
    private void start() {
        Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Dime algo");
        try {
            startActivityForResult(intent,reg);
        }catch (ActivityNotFoundException e){

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        learn.super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK && null!=data){
            ArrayList<String>result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


            rectify(result.get(0));

        }

        switch ( requestCode){
        case reg:{

            break;
        }
    }

    }

    public void showImage(){

        Random rnd = new Random();

        num = rnd.nextInt(letter.size());


        imageView.setImageResource(imgs.get(num));
        texto= letter.get(num);






    }

       public void rectify(String tx){
        if(tx.toLowerCase().equals("v")&&texto.equals("b")){
            Toast toast=Toast.makeText(getApplicationContext(),"Quedan "+(letter.size())+" palabras",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            String text= "Muy bien";
            voz.initQueue(text);
            letter.remove(num);
            imgs.remove(num);
            size();
        }

        else   if(tx.toLowerCase().equals("n")&&texto.equals("ñ")){
            Toast toast=Toast.makeText(getApplicationContext(),"Quedan "+(letter.size())+" palabras",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            String text= "Muy bien";
            voz.initQueue(text);
            letter.remove(num);
            imgs.remove(num);
            size();
        }
        else   if(tx.toLowerCase().equals("y")&&texto.equals("i")){
            Toast toast=Toast.makeText(getApplicationContext(),"Quedan "+(letter.size())+" palabras",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            String text= "Muy bien";
            voz.initQueue(text);
            letter.remove(num);
            imgs.remove(num);
            size();
        }
        else   if(tx.toLowerCase().equals("ca")&&texto.equals("k")){
            Toast toast=Toast.makeText(getApplicationContext(),"Quedan "+(letter.size())+" palabras",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            String text= "Muy bien";
            voz.initQueue(text);
            letter.remove(num);
            imgs.remove(num);
            size();
        }
        else   if(tx.toLowerCase().equals("ü")&&texto.equals("u")||tx.toLowerCase().equals("o")&&texto.equals("u")){
            Toast toast=Toast.makeText(getApplicationContext(),"Quedan "+(letter.size())+" palabras",Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
            String text= "Muy bien";
            voz.initQueue(text);
            letter.remove(num);
            imgs.remove(num);
            size();
        }
        else {
            if (tx.toLowerCase().equals(texto)) {
                Toast toast = Toast.makeText(getApplicationContext(), "Quedan " + (letter.size()) + " palabras", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
                String text = "Muy bien";
                voz.initQueue(text);
                letter.remove(num);
                imgs.remove(num);
                size();
            } else {

                String text = "Intenta de nuevo";
                voz.initQueue(text);
            }
        }

       }

       public void size(){

           if(letter.size()>0) {
               showImage();
           }
           else {

               speak.setVisibility(View.INVISIBLE);
               String text = "Terminaste";
               voz.initQueue(text);
           }
       }
    }




