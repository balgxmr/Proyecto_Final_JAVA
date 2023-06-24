public class Jugador {
    private String name;
    Tablero tablero;

    public Jugador(String n) {
        this.name = n;
        this.tablero = new Tablero();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public String getName() {
        return name;
    }
}
