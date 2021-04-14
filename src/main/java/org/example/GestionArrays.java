package org.example;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;



public class GestionArrays {
    public static void main(String[] args) {
        Punto[][] imagen = generarImagen();
        imprimirImage(imagen);
    }

    public static void ordenamientoBurbuja(int[] datos){

    }

    public static void ordenamientoDirecto(int[] datos){

    }

    public static void imprimirImage(Punto[][] imagen){
        for (Punto[] columna: imagen){
            System.out.println(Arrays.toString(columna));
        }
    }

    public static Punto[][] generarImagen(){
        Punto[][] imagen = new Punto[250][100];
        Random generador = new Random(123);
        for(int i = 0; i < imagen.length; i++){
            for(int j = 0; j < imagen[i].length; j++){
                int red = Math.abs(generador.nextInt() % 255);
                int blue = Math.abs(generador.nextInt() % 255);
                int green = Math.abs(generador.nextInt() % 255);
                imagen[i][j] = new Punto(red, blue, green); // 123 es la seed para que se genere siempre la misma secuencia como si fuera mundo de minecraft.
            }
        }
        return imagen;
    }
}

class Punto{
    private int red;
    private int blue;
    private int green;

    public Punto(int r, int b, int g){
        this.red = r;
        this.blue = b;
        this.green = g;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "red=" + red +
                ", blue=" + blue +
                ", green=" + green +
                '}';
    }

    public void guardarEnDisco(String ruta){
        FileOutputStream fos = new FileOutputStream(ruta);
        try {
            fos.write(someByteArray);
        }
        finally {
            fos.close();
        }
    }
}
