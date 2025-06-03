import java.util.concurrent.Callable;

// Supervisa temperaturas internas y externas.
public class SistemaDeControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}
