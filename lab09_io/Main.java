import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            PersistenciaGremio persistencia = new PersistenciaGremio();

            // Bloque 1 — Crear personajes y guardar roster
            ArrayList<Personaje> roster = new ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100));
            roster.add(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            roster.add(new Guerrero("Thorin", 9, 400, "Hacha", 80));
            persistencia.guardarRoster(roster);

            // Bloque 2 — Cargar roster desde archivo
            ArrayList<String> lineasRoster = persistencia.cargarRoster();
            System.out.println("\n=== Roster cargado desde archivo ===");
            for (String linea : lineasRoster) {
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0] +
                                   " | Nivel: " + partes[1] +
                                   " | Vida: " + partes[2]);
            }

            // Bloque 3 — Guardar y cargar inventario (Orden exacto del ejemplo)
            LinkedHashMap<String, Integer> inventario = new LinkedHashMap<>();
            inventario.put("Poción de vida", 8);
            inventario.put("Flecha élfica", 30);
            inventario.put("Pergamino de fuego", 3);
            persistencia.guardarInventario(inventario);

            HashMap<String, Integer> inventarioCargado = persistencia.cargarInventario();
            System.out.println("\n=== Inventario cargado desde archivo ===");
            for (Map.Entry<String, Integer> e : inventarioCargado.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }

            // Bloque 4 — Escribir entradas en la bitácora
            persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
            persistencia.agregarEntradaBitacora("Legolas sin flechas — no pudo atacar");
            persistencia.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");
            persistencia.mostrarBitacora();

            // Bloque 5 — Verificar los archivos creados
            File carpeta = new File("datos_gremio");
            System.out.println("\n=== Archivos en datos_gremio/ ===");
            if (carpeta.exists() && carpeta.isDirectory()) {
                for (File f : carpeta.listFiles()) {
                    System.out.println(f.getName() + " (" + f.length() + " bytes)");
                }
            }

        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }
}