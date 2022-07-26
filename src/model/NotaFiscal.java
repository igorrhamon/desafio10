package model;

import java.util.HashMap;
import java.util.Map;

public class NotaFiscal implements Runnable{

    private Map<String, Integer> produtos = new HashMap<>();

    public NotaFiscal(Map<String, Integer> produtos) {
        this.produtos = produtos;
    }
    @Override
    public void run() {
        System.out.println("Nota fiscal emitida");
    }
    
}