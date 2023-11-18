/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_josafatmoncada_;

import java.util.Scanner;
import java.util.Random;
        
public class Lab6P1_JosafatMoncada_ {

    

    public static String genRandCharArray(int Tamaño) {
        String result = "";
        for (int i = 0; i < Tamaño; i++) {
            result += (char) (65 + (int) (Math.random() * 9));
        }
        return result;
    }//genRandCharArray

    public static void printArray(String Array) {
        System.out.print("[");
        for (int i = 0; i < Array.length(); i++) {
            System.out.print(Array.charAt(i));
            if (i < Array.length() - 1) {
                System.out.print("][");
            }
        }
        System.out.println("]");
    }//PrintArray

    public static String intersection(String set1, String set2) {
        String result = "";
        for (int i = 0; i < set1.length(); i++) {
            char actual = set1.charAt(i);
            if (set2.contains(String.valueOf(actual))) {
                result += actual;
            }
        }
        return result;
    }//Intersection

    public static String difference(String SET1, String SET2) {
        String result = "";
        for (int j = 0; j < SET1.length(); j++) {
            char actual = SET1.charAt(j);
            if (!SET2.contains(String.valueOf(actual))) {
                result += actual;
            }
        }
        return result;
    } //Difference
    

    public static int[] genRandArray(int Tamaño, int limiteInferior, int limiteSuperior) {
        
        int[] array = new int[Tamaño];
        Random ran = new Random();
        for (int i = 0; i < Tamaño; i++) {
            array[i] = ran.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            }

        return array;
        }

    public static boolean isPrime(int numero) {
    if (numero <= 1) {
        return false;
        }
    
    for (int i = 2; i <= Math.sqrt(numero); i++) {
        
        if (numero % i == 0) { 
            return false;
            }
        }

        return true;
    }

    public static int countPrimeFactors(int numero) {
        int count = 0;
        for (int i = 2; i <= numero; i++) {
            while (numero % i == 0 && isPrime(i)) {
                count++;
                numero /= i;
            }
        }

        return count;
    }

    public static int[] getTotalPrimeCount(int[] array) {
        int[] cuenta = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            cuenta[i] = countPrimeFactors(array[i]);
        }

        return cuenta;
    }
  

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcion = 0;
        while (opcion !=2) {
            System.out.println("****MENU****");
            System.out.println("Elija el ejercicio:");
            System.out.println("1.Conjuntos");
            System.out.println("2.Cuantos primos tenes?");
            System.out.println("3. Salir del programa");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{

                    System.out.println("Conjuntos");
                    Scanner Scanner = new Scanner(System.in);

                    System.out.print("Size SET1: ");
                    int size1 = Scanner.nextInt();

                    System.out.print("Size SET2: ");
                    int size2 = Scanner.nextInt();

                    String set1 = genRandCharArray(size1);
                    String set2 = genRandCharArray(size2);

                    System.out.println("Conjunto 1:");
                    printArray(set1);
                    System.out.println("Conjunto 2:");
                    printArray(set2);

                    System.out.println("Operaciones ");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingresar una opcion:");
                    
                    char operacion = Scanner.next().charAt(0);

                switch (operacion) {
                    case '1' ->                         {
                            String result = intersection(set1, set2);
                            System.out.println("INTERSECTION(SET1,SET2):");
                            printArray(result);
                        }
                    case '2' ->                       {
                            String result = difference(set1, set2);
                            System.out.println("DIFFERENCE(SET1,SET2):");
                            printArray(result);
                        }
                    default -> System.out.println("Opcion invalida.");
                }
                
           

                    break;
                }
                case 2:{
                    
                    System.out.println("¿Cuántos primos tienes?");
                    Scanner scanner = new Scanner (System.in);
                   

                    System.out.print("Ingrese el tamaño del arreglo a generar: ");
                    int Tamaño = scanner.nextInt();

                    while (Tamaño <= 1) {
                        System.out.println(" Inténtelo nuevamente.");
                        System.out.print("Ingresar el tamaño del arreglo a generar: ");
                        Tamaño = scanner.nextInt();
                    }

                    System.out.print("Ingrese el límite inferior: ");
                    int limiteInferior = scanner.nextInt();

                    System.out.print("Ingrese el límite superior: ");
                    int limiteSuperior = scanner.nextInt();

                    while (limiteSuperior <= limiteInferior) {
                        System.out.println("Inténtelo nuevamente.");
                        System.out.print("Ingrese el límite superior: ");
                        limiteSuperior = scanner.nextInt();
                    }
                    
                    int[] randomArray = genRandArray(Tamaño, limiteInferior, limiteSuperior);

                    System.out.print("Arreglo generado: [");
                    for (int i = 0; i < Tamaño; i++) {
                        System.out.print(randomArray[i]);
                        if (i < Tamaño - 1) {
                            System.out.print("][");
                        }
                    }
                    System.out.println("]");

                    int[] primeCounts = getTotalPrimeCount(randomArray);
                    System.out.print("No divisores primos: [");
                    for (int i = 0; i < Tamaño; i++) {
                        System.out.print(primeCounts[i]);
                        if (i < Tamaño - 1) {
                            System.out.print("][");
                        }
                    }
                    System.out.println("]");
               
                    break;
                }
                case 3:
                    System.out.println("Salio del programa");
                    break;
            }
                    
        }//fin clase
        
    }//FIn programa
    
}
