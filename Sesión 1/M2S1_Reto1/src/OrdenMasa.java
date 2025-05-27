// Para órdenes de producción en masa (productos estándar)
public class OrdenMasa extends OrdenProduccion{

    // Constructor de la clase.
    public OrdenMasa (String codigo, int cantidad){
        super(codigo, cantidad);
    }

    // Muestra la información de la orden con un ícono representativo.
    @Override
    String mostrarResumen() {
        return "🔧 " + super.mostrarResumen();
    }
}
