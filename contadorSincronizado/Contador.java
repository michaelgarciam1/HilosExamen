package contadorSincronizado;

public class Contador {
    private int contador;

    public Contador() {
        this.contador = 0;
    }

    public synchronized void incrementar() {
        this.contador++;
    }

    public synchronized void decrementar() {
        this.contador--;
    }

    public int getContador() {
        return this.contador;
    }

}
