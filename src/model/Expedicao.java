package model;

import java.util.HashMap;
import java.util.Map;

public class Expedicao{

    private Map<String, Integer> produtos = new HashMap<>();

    public Expedicao(Map<String, Integer> produtos) {
        this.produtos = produtos;
    }

    
}