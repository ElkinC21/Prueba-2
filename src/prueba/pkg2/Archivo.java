
package prueba.pkg2;


import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo {
private File archivo;


public Archivo() throws IOException{
archivo=new File("Tareas.txt");
archivo.createNewFile();
}
public void agregarTarea(String tarea) throws IOException{
    try (FileWriter archivoescribir = new FileWriter(archivo,true)) {
        archivoescribir.write("[]"+tarea);
        archivoescribir.flush();
    }

}
public void mostrartareas() throws IOException {
    FileReader fr = new FileReader(archivo);

    int c;
    String linea = "";
    int contador = 1;

    while ((c = fr.read()) != -1) {
        char letra = (char) c;

        if (letra == '\n') {
            System.out.println(contador + ". " + linea);
            linea = "";
            contador++;
        } else {
            linea += letra;
        }
    }
    
    if (!linea.isEmpty()) {
        System.out.println(contador + ". " + linea);
    }

    fr.close();
}


public void Completartarea(int numtarea) throws IOException {
    FileReader archivoleer = new FileReader(archivo);

    int c;
    String linea = "";
    String todo = "";
    int contador = 1;
    boolean existe = false;

    while ((c = archivoleer.read()) != -1) {
        char letra = (char) c;

        if (letra == '\n') {
            if (contador == numtarea) {
                linea = "[✔]" + linea.substring(2);
                existe = true;
            }
            todo += linea + "\n";
            linea = "";
            contador++;
        } else {
            linea += letra;
        }
    }

    
    if (!linea.isEmpty()) {
        if (contador == numtarea) {
            linea = "[✔]" + linea.substring(2);
            existe = true;
        }
        todo += linea + "\n";
    }

    archivoleer.close();

    if (!existe) {
        System.out.println("No se encontro la tarea numero " + numtarea);
        return; 
    }
    System.out.println("Tarea Completada");
    
    FileWriter fw = new FileWriter(archivo);
    fw.write(todo);
    fw.close();
}



}
