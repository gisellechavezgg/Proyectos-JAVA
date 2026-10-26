public class Nigromante extends Personaje {
    private int mana;

    public Nigromante(String nombre, int nivel, int vida, int mana) {
        super(nombre, nivel, vida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (mana < 15) {
            throw new RpgException("Sin maná suficiente");
        }
        mana -= 15;
        // System.out.println(nombre + " invoca magia oscura");
    }

    @Override
    public int calcularDanio() {
        return nivel * 20; // Ejemplo de cálculo
    }
}