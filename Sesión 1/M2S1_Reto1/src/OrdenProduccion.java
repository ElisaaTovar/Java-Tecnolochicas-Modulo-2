public abstract class OrdenProduccion {
    String codigo;
    int cantidad;

    // Constructor de la clase.
    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    // Metodo mostrarResumen para imprimir información básica.
    String mostrarResumen(){
        return getClass().getName()
                + " - Código: " + codigo
                + " - Cantidad: " + cantidad;
    }
}
