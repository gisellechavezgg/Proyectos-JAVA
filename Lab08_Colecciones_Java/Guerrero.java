public class Guerrero extends Personaje {

    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida,
                    int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
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
        System.out.println(nombre + " ataca con su espada.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se defiende con su " + armadura + ".");
    }

    public void entrenar() {
        fuerza = fuerza + 5;
        System.out.println(nombre + " entrenó. Fuerza: " + fuerza);
    }

    public void entrenar(int sesiones) {
        fuerza = fuerza + (5 * sesiones);
        System.out.println(nombre + " entrenó " + sesiones
                + " sesiones. Fuerza: " + fuerza);
    }

    public void entrenar(int sesiones, boolean intensivo) {
        if (intensivo) {
            fuerza = fuerza + (10 * sesiones);
        } else {
            fuerza = fuerza + (5 * sesiones);
        }

        System.out.println(nombre + " entrenó " + sesiones
                + " sesiones. Intensivo: " + intensivo
                + ". Fuerza: " + fuerza);
    }
}
