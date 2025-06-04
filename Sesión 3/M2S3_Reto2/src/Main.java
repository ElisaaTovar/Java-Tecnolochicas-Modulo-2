import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Juan", "El tiempo de espera fue largo", 3),
                        new Encuesta("Abril", "No me gustó su atención.", 0))),
                new Sucursal("Norte", List.of(
                        new Encuesta("Ana", "La atención fue buena, pero la limpieza puede mejorar", 4),
                        new Encuesta("Saúl", "Pésimo servicio, no regreso.", 1),
                        new Encuesta("Ramona", null, 4)
                )));

        // Desanidar todas las encuestas de las sucursales usando flatMap().
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuesta().stream()
                        // Filtrar solo las ecuestas con calificación menor o igual a 3.
                        .filter(calificacion -> calificacion.calificacion>=3)
                        .map(encuesta -> new Confirmacion(encuesta, sucursal.getNombre()))
                )

                // Recuperar los comentarios disponibles usando Optional.
                .filter(conf -> conf.encuesta.getComentario().isPresent())

                // Transformar cada comentario en un mensaje.
                .map(conf -> {
                    String comentario = conf.getPedido().getComentario().get();
                    return "Sucursal " + conf.getSucursal() + ": "
                    +"Seguimiento a paciente con comentario: " + comentario;})
                .forEach(System.out::println);
    }

    // Clase auxiliar para transportar Encuesta + Sucursal juntos
    static class Confirmacion {
        private final Encuesta encuesta;
        private final String sucursal;

        public Confirmacion(Encuesta encuesta, String sucursal) {
            this.encuesta = encuesta;
            this.sucursal = sucursal;
        }

        public Encuesta getPedido() { return encuesta; }
        public String getSucursal() { return sucursal; }
    }
}