/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedapalabraarchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xcheko51x
 */
public class BusquedaPalabraArchivo {

    static int lineasTotales;
    static int totalCoincidencias;
    
    public static void main(String[] args) {        
        // OBJETO ARCHIVO CON LA RUTA DE DONDE SE CREARA
        File archivo = new File("RUTA_DEL_ARCHIVO/Archivo.txt");
        // OBJETO PARA LEER EL TECLADO
        Scanner teclado = new Scanner(System.in);
        // PALABRA A BUSCAR EN EL TECLADO
        System.out.print("Escribe la palabra a buscar en el archivo: ");
        String palabra = teclado.nextLine();
        System.out.println("");
        // LLAMADA AL METODO PARA LEER EL ARCHIVO Y HACER LA BUSQUEDA
        buscarPalabra(archivo, palabra);
    }
    
    // METODO PARA LEER EL ARCHIVO Y HACER LA BUSQUEDA
    public static void buscarPalabra(File archivo, String palabra) {
        try {
            // SI EXISTE EL ARCHIVO
            if(archivo.exists()) {
                // ABRE LECTURA DEL ARCHIVO
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                // LINEA LEIDA
                String lineaLeida;
                // MIENTRAS LA LINEA LEIDA NO SEA NULL
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    lineasTotales = lineasTotales + 1;
                    String[] palabras = lineaLeida.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(palabra)) {
                            totalCoincidencias = totalCoincidencias + 1;
                            System.out.println(lineaLeida);
                            System.out.println("En la linea: " + lineasTotales + " se encontro la palabra a buscar: " + palabra);
                            System.out.println("");
                        }
                    }
                }
            }
            System.out.println("En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
