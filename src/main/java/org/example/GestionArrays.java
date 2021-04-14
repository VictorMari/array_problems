package org.example;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class GestionArrays {
    public static void main(String[] args) {
        //Punto[][] imagen = generarImagen();
        //imprimirImage(imagen);
        int[] numsBurbuja = solicitarArray();
        ordenamientoDirecto(numsBurbuja);
        ordenamientoDirecto(numsBurbuja);
        System.out.println(Arrays.toString(numsBurbuja));
    }

    public static int pedirDato(){
        Scanner in = new Scanner(System.in);
        try{
            return in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Solo se permiten numeros");
            return pedirDato();
        }
        catch (Exception e){
            System.out.println("No se pudo leer. Vuelve a introducir el dato");
            return pedirDato();
        }

    }

    public static int[] solicitarArray(){
        int[] numeros = new int[10];
        System.out.println("Introduce " + numeros.length + " numeros para ordenar");
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = pedirDato();
        }
        return numeros;
    }

    public static void ordenamientoBurbuja(int[] datos){
        for (int i = 1; i < datos.length; i++){
            for (int j = 0; j < datos.length - i; j++){
                if (datos[j] > datos[j + 1]){
                    // algoritmo para intercabiar el valor de dos variables.
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenamientoDirecto(int[] datos){
        for (int i = 0; i < datos.length - 1; i++){
            for (int j = i + 1; j < datos.length; j++){
                if(datos[j] < datos[i]){
                    int temp  = datos[i];
                    datos[i] = datos[j];
                    datos[j] = temp;
                }
            }
        }
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
        /*
        FileOutputStream fos = new FileOutputStream(ruta);
        try {
            fos.write(someByteArray);
        }
        finally {
            fos.close();
        }
         */
    }
}
