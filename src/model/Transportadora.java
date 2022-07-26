package model;

import java.util.HashMap;
import java.util.Map;

public class Transportadora implements Runnable{

    private Map<String, Integer> produtos = new HashMap<>();

    public Transportadora(Map<String, Integer> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void run() {
        System.out.println("Aviso foi enviado para Transportadora");
    }
    
}
