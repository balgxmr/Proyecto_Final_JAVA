public class Jugador {
    private String name;
    Tablero tablero;
    Barco[] barcos = new Barco[4];

    public Jugador(String n) {
        this.name = n;
        this.tablero = new Tablero();
        this.barcos[0] = new Barco(4);
        this.barcos[1] = new Barco(3);
        this.barcos[2] = new Barco(2);
        this.barcos[3] = new Barco(2);
    }

    public Tablero getTablero() {
        return tablero;
    }

    public String getName() {
        return name;
    }

    public int getBarcos() {

    }
}