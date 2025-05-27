public class Video extends MaterialCurso {
    int duracion; // Duración en minutos

    // Constructor de la clase.
    public Video(String titulo, String autor, int duracion){
        super(titulo, autor);
        this.duracion=duracion;
    }

    @Override
    String MostrarDetalle() {
        return "📽️ Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min.";
    }
}
