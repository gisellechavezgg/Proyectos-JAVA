public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " dispara una flecha con precisión del 95%.");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se desplaza ágilmente esquivando el ataque.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo de arco: " + tipoArco + " | Flechas: " + flechasDisponibles;
    }
}
