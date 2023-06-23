import java.io.*;
public class Manejo_errores {
    static int valor(String mensaje) throws IOException{//funcio para errores, solo se admiten numeros

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(mensaje);
            return Integer.parseInt(leer.readLine());
        } catch (Exception e) {
            System.out.println("\nIngrese un valor valido\n");
            return valor(mensaje);
        }
    }

    static String name(String mensaje) {//funcio para errores, solo se admiten nombres

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(mensaje);
            return leer.readLine();
        } catch (Exception e) {
            System.out.println("\nIngrese un nombre no se premiten numeros\n");
            return name(mensaje);
        }
    }
    
}
