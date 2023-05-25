package com.example.proj_nevera;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fitxers {

    Fitxers() {
    }

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

    public void mostraFitxerText(String fitxer) throws IOException {
        System.out.println(this.retornaFitxerText(fitxer));
    }
    public void escriuObjecteFitxer(Object obj, String arxiu,boolean afegir)throws IOException{

        if(!afegir || !existeix(arxiu)){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(arxiu,afegir));
            out.writeObject(obj);
        }else{
            MeuObjecteOutputStream out2 =new MeuObjecteOutputStream(new FileOutputStream(arxiu,afegir));
            out2.writeObject(obj);
        }
    }

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

    public boolean existeix(String ruta) {
        // Comprova la existència d'un directori o un fitxer
        Path fitxer = Paths.get(ruta);         // Path --> import java.nio.file.Path;
        // Paths --> import java.nio.file.Paths
        return Files.exists(fitxer);    // Files --> import java.nio.file.Files
    }
}
