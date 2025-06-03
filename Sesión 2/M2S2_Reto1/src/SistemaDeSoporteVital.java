import java.util.concurrent.Callable;

// Monitorea presión, oxígeno y condiciones internas.
public class SistemaDeSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
