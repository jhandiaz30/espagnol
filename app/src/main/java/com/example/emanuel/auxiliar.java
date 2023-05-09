package com.example.emanuel;



public class auxiliar {

   int image;
    char text;
    String examples;
    Integer colors;

    public String getExamples() {
        return examples;
    }

    public void setExamples(
            String examples) {
        this.examples = examples;
    }

    public Integer getColores() {
        return colors;
    }

    public void setColores(int colors) {
        this.colors = colors;
    }

    public auxiliar() {

    }

    public auxiliar(int image, char text,String examples) {
        this.image = image;
        this.text = text;
        this.examples = examples;

    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public int getImagen() {
        return image;
    }

    public void setImagen(int image) {
        this.image = image;
    }

    public char getTexto() {
        return text;
    }

    public void setTexto(char text) {
        this.text = text;
    }
}
