package com.example.proj_nevera;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * The Mostrar producte.
     */
    public Label mostrar_producte;

    /**
     * The Nom buscar.
     */
    public TextField nom_buscar;
    /**
     * The Producte trobat.
     */
    public Label producte_trobat;


    /**
     * Guardar producte en un fitxer amb el botó guardar i el mostra per la finestra
     *
     * @throws IOException the io exception
     */
    public void BTguardar() throws IOException {
        String nom = nom_entrada.getText();

        double preu = Double.parseDouble(preu_entrada.getText());
        String descripcio = descripcio_entrada.getText();
        String data = String.valueOf(data_entrada.getValue());
        mostrar_producte.setText("PRODUCTE AFEGIT \n" + nom + "\n" + preu + "\n" + descripcio + "\n" + data);
        Producte prod = new Producte(nom, preu, descripcio, data);

        prod.guardarProducteFitxer();
    }

    /**
     * Cercar producte per nom i el mostra per la finestra
     *
     * @throws ClassNotFoundException the class not found exception
     * @throws FileNotFoundException  the file not found exception
     * @throws InterruptedException   the interrupted exception
     */
    public void cercarProducte() throws ClassNotFoundException, FileNotFoundException, InterruptedException {
        String nom = nom_buscar.getText();
        Producte producto = new Producte();
        List<Producte> resultados = new ArrayList<>();
        producto.ProducteLlista();
        List<Producte> lProductes = producto.retornaProductesFitxerBinariEnLlista();

        for (Producte pr : lProductes) {
            // Compara el nombre del producto con el nombre buscado
            if (pr.getNom().equals(nom)) {
                producte_trobat.setText("PRODUCTE TROBAT \n" +
                        pr.getNom() + "\n" +
                        pr.getPreu() + "\n" +
                        pr.getDescripcio() + "\n" +
                        pr.getData());
            }

        }

    }
}






