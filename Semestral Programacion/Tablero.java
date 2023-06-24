import java.util.Scanner;

public class Tablero {

    private char[][] matriz;

    public Tablero() {
        matriz = new char[9][9];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public void dibujarTablero() {
        System.out.print("  ");
        for (char c = 'A'; c <= 'I'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int i = 0; i < 9; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean validarCoordenada(char columna, int fila) {
        int columnaIndex = columna - 'A';
        int filaIndex = fila - 1;
        return columnaIndex >= 0 && columnaIndex < 9 && filaIndex >= 0 && filaIndex < 9;
    }

    public boolean setBarco(char columnaInicio, int filaInicio, char columnaFinal, int filaFinal) {
        if (!validarCoordenada(columnaInicio, filaInicio) || !validarCoordenada(columnaFinal, filaFinal))
            return false;
        return true;

    }

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.dibujarTablero();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la columna (A-I): ");
        char columna = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Ingrese la fila (1-9): ");
        int fila = scanner.nextInt();

        tablero.marcarCoordenada(columna, fila);
        tablero.dibujarTablero();

        scanner.close();
    }
}