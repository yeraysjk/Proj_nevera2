package com.example.proj_nevera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Producte implements Serializable {
    static Fitxers f = new Fitxers();
    static private String fitxerCsv = "productes.csv";
    static private String arxiu="nevera.dat";



    private String nom;
    private double preu;
    private String descripcio;
    private String data;

    public Producte() {

    }

    public Producte(String nom, double preu, String descripcio, String data) {
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
        this.data = data;
    }


    public String toString() {

        return nom + ";" + preu + ";" + descripcio + ";" + data;
    }

    public void guardarProducteFitxer() throws IOException {
        f.escriuObjecteFitxer(this,arxiu,true);
    }
    public void ProducteLlista() throws ClassNotFoundException {
        f.retornaFitxerObjecteEnLlista(arxiu);


    }



    public static String llegirFitxer(File fitxer) {
        String contingut = "";

        try {
            Scanner scanner = new Scanner(fitxer);

            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                contingut += linia + "\n";// al contingut se li van afegint línies
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return contingut;//String
    }

    public void mostrarProducte() throws IOException {
        String text = toString();
        text = llegirFitxer(new File(fitxerCsv));

        String[] parts = text.split(";");

        for (String part : parts) {
            System.out.print(part + " ");
        }
    }
    private List<Producte> converteixAlProducte(List<Object> lObjectes){
        List<Producte> productes=new ArrayList<>();
        Producte prod=new Producte();
        for(Object obj: lObjectes){
            prod=(Producte) obj;
            productes.add(prod);
        }
        return productes;
    }
    public List<Producte> retornaProductesFitxerBinariEnLlista() throws FileNotFoundException,InterruptedException,ClassNotFoundException{
        Fitxers f=new Fitxers();
        List<Object>objs=f.retornaFitxerObjecteEnLlista(arxiu);
        List<Producte>producte=converteixAlProducte(objs);
        return producte;
    }




}
