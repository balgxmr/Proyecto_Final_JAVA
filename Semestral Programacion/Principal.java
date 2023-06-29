import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        CapturarDatos datos = new CapturarDatos();

        String name;
        char columna;
        int fila;
        String coordenadas;
        int contador = 0;
        int optionForma;
        int optionBarco;
        int tamaño;
        boolean verificador = true;
        int filaFinal;
        char columnaFinal;

        // Imagen del juego de jonatan
        System.out.println("Bienvenido al juego");
        // Boton en la imagen de jonatan
        System.out.println("Presione el boton para continuar");

        name = datos.capturarDatos("Ingrese el nombre del primer jugador");
        Jugador jugador1 = new Jugador(name);
        name = datos.capturarDatos("Ingrese el nombre del segundo jugador");
        Jugador jugador2 = new Jugador(name);

        System.out.println("Es momento de colocar sus barcos");
        System.out.println("Turno de " + jugador1.getName());
        System.out.println("Reglas:");

        // Funcion colocar barcos jugador 1

        System.out.println("Seleccion de barcos");

        while (true) {
            optionBarco = datos.capturarOpcionBarco(
                    "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");
            if (jugador1.getBarco(optionBarco - 1).getSeleccionado()) {
                System.out.println("Ya selecciono este barco, escoje otro");
            } else {
                break;
            }
        }

        while (true) {
            coordenadas = datos.capturarCoordenada(
                    "Ingrese las coordenadas, primero la letra de la columna y luego el numero de fila; ejemplo(letra+numero)");
            columna = coordenadas.charAt(0);
            fila = Integer.parseInt(coordenadas.substring(1));
            if (jugador1.getTablero().validarCoordenada(columna, fila)) {
                optionForma = datos.capturarDireccionBarco(
                        "De que forma va a colocar su barco:\nPresione 1 para horizontal\nPresione 2 para vertical");
                if (jugador1.getTablero().validarEspacio(columna, fila, jugador1.getBarco(optionBarco - 1).getTamaño(),
                        optionForma)) {
                    break;
                } else {
                    System.out.println("");
                }
            } else {
                System.out.println("Las coordenadas estan mal, vuelve a introducirlas");
            }
        }

        jugador1.getTablero().setBarco(columna, fila, jugador1.getBarco(optionBarco - 1).getTamaño(), optionForma);
        jugador1.getBarco(optionBarco - 1).setSeleccionado();

    }

}