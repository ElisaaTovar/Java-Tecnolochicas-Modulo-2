import java.util.List;

public class Main {
    // Metodo genérico: lee cualquier tipo de orden y muestra sus datos.
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        System.out.println("\n📋 Órdenes registradas: ");
        for (OrdenProduccion o : lista){
            System.out.println(o.mostrarResumen());
        }
    }

    // Metodo que modifica solo las órdenes personalizadas, mostrando un mensaje por el costo agregado.
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        System.out.println("\n💰 Procesando órdenes personalizadas... ");
        lista.forEach(o ->{
            if (o instanceof OrdenPersonalizada orden) {
                System.out.println("✅ Orden " + orden.codigo+ " ajustada con costo adicional de $" + costoAdicional);
            }
        });
    }

    // Función que cuenta el total de órdenes de cada tipo en la planta.
    public static int totalOrdenes(List<?> ordenes){
        return ordenes.size();
    }

    public static void main(String[] args) {
        // Creación de las listas para cada tipo de orden.
        List<OrdenMasa> ordenMasa =
                List.of(new OrdenMasa("A123", 500),
                        new OrdenMasa("A124", 750));
        List<OrdenPersonalizada> ordenPersonalizada =
                List.of(new OrdenPersonalizada("P456",100, "ClienteX"),
                        new OrdenPersonalizada("P789", 150, "ClienteY"));
        List<OrdenPrototipo> ordenPrototipo =
                List.of(new OrdenPrototipo("T789", 10, "Diseño"),
                        new OrdenPrototipo("T790", 5, "Pruebas"));

        // Implementación del metodo mostrarOrdenes.
        mostrarOrdenes(ordenMasa);
        mostrarOrdenes(ordenPersonalizada);
        mostrarOrdenes(ordenPrototipo);

        // Implementación del metodo procesarPersonalizadas.
        procesarPersonalizadas(ordenPersonalizada, 200);

        // Muestra un resumen del total de órdenes.
        System.out.println("\n📊 Resumen total de órdenes: ");
        System.out.println("🔧 Producción en masa: " + totalOrdenes(ordenMasa));
        System.out.println("🛠️ Personalizadas: " + totalOrdenes(ordenPersonalizada));
        System.out.println("🧪 Prototipos: "+ totalOrdenes(ordenPrototipo));

    }
}
