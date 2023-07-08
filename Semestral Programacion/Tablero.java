/*Alexander Camargo (8-1002-1756)
 * Richard Herranz (E-8-192057)
 * José Encalada (8-999-1420)
 * Jonathan Núñez (4-823-1010)
 */
public class Tablero {
    private char[][] tablero = new char[9][9];

    public Tablero() {
        this.tablero = inicializarMatriz();
    }

    public boolean validarCoordenada(int fila, int columna) {
        return fila >= 0 && fila < 9 && columna >= 0 && columna < 9;
    }

    public boolean validarEspacio(int fila, int columna, int tamaño, int option) 
    //validar si el espacio es una espacio correcto y vacio
    {
        if (option == 1) {//Verificar si la posicion en vertical esta vacia
            for (int i = columna; i < columna + tamaño; i++) {
                if (!validarCoordenada(fila, i) || tablero[fila][i] != '-') {
                    return false;
                }
            }
        }//If posicion Vertical, Fin
        else {//verificar si la posicion horizontal esta vacia
            for (int i = fila; i < fila + tamaño; i++) {
                if (!validarCoordenada(i, columna) || tablero[i][columna] != '-') {
                    return false;
                }
            }
        }//Else posicion horizontal, Fin

        return true;
    }

    public void setBarco(int fila, int columna, int numeroBarco, int tamaño, int optionForma) 
    //Barco: seleccion de tamaño o tipo
    {
        char letraBarco = Integer.toString(numeroBarco).charAt(0);
        if (optionForma == 1) {//colocar barco en posicion vertical
            for (int i = columna; i < columna + tamaño; i++) {
                tablero[fila][i] = letraBarco;
            }
        }//If posicion Vertical, Fin 
        else {//colocar barco en posicion horizontal
            for (int i = fila; i < fila + tamaño; i++) {
                tablero[i][columna] = letraBarco;
            }
        }//Else posicion horizontal, Fin
    }

    public void imprimirTablero(boolean ocultarBarco) {//Impresion del tablero
        int num = 1;
        char letra = 'A';
        System.out.print("    ");
        for (int x = 0; x < 9; x++) {
            System.out.print(num + "   ");
            num++;
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letra + "   ");
            letra++;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] >= '1' && tablero[i][j] <= '4') {
                    if (ocultarBarco) {//ocultar posicion de los barcos mientras se juega
                        System.out.print("-   ");
                    } else {//ver los barcos colocados
                        // Se asigna el color a cada barco
                        switch (tablero[i][j]) {
                            case '1':
                                System.out.print("\u001B[31m0   \u001B[0m"); // Rojo + Reset
                                break;
                            case '2':
                                System.out.print("\u001B[32m0   \u001B[0m"); // Verde + Reset
                                break;
                            case '3':
                                System.out.print("\u001B[34m0   \u001B[0m"); // Azul + Reset
                                break;
                            case '4':
                                System.out.print("\u001B[33m0   \u001B[0m"); // Amarillo + Reset
                                break;
                        }
                    }

                } else if (tablero[i][j] >= 'A' && tablero[i][j] <= 'D') {
                    System.out.print("*   ");
                } else {
                    System.out.print(tablero[i][j] + "   ");
                }

            }//Fin for de Impresion barcos visibles o ocultos
            System.out.println();
        }

    }//Fin impresion del tablero

    public char[][] inicializarMatriz() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
        return tablero;
    }

    public void eliminarBarco(int numeroBarco) {//Eliminar barco para cambiar de porsicion
        char letraBarco = Integer.toString(numeroBarco).charAt(0);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == letraBarco) {
                    tablero[i][j] = '-';
                }

            }
        }
    }//Fin eliminar barco

    public boolean atacarCoordenada(int fila, int columna) throws InterruptedException {//atacar possicion en el tablero enemigo
        int valor;
        char valorConvertido;
        if (tablero[fila][columna] == 'X' || (tablero[fila][columna] >= 'A' && tablero[fila][columna] <= 'D')) {
            System.out.println("\n\u001B[31m\u26A0 Ya atacó este lugar, intentelo de nuevo." + "\u001B[0m");
            return false;
        }
        if (tablero[fila][columna] == '-') {
            tablero[fila][columna] = 'X';
            System.out.println("\u001B[31m" + "MISS\n" + "\u001B[0m");
            for(int i = 2; i >= 0; i--){
                System.out.print("\r" + (i+1) + "...");
                Thread.sleep(1000); // esperar 1s
            }
        } else {
            valor = tablero[fila][columna] - '0';
            valorConvertido = (char) ('A' + valor - 1);
            tablero[fila][columna] = valorConvertido;
            System.out.println("\u001B[32m" + "HIT\n" + "\u001B[0m");
            for(int i = 2; i >= 0; i--){
                System.out.print("\r" + (i+1) + "...");
                Thread.sleep(1000); // esperar 1s
            }
        }

        return true;
    }

    public boolean recorrerTablero() {//recorremos en tablero para saber la condicion de los barcos
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] >= '1' && tablero[i][j] <= '4') {
                    return false;
                }
            }
        }
        return true;
    }

    public String capturarPosicionBarco(int numeroBarco) {//Captura y valida las coordenadas de los barcos
        String coordenadaFinal;
        char coordenadaFila;
        int coordenadaColumna;
        char letra = (char) ('A' + numeroBarco - 1);
        char numero = (numeroBarco + "").charAt(0);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == letra || tablero[i][j] == numero) {//validad si las coordenadas estan en el formato correcto
                    coordenadaFila = (char) ('A' + i);
                    coordenadaColumna = j + 1;

                    if (i < tablero.length - 1 && (tablero[i + 1][j] == letra || tablero[i + 1][j] == numero)) {
                        coordenadaFinal = coordenadaFila + "" + coordenadaColumna + " Vertical hacia abajo";
                        return coordenadaFinal;
                    } else if (j < tablero.length - 1 && (tablero[i][j + 1] == letra || tablero[i][j + 1] == numero)) {
                        coordenadaFinal = coordenadaFila + "" + coordenadaColumna + " Horizontal hacia la derecha";
                        return coordenadaFinal;
                    }

                }
            }
        }
        return "";
    }//Fin captura de posicion

}