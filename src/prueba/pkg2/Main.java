
package prueba.pkg2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        Archivo archivo = null;

        try {
            archivo = new Archivo();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\nGestor de tareas\n=============");
            System.out.println("1.Agregar tarea:");
            System.out.println("2.Mostrar tarea");
            System.out.println("3.Completar tarea");
            System.out.println("4.Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = lea.nextInt();
            lea.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese tarea a agregar: ");
                    String nuevatarea = lea.nextLine();
                    try {
                        archivo.agregarTarea(nuevatarea + "\n");
                        System.out.println("Tarea agregada");
                    } catch (IOException e) {
                        System.out.println("No pudo agregarse la tarea " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        archivo.mostrartareas();
                    } catch (IOException e) {
                        System.out.println("Erro al mostrar las tareas " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Numero de tarea a completar: ");
                    int numtarea = lea.nextInt();
                    lea.nextLine(); 
                    try {
                        archivo.Completartarea(numtarea);
                        
                    } catch (IOException e) {
                        System.out.println("Error al completar la tarea " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            if (opcion == 4) {
                break;
            }
        }
    }
}
