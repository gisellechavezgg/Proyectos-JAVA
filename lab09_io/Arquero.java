public class Arquero extends Personaje {
    private String tipoArco;
    private int alcance;
    private int flechas;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int alcance, int flechas) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.alcance = alcance;
        this.flechas = flechas;
    }

    public int getFlechas() { 
        return flechas; 
    }

    public boolean isEstaVivo() {
        return this.puntosVida > 0;
    }

    public int calcularDanio() {
        return this.nivel * 10;
    }

    public void atacar(Personaje objetivo) throws RecursoInsuficienteException {
        if (this.flechas <= 0) {
            throw new RecursoInsuficienteException("El arquero no tiene flechas para atacar.");
        }
        this.flechas--;
    }
}