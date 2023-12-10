package contadorSincronizado;
public class Producer implements Runnable{
    
    private Contador contador;

    public Producer(Contador contador) {
        this.contador = contador;
    }

    public void producir() {
        for(int i = 0; i < 100; i++) {
            this.contador.incrementar();
        }
    }

    @Override
    public void run() {
        producir();
    }

}