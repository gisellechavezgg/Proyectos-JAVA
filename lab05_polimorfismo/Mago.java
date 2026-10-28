public class Mago extends Personaje {
    private int mana;
    private int poderMagico;
    private String hechizo;

    public Mago(String nombre, int nivel, int vida,
                int mana, String hechizo) {
        super(nombre, nivel, vida);
        this.mana = mana;
        this.poderMagico = mana;
        this.hechizo = hechizo;
    }

    public int getMana() {
        return mana;
    }

    public String getHechizo() {
        return hechizo;
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] ataca con un golpe básico.");
        System.out.println("¡" + getNombre() + " lanza una bola de fuego causando " + mana + " de daño mágico!");
    }

    @Override
    public void defender() {
        System.out.println(getNombre()
                + " crea un escudo mágico.");
    }
}
