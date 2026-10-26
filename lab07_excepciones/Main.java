public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG - Sistema con Manejo de Excepciones ===");

        Druida druida = new Druida("Sylva", 7, 200, 90, 120, "Lobo");
        Nigromante nigromante = new Nigromante("Malachar", 8, 120, 80);
        MotorCombate motor = new MotorCombate();

        motor.ejecutarTurno(druida, nigromante);

        druida.derrotar();
        motor.ejecutarTurno(druida, nigromante);

        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);

        System.out.println("\n-- Intento de curar aliado derrotado --");
        Druida druida2 = new Druida("Natura", 7, 200, 60, 100, "Águila");
        Arquero personajeDerrotado = new Arquero("Robin", 5, 100, "Arco Corto", 5, 90);

        try {
            personajeDerrotado.derrotar();
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();
    }
}
