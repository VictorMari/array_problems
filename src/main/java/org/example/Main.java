package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        String frase = SolicitarFrase();
        Ejercicios tarea6 = new Ejercicios(frase);
        tarea6.calcularLineas();

    }

    public static String SolicitarFrase(){
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca una frase acabada en punto  ----> .");
        String frase = in.nextLine();
        boolean fraseMalFormada  = true;

        char ultimaLetra = frase.charAt(frase.length() - 1);
        if (ultimaLetra != '.'){
            System.out.println("La frase no acaba en punto");
            return SolicitarFrase(); // LLamada recursiva
            //el mismo metodo se vuelve a llamar otra vez y se vuelve a ejecutar el codigo desde arriba
            // mas info sobre metodos recursivos https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=123&punto=&inicio=#:~:text=En%20Java%20los%20m%C3%A9todos%20pueden,nuevas%20variables%20locales%20y%20par%C3%A1metros.
        }
        return frase;
    }
}




class Ejercicios {
    private String frase;

    public Ejercicios(String frase){
        this.frase = frase;
    }

    public  int calcularLineas(){
        int lineas = (int)(this.frase.length() / 80);

        if (lineas == 0){
            lineas = 1;
        }

        System.out.println("Numbero de lineas: " + lineas);
        return lineas;
    }
}