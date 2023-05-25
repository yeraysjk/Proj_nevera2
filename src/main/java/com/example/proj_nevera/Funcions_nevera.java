package com.example.proj_nevera;
import java.io.*;
import java.util.Scanner;

/**
 * Classe que transforma l'arxiu de text a binari
 * @autor yeray.Priede marc.Retamal
 * @since x/5/12
 */
public class Funcions_nevera {
    static Scanner scan = new Scanner(System.in);

    //metode per demanar dades
    public static String demanarDades(String dada) {
        String valor;
        System.out.println("Introdueix " + dada + ": ");
        valor = scan.nextLine();
        return valor; //retorna el valor de la dada que ha preguntat
    }
    //metode per guardar les dades del producte
    public static void guardarProducte() throws IOException {
        String marca,color;
        int anyFabricacio;
        double preu;

        marca = demanarDades("marca");
        color = demanarDades("color");
        anyFabricacio = Integer.parseInt(demanarDades("any de fabriccacio"));
        preu = Double.parseDouble(demanarDades("preu"));
        Cotxe c = new Cotxe(marca,color,anyFabricacio,preu);
        c.guardarCotxeFitxer();

    }

    /**
     * Escriure binari.
     *
     * @param input    the input = cadena de text String
     * @param fileName the file name = nom de l'arxiu
     */
    public static void escriureBinari(String input, String fileName) {

            try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
                outputStream.writeUTF(input);
                System.out.println("La cadena se ha guardado correctamente en el archivo binario.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo binario: " + e.getMessage());
            }
        }

    /**
     * Llegir binari string.
     *
     * @param fileName the file name = nom de l'arxiu
     * @return the string = ???
     */
    public static String llegirBinari(String fileName) {
        String content = null;

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            content = inputStream.readUTF();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }

        return content;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String userInput = "¡Hola, mon!";
        String fileName = "archivo.bin2";
        escriureBinari(userInput, fileName);
        String content = llegirBinari(fileName);
        if (content != null) {
            System.out.println("Contenido del archivo binario: " + content);
        }
    }
}
