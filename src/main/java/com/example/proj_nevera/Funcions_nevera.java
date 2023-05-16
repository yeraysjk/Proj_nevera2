package com.example.proj_nevera;
import java.io.*;

public class Funcions_nevera {

    public static void escriureBinari(String input, String fileName) {

            try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
                outputStream.writeUTF(input);
                System.out.println("La cadena se ha guardado correctamente en el archivo binario.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo binario: " + e.getMessage());
            }
        }
    public static String llegirBinari(String fileName) {
        String content = null;

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            content = inputStream.readUTF();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }

        return content;
    }

    public static void main(String[] args) {
        String userInput = "¡Hola, mundso!";
        String fileName = "archivo.bin2";
        escriureBinari(userInput, fileName);
        String content = llegirBinari(fileName);
        if (content != null) {
            System.out.println("Contenido del archivo binario: " + content);
        }
    }
}
