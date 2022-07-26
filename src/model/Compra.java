package model;

import java.util.HashMap;
import java.util.Map;

public class Compra {
    private Map<Produto, Integer> itens;
    private double valorTotal;

    public Compra(Map<Produto, Integer> itens) {
        this.itens = itens;
        
        double valorTotal = 0;
        for (Produto produto : itens.keySet()) {
            valorTotal += produto.getPreco() * itens.get(produto);
        }
        this.valorTotal = valorTotal;
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Produto, Integer> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Map<Produto, Integer> getProdutos() {
        
        Map<Produto, Integer> produtos = new HashMap<>();
        for (Produto produto : itens.keySet()) {
            produtos.put(produto, itens.get(produto));
        }
        return produtos;
    }


    
}
