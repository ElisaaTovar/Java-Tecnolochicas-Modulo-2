import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional){
        lock.lock(); // Bloquea el acceso al recurso.
        try {
            System.out.println("🧑‍⚕️ " + profesional + " ha ingresado a la " + nombre);
            Thread.sleep(2000); // Simula el tiempo de uso del recurso.
            System.out.println("✅ " + profesional + " ha salido de la " + nombre);
            Thread.sleep(1000); // Tiempo entre cambio de profesional.
        } catch (InterruptedException e) {
            throw new RuntimeException("❌ ¡Ingreso no permitido detectado!", e);
        } finally {
            lock.unlock(); // ⚠️ ¡Siempre liberar el lock!
        }

    }
}
