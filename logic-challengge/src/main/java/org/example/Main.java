package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.println("/**********************Reto de números primos****************************/");
        for(int i = 0; i<=100; i++)
            esPrimo(i);
        System.out.println("\n");

        System.out.println("/**********************Reto de ordenamiento de cadenas*******************/");
        ordenarCadenas("perro gato casa");
        System.out.println("\n");

        System.out.println("/**********************Reto de palíndromos*******************************/");
        System.out.println(esPalindromo("azaa"));
        System.out.println("\n");

        System.out.println("/**********************Reto de Fibonacci*********************************/");
        System.out.println(fibonacci(20));
        System.out.println("\n");

        System.out.println("/**********************Reto de suma de dos números***********************/");
        System.out.println(sumaDosNumeros(new ArrayList<>(Arrays.asList(8,12,4,0,6,9,7,6,1)), 13));
        System.out.println("\n");
    }

    public static void esPrimo(int numero) {

        if(numero <= 1)
            System.out.println(numero + " no es primo");

        else {
            for(int i = 2; i<numero; i++){
                if(numero % i == 0) {
                    System.out.println(numero + " no es primo");
                    return;
                }
            }
            System.out.println(numero + " es primo");
        }
    }

    public static void ordenarCadenas(String cadenas) {

        ArrayList<String> listaCadenas = new ArrayList<>(Arrays.asList(cadenas.split(" ")));
        Collections.sort(listaCadenas);

        for (String palabra : listaCadenas){
            System.out.print(palabra+"\n");
        }
    }

    private static boolean esPalindromo(String cadena) {

        for(int i = 0, j=cadena.length()-1; i<cadena.length() && j>i; i++, j--) {
            if(cadena.toLowerCase().charAt(i)!=cadena.toLowerCase().charAt(j))
                return false;
        }

        return true;
    }

    private static ArrayList<Integer> fibonacci(int cantidad) {
        ArrayList<Integer> numeros = new ArrayList<>();

        for(int i=0; i<cantidad;i++){
            if(i == 0 || i == 1)
                numeros.add(i);

            else
                numeros.add(numeros.get(i-2) + numeros.get(i-1));
        }

        return numeros;
    }

    private static String sumaDosNumeros(ArrayList<Integer> integers, Integer objetivo) {

        for(int i=0; i<integers.size(); i++) {
            for(int j=i+1; j<integers.size(); j++) {
                if(integers.get(i)+ integers.get(j) == objetivo){
                    return integers.get(i)+ ", " + integers.get(j);
                }
            }
        }

        return "None";
    }
}