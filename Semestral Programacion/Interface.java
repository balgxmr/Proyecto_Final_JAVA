/*Alexander Camargo (8-1002-1756)
 * Richard Herranz (E-8-192057)
 * José Encalada (8-999-1420)
 * Jonathan Núñez (4-823-1010)
 */
import java.io.*;

public class Interface {

  BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

  public String capturarDatos(String message) { // captura de dato general

    try {
      System.out.print(message);
      return read.readLine();
    } catch (Exception e) {
      System.out.println("Ingrese un valor valido");
      return capturarDatos(message);
    }
  }

  public String capturarCoordenada(
      String message,
      boolean finalizar) { // capturar las coordenadas para los barcos
    String coordenada;
    try {
      while (true) {
        System.out.println(message);
        coordenada = read.readLine();

        if (finalizar) {
          if (coordenada.equals("EXIT") ||
              coordenada.equals("exit")) { // validar si las coordenadas son
                                           // exit para finalizar partida
            return "EXIT";
          }
        }

        if (coordenada.length() == 2 &&
            Character.isDigit(coordenada.charAt(
                1))) { // validar si las coordenadas son validas
          return coordenada;
        } else {
          System.out.println("Ingrese un valor valido");
        }
      }
    } catch (Exception e) {
      System.out.println("Ingrese un valor valido");
      return capturarCoordenada(message, finalizar);
    }
  }

  public int capturarMenu(String message) { // capturar opciones del menu

    boolean loop = true;
    int option = 0;
    try {
      while (loop) {
        System.out.println(message);
        option = Integer.parseInt(read.readLine());
        if (option > 2 || option < 1) { // limita las opciones a solo 2 caso
                                        // contrario saltara in error
          System.out.println("Ingrese un valor valido");
        } else {
          loop = false;
        }
      }
      return option;
    } catch (Exception e) {
      System.out.println("Ingrese un valor valido");
      return capturarMenu(message);
    }
  }

  public int capturarOpcionBarco(
      String message) { // captura las distiantas opciones disponibles de barcos

    boolean loop = true;
    int option = 0;
    try {
      while (loop) {
        System.out.println(message);
        option = Integer.parseInt(read.readLine());
        if (option > 4 ||
            option < 1) { // limita las opciones a solo 4 caso contrario
                          // devolcera error hata seleccionar una de las opciones
          System.out.println("Ingrese un valor valido");
        } else {
          loop = false;
        }
      }
      return option;
    } catch (Exception e) {
      System.out.println("Ingrese un valor valido");
      return capturarOpcionBarco(message);
    }
  }

  public void
  limpiarPantalla() { // limpirar la pantalla para las siguientes impresione
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (Exception e) {
      // Manejo de errores
      e.printStackTrace();
    }
  }

  public void imprimirPantalla(Jugador jugador1, Jugador jugador2,
                               boolean ocultarBarco) {

    limpiarPantalla();
    System.out.println("Tablero de " + jugador1.getName() + "\n");
    jugador1.getTablero().imprimirTablero(
        ocultarBarco); // impresion del tablero del jugador n°1

    System.out.println("\n=====================================\n");
    System.out.println("Tablero de " + jugador2.getName() + "\n");
    jugador2.getTablero().imprimirTablero(
        ocultarBarco); // impresion del tablero del jugador n°2
  }
}
