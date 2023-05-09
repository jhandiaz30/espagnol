package com.example.emanuel;

public class time2 {
    String datos;

    public String empezar() {

        for (int j = 5; j <= 0; j--) {

            if (j == 0) {
                segundos();
                parar();
datos="0";

            } else {
                segundos();
                datos=""+j;
                return datos;

            }
        }
        return datos;


    }

    public String parar() {

        return datos;
    }

    public void segundos() {

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void minutos() {

        try {

            Thread.sleep(60000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}