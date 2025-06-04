import java.util.Optional;

public class Pedido {
    String cliente;
    String tipoEntrega; // "Domicilio" o "local"
    String telefono; // Puede ser null

    public Pedido(String cliente, String tipoEntrega, String telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    // Metodo que devuelve un Optional<String>
    public Optional<String> getTelefono (){return Optional.ofNullable(telefono);}

    // Metodo que retorna el tipo de entrega.
    public String getTipoEntrega() {return tipoEntrega.toLowerCase();}
}

