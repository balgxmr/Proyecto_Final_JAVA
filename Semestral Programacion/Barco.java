public class Barco {
    public int verificarBarco(int op) {
        boolean[] verificador = { true, true, true, true };
        int tamaño = 0;

        if (op == 1 && verificador[0] == true) {
            tamaño = 4;
            verificador[0] = false;
        } else if (op == 2 && verificador[1] == true) {
            tamaño = 3;
            verificador[1] = false;
        } else if (op == 3 && verificador[2] == true) {
            tamaño = 2;
            verificador[2] = false;
        } else if (op == 4 && verificador[3] == true) {
            tamaño = 2;
            verificador[3] = false;
        } else {
            System.out.println("Ya ha colocado este barco, escoja otro");
        }

        return tamaño;
    }
}
