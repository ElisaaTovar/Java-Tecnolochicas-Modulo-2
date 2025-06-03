import java.util.concurrent.Callable;

// Calcula trayectoria y correcciones orbitales.
public class SistemaDeNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simula el proceso con "sleep" y devuelve un mensaje.
        Thread.sleep(1000); // Pausa por 1 segundo.
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}
