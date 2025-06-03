import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            Future<String> nav = executor.submit(new SistemaDeNavegacion());
            Future<String> vita = executor.submit(new SistemaDeSoporteVital());
            Future<String> temp = executor.submit(new SistemaDeControlTermico());
            Future<String> comu = executor.submit(new SistemaDeComunicaciones());

            try {
                System.out.println("🚀 Simulación de misión espacial iniciada...");
                // Devuelve el mensaje del sistema.
                System.out.println(comu.get());
                System.out.println(vita.get());
                System.out.println(temp.get());
                System.out.println(nav.get());

                System.out.println("✅ Todos los sistemas reportan estado operativo");

            } catch (RuntimeException | ExecutionException | InterruptedException e) {
                throw new RuntimeException("❌ Los sistemas presentan fallas.", e);
            } finally {
                executor.shutdown();
            }
    }
}