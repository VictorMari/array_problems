package org.example;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        String frase = SolicitarFrase();
        Ejercicios tarea = new Ejercicios(frase);
        menu(tarea);
    }


    public static void menu(Ejercicios tarea) {
        int opcion = imprimirMenu();
        switch (opcion){
            case 1: tarea.calcularLineas(); break;
            case 2: tarea.numeroDePalabras(); break;
            case 3: tarea.numeroDePalabrasSinValidar(); break;
            case 4: tarea.numeroDePalabras(); break;
            case 5: tarea.mostrarPalabras(); break;
            case 6: tarea.numeroDeRepeticiones("asdf"); break;
            case 7: tarea.convertirMallusculas(); break;
        }

        menu(tarea); //otra llamada recursiva
    }

    public static int imprimirMenu() {
        StringBuilder output = new StringBuilder("--------- Menu de ejercicios ---------\n");
        output.append("1. Mostrar numero de lineas\n");
        output.append("2. Mostrar numero de palabras (con espacios)\n");
        output.append("3. Mostrar nuemro de palabras (sin espacios)\n");
        output.append("4. Mostrar palabras individuales\n");
        output.append("5. Mostrar repeticiones de una palabra\n");
        output.append("6. Mostrar palabras capitalizadas\n");
        output.append("7. Mostar palabras en order alfabetico y alfabetico invertido\n");
        output.append("8. Comprobar si la frase contiene una fecha\n");
        output.append("9. Comprobar si la frase tiene una matricula\n");
        output.append("10. Comprobar si la frase tiene un email\n");
        output.append("--------- --------- ---------\n");
        System.out.println(output);

        Scanner in = new Scanner(System.in);
        int seleccion = 0;
        try {
            seleccion = in.nextInt();
            if (seleccion > 11 || seleccion < 1) {
                System.out.println("Introduce los numerod dentro del rango 1 - 11");
                return imprimirMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Introduzca solo digitos");
            return imprimirMenu(); // llamada recursiva
        } catch (Exception e) {
            System.out.println("Algo salio mal introduzca la opcion de nuevo");
            return imprimirMenu(); // llamada recursiva
        }
        return seleccion;

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

    public int numeroDePalabrasSinValidar() {
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
            if (indexInicial == -1) {
                break;
            }
            repeticiones++;
            indexInicial++;
        }
        System.out.println("Repeticiones de la palabra " + palabraRepetida + ": " + repeticiones);

        return repeticiones;
    }

    public void convertirMallusculas() {
        List<String> palabrasCapitalizadas = new ArrayList<String>();
        for (String palabra : this.palabras) {
            String letraCapitalizada = "" + Character.toUpperCase(palabra.charAt(0));
            String palabraCapitalizada = new StringBuilder(palabra)
                    .replace(0, 1, letraCapitalizada)
                    .toString();
            palabrasCapitalizadas.add(palabraCapitalizada);
        }
        this.palabrasCapitalizadas = palabrasCapitalizadas.toArray(new String[0]);
    }

    public void ordenarAlfabeticamente() {
        this.ordenAlfabetico = this.palabras;
        Arrays.sort(this.ordenAlfabetico);
        System.out.println("Orden alfabetico: " + Arrays.toString(this.ordenAlfabetico));
    }

    public void ordenarAlfabeticamenteInvertido() {
        this.ordenAlfabeticoInvertido = this.palabras;
        Arrays.sort(this.ordenAlfabeticoInvertido, Comparator.<String>reverseOrder());
        System.out.println("Orden alfabetico invertido: " + Arrays.toString(this.ordenAlfabeticoInvertido));
    }

    public boolean comprobarFecha(){
        return true;
    }

    public boolean comprobarMatricula(){
        return true;
    }

    public boolean comprobarEmail(){
        return true;
    }
}