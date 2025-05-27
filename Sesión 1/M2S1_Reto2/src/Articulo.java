public class Articulo extends MaterialCurso {
    int palabras; // Conteo de palabras.

    public Articulo(String titulo, String autor, int palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }
    @Override
    String MostrarDetalle() {
        return "📄 Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras;
    }
}
