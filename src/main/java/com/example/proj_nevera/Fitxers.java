package com.example.proj_nevera;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
}
