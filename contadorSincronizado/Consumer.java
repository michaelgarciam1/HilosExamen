package contadorSincronizado;

public class Consumer implements Runnable{
    
    private Contador contador;

    public Consumer(Contador contador) {
        this.contador = contador;
    }

    public void consumir() {
        for(int i = 0; i < 100; i++) {
            this.contador.decrementar();        }
    }

    @Override
    public void run() {
        consumir();
    }

}
