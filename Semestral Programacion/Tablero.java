public class Tablero {
    private char[][] tablero;

    public boolean validarCoordenada(int columna, int fila) {

    }

    public boolean validarEspacio(int columna, int fila, int tamaño, int option) {
        if (option == 1) {
            for (int i = columna; i <= columna + tamaño; i++) {
                if (validarCoordenada(i, fila)) {

                }
            }
        } else {
            for (int i = fila; i <= fila + tamaño; i++) {
                if (validarCoordenada(columna, i)) {

                }
            }
        }

    }
}