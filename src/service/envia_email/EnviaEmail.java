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
        System.out.println("Email enviado com sucesso");
        
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}
