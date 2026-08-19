package lab02;

public class Perro extends Animal {

    private String raza;
    private boolean estaVacunado;

    public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) {
        super(nombre, edad, peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    public void ladrar() {
        System.out.println(getNombre() + " dice: ¡Guau guau!");
    }

    public void buscarPelota() {
        System.out.println(getNombre() + " está buscando la pelota...");
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Raza: " + raza +
               " | Vacunado: " + (estaVacunado ? "Sí" : "No");
    }
}
