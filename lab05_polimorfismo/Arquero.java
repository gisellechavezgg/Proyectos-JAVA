public class Arquero extends Personaje {
    private String arma;
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int vida,
                   String arma, int flechasDisponibles,
                   int precision) {
        super(nombre, nivel, vida);
        this.arma = arma;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] ataca con un golpe básico.");

        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(getNombre()
                    + " dispara una flecha. Flechas restantes: "
                    + flechasDisponibles);
        } else {
            System.out.println(getNombre()
                    + " no tiene flechas disponibles.");
        }
    }

    @Override
    public void defender() {
        System.out.println(getNombre()
                + " esquiva el ataque.");
    }
}
