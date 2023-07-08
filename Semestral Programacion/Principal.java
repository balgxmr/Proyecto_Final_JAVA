/*Alexander Camargo (8-1002-1756)
 * Richard Herranz (E-8-192057)
 * José Encalada (8-999-1420)
 * Jonathan Núñez (4-823-1010)
 */
import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Interface datos = new Interface();
        String name;
        boolean turnoJuego = true;

        datos.limpiarPantalla();

        System.out.println("Bienvenido al juego!");

        name = datos.capturarDatos("Ingrese el nombre del primer jugador: ");
        Jugador jugador1 = new Jugador(name);
        name = datos.capturarDatos("Ingrese el nombre del segundo jugador: ");
        Jugador jugador2 = new Jugador(name);
        datos.limpiarPantalla();

        inicializarJuego(jugador1);
        datos.limpiarPantalla();
        inicializarJuego(jugador2);
        datos.limpiarPantalla();

        // datos de prueba

        /*
         * jugador1.getTablero().setBarco(0, 0, 1, 4, 1);
         * jugador1.getTablero().setBarco(2, 0, 2, 3, 1);
         * jugador1.getTablero().setBarco(1, 0, 3, 2, 1);
         * jugador1.getTablero().setBarco(0, 8, 4, 2, 2);
         * 
         * jugador2.getTablero().setBarco(0, 0, 1, 4, 1);
         * jugador2.getTablero().setBarco(2, 0, 2, 3, 1);
         * jugador2.getTablero().setBarco(1, 0, 3, 2, 1);
         * jugador2.getTablero().setBarco(8, 0, 4, 2, 1);
         */

        while (true) {
            datos.imprimirPantalla(jugador1, jugador2, true);
            if (turnoJuego) {//verificar tablero e indentificar el ganador 

                if (!jugar(jugador1, jugador2.getTablero())) {//verificar si el jugador se ha rendido
                    turnoJuego = !turnoJuego;
                    break;
                }
                if (jugador2.getTablero().recorrerTablero()) {//llamar funcion para recorer el tablero y verificar la condicion de los barcos
                    break;
                }

            } else {

                if (!jugar(jugador2, jugador1.getTablero())) {//verificar si el jugador se ha rendido
                    turnoJuego = !turnoJuego;
                    break;
                }
                if (jugador1.getTablero().recorrerTablero()) {//llamar funcion para recorer el tablero y verificar la condicion de los barcos
                    break;
                }

            }
            turnoJuego = !turnoJuego;//cambiar turno de jugador
        }

        finalizarJuego(jugador1, jugador2, turnoJuego);

    }

    public static void inicializarJuego(Jugador jugador) {//inicio del juego

        Interface datos = new Interface();

        int optionBarco;

        //Reglas del juego 
        System.out.println("Reglas:\n1.Los turnos de los jugadores se intercalaran."+
        "\n2.cada jugador al inicio deben elegir la posicion de sus barcos."+ 
        "\n3.Las coordenadas tanto de ataque como de seleccion seran colocadas primero la letra luego el numero (A1)\n"+
        "4.Los jugadores podran colocar la palabra EXIT en sus respectivos turnos para terminar la partida.\n");

        //turno del primer jugador de elegir la posicion de sus barcos
        System.out.println("> Turno de " + jugador.getName());
        System.out.println("Es momento de colocar sus barcos");
        
        jugador.getTablero().imprimirTablero(false);
        for (int i = 0; i <= 3; i++) {
            while (true) {//selecion de el tipo de barco
                System.out.println("Seleccion de barcos");
                optionBarco = datos.capturarOpcionBarco(
                        "Presione 1 para el barco de 4 casillas\nPresione 2 para el barco de 3 casillas\nPresione 3 para el barco de 2 casillas\nPresione 4 para el barco de 2 casillas");
                if (jugador.getBarco(optionBarco - 1).getSeleccionado()) {//en caso de barco ya seleccionado
                    System.out.println("Ya selecciono este barco, escoje otro");
                } else {
                    break;
                }
            }

            inicializarBarco(jugador, optionBarco);//Setear posicion de los barcos
            datos.limpiarPantalla();
            System.out.println("> Turno de " + jugador.getName());
            jugador.getTablero().imprimirTablero(false);

        }
        while (true) {
            //opcion para cambiar la posicion de los barcos o seguir con el juego
            int seleccionar = datos.capturarMenu(
                    "Si esta listo presione 1 para comenzar la batalla\nPresione 2 si desea cambiar la posicion de algun barco");
            if (seleccionar == 2) {
                System.out.println("Cual barco desea cambiar de posicion?\n");//selecion de el tipo de barco a cambiar
                optionBarco = datos.capturarOpcionBarco(
                        "Presione 1 para el barco de 4 casillas (Color Rojo)\nPresione 2 para el barco de 3 casillas (Color Verde)\nPresione 3 para el barco de 2 casillas (Color Azul)\nPresione 4 para el barco de 2 casillas (Color Amarillo)");
                jugador.getTablero().eliminarBarco(optionBarco);
                jugador.getTablero().imprimirTablero(false);
                inicializarBarco(jugador, optionBarco);
                datos.limpiarPantalla();
                jugador.getTablero().imprimirTablero(false);
            } else {
                break;
            }
        }
    }

    public static void inicializarBarco(Jugador jugador, int numeroBarco) {

        Interface datos = new Interface();

        int columna;
        char fila;
        String coordenadas;
        int optionForma;
        int filaIndex;
        int columnaIndex;

        while (true) {
            //leer coordenadas del barco
            coordenadas = datos.capturarCoordenada(
                    "Ingrese las coordenadas, primero la letra de la fila y luego el numero de columna; ejemplo (letra+numero)",
                    false);
            fila = Character.toUpperCase(coordenadas.charAt(0));
            columna = Integer.parseInt(coordenadas.substring(1));
            filaIndex = (int) fila - 'A';
            columnaIndex = columna - 1;
            if (jugador.getTablero().validarCoordenada(filaIndex, columnaIndex)) 
            //selecionar posicion del barco si es horizontal o vertica
            {
                optionForma = datos.capturarMenu(
                        "De que forma va a colocar su barco:\nPresione 1 para horizontal\nPresione 2 para vertical");
                if (jugador.getTablero().validarEspacio(filaIndex, columnaIndex, jugador.getBarco(numeroBarco - 1).getTamaño(),optionForma)) 
                //marcar como seleccionado el barco escojido por el jugador si estan los espacios disponibles
                {
                    jugador.getTablero().setBarco(filaIndex, columnaIndex, numeroBarco,
                            jugador.getBarco(numeroBarco - 1).getTamaño(), optionForma);
                    jugador.getBarco(numeroBarco - 1).setSeleccionado();
                    System.out.println("Su barco ha sido colocado con exito");
                    break;
                } 
                else {//mensaje si no hay espacio disponible para el barco
                    System.out.println("No hay suficiente espacio para colocar el barco, intentelo de nuevo");
                }
            } else {//error de escritura en las coordenadas
                System.out.println("Las coordenadas estan mal, vuelve a introducirlas");
            }
        }
    }

    public static boolean jugar(Jugador jugador, Tablero tableroOponente) throws InterruptedException {

        Interface datos = new Interface();

        int columna;
        char fila;
        String coordenadas;
        int filaIndex;
        int columnaIndex;

        while (true) {
            System.out.println("\n> Turno de " + jugador.getName());
            coordenadas = datos.capturarCoordenada(
                    "Ingrese las coordenadas, primero la letra de la fila y luego el numero de columna; ejemplo (letra+numero)",
                    true);
            if (coordenadas.equals("EXIT")) {//si coordenadas es igual a Exit termina el juego
                return false;
            }
            fila = Character.toUpperCase(coordenadas.charAt(0));//Dar el caracter de la posicion 0 a fila
            columna = Integer.parseInt(coordenadas.substring(1));//convertir la subcadela de la posicion 1 a entero y asignar a columna
            filaIndex = (int) fila - 'A';//converit el char asignado a fila a un numero y asignar a filaIndex
            columnaIndex = columna - 1;//asignar el valor de columna a columnaIndex

            if (jugador.getTablero().validarCoordenada(filaIndex, columnaIndex)
                    && tableroOponente.atacarCoordenada(filaIndex, columnaIndex)) {//validar si la coordenada es valida y si a dado en el blanco o no
                break;

            } else {//error de coordenadas incorrectas
                System.out.println("\u001B[31m Vuelve a introducir las coordenadas" + "\u001B[0m");
            }
        }
        return true;

    }

    public static void finalizarJuego(Jugador jugador1, Jugador jugador2, boolean turnoJuego) {//impresiones de fin del juego

        Interface datos = new Interface();

        datos.imprimirPantalla(jugador1, jugador2, false);

        System.out.println("\n\n" + "\u001B[31m" + "EL JUEGO HA FINALIZADO." + "\u001B[0m");

        System.out.println("\n-----------------------------");
        if (turnoJuego) {//impresion de ganador del juego
            System.out.println("\u001B[32m" + "\nGanador: " + jugador1.getName() + "\u001B[0m" + "\n");
        } else {
            System.out.println("\u001B[32m" + "\nGanador: " + jugador2.getName() + "\u001B[0m" + "\n");
        }
        System.out.println("-----------------------------");
        System.out.println("\nBarcos de " + jugador1.getName() + ":");//impresion de los barcos del jugador N°1
        for (int i = 1; i <= 4; i++) {
            System.out.println("Barco #" + i + ": " + jugador1.getTablero().capturarPosicionBarco(i));
        }
        System.out.println("\nBarcos de " + jugador2.getName() + ":");//impresion de los barcos del jugador N°2
        for (int i = 1; i <= 4; i++) {
            System.out.println("Barco #" + i + ": " + jugador2.getTablero().capturarPosicionBarco(i));
        }
    }
}
