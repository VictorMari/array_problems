package org.example;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        String frase = SolicitarFrase();
        Ejercicios tarea6 = new Ejercicios(frase);
        tarea6.calcularLineas();
        tarea6.numeroDePalabrasConUnSoloEspacio();
        tarea6.numeroDePalabras();
        tarea6.mostrarPalabras();
        tarea6.numeroDeRepeticiones("asdf");
        tarea6.convertirMallusculas();
        tarea6.ordenarAlfabeticamente();
        tarea6.ordenarAlfabeticamenteInvertido();
    }

    public static String SolicitarFrase() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca una frase acabada en punto  ----> .");
        String frase = in.nextLine();
        boolean fraseMalFormada = true;

        char ultimaLetra = frase.charAt(frase.length() - 1);
        if (ultimaLetra != '.') {
            System.out.println("La frase no acaba en punto");
            return SolicitarFrase(); // LLamada recursiva
            //el mismo metodo se vuelve a llamar otra vez y se vuelve a ejecutar el codigo desde arriba
            // mas info sobre metodos recursivos https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=123&punto=&inicio=#:~:text=En%20Java%20los%20m%C3%A9todos%20pueden,nuevas%20variables%20locales%20y%20par%C3%A1metros.
        }
        return frase.trim(); //trim borra los espacios al principio y al final de cada string
    }
}


class Ejercicios {
    private String frase;
    private String[] palabras;
    private String[] palabrasCapitalizadas;
    private String[] ordenAlfabetico;
    private String[] ordenAlfabeticoInvertido;

    public Ejercicios(String frase) {
        this.frase = frase;
    }

    public int calcularLineas() {
        int lineas = (int) (this.frase.length() / 80);

        if (lineas == 0) {
            lineas = 1;
        }

        System.out.println("Numbero de lineas: " + lineas);
        return lineas;
    }

    public int numeroDePalabrasConUnSoloEspacio() {
        String[] palabras = this.frase.split(" ");
        System.out.println("Numero de palabras (Asumiendo que la frase este \"bien escrita\"): " + palabras.length);
        return palabras.length;
    }

    public int numeroDePalabras() {
        String[] palabras = this.frase.split(" ");
        int NumeroPalabras = 0;
        for (String palabra : palabras) {
            if (!palabra.equals("")) {
                NumeroPalabras += 1;
            }
        }
        System.out.println("Numero de palabras: " + NumeroPalabras);

        return NumeroPalabras;
    }

    public String[] mostrarPalabras() {
        List<String> palabrasIndividuales = new ArrayList<>();
        String[] palabras = this.frase.split(" ");
        for (String palabra : palabras) {
            if (!palabra.equals("")) {
                palabrasIndividuales.add(palabra);
                System.out.println("Palabra -----> " + palabra);
            }
        }
        this.palabras = palabrasIndividuales.toArray(new String[0]);
        return this.palabras;
    }

    public int numeroDeRepeticiones(String palabraRepetida) {
        StringBuilder frase = new StringBuilder(this.frase);
        int indexInicial = 0;
        int repeticiones = 0;
        while (true) {
            indexInicial = frase.indexOf(palabraRepetida, indexInicial);
            if (indexInicial == -1){
                break;
            }
            repeticiones++;
            indexInicial++;
        }
        System.out.println("Repeticiones de la palabra " + palabraRepetida + ": " + repeticiones);

        return repeticiones;
    }

    public void convertirMallusculas(){
        List<String> palabrasCapitalizadas = new ArrayList<String>();
        for (String palabra : this.palabras){
            String letraCapitalizada =  "" + Character.toUpperCase(palabra.charAt(0));
            String palabraCapitalizada = new StringBuilder(palabra)
                .replace(0, 1, letraCapitalizada)
                .toString();
            palabrasCapitalizadas.add(palabraCapitalizada);
        }
        this.palabrasCapitalizadas = palabrasCapitalizadas.toArray(new String[0]);
    }

    public void ordenarAlfabeticamente(){
        this.ordenAlfabetico = this.palabras;
        Arrays.sort(this.ordenAlfabetico);
        System.out.println("Orden alfabetico: " + Arrays.toString(this.ordenAlfabetico));
    }

    public void ordenarAlfabeticamenteInvertido(){
        this.ordenAlfabeticoInvertido = this.palabras;
        Arrays.sort(this.ordenAlfabeticoInvertido, Comparator.<String>reverseOrder());
        System.out.println("Orden alfabetico invertido: " + Arrays.toString(this.ordenAlfabeticoInvertido));
    }
}