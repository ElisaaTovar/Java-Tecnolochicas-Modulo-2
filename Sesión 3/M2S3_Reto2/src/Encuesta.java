import java.util.Optional;

public class Encuesta {
    String nombre;
    String comentario; // Puede ser null
    int calificacion;


    public Encuesta (String nombre, String comentario, int calificacion){
        this.nombre = nombre;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    // Metodo que devuelve un Optional<String> si el comentario no existe (null).
    public Optional<String> getComentario() {return Optional.ofNullable(comentario);}

    public String getNombre() {return nombre;}
    public int getCalificacion(){return calificacion;}
}
