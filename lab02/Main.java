package lab02;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Clínica Veterinaria ===");

        Perro perro = new Perro(
            "Max", 3, 12.5, "Labrador", true
        );

        System.out.println("\n-- Perro --");
        System.out.println(perro.toString());
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();

        Gato gato = new Gato(
            "Misi", 2, 3.8, "Gris", true
        );

        System.out.println("\n-- Gato --");
        System.out.println(gato.toString());
        gato.dormir();
        gato.maullar();
        gato.ronronear();

        Canario canario = new Canario(
            "Pico", 1, 0.03, "Amarillo", true
        );

        System.out.println("\n-- Canario --");
        System.out.println(canario.toString());
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}
/*1. ¿Por qué declaramos los atributos como private y no como public?

Porque así protegemos los datos de la clase y evitamos que puedan ser modificados directamente desde cualquier otra clase. Es mejor usar private porque tenemos un mayor control sobre la información.

2. ¿Qué pasaría si quitaras el super() del constructor de Perro?

Si quitamos el super(), Java intentaría usar el constructor vacío de la clase Animal. Si Animal no tiene un constructor vacío, nos marcaría un error y el programa no podría compilar. Por eso usamos super() para mandar los datos que necesita el constructor de Animal.

3. ¿Qué ventaja tiene sobreescribir toString() en lugar de crear un método con otro nombre?

La ventaja es que toString() ya es un método que Java reconoce y podemos usarlo directamente cuando imprimimos un objeto con System.out.println(). Así podemos mostrar la información del objeto de una manera más clara sin tener que llamar otro método. */