import java.io.*;

public class CapturarDatos {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public String capturarDatos(String message) {

        try {
            System.out.println(message);
            return read.readLine();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDatos(message);
        }
    }

    public char capturarColumnas(String message) {
        char columna = ' ';
        boolean loop = true;
        try {
            while (loop) {

                System.out.println(message);
                columna = read.readLine().charAt(0);
                if (!(columna == 'A' || columna == 'B' || columna == 'C' || columna == 'D' || columna == 'E'
                        || columna == 'F' || columna == 'G' || columna == 'H' || columna == 'I')) {
                    System.out.println("Valor incorrecto, Ingrese un valor entre A e I");
                } else {
                    loop = false;
                }
            }
            return columna;

        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarColumnas(message);
        }
    }

    public int capturarFilas(String message) {
        int fila = 0;
        boolean loop = true;
        try {
            while (loop) {
                System.out.println(message);
                fila = Integer.parseInt(read.readLine());
                if (fila < 0 || fila >= 9) {
                    System.out.println("Valor incorrecto, Ingrese un valor entre 1 y 9");
                } else {
                    loop = false;
                }
            }
            return fila;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarFilas(message);
        }
    }

    public int capturarDireccionBarco(String message) {

        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.println(message);
                option = Integer.parseInt(read.readLine());
                if (option > 2 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                }
            }
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarDireccionBarco(message);
        }
    }

    public int capturarOpcionBarco(String message) {

        boolean loop = true;
        int option = 0;
        try {
            while (loop) {
                System.out.println(message);
                option = Integer.parseInt(read.readLine());
                if (option > 4 || option < 0) {
                    System.out.println("Ingrese un valor valido");
                } else {
                    loop = false;
                }
            }
            return option;
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarOpcionBarco(message);
        }
    }

}