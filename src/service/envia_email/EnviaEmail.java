package service.envia_email;

import model.Compra;
import model.Email;

public class EnviaEmail implements Runnable{
    private Email email;
    private Compra compra;

    public EnviaEmail(Email email, Compra compra) {
        this.email = email;
        this.compra = compra;
    }

    @Override
    public void run() {
        synchronized(this) {
            try {
                System.out.println("Enviando email...");
                Thread.sleep(2000);
                System.out.println("Email enviado com sucesso");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
        
    }

    
}
