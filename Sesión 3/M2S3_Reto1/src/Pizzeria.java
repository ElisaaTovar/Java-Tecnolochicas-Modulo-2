import java.util.List;
import java.util.Optional;

public class Pizzeria {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
            new Pedido("Elisa", "domicilio", "555-1234"),
            new Pedido("Abraham", "Domicilio", null),
            new Pedido("Ana", "domicilio", "555-5678"),
            new Pedido("Gonzalo", "local", null)
        );

        pedidos.stream()
                // Filtrar solo los pedidos con tipo de entrega "domicilio".
                .filter(Entrega -> Entrega.getTipoEntrega().equals("domicilio"))
                // Recuperar los teléfonos disponibles usando Optional.
                .map(Pedido::getTelefono)
                // Transformar cada teléfono en un mensaje de confirmación.
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(telefono -> "📞 Confirmación enviada al número: " + telefono)
                .forEach( System.out::println);
    }
}