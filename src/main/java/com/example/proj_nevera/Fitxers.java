package com.example.proj_nevera;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Una classe fitxers per crear, modificar i eliminar
 */
public class Fitxers {

    Fitxers() {
    }

    /**
     * Escriu fitxer en un text.
     *
     * @param arxiu  l'arxiu on es guarda el text
     * @param text   el text que s'afegirà
     * @param afegir true per afegir text o false per sobreescriure
     * @throws IOException the io exception
     */
    public void escriuFitxerText(String arxiu, String text, Boolean afegir) throws IOException {
        FileWriter out = new FileWriter(arxiu, afegir);
        Throwable var5 = null;

        try {
            out.write(text + "\n");
        } catch (Throwable var14) {
            var5 = var14;
            throw var14;
        } finally {
            if (out != null) {
                if (var5 != null) {
                    try {
                        out.close();
                    } catch (Throwable var13) {
                        var5.addSuppressed(var13);
                    }
                } else {
                    out.close();
                }
            }

        }

    }

    /**
     * Retorna un fitxer de text a un string.
     *
     * @param fitxer el nom del fitxer o el seu camí
     * @return un string d'una línia
     * @throws IOException the io exception
     */
    public String retornaFitxerText(String fitxer) throws IOException {
        String linia = "";
        FileReader in = new FileReader(fitxer);
        Throwable var4 = null;

        try {
            for(Scanner input = new Scanner(in); input.hasNextLine(); linia = linia + input.nextLine() + "\n") {
            }
        } catch (Throwable var13) {
            var4 = var13;
            throw var13;
        } finally {
            if (in != null) {
                if (var4 != null) {
                    try {
                        in.close();
                    } catch (Throwable var12) {
                        var4.addSuppressed(var12);
                    }
                } else {
                    in.close();
                }
            }

        }

        return linia;
    }

    /**
     * Mostra fitxer text per consola.
     *
     * @param fitxer el nom del fitxer o el seu camí
     * @throws IOException the io exception
     */
    //@Override
    public void mostraFitxerText(String fitxer) throws IOException {
        System.out.println(this.retornaFitxerText(fitxer));
    }

    /**
     * Escriu un objecte en un fitxer.
     *
     * @param obj    l'obj que volem pasar les dades a un fitxer
     * @param arxiu  l'arxiu on el volem guardar
     * @param afegir true per afegir false per sobreescriure
     * @throws IOException the io exception
     */
    public void escriuObjecteFitxer(Object obj, String arxiu,boolean afegir)throws IOException{

        if(!afegir || !existeix(arxiu)){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(arxiu,afegir));
            out.writeObject(obj);
        }else{
            MeuObjecteOutputStream out2 =new MeuObjecteOutputStream(new FileOutputStream(arxiu,afegir));
            out2.writeObject(obj);
        }
    }

    /**
     * Retorna fitxer objecte en una llista list.
     *
     * @param fitxer la ruta del fitxer
     * @return the list retorna en una llista l'objecte
     * @throws ClassNotFoundException the class not found exception
     */
    public List<Object> retornaFitxerObjecteEnLlista(String fitxer)throws  ClassNotFoundException{
        List<Object> LObjs =new ArrayList<>();
        try{
            ObjectInputStream in=new ObjectInputStream(
                    new FileInputStream(fitxer));
            do{
                Object obj=in.readObject();
                LObjs.add(obj);
            }while (in!=null);
            in.close();
            in=null;
        }catch (IOException e){
//...
        }
        return  LObjs;
    }

    /**
     * Existeix boolean.
     *
     * @param ruta the ruta
     * @return the boolean
     */
    public boolean existeix(String ruta) {
        // Comprova la existència d'un directori o un fitxer
        Path fitxer = Paths.get(ruta);         // Path --> import java.nio.file.Path;
        // Paths --> import java.nio.file.Paths
        return Files.exists(fitxer);    // Files --> import java.nio.file.Files
    }


}
