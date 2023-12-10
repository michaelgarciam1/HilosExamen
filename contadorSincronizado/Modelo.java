package contadorSincronizado;

public class Modelo {
    public static void main(String[] args) {
        new Modelo().inicio();
    }

    private void inicio() {
        parte1();

    }


    /*
     * En esta parte se crea un array de hilos de productores y consumidores
     * pero con el contador sincronizado , que simplemente se le ponen la palabra
     * synchronized a los metodos incrementar y decrementar en la clase Contador
     */
    private void parte1() {
        Contador contador = new Contador();

        Thread[] productores = new Thread[10];
        Thread[] consumidores = new Thread[10];

        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Producer(contador)); 
            productores[i].start();
        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumer(contador)); 
            consumidores[i].start();
        }
        System.out.println("El valor final del contador es: " + contador.getContador());
    }

}
