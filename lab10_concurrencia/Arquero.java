public class Arquero extends Personaje {
    private String tipoArco;
    private int alcance;
    private int precision;

    public Arquero(String nombre, int nivel, int vida, String tipoArco, int alcance, int precision) {
        super(nombre, nivel, vida);
        this.tipoArco = tipoArco;
        this.alcance = alcance;
        this.precision = precision;
    }

   
    public void atacar() throws RpgException {}

    @Override
    public int calcularDanio() {
        return precision; // Ejemplo de cálculo
    }
}