import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    // Metodo genérico que muestra el detalle de todos los materiales.
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        for(MaterialCurso material : lista){
            System.out.println(material.MostrarDetalle());
        }
    }

    // Suma y muestra la duración total de los videos.
    public static void contarDuracionVideos(List<? extends Video> lista){
        int duracion = 0;
        for(Video video : lista){
            duracion += video.duracion;
        }
        System.out.println("\n📽️ Duración total de videos: " + duracion + " minutos.\n");
    }

    // Actualiza el estado de los ejercicios a revisado=true y muestra un mensaje por cada uno
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        lista.forEach(o ->{
            if (o instanceof Ejercicio ejercicio && !ejercicio.revisado) {
                ejercicio.revisado = true;
                System.out.println("✅ Ejercicio '" + ejercicio.titulo +"' marcado como revisado" );
            }
        });
    }

    // Metodo genérico que filtra materiales por autor
    public static void filtroPorAutor (List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro){
        System.out.println("\n🔎 Filtrando materiales por autor: ");
        for (MaterialCurso materialCurso : lista){
            if (filtro.test(materialCurso)){
                System.out.println(materialCurso.MostrarDetalle());
            }
        }
    }

    public static void main(String[] args) {
        // Se crea una lista general de los materiales.
        List<MaterialCurso> materiales = new ArrayList<>();

        // Se añaden todos los materiales a la lista de materiales.
        Video video1 = new Video("Introducción a Java", "Mario", 15);
        Video video2 = new Video("POO en Java", "Carlos", 20);

        Articulo articulo1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo articulo2 = new Articulo("Tipos de datos", "Luis", 800);

        Ejercicio ejercicio1 = new Ejercicio("Variables y tipos", "Luis", false);
        Ejercicio ejercicio2 = new Ejercicio("Condicionales", "Mario",false);

        materiales.add(video1);
        materiales.add(video2);
        materiales.add(articulo1);
        materiales.add(articulo2);
        materiales.add(ejercicio1);
        materiales.add(ejercicio2);

        List<Video> videos = List.of(video1, video2);

        // Detalles de los materiales, implementación de mostrarMateriales.
        System.out.println("📚 Materiales del curso: ");
        mostrarMateriales(materiales);

        // Muestra la duración total de los videos.
        contarDuracionVideos(videos);

        // Cambia el estado 'revisado' a true
        marcarEjerciciosRevisados(materiales);
        // Verifica que se hizo el cambio
        System.out.println("\n⚠️ Los detalles de algunos ejercicios han cambiado: ");
        mostrarMateriales(materiales);

        // Filtrado de materiales por autor.
        Predicate<MaterialCurso> escritoPor = material -> material.autor.equals("Mario");
        filtroPorAutor(materiales, escritoPor);
    }

}