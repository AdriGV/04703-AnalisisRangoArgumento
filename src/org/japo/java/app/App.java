/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.app;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author CicloM
 */
public final class App {

    //Scan
    public static final Scanner SCN
            = new Scanner(System.in, "ISO-8859-1")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    //Constantes
    public static final int NUM = 0;
    public static final int MIN = 1;
    public static final int MAX = 10;
    public static final String MSG_USR = "Número ......: ";
    public static final String MSG_MIN = "Mínimo ......: ";
    public static final String MSG_MAX = "Máximo ......: ";
    public static final String MSG_ANA = "Análisis ....: ";
    public static final String MSG_ERR = "Error";

//    static {
//        final Random RND = new Random();
//        
//
//        MAX = RND.nextInt();
//        MIN = RND.nextInt();
//    }

    public final void launchApp() {
        System.out.println("ANÁLISIS DE RANGO");
        System.out.println("=================");
        int valor;

 
        valor = analizarRango(NUM, MIN, MAX);
       
             switch (valor){
            case 0:
                System.out.println(MSG_ANA + "DENTRO");
                break;
            case 1: 
                System.out.println(MSG_ANA + "FUERA ( Abajo )");
                break;
            case 2:
                System.out.println(MSG_ANA + "FUERA ( Arriba )");
        }
    

    

    

    
    }
    public static final int analizarRango(double num, int min, int max){
       boolean errorOK = true;     
       int valor = 0;
        do {
            try {
                System.out.print(MSG_USR);
                num = SCN.nextInt();
                if (num > min && num < max) {
                    valor = 0;
                } else if (num < min) {
                    valor = 1;
                } else if (num> max) {
                    valor = 2;
                }
                errorOK = false;

            } catch (Exception e) {
                System.out.println(MSG_ERR);
                System.out.println("---");

            } finally {
                SCN.nextLine();
            }
        } while (errorOK);

        System.out.println("---");
        System.out.printf(MSG_MIN + "%d%n", min);
        System.out.printf(MSG_MAX + "%d%n", max);
        System.out.println("---");

        return valor;
    }
}
