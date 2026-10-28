public class Personaje implements Combatiente {
    private String nombre;
    private int nivel;
    private int vida;
    private int vidaMaxima;

    public Personaje(String nombre, int nivel, int vida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int calcularDanio() {
        return nivel * 10;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se prepara para defenderse.");
    }

    @Override
    public void recibirDanio(int danio) {
        vida -= danio;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " recibe " + danio
                + " puntos de daño. Vida restante: " + vida);

        if (vida == 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - Nivel: " + nivel
                + ", Vida: " + vida + "/" + vidaMaxima);
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println("Personaje: " + nombre);
            System.out.println("Nivel: " + nivel);
            System.out.println("Vida actual: " + vida);
            System.out.println("Vida máxima: " + vidaMaxima);
            System.out.println("Daño: " + calcularDanio());
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String formato) {
        System.out.println("[" + formato + "] " + toString());
    }

    @Override
    public String toString() {
        return nombre + " (Nivel " + nivel + ", Vida "
                + vida + "/" + vidaMaxima + ")";
    }
}
