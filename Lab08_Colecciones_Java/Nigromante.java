public class Nigromante extends Personaje implements Hechicero {
    private int mana;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 15;
        lanzarHechizo();
        System.out.println("[" + getNombre() + "] lanza un hechizo oscuro.");
    }

    @Override
    public void lanzarHechizo() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        System.out.println("[" + getNombre() + "] invoca energía oscura.");
    }

    @Override
    public int calcularDanio() {
        return 70 + (nivel * 10);
    }

    @Override
    public int getMana() {
        return mana;
    }
}
