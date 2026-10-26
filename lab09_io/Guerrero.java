public class Guerrero extends Personaje {
    private String arma;
    private int fuerza;
    private int armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
        this.armadura = 50;
    }

    public void defender() {
        this.armadura += 10;
    }

    public String getArma() { return arma; }
    public int getFuerza() { return fuerza; }
    public int getArmadura() { return armadura; }
}