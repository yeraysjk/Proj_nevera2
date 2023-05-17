package com.example.proj_nevera;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import com.example.proj_nevera.Funcions_nevera;

import java.io.*;

/**
 * The type Hello controller.
 */
public class HelloController {
    /**
     * The Preu entrada.
     */
    public TextField preu_entrada;
    /**
     * The Descripcio entrada.
     */
    public TextField descripcio_entrada;
    /**
     * The Data entrada.
     */
    public DatePicker data_entrada;
    /**
     * The Producte entrada.
     */
    public TextField producte_entrada;
    /**
     * The Guardar entrada.
     */
    public Button guardar_entrada;
    /**
     * The Nom entrada.
     */
    public TextField nom_entrada;

    private String input;
    /**
     * The File name.
     */
    String fileName;

    /**
     * Escriure binari.
     *
     * @param actionEvent the action event
     */
    public void escriureBinari(ActionEvent actionEvent) {
        String espacio="-";
        input=this.nom_entrada.getText()+espacio+
                this.preu_entrada.getText()+espacio+
                this.descripcio_entrada.getText()+espacio+
                this.data_entrada.getValue();
        fileName=nom_entrada.getText();
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeUTF(input);
            System.out.println("La cadena se ha guardado correctamente en el archivo binario.");
            producte_entrada.setText(input);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo binario: " + e.getMessage());
        }
    }

    /**
     * Llegir binari string.
     *
     * @param fileName the file name
     * @return the string
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
        // Código de inicio de la aplicación
    }
    }



