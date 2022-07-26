package model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> itens;

    private boolean estoqueBloqueado = false;

    public boolean isEstoqueBloqueado() {
        return estoqueBloqueado;
    }

    public Estoque() {
        this.itens = new HashMap<>();
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 30.0);

        itens.put(produto1, 1);
        itens.put(produto2, 2);
        itens.put(produto3, 3);
        
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public void diminuiEstoque(Produto produto, Integer integer) {
        itens.put(produto, itens.get(produto) - integer);
        
    }


    
    
}
