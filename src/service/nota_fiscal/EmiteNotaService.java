package service.nota_fiscal;

import model.Compra;
import model.NotaFiscal;

public class EmiteNotaService implements Runnable {

    private NotaFiscal notaFiscal;
    private Compra compra;

    @Override
    public void run() {
        synchronized (notaFiscal) {
            this.notaFiscal = new NotaFiscal(compra);
        }
        
    }
    
}
