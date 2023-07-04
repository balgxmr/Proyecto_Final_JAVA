public class Tablero {
    private char[][] tablero = new char[9][9];

    public Tablero() {
        this.tablero = inicializarMatriz();
    }

    public boolean validarCoordenada(int fila, int columna) {
        return fila >= 0 && fila < 9 && columna >= 0 && columna < 9;
    }

    public boolean validarEspacio(int fila, int columna, int tamaño, int option) {
        if (option == 1) {
            for (int i = columna; i < columna + tamaño; i++) {
                if (!validarCoordenada(fila, i) || tablero[fila][i] != '-') {
                    return false;
                }
            }
        } else {
            for (int i = fila; i < fila + tamaño; i++) {
                if (!validarCoordenada(i, columna) || tablero[i][columna] != '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public void setBarco(int fila, int columna, int numeroBarco, int tamaño, int optionForma) {
        char letraBarco = Integer.toString(numeroBarco).charAt(0);
        if (optionForma == 1) {
            for (int i = columna; i < columna + tamaño; i++) {
                tablero[fila][i] = letraBarco;
            }
        } else {
            for (int i = fila; i < fila + tamaño; i++) {
                tablero[i][columna] = letraBarco;
            }
        }
    }

    public void imprimirTablero(boolean ocultarBarco) {
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
                    if (ocultarBarco) {
                        System.out.print("-   ");
                    } else {
                        System.out.print("0   ");
                    }

                } else if (tablero[i][j] >= 'A' && tablero[i][j] <= 'D') {
                    System.out.print("*   ");
                } else {
                    System.out.print(tablero[i][j] + "   ");
                }

            }
            System.out.println();
        }

    }

    public char[][] inicializarMatriz() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
        return tablero;
    }

    public void eliminarBarco(int numeroBarco) {
        char letraBarco = Integer.toString(numeroBarco).charAt(0);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == letraBarco) {
                    tablero[i][j] = '-';
                }

            }
        }
    }

    public boolean atacarCoordenada(int fila, int columna) {
        int valor;
        char valorConvertido;
        if (tablero[fila][columna] == 'X' || (tablero[fila][columna] >= 'A' && tablero[fila][columna] <= 'D')) {
            System.out.println("Ya ataco este lugar, intentelo de nuevo");
            return false;
        }
        if (tablero[fila][columna] == '-') {
            tablero[fila][columna] = 'X';
            System.out.println("MISS");
        } else {
            System.out.println("HIT");
            valor = tablero[fila][columna] - '0';
            valorConvertido = (char) ('A' + valor - 1);
            tablero[fila][columna] = valorConvertido;
        }

        return true;
    }

    public boolean recorrerTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] >= '1' && tablero[i][j] <= '4') {
                    return false;
                }
            }
        }
        return true;
    }

    public String capturarPosicionBarco(int numeroBarco) {
        String coordenadaFinal;
        char coordenadaFila;
        int coordenadaColumna;
        char letra = (char) ('A' + numeroBarco - 1);
        char numero = (numeroBarco + "").charAt(0);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == letra || tablero[i][j] == numero) {
                    coordenadaFila = (char) ('A' + i);
                    coordenadaColumna = j + 1;
                    if (tablero[i + 1][j] == letra || tablero[i + 1][j] == numero) {
                        coordenadaFinal = coordenadaFila + coordenadaColumna + " Vertical hacia abajo";
                        return coordenadaFinal;
                    } else if (tablero[i][j + 1] == letra || tablero[i][j + 1] == numero) {
                        coordenadaFinal = coordenadaFila + "" + coordenadaColumna + " Horizontal hacia la derecha";
                        return coordenadaFinal;
                    }

                }
            }
        }
        return "";
    }

}