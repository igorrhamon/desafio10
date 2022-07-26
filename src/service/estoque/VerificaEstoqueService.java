package service.estoque;

import java.util.Map;

import model.Compra;
import model.Estoque;
import model.Produto;

public class VerificaEstoqueService {
    private Compra compra;
    private Estoque estoque;

    public VerificaEstoqueService(Compra compra, Estoque estoque) {
        this.compra = compra;
        this.estoque = estoque;
    }

    public void executa() {
        // Verifica se o produto está disponível no estoque
        System.out.println("Verificando estoque");
        if (this.isEstoqueDisponivel(compra.getProdutos())) {
            System.out.println("Produto disponível no estoque");
        } else {
            System.out.println("Produto não disponível no estoque");
        }
    }

    private boolean isEstoqueDisponivel(Map<Produto, Integer> produtos) {
        for (Map.Entry<Produto, Integer> produto : produtos.entrySet()) {
            if (estoque.getItens().get(produto.getKey()) < produto.getValue()) {
                return false;
            }
        }
        return true;
    }
    
}
