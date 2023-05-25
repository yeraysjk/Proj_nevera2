package com.example.proj_nevera;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MeuObjecteOutputStream extends ObjectOutputStream {

    public MeuObjecteOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MeuObjecteOutputStream() throws IOException, SecurityException {
        super();
    }

    protected void writeStreamHeader() throws IOException {

    }
}

