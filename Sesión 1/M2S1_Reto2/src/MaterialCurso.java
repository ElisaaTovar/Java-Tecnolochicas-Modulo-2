public abstract class MaterialCurso {
    String titulo;
    String autor;

    public MaterialCurso (String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }
    abstract String MostrarDetalle();

}
