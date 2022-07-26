package service.estoque;

import model.Compra;
import model.Estoque;
import model.Produto;

public class BloqueiaEstoqueService implements Runnable {

    
    private Estoque estoque;
    private Compra compra;
    
    
    
    public BloqueiaEstoqueService(Compra compra, Estoque estoque) {
        this.compra = compra;
        this.estoque = estoque;
    }
    @Override
    public void run() {
        
        
        synchronized(this){
            for(Produto produto : compra.getProdutos().keySet()) {
                estoque.getItens().put(produto, estoque.getItens().get(produto) - compra.getProdutos().get(produto));
            }
            System.out.println("Estoque bloqueado");
            notify();
        }


    
    }
   
}
