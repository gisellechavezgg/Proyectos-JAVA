public class Druida extends Personaje {
    private int mana;
    private int poderCuracion;

    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = 50;
    }

    public void lanzarHechizo() throws RecursoInsuficienteException {
        if (mana < 20) {
            throw new RecursoInsuficienteException("Maná insuficiente para lanzar hechizo.");
        }
        mana -= 20;
    }

    public void curarAliado(Personaje aliado) throws RecursoInsuficienteException {
        if (mana < 15) {
            throw new RecursoInsuficienteException("Maná insuficiente para curar.");
        }
        mana -= 15;
    }

    public int getMana() {
        return mana;
    }

    public int getPoderCuracion() {
        return poderCuracion;
    }
}