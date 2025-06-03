import java.util.concurrent.*; // Permite utilizar el paquete concurrent por completo.

public class Hospital {
    public static void main(String[] args){
        // Se crea el recurso médico.
        RecursoMedico recurso = new RecursoMedico("sala de cirugía");

        // Se da aviso de que alguien está intentando acceder a la sala de cirugía.
        System.out.println("🪪 Iniciando acceso a la  " + recurso.nombre + "...");

        // Se crea un ExecutorService con 4 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Representa a un médico o enfermero intentando usar el recurso médico.
        String[] nombreProfesional = new String[]{"Dra. Sánchez", "Dr. Gómez"};

        for (String nombre : nombreProfesional){
            Runnable ingreso = () -> recurso.usar(nombre);
            executor.submit(ingreso); // Se da acceso al recurso a través de uno de los 4 hilos ("lista de espera").
        }

        executor.shutdown(); // Cierra el pool.
    }
}