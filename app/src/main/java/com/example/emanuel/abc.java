package com.example.emanuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class abc extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secciones);
        Integer [] images  = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.gn,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};
        char [] abc={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        String [] examples={"Ardilla","Burro","Carro","Dinosaurio","Elefante","Faro","Girasol","Héroe","Isla","Jirafa","Koala","Libros","Marrano","Nube","Otoño","Oso","Pato","Queso","Rosa","Serpiente","Tigre","Uvas","Vaso","Wi-fi","Xilófono","Yoyo","Zapato"};
        Integer [] colors ={R.color.black,R.color.colorPrimary};

        RecyclerView obj = findViewById(R.id.recycler);

        ArrayList<auxiliar> aux = new ArrayList<>();
            Prime alg = new Prime();
            int number = 0;
        for(int i=0;i<images.length;i++) {


                number = i;
                if (alg.isPrime(number) == true) {
                        aux.add(new auxiliar(images[i], abc[i], examples[i]));

                } else {
                        aux.add(new auxiliar(images[i], abc[i], examples[i]));
                }
        }

        MyRecyclerViewAdapter myadapter = new MyRecyclerViewAdapter(this,aux);
        myadapter.setClickListener(this);
        obj.setLayoutManager(new LinearLayoutManager(this));
        obj.setAdapter(myadapter);


        }
        public class Prime {

                boolean isPrime(int n) {
                        if (n%2==0) return false;
                        for(int i=3;i*i<=n;i+=2) {
                                if(n%i==0)
                                        return false;
                        }
                        return true;
                }
        }

public void onItemClick(View view, int position) {

        }


        }

