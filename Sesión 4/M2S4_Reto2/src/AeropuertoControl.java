import java.util.concurrent.*;
import java.util.Random;

public class AeropuertoControl {
    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...");

        // Crea las tareas asíncronas.
        CompletableFuture<Boolean> pista = verificarPista();

        CompletableFuture<Void> aeropuertoControl = CompletableFuture.allOf(pista).thenAccept(verificar -> {
           try {
               boolean pistaEstado = pista.get();

               if (pistaEstado) { //&& clima && trafico && personal
                   System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
               } else {
                   System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
               }
           } catch (InterruptedException | ExecutionException e){
               throw new RuntimeException(e);
           }
        });

        aeropuertoControl.join();
    }

    // Usa valores aleatorios booleanos.
    private static final Random random = new Random();

    // Verifica la disponibilidad de la pista.
    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(()->{
            boolean disponibilidad = random.nextInt(100)<20;
            try {
                Thread.sleep(2000); // Simula latencia de 2s.
            } catch (InterruptedException e) {
                throw new RuntimeException("❌ No pudo verificarse la disponibilidad de la pista. " + e);
            }
            System.out.println("🛣️ Pista disponible: " + disponibilidad);
            return disponibilidad;
        });
    }

//    // Verifica el estado meteorológico.
//    public CompletableFuture<Boolean> verificarClima(){
//        return CompletableFuture.supplyAsync(()->{
//           return true;
//        });
//    }
//
//    // Verifica el estado del tráfico aéreo cercano.
//    public CompletableFuture<Boolean> verificarTraficoAereo(){
//        return CompletableFuture.supplyAsync(()->{
//            return true;
//        });
//    }
//
//    // Verifica la disponibilidad del personal en tierra.
//    public CompletableFuture<Boolean> verificarPersonalTierra(){
//        return CompletableFuture.supplyAsync(()->{
//            return true;
//        });
//    }
}