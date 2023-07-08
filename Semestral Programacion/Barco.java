/*Alexander Camargo (8-1002-1756)
 * Richard Herranz (E-8-192057)
 * José Encalada (8-999-1420)
 * Jonathan Núñez (4-823-1010)
 */
public class Barco {
  private boolean seleccionado;
  private int tamaño;
  private String color;

  public Barco(int tamaño) {
    this.seleccionado = false;
    this.tamaño = tamaño;
  }

  public int getTamaño() { return tamaño; }

  public boolean getSeleccionado() { return seleccionado; }

  public void setSeleccionado() { this.seleccionado = true; }

  public String getColor() { return color; }
}