package model;

import java.math.BigDecimal;

public class Pagamento  {
    private boolean pagamentoRealizado;
    private Compra compra;

    
    public Pagamento(Compra compra) {
        this.compra = compra;
    
    }

    public boolean isPagamentoRealizado() {
        return pagamentoRealizado;
    }

    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
    }

    public Double getValorTotal() {
        return compra.getValorTotal();
    }

        
}
