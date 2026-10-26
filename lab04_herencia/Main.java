public class Main {
    public static void main(String[] args) {
        Personaje guerrero = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje mago = new Mago("Gandalf", 8, 180, 120, "Fuego");
        Personaje arquero = new Arquero("Legolas", 6, 120, "Arco largo", 30);

        System.out.println("=== Batalla RPG ===");

        System.out.println("\n-- Ronda 1: Ataques --");
        guerrero.atacar();
        mago.atacar();
        arquero.atacar();

        System.out.println("\n-- Ronda 2: Defensas --");
        guerrero.defender();
        mago.defender();
        arquero.defender();

        System.out.println("\n-- Daño recibido --");
        guerrero.recibirDanio(60);
        mago.recibirDanio(200);

        System.out.println("\n-- Estado final --");
        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);
    }
}
