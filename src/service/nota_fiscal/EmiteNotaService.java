package service.nota_fiscal;

import model.Compra;
import model.NotaFiscal;

public class EmiteNotaService implements Runnable {

    
    private Compra compra;

    public EmiteNotaService(  Compra compra) {
        
        if(compra == null) {
            throw new IllegalArgumentException("NotaFiscal e Compra não podem ser nulos");
        }
        this.compra = compra;
    }

    @Override
    public void run() {
        synchronized(this){
        NotaFiscal notaFiscal = new NotaFiscal(compra);
        System.out.println("Nota Fiscal emitida com sucesso");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        notify();
        }
        
    }


    
}
