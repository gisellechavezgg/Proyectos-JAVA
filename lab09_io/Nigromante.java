public class Nigromante extends Personaje {
    private int mana;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    public void lanzarHechizo() throws RecursoInsuficienteException {
        if (mana < 25) {
            throw new RecursoInsuficienteException("Maná insuficiente para magia oscura.");
        }
        mana -= 25;
    }

    public int getMana() {
        return mana;
    }
}