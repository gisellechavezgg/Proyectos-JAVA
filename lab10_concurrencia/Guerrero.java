public class Guerrero extends Personaje {
    private String arma;
    private int fuerza;

    public Guerrero(String nombre, int nivel, int vida, String arma, int fuerza) {
        super(nombre, nivel, vida); // Llama al constructor de Personaje
        this.arma = arma;
        this.fuerza = fuerza;
    }

    public void atacar() throws RpgException {}

    @Override
    public int calcularDanio() {
        return fuerza * 2; // Ejemplo de cálculo
    }
}