import java.util.concurrent.Callable;

// Establece contacto con la estación terrestre.
public class SistemaDeComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "📡 Comunicaciones: Enlace con estación terrestre 'Punpunia' establecido.";
    }
}
