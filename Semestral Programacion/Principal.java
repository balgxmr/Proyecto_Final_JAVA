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
        System.out.println(
                "Reglas:\nEscoja la coordenada donde estara la punta del barco\nDefina si estara ubicado horizontal o verticalmente");

        // Funcion colocar barcos jugador 1

        System.out.println("Seleccion de barcos");

        optionBarco = datos.capturarOpcionBarco(
                "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");

        columna = datos.capturarColumnas("Escoja la columna");
        fila = datos.capturarFilas("Escoja la fila");

        option = datos.capturarDireccionBarco(
                "De que forma va a colocar su barco:\nPresione 1 para horizontal\nPresione 2 para vertical");

        tamaño = jugador1.getBarco(optionBarco - 1).getTamaño();
    }

}