// Para órdenes personalizadas (adaptadas al cliente).
public class OrdenPersonalizada extends OrdenProduccion{
    String cliente;

    // Constructor de la clase.
    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    // Muestra la información de la orden con un ícono representativo y se añade también al cliente.
    @Override
    String mostrarResumen() {
        return "🛠️ " + super.mostrarResumen() + " - Cliente: " + cliente;
    }
}
