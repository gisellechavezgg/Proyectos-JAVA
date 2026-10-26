public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int vida;

    public Personaje(String nombre, int nivel, int vida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    // El método que te marcaba error en CombateConcurrente
    public boolean isEstaVivo() {
        return this.vida > 0; 
    }

    // Métodos que cada personaje específico debe definir
    public abstract void atacar() throws RpgException;
    public abstract int calcularDanio();
    
    // Método para restar vida
    public void recibirDanio(int danio) {
        this.vida -= danio;
        if (this.vida < 0) {
            this.vida = 0; // Para que la vida no sea negativa
        }
        System.out.println(this.nombre + " recibe " + danio + " de daño. Vida: " + this.vida);
    }
}