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

    public String capturarCoordenada(String message) {
        String coordenada;
        try {
            while (true) {
                System.out.println(message);
                coordenada = read.readLine();
                if (coordenada.length() == 2) {
                    return coordenada;
                } else {
                    System.out.println("Ingrese un valor valido");
                }
            }
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido");
            return capturarCoordenada(message);
        }
    }

    public int capturarMenu(String message) {

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
            return capturarMenu(message);
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