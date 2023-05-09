package com.example.emanuel;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class cards extends AppCompatActivity {

    public boolean loop;
    public int count;

   MediaPlayer mediaPlayer;
   String mi,m,s, total;;
    int mili=0,seg=0, mins =0, mili2=0,seg2=0, mins2 =0;
    LottieAnimationView animationView, animationView2,animationView3;
    boolean isOn= false, isOn2= false;
    Handler h = new Handler(), h2 = new Handler();
    int touchs, clicks, sound, p1,p2, n, l;
    voz voz = null;
    Integer rect[] = new Integer[24],rect2[] = new Integer[24];


public    TextView textView;
      TextView textView1;
    ImageButton btn1, btn9,btn2, btn15,btn10, btn3,btn11, btn4, btn12, btn5, btn13, btn6,btn14, btn7,btn8, btn21,btn17,btn22,btn18, btn23, btn19, btn24, btn20, btn16, btn26, btn27, num1, num2;
    ArrayList<Integer> position, abc2, abc3, images2, images3;;
    Button btn30, button4, btn;
    ArrayList<ImageButton> buttons,org, buttons2, buttons3;

    Thread cronos, cronos2;


Integer audiosB [] ={R.raw.bien1,R.raw.bien2,R.raw.bien3};
    Integer audiosM [] ={R.raw.mal1,R.raw.mal2,R.raw.mal3};

    ArrayList<ImageButton> btns2 = new ArrayList<>();

    public  void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
animationView= findViewById(R.id.animation_view5);
        animationView3= findViewById(R.id.animation_view7);
        animationView2= findViewById(R.id.animation_view6);



         textView = findViewById(R.id.textView5);
        btn = findViewById(R.id.buttonr);
        btn1 = findViewById(R.id.imageButton);
        btn2 = findViewById(R.id.imageButton3);
        btn3 = findViewById(R.id.imageButton4);
        btn4 = findViewById(R.id.imageButton5);
        btn5 = findViewById(R.id.imageButton6);
        btn6 = findViewById(R.id.imageButton7);
        btn7 = findViewById(R.id.imageButton8);
        btn8 = findViewById(R.id.imageButton9);
        btn9 = findViewById(R.id.imageButton10);
        btn10 = findViewById(R.id.imageButton11);
        btn11 = findViewById(R.id.imageButton12);
        btn12 = findViewById(R.id.imageButton13);
        btn13 = findViewById(R.id.imageButton14);
        btn14 = findViewById(R.id.imageButton15);
        btn15 = findViewById(R.id.imageButton16);
        btn16 = findViewById(R.id.imageButton17);
        btn17 = findViewById(R.id.imageButton18);
        btn18 = findViewById(R.id.imageButton19);
        btn19 = findViewById(R.id.imageButton20);
        btn20 = findViewById(R.id.imageButton21);
        btn21 = findViewById(R.id.imageButton22);
        btn22 = findViewById(R.id.imageButton23);
        btn23 = findViewById(R.id.imageButton24);
        btn24 = findViewById(R.id.imageButton25);
        btn27 = findViewById(R.id.imageButton27);
        btn26 = findViewById(R.id.imageButton26);
        btn30 = findViewById(R.id.button5);
        btn30 = findViewById(R.id.button5);
        button4 = findViewById(R.id.button4);
        textView = findViewById(R.id.textView5);
        textView1 = findViewById(R.id.textView6);
        final ImageButton[] btns3 = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24};
       cronos = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (isOn) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mili++;
                        if (mili == 999) {
                            seg++;
                            mili = 0;
                        }
                        if (seg == 59) {
                            mins++;
                            seg = 0;

                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String m = "", s = "", mi = "";
                                if (mili < 10) {
                                    m = "00" + mili;
                                } else if (mili < 100) {
                                    m = "0" + mili;
                                } else {
                                    m = "" + mili;
                                }
                                if (seg < 10) {
                                    s = "0" + seg;
                                } else {
                                    s = "" + seg;
                                }
                                if (mins < 10) {
                                    mi = "0" + mins;
                                } else {
                                    mi = "" + mins;
                                }
                                total =mi+":"+s+":"+m;
                                textView1.setText(total);
                            }

                        });
                    }
                }
            }
        });
        cronos.start();
        cronos2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (isOn2) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mili2++;
                        if (mili2 == 999) {
                            seg2++;
                            mili2 = 0;
                        }

                        h2.post(new Runnable() {
                            @Override
                            public void run() {
                                m = "";
                                s = "";
                                mi = "";
                                if (mili2 < 10) {
                                    m = "00" + mili2;
                                } else if (mili2 < 100) {
                                    m = "0" + mili2;
                                } else {
                                    m = "" + mili2;
                                }
                                if (seg2 < 10) {
                                    s = "0" + seg2;
                                } else {
                                    s = "" + seg2;
                                }
                                if (mins2 < 10) {
                                    mi = "0" + mins2;
                                } else {
                                    mi = "" + mins2;
                                }
                                textView.setText(s);
                            }

                        });

                        if(seg2==6){
                            terminar2();

                        }
                    }
                }
            }
        });
        cronos2.start();
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView.setVisibility(View.INVISIBLE);
                touchs =0;
                for (int i = 0; i < btns3.length; i++) {
                    btns3[i].setVisibility(View.VISIBLE);
                }
                button4.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                terminar();
                terminar2();
                llenarImg();
                mover();
            }

        });

        for (int i = 0; i < btns3.length; i++) {
            btns3[i].setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);
        }
        voz = new voz();
        voz.init(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<btns3.length;i++){
                    btns3[i].setEnabled(true);
                }
                textView1.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                touchs =0;
terminar();
terminar2();
                textView.setText("-");
                llenarImg();
                mover();
            }
        });
    }
    public void segundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

         public void mover() {
            btn.setVisibility(View.INVISIBLE);
         new Thread(new Runnable() {
             @Override
             public void run() {

for(int i=5;i>=1;i--){

    if(i==1){

        voz.initQueue("Uno");
        tiempo(i+"");
        segundo();
    }
    if(i==2){

        voz.initQueue("Dos");
        tiempo(i+"");
        segundo();

    }
    if(i==3){

        voz.initQueue("Tres");
        tiempo(i+"");
        segundo();

    }
    if(i==4){

        voz.initQueue("Cuatro");
        tiempo(i+"");
        segundo();


    }
    if(i==5){

        voz.initQueue("Cinco");
        tiempo(i+"");
        segundo();

    }
}
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {

                         for (int i = 0; i < buttons.size(); i++) {
                             buttons.get(i).setImageResource(R.drawable.fondo);
                         }
cro();


                     }
                 });
             }

         }).start();

        }
        public void cro() {
        btn.setVisibility(View.VISIBLE);
textView.setVisibility(View.INVISIBLE);
textView1.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    comenzar();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }).start();
        }
    public void comenzar(){
        isOn=true;
    }
    public void terminar(){
        isOn=false;
        mili=0;
        seg=0;
        mins =0;
    }
 public void terminar2(){
        isOn2=false;
        mili2=0;
        seg2=0;
        mins2 =0;

    }
public void tiempo(final String t){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i < 2; i++) {
                        if (i == 1) {

                            segundo();
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            textView.setText(t);
                        }
                    });
                }
            }).start();
        }
public void llenarImg() {
            clicks = 0;
            buttons3 = new ArrayList<>();
            org = new ArrayList<>();

            position = new ArrayList<>();
            buttons2 = new ArrayList<>();
            buttons = new ArrayList<>();
            abc2 = new ArrayList<>();
            abc3 = new ArrayList<>();
            images2 = new ArrayList<>();
            images3 = new ArrayList<>();
            ImageButton[] btns = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24};
            Integer[] imagenes4 = {R.drawable.a2, R.drawable.b2, R.drawable.c2, R.drawable.d2, R.drawable.e2, R.drawable.f2, R.drawable.g2, R.drawable.h2, R.drawable.i2, R.drawable.j2, R.drawable.k2, R.drawable.l2, R.drawable.m2, R.drawable.n2, R.drawable.gn2, R.drawable.o2, R.drawable.p2, R.drawable.q2, R.drawable.r2, R.drawable.s2, R.drawable.t2, R.drawable.u2, R.drawable.v2, R.drawable.w2, R.drawable.x2, R.drawable.y2, R.drawable.z2};
            Integer[] imagenes = {R.drawable.a1, R.drawable.b1, R.drawable.c1, R.drawable.d1, R.drawable.e1, R.drawable.f1, R.drawable.g1, R.drawable.h1, R.drawable.i1, R.drawable.j1, R.drawable.k1, R.drawable.l1, R.drawable.m1, R.drawable.n1, R.drawable.gn1, R.drawable.o1, R.drawable.p1, R.drawable.q1, R.drawable.r1, R.drawable.s1, R.drawable.t1, R.drawable.u1, R.drawable.v1, R.drawable.w1, R.drawable.x1, R.drawable.y1, R.drawable.z1};
            for (int i = 0; i < btns.length; i++) {
                btns2.add(btns[i]);
            }
            for (int i = 0; i < imagenes.length; i++) {
                images2.add(imagenes[i]);
                images3.add(imagenes4[i]);
            }
            Random rnd = new Random();
            int o = 0;

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn1);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn2);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn3);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn4);
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn5);
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn6);
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn7);
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn8);
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn9);
                }
            });
            btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn10);
                }
            });
            btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn11);
                }
            });
            btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn12);
                }
            });
            btn13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn13);
                }
            });
            btn14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn14);
                }
            });
            btn15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn15);
                }
            });
            btn16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn16);
                }
            });
            btn17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn17);
                }
            });
            btn18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn18);
                }
            });
            btn19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn19);
                }
            });
            btn20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn20);
                }
            });
            btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn21);
                }
            });
            btn22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn22);
                }
            });
            btn23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn23);
                }
            });
            btn24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltear(btn24);
                }
            });

            int num;
            for (int i = 0; i < 12; i++) {

                do {
                    num = rnd.nextInt(images2.size());
                    abc2.add(images2.get(num));
                    abc3.add(images3.get(num));
                    System.out.println(abc2.get(i));
                    images2.remove(num);
                    images3.remove(num);

                    for (int j = 0; j < 2; j++) {
                        int num2 = rnd.nextInt(btns2.size());
                        buttons.add(btns2.get(num2));
                        buttons3.add(btns2.get(num2));
                        org.add(btns2.get(num2));
                        buttons.get(o).setImageResource(abc2.get(i));
                        buttons3.get(o).setImageResource(abc2.get(i));
                        rect[o] = abc2.get(i);
                        rect2[o] = abc3.get(i);
                        System.out.println(abc2.get(i));
                        btns2.remove(num2);
                        o = o + 1;
                    }
                }
                while (images2.contains(abc2.get(i)));
            }
            for (int i = 0; i < buttons.size(); i++) {

                buttons.get(i).setVisibility(View.VISIBLE);

            }
        }

        public void voltear(ImageButton btn1) {
            clicks++;
            buttons2.add(btn1);

            if (buttons2.size() == 1) {
                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).equals(buttons2.get(0))) {
                        buttons2.get(0).setImageResource(rect[i]);


                        position.add(i);

                        n = i;
                        System.out.println("----------------------");

                        System.out.println(n);
                    }
                }

            } else if (buttons2.size() == 2) {

                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).equals(buttons2.get(1))) {
                        buttons.get(i).setImageResource(rect[i]);


                        position.add(i);

                        l = i;
                        System.out.println("----------------------");
                    }
                }

                System.out.println("----------------------");

                System.out.println(n);
                buttons.set(n, buttons2.get(0));
                buttons.set(l, buttons2.get(1));

                int cont = 0;

                for (int i = 0; i < buttons3.size(); i++) {


                    if (buttons2.get(0).equals(buttons.get(i))) {
                        buttons.set(i, buttons3.get(i));
                        cont++;
                        System.out.println("----------------------");

                        System.out.println(i);

                        num1 = buttons2.get(0);

                    }
                }
                for (int i = 0; i < buttons.size(); i++) {


                    if (buttons2.get(1).equals(buttons.get(i))) {
                        buttons.set(i, buttons3.get(i));
                        cont++;
                        num2 = buttons2.get(1);


                    }
                }


                for (int i = 0; i < buttons.size(); i++) {

                    if (org.get(i).equals(num1)) {

                        p1 = i;
                        position.add(p1);

                    } else if (org.get(i).equals(num2)) {
                        p2 = i;
                        position.add(p2);
                    }
                }

                if (rect[p1].equals(rect[p2]) && p1 != p2) {
                    System.out.println(p1 + " " + p2);
                    System.out.println(rect[p1] + " iguakes " + rect[p2]);
                    count = 0;
                    run2(View.INVISIBLE, View.INVISIBLE);
                    buttons2.clear();
                } else {
                    System.out.println(p1 + " " + p2);
                    System.out.println(rect[p1] + " " + rect[p2]);
                    buttons2.get(1).setImageResource(rect[p2]);
                    count = 5;
                    run2(R.drawable.fondo, R.drawable.fondo);
                    buttons2.clear();
                }
            }
        }


        public void run2(int num, int num2) {

            start();
            while (loop) {
Random rnd = new Random();
int ale =  rnd.nextInt(3);
                count++;
                if (count < 4) {
                    sound =audiosB[ale];
                    touchs++;
                    buttons2.get(0).setEnabled(false);
                    buttons2.get(1).setEnabled(false);
                    animationView3.setVisibility(View.VISIBLE);
                    detener();
                    mostrar();
                }

                if (count > 5) {
                    sound =audiosM[ale];
                    buttons2.get(0).setImageResource(num);
                    buttons2.get(1).setImageResource(num2);
                    animationView2.setVisibility(View.VISIBLE);
                    detener();
                    mostrar();
                }
                try {
                    sleep(1);
                } catch (Exception e) {
                }
            }
        }

        public void start() {
            loop = true;
            new Thread().start();
        }

        public void detener() {
            loop = false;

        }
        public void mostrar() {

            for (int i = 0; i < buttons.size(); i++) {

                buttons.get(i).setVisibility(View.INVISIBLE);
            }
            btn30.setVisibility(View.VISIBLE);
            btn26.setVisibility(View.VISIBLE);
            btn27.setVisibility(View.VISIBLE);
            btn.setVisibility(View.INVISIBLE);
            btn26.setImageResource(rect2[p1]);
            btn27.setImageResource(rect2[p2]);

            btn30.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer =MediaPlayer.create(cards.this, sound);
                    mediaPlayer.start();
                    animationView2.setVisibility(View.INVISIBLE);
                    animationView3.setVisibility(View.INVISIBLE);
                    btn30.setVisibility(View.INVISIBLE);
                    btn26.setVisibility(View.INVISIBLE);
                    btn27.setVisibility(View.INVISIBLE);

                    if (touchs == 12) {
                        String minutos= total;
                        Toast.makeText(cards.this,""+minutos,Toast.LENGTH_SHORT).show();
                        Intent cambio = new Intent(cards.this, score.class);
                        cambio.putExtra("toques", "-"+clicks + "- ");
                        cambio.putExtra("tiempo", "*"+minutos + "*");
                        startActivity(cambio);
                    }

                    for (int i = 0; i < buttons.size(); i++) {

                        buttons.get(i).setVisibility(View.VISIBLE);
                    }
                    btn.setVisibility(View.VISIBLE);
                }
            });
            buttons2.clear();
        }
}

