public class Tablero {
    private char[][] tablero;

    public boolean validarCoordenada(char columna, int fila) {
        int columnaIndex = (int) columna - 'A';
        int filaIndex = fila - 1;
        return columnaIndex >= 0 && columnaIndex < 9 && filaIndex >= 0 && filaIndex < 9;
    }

    public boolean validarEspacio(char columna, int fila, int tamaño, int option) {
        if (option == 1) {
            for (int i = (int) columna; i <= (int) columna + tamaño; i++) {
                if (!validarCoordenada((char) i, fila)) {
                    return false;
                }
            }
        } else {
            for (int i = fila; i <= fila + tamaño; i++) {
                if (!validarCoordenada(columna, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setBarco(char columna, int fila, int tamaño, int option) {
        if (option == 1) {
            for (int i = (int) columna; i <= (int) columna + tamaño; i++) {
                tablero[(char) i - 'A'][fila] = '0';
            }
        } else {
            for (int i = fila; i <= fila + tamaño; i++) {
                tablero[(int) columna - 'A'][i] = '0';
            }
        }
    }
}