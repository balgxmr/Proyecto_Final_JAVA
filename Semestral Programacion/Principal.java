import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        CapturarDatos datos = new CapturarDatos();
        String name;
        boolean turnoJuego = true;

        // Imagen del juego de jonatan
        System.out.println("Bienvenido al juego");
        // Boton en la imagen de jonatan
        System.out.println("Presione el boton para continuar");

        name = datos.capturarDatos("Ingrese el nombre del primer jugador");
        Jugador jugador1 = new Jugador(name);
        name = datos.capturarDatos("Ingrese el nombre del segundo jugador");
        Jugador jugador2 = new Jugador(name);

        inicializarJuego(jugador1);
        // clear
        inicializarJuego(jugador2);
        // clear

        // datos de prueba
        /*
         * jugador1.getTablero().setBarco(0, 0, 1, 4, 1);
         * jugador1.getTablero().setBarco(2, 0, 2, 3, 1);
         * jugador1.getTablero().setBarco(1, 0, 3, 2, 1);
         * jugador1.getTablero().setBarco(3, 0, 4, 2, 1);
         * 
         * jugador2.getTablero().setBarco(0, 0, 1, 4, 1);
         * jugador2.getTablero().setBarco(2, 0, 2, 3, 1);
         * jugador2.getTablero().setBarco(1, 0, 3, 2, 1);
         * jugador2.getTablero().setBarco(3, 0, 4, 2, 1);
         */

        System.out.println("Comienza el juego");
        while (true) {
            if (turnoJuego) {
                Jugar(jugador1, jugador2.getTablero());
                if (jugador2.getTablero().recorrerTablero()) {
                    break;
                }
            } else {
                Jugar(jugador2, jugador1.getTablero());
                if (jugador1.getTablero().recorrerTablero()) {
                    break;
                }
            }
            turnoJuego = !turnoJuego;
        }

        if (turnoJuego) {
            System.out.println("Ganador: " + jugador1.getName());
        } else {
            System.out.println("Ganador: " + jugador2.getName());
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println("Barco " + i + ": " + jugador1.getTablero().capturarPosicionBarco(i));
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println("Barco " + i + ": " + jugador2.getTablero().capturarPosicionBarco(i));
        }

    }

    public static void inicializarJuego(Jugador jugador) {

        CapturarDatos datos = new CapturarDatos();

        int optionBarco;

        System.out.println("Turno de " + jugador.getName());
        System.out.println("Es momento de colocar sus barcos");
        System.out.println("Reglas:  ");
        jugador.getTablero().imprimirTablero(false);
        for (int i = 0; i <= 3; i++) {
            while (true) {
                System.out.println("Seleccion de barcos");
                optionBarco = datos.capturarOpcionBarco(
                        "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");
                if (jugador.getBarco(optionBarco - 1).getSeleccionado()) {
                    System.out.println("Ya selecciono este barco, escoje otro");
                } else {
                    break;
                }
            }

            inicializarBarco(jugador, optionBarco);
            jugador.getTablero().imprimirTablero(false);
        }
        while (true) {
            int seleccionar = datos.capturarMenu(
                    "Si esta listo presione 1 para comenzar la batalla\nPresione 2 si desea cambiar la posicion de algun barco");
            if (seleccionar == 2) {
                System.out.println("Cual barco desea cambiar de posicion?\n");
                optionBarco = datos.capturarOpcionBarco(
                        "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");
                jugador.getTablero().eliminarBarco(optionBarco);
                jugador.getTablero().imprimirTablero(false);
                inicializarBarco(jugador, optionBarco);
                jugador.getTablero().imprimirTablero(false);
            } else {
                break;
            }
        }
    }

    public static void inicializarBarco(Jugador jugador, int numeroBarco) {

        CapturarDatos datos = new CapturarDatos();

        int columna;
        char fila;
        String coordenadas;
        int optionForma;
        int filaIndex;
        int columnaIndex;

        while (true) {
            coordenadas = datos.capturarCoordenada(
                    "Ingrese las coordenadas, primero la letra de la fila y luego el numero de columna; ejemplo (letra+numero)");
            fila = Character.toUpperCase(coordenadas.charAt(0));
            columna = Integer.parseInt(coordenadas.substring(1));
            filaIndex = (int) fila - 'A';
            columnaIndex = columna - 1;
            if (jugador.getTablero().validarCoordenada(filaIndex, columnaIndex)) {
                optionForma = datos.capturarMenu(
                        "De que forma va a colocar su barco:\nPresione 1 para horizontal\nPresione 2 para vertical");
                if (jugador.getTablero().validarEspacio(filaIndex, columnaIndex,
                        jugador.getBarco(numeroBarco - 1).getTamaño(),
                        optionForma)) {
                    jugador.getTablero().setBarco(filaIndex, columnaIndex, numeroBarco,
                            jugador.getBarco(numeroBarco - 1).getTamaño(), optionForma);
                    jugador.getBarco(numeroBarco - 1).setSeleccionado();
                    System.out.println("Su barco ha sido colocado con exito");
                    break;
                } else {
                    System.out.println("No hay suficiente espacio para colocar el barco, intentelo de nuevo");
                }
            } else {
                System.out.println("Las coordenadas estan mal, vuelve a introducirlas");
            }
        }
    }

    public static void Jugar(Jugador jugador, Tablero tableroOponente) {

        CapturarDatos datos = new CapturarDatos();

        int columna;
        char fila;
        String coordenadas;
        int option;
        int filaIndex;
        int columnaIndex;

        while (true) {
            System.out.println("Turno de " + jugador.getName());
            option = datos.capturarMenu("Presione 1 para atacar\nPresione 2 para ver la posicion de sus barcos");

            if (option == 2) {

                while (true) {

                    tableroOponente.imprimirTablero(true);
                    coordenadas = datos.capturarCoordenada(
                            "Ingrese las coordenadas, primero la letra de la fila y luego el numero de columna; ejemplo (letra+numero)");
                    fila = Character.toUpperCase(coordenadas.charAt(0));
                    columna = Integer.parseInt(coordenadas.substring(1));
                    filaIndex = (int) fila - 'A';
                    columnaIndex = columna - 1;
                    if (tableroOponente.atacarCoordenada(filaIndex, columnaIndex)) {
                        break;
                    }
                }

                tableroOponente.imprimirTablero(true);
                break;
            } else {
                System.out.println("Posicion de sus barcos");
                jugador.getTablero().imprimirTablero(false);
            }

        }
    }

    public static void finalJuego(Jugador jugador) {

    }
}
