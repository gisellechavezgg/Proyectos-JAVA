public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String companero;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String companero) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.companero = companero;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 10;
        lanzarHechizo();
        System.out.println("[" + getNombre() + "] invoca raíces del bosque y ataca con furia natural.");
    }

    @Override
    public void lanzarHechizo() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        System.out.println("[" + getNombre() + "] canaliza magia de la naturaleza.");
    }

    @Override
    public int calcularDanio() {
        return 50 + (nivel * 10);
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }

        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException(
                "curarAliado",
                "No se puede curar a un personaje derrotado"
            );
        }

        System.out.println("[" + getNombre() + "] cura a " + aliado.getNombre() + " con " + poderCuracion + " puntos de curación.");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getCompanero() {
        return companero;
    }
}
