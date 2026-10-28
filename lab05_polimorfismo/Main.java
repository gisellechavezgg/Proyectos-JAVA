public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG - Demostración de Polimorfismo ===");

        Personaje p1 = new Guerrero(
                "Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago(
                "Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero(
                "Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("\n-- calcularDanio() por tipo --");

        System.out.println("Thorin  (Guerrero) daño: "
                + p1.calcularDanio());
        System.out.println("Gandalf (Mago)     daño: "
                + p2.calcularDanio());
        System.out.println("Legolas (Arquero)  daño: "
                + p3.calcularDanio());

        System.out.println("\n-- Arreglo polimórfico --");

        Personaje[] equipo = {p1, p2, p3};

        for (Personaje p : equipo) {
            p.atacar();
        }

        System.out.println("\n-- GestorBatalla --");

        GestorBatalla gestor = new GestorBatalla();

        gestor.ejecutarAtaque(p1);
        gestor.ejecutarAtaque(p2, p3);
        gestor.ejecutarAtaque(equipo);

        gestor.mostrarHistorial();

        System.out.println("\n-- instanceof --");

        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre()
                        + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre()
                        + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre()
                        + " es un Arquero.");
            }
        }
    }
}
