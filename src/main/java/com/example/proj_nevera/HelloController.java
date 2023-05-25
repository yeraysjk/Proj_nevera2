package com.example.proj_nevera;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    public Text mostrar_producte;

    /**-
    public void BTguardar() throws IOException {
        String nom =nom_entrada.getText();

        double preu= Double.parseDouble(preu_entrada.getText());
        String descripcio=descripcio_entrada.getText();
        String data= String.valueOf(data_entrada.getValue());
        mostrar_producte.setText(nom+preu+descripcio+data);
        Producte prod=new Producte(nom,preu,descripcio,data);

        prod.guardarProducteFitxer();


    }

    public void cercarProducte{


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



