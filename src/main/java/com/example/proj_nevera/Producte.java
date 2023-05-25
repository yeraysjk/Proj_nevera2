package com.example.proj_nevera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import static com.example.proj_nevera.Funcions_nevera.scan;

public class Producte {
    Fitxers f = new Fitxers();

    private String fitxer = "C:\\Users\retil\\IdeaProjects\\_57_funcioSuma\\Proj_nevera2\\DadesProductes\\FitxerProductes.cvs";
    private String nom;
    private int preu;
    private String descripcio;
    private Date data;

    public Producte() {

    }

    public Producte(String nom, int preu, String descripcio, Date data) {
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
        this.data = data;
    }

    public String toString() {

        return nom + ";" + preu + ";" + descripcio + ";" + data;
    }

    public void guardarProducteFitxer() throws IOException {
        f.escriuFitxerText(fitxer, this.toString(), true);
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
        text = llegirFitxer(new File(fitxer));

        String[] parts = text.split(";");

        for (String part : parts) {
            System.out.print(part + " ");
        }
    }
    public static String[] cercarProducteNom(String fitxer ) {
        String Producte[];
        int cont = 0;
        System.out.println("diga'm el nom");
        String nomProdBuscar = scan.nextLine();
        String nomProducte[] = new String[]{llegirFitxer(new File(fitxer))};
        for (int i = 0; i < cont; i++) {
            if (nomProdBuscar.equals(nomProducte[0])) {
                System.out.println("s'ha trobat el producte" + nomProdBuscar);
                cont++;
            }else {
                System.out.println("no s'ha tobat el producte");
            }
        }

        return nomProducte;
    }
}
