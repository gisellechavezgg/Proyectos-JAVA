public class Main {
    public static void main(String[] args) {

        // 1. ARRAYLIST - ROSTER

        GestionGremio gremio = new GestionGremio();

        gremio.agregarMiembro(
                new Druida("Sylva", 10, 300, 100, 0, null));

        gremio.agregarMiembro(
                new Nigromante("Malachar", 8, 250, 120));

        gremio.agregarMiembro(
                new Arquero("Legolas", 6, 150, "Arco", 20, 95));

        gremio.agregarMiembro(
                new Guerrero("Thorin", 9, 400, 80, "Hacha"));

        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");

        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }


        // 2. LINKEDLIST - COLA

        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");

        gremio.mostrarCola();

        gremio.atenderSiguiente();

        gremio.mostrarCola();


        // 3. HASHMAP - INVENTARIO

        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);

        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");

        gremio.mostrarInventario();


        // 4. HASHSET - HABILIDADES

        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");

        gremio.mostrarHabilidades();

        System.out.println("¿Tiene flecha? "
                + gremio.tieneHabilidad("Tiro con arco"));

        System.out.println("¿Tiene curación? "
                + gremio.tieneHabilidad("Curación"));


        // 5. MOSTRAR

        System.out.println("\n========== RESUMEN FINAL ==========");

        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
