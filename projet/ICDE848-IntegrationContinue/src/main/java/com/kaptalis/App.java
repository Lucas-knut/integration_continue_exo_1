package com.kaptalis;

public class App {  

    // PMD va détecter cette variable car elle est privée 
    // et n'est lue nulle part dans le code.
    //private static int unusedVariable = 42;


       public static void main(String[] args) {
        System.out.println("Kaptalis Monitoring System - Active");
    }


    public static boolean isTemperatureValid(double temp) {
        // Température valide entre 2°C et 8°C
        return (temp >= 2.0 && temp <= 8.0);
    }
}

