package com.example.proj_nevera;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Date;

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
     */
    public void escriureBinari() throws IOException {
        String nom =nom_entrada.getText();
        Double preu= Double.valueOf(preu_entrada.getText());
        String descripcio=descripcio_entrada.getText();
        String data= String.valueOf(data_entrada.getValue());

        Producte prod=new Producte(nom,preu,descripcio,data);

        prod.guardarProducteFitxer();
    }
    /**
     * Llegir binari string.
     *
     * @param fileName the file name
     * @return the string
     */


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        // Código de inicio de la aplicación
    }
    }



