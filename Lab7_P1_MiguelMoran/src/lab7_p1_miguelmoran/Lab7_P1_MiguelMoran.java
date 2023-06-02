/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7_p1_miguelmoran;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author flash
 */
public class Lab7_P1_MiguelMoran {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir = true;
        while (seguir) {
            System.out.println("1.She shoot, she scores");
            System.out.println("2.Piedra, papel o...");
            System.out.println("3.Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    boolean val = true;
                    int col = 0;
                    int fil = 0;
                    while (val) {
                        val = false;
                        System.out.print("Ingrese el numero de columnas que desea que tenga el tablero: ");
                        col = sc.nextInt();
                        System.out.print("Ingrese el numero de filas que desea que tenga el tablero: ");
                        fil = sc.nextInt();
                        if (col * fil > 87) {
                            val = true;
                            System.out.println("El tablero ingresado es demasiado grande, porfavor ingrese un tablera mas pequeño");
                        } else if (col * fil <= 0) {
                            val = true;
                            System.out.println("El tablero ingresado es invalido");
                        }
                        
                    }
                    int[][] tablero = Gen(fil, col);
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    break;

                case 2:
                    int e = 0;
                    while (e > 5 || e < 1) {
                        System.out.println("1.Tijera");
                        System.out.println("2.Papel");
                        System.out.println("3.Piedra");
                        System.out.println("4.Lizard");
                        System.out.println("5.Spock");
                        System.out.print("Seleccione una de las opciones: ");
                        e = sc.nextInt();
                        if (e > 5 || e < 1) {
                            System.out.println("Porfavor elija una opcion valida");
                        }
                    }
                    int j = e - 1;
                    int c = rand.nextInt(4);
                    int npc = c + 1;
                    System.out.println("La computadora elijio " + npc);
                    int[][] eval = MatrizInteracciones();
                    int result = eval[c][j];
                    switch(result){
                        case 0:
                            System.out.println("Empate");
                            break;
                            
                        case 1:
                            System.out.println("El jugador gana!");
                            break;
                            
                        case 2:
                            System.out.println("La computadora gana!");
                            break;
                    }
                    break;

                case 3:
                    seguir = false;
                    break;

                default:
                    System.out.println("Porfavor ingrese una opcion valida");
            }
        }
    }

    public static int[][] Gen(int x, int y) {
        int[][] tablero1 = new int[x][y];
        int h = rand.nextInt(y);
        int w = rand.nextInt(x);
        int cont = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tablero1[i][j] = cont;
            cont += 1;   
            }
        }
        return tablero1;
    }

    public static int[][] MatrizInteracciones() {
        int[][] interac = new int[5][5];
        for (int i = 0; i < interac.length; i++) {
            for (int j = i + 1; j < interac.length; j++) {
                interac[i][j] = (i + j) % 2 + 1;
            }
        }
        for (int i = 1; i < interac.length; i++) {
            for (int j = 0; j < i; j++) {
                int n = (i + j) % 2;
                if (n == 1) {
                    interac[i][j] = 1;
                } else {
                    interac[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < interac.length; i++) {
            interac[i][i] = 0;
        }
        return interac;
    }

}
