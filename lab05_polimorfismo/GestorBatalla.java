import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla() {
        historial = new ArrayList<>();
    }

    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();

        System.out.println("[BATALLA] " + atacante.getNombre()
                + " ataca solo -> daño: " + danio);

        historial.add(atacante.getNombre()
                + " atacó solo (daño: " + danio + ")");
    }

    public void ejecutarAtaque(Personaje atacante,
                               Personaje defensor) {
        int danio = atacante.calcularDanio();

        atacante.atacar();
        defensor.recibirDanio(danio);
        defensor.defender();

        System.out.println("[BATALLA] " + atacante.getNombre()
                + " ataca a " + defensor.getNombre()
                + " -> daño: " + danio);

        String evento = atacante.getNombre()
                + " atacó a " + defensor.getNombre()
                + " (daño: " + danio + ")";

        if (defensor.getVida() == 0) {
            evento += " - " + defensor.getNombre() + " derrotado";
        }

        historial.add(evento);
    }

    public void ejecutarAtaque(Personaje[] equipo) {
        StringBuilder nombres = new StringBuilder();

        for (int i = 0; i < equipo.length; i++) {
            Personaje atacante = equipo[i];
            int danio = atacante.calcularDanio();

            atacante.atacar();

            if (i > 0) {
                nombres.append(", ");
            }

            nombres.append(atacante.getNombre());
        }

        System.out.println("[BATALLA] Equipo completo ataca -> "
                + equipo.length + " personajes");

        historial.add("Ataque en equipo: " + nombres);
    }

    public void mostrarHistorial() {
        System.out.println("\n-- Historial --");

        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". "
                    + historial.get(i));
        }
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}
