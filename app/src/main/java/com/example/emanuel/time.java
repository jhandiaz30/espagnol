package com.example.emanuel;

import android.os.Handler;

public class time {


    int mili=0,seg=0,minutos=0;
    boolean isOn= false;
    Handler h = new Handler();
    Thread cronos= new Thread(new Runnable() {
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
                        minutos++;
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
                            if (minutos < 10) {
                                mi = "0" + minutos;
                            } else {
                                mi = "" + minutos;
                            }


                        }
                    });
                }
                }
        }
    });

    public void comenzar(){
isOn=true;

    }
    public void terminar(){
        isOn=false;
        mili=0;
        seg=0;
        minutos=0;

    }
}







