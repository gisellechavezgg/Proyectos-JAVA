public class Druida extends Personaje {
    private int energiaMagica;

    public Druida(String nombre, int nivel, int vida, int energiaMagica) {
        super(nombre, nivel, vida);
        this.energiaMagica = energiaMagica;
    }

    @Override
    public void atacar() throws RpgException {
        if (energiaMagica < 10) {
            throw new RpgException("No hay suficiente energía mágica");
        }
        energiaMagica -= 10;
       // System.out.println(nombre + " lanza un hechizo de la naturaleza");
    }

    @Override
    public int calcularDanio() {
        return nivel * 15; // Ejemplo de cálculo
    }
}