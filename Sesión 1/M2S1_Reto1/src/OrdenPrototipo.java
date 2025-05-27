// Para prototipos (productos en prueba).
public class OrdenPrototipo extends OrdenProduccion{
    String faseDesarrollo;

    // Constructor de la clase.
    public OrdenPrototipo (String codigo, int cantidad, String faseDesarrollo){
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    // Muestra la información de la orden con un ícono representativo
    // y se añade también la fase de desarrollo en que se encuentra.
    @Override
    String mostrarResumen() {
        return "🧪 " + super.mostrarResumen() + " - Fase: " + faseDesarrollo;
    }
}
