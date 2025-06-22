import java.util.concurrent.*;

public class MovilidadApp {
    // Simula la ruta óptima.
    public static CompletableFuture<String> calcularRuta (){
        return CompletableFuture.supplyAsync(()-> {
            try {
                System.out.println("🚦 Calculando ruta...");
                Thread.sleep(3000); // Simulando que la tarea tarda 3 segundos en completarse.
            } catch (InterruptedException e){
                throw new RuntimeException("❌ No se pudo calcular la ruta." + e);
            }
            return "Centro -> Norte";
        });
    }

    // Simula la estimación de la tarifa.
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("💰 Estimando la tarifa...");
            try {
                Thread.sleep(2000); // Simulando que la tarea tarda 2 segundos en completarse.
            } catch (InterruptedException e){
                throw new RuntimeException("❌ No pudo estimarse la tarifa." + e);
            }
            return 75.50;
        });
    }

    public static void main(String[] args) {
        // Metodo que combina ambas operaciones.
        CompletableFuture<Void> combinacion = calcularRuta()
                .thenCombine(estimarTarifa(), (ruta, tarifa) -> "✅ 🚗 Ruta Calculada: " + ruta +
                        " | Tarifa estimada: $" + tarifa)
                .thenAccept(System.out::println)
                .exceptionally(ex -> { // ❌ Maneja errores
                    System.out.println("🚨 Error en el proceso: " + ex.getMessage());
                    return null;
                });

        combinacion.join(); // Main espera hasta que se terminen las tareas.
    }
}