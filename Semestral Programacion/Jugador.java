/*Alexander Camargo (8-1002-1756)
 * Richard Herranz (E-8-192057)
 * José Encalada (8-999-1420)
 * Jonathan Núñez (4-823-1010)
 */
public class Jugador {
  private String name;
  private Tablero tablero;
  private Barco[] barcos = new Barco[4];

  public Jugador(String n) {
    this.name = n;
    this.tablero = new Tablero();
    this.barcos[0] = new Barco(4);
    this.barcos[1] = new Barco(3);
    this.barcos[2] = new Barco(2);
    this.barcos[3] = new Barco(2);
  }

  public Tablero getTablero() { return tablero; }

  public String getName() { return name; }

  public Barco getBarco(int index) { return barcos[index]; }
}