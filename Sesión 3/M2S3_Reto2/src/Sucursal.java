import java.util.List;

public class Sucursal {
    String nombre;
    List<Encuesta> encuesta;

    public Sucursal(String nombre, List<Encuesta> encuesta){
        this.nombre = nombre;
        this.encuesta = encuesta;
    }

    public List<Encuesta> getEncuesta() {return encuesta;}

    public String getNombre() {return nombre;}
}
