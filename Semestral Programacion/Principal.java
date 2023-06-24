import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {

        CapturarDatos datos = new CapturarDatos();
        Tablero tablero = new Tablero();

        String name;
        char columna;
        int fila;
        String coordenadas;
        int contador = 0;
        int option;
        int optionBarco;
        int tamaño;
        boolean verificador = true;
        int filaFinal;
        char columnaFinal;

        Jugador registroJugadores[] = new Jugador[2];

        // Imagen del juego de jonatan
        System.out.println("Bienvenido al juego");
        // Boton en la imagen de jonatan
        System.out.println("Presione el boton para continuar");

        for (int i = 0; i <= 1; i++) {
            name = datos.capturarDatos("Ingrese el nombre del jugador " + (i + 1));
            registroJugadores[i] = new Jugador(name);
        }

        System.out.println("Es momento de colocar sus barcos");
        System.out.println("Turno de " + registroJugadores[0].getName());
        System.out.println(
                "Reglas:\nEscoja la coordenada donde estara la punta del barco\nDefina si estara ubicado horizontal o verticalmente");

        // Funcion colocar barcos jugador 1

        System.out.println("Seleccion de barcos");

        optionBarco = datos.capturarOpcionBarco(
                "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");

        if (optionBarco == 1) {
            tamaño = 4;
        } else if (optionBarco == 2) {
            tamaño = 3;
            verificador = true;
        } else if (optionBarco == 3) {
            tamaño = 2;
        } else if (optionBarco == 4) {
            tamaño = 2;
        }

        columna = datos.capturarColumnas("Escoja la columna");
        fila = datos.capturarFilas("Escoja la fila");

        option = datos.capturarDireccionBarco(
                "De que forma va a colocar su barco:\nPresione 1 para horizontal\nPresione 2 para vertical");

        if (option == 1) {
            filaFinal = fila - tamaño;
            if (filaFinal < 1) {
                System.out.println("No es posible colocar el barco ahi");
            } else {
                // para la derecha(sumar)
            }
        } else if (option == 2) {
            columnaFinal = (char) (columna + tamaño);
            if (columnaFinal < 'A') {
                System.out.println("No es posible colocar el barco ahi");
            }
        }
        tablero.setBarco(columna, fila, columnaFinal, filaFinal);

        System.out.println("Es momento de colocar sus barcos");
        System.out.println("Turno de " + registroJugadores[1].getName());
        System.out.println(
                "Reglas:\nEscoja la coordenada donde estara la punta del barco\nDefina si estara ubicado horizontal o verticalmente");
        // Funcion colocar barcos jugador 2

        // Boton A la batalla

        System.out.println("Es momento de pelear");

        while (true) {
            System.out.println("Turno de " + registroJugadores[contador].getName());
            coordenadas = datos.capturarCoordenadas(
                    "Escoja la coordenada a la cual va a atacar\nSi desea revisar la posicion de sus barcos marque 1");

            // Funcion atacar
            // Sombrear la coordenada elejida si no golpeo nada, Marcar con una X si golpeo
            // un barco, mostrar algun efecto cuando el barco este completamente destruido
            // ir actualizando el tablero en cada turno

            if (coordenadas.equals("1")) {
                // Funcion mostrar tablero con barcos del jugador
            } else if (coordenadas.equals("EXIT")) {
                System.out.println("Se ha acabado el juego");
                break;
            }

            if (contador == 0) {
                contador = 1;
            } else if (contador == 1) {
                contador = 0;
            }
        }

    }

}