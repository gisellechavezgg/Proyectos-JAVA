public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int vida,
                    int fuerza, String armadura) {
        super(nombre, nivel, vida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel();
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] ataca con un golpe básico.");
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + getFuerza() + " de daño!");
    }

    @Override
    public void defender() {
        System.out.println(getNombre()
                + " se protege con su armadura: " + armadura);
    }

    public void entrenar() {
        fuerza += 5;
    }

    public void entrenar(int sesiones) {
        fuerza += 5 * sesiones;
    }

    public void entrenar(int sesiones, boolean intensivo) {
        int incremento = 5 * sesiones;

        if (intensivo) {
            incremento *= 2;
        }

        fuerza += incremento;
    }
}
