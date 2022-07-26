package model;

public class NotaFiscal {

    private Compra compra;
    private Double total;

    public NotaFiscal(Compra compra) {
        this.compra = compra;
        this.total = compra.getValorTotal();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Double getTotal() {
        return total;
    }

    
    
}