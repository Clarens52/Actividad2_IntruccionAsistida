/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2_intruccionasistida;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Clarens
 */
public class Actividad2_IntruccionAsistida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        int preguntasCorrectas = 0;
        int preguntasIncorrectas = 0;
        int totalPreguntas = 10;

        System.out.println("Bienvenido al programa de instrucciÃ³n asistida por computadora");
         System.out.println("Elige el nivel de dificultad:");
          System.out.println("1. NÃºmeros de un dÃ­gito");
           System.out.println("2. NÃºmeros de dos dÃ­gitos mÃ¡ximo");
            System.out.println("3. NÃºmeros de tres dÃ­gitos mÃ¡ximo");
             System.out.print("Escoja la opcion: ");
              int nivelDificultad = scanner.nextInt();

        System.out.println("Elige el tipo de problema aritmÃ©tico:");
         System.out.println("1. Suma");
          System.out.println("2. Resta");
           System.out.println("3. MultiplicaciÃ³n");
            System.out.println("4. DivisiÃ³n");
             System.out.println("5. Mezcla aleatoria");
              int tipoProblema = scanner.nextInt();

        while (preguntasCorrectas < totalPreguntas) {
            int numero1 = generarNumeroAleatorio(nivelDificultad);
             int numero2 = generarNumeroAleatorio(nivelDificultad);
              String operador = obtenerOperadorAritmetico(tipoProblema);

            int resultado = realizarOperacion(numero1, numero2, operador);
             System.out.print("Â¿CuÃ¡nto es " + numero1 + " " + operador + " " + numero2 + "? ");
              int respuestaUsuario = scanner.nextInt();

            if (respuestaUsuario == resultado) {
                preguntasCorrectas++;
                System.out.println(obtenerRespuestaPositivaAleatoria());
            } 
            else {
                preguntasIncorrectas++;
                System.out.println(obtenerRespuestaNegativaAleatoria());
            }
        }

        double porcentajeCorrecto = (double) preguntasCorrectas / totalPreguntas * 100;

        if (porcentajeCorrecto >= 75) {
            System.out.println("Felicidades, estÃ¡s listo para pasar al siguiente nivel!");
        } 
        else {
            System.out.println("Por favor pide ayuda adicional a tu instructor.");
        }

        System.out.println("Rendimiento del estudiante:");
         System.out.println("Preguntas correctas: " + preguntasCorrectas);
          System.out.println("Preguntas incorrectas: " + preguntasIncorrectas);
           System.out.println("Porcentaje de respuestas correctas: " + porcentajeCorrecto + "%");
    }

    private static int generarNumeroAleatorio(int nivelDificultad) {
        Random random = new Random();
         int maximo = (int) Math.pow(10, nivelDificultad);
          return random.nextInt(maximo);
    }

    private static String obtenerOperadorAritmetico(int tipoProblema) {
        switch (tipoProblema) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            case 4:
                return "/";
            case 5:
                Random random = new Random();
                int operador = random.nextInt(4);
                switch (operador) {
                    case 0:
                        return "+";
                    case 1:
                        return "-";
                    case 2:
                        return "*";
                    case 3:
                        return "/";
                }
        }
        return "+";
    }

    private static int realizarOperacion(int numero1, int numero2, String operador) {
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                return numero1 / numero2;
        }
        return 0;
    }

    private static String obtenerRespuestaPositivaAleatoria() {
        String[] respuestasPositivas = {
                "Â¡Muy bien!",
                "Â¡Excelente!",
                "Â¡Buen trabajo!",
                "Â¡Sigue asÃ­!"
        };
        Random random = new Random();
        int indice = random.nextInt(respuestasPositivas.length);
        return respuestasPositivas[indice];
    }

    private static String obtenerRespuestaNegativaAleatoria() {
        String[] respuestasNegativas = {
                "No. Por favor intenta de nuevo.",
                "Incorrecto. Intenta una vez mÃ¡s.",
                "Â¡No te rindas!",
                "No. Sigue intentando."
        };
        Random random = new Random();
        int indice = random.nextInt(respuestasNegativas.length);
        return respuestasNegativas[indice];
    }
    }
    
    

