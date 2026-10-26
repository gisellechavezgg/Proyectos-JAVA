public class Arquero extends Personaje {
    private String arma;
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida, String arma, int flechasDisponibles, int precision) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha con " + arma + ". Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() {
        return 20 + (nivel * 5) + (precision / 10);
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }
}
