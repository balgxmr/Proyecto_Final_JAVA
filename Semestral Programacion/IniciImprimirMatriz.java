
public class IniciImprimirMatriz{
        public static String[][] mat_Imp = new String[9][9];
        
        public static void Imprimir_Matriz(){
            int nUm = 1;
            char letra = 'A';
            System.out.print("    ");
            for (int x = 0; x < 9; x++) {
                System.out.print(nUm + "   ");   
                nUm++;
            }
            System.out.println();
            for (int i = 0; i < mat_Imp.length; i++) {
                System.out.print(letra + "   ");
                letra++;
                for (int j = 0; j < mat_Imp.length; j++) {
                    mat_Imp[i][j] = "-";
                    System.out.print(mat_Imp[i][j] + "   ");
                }
                System.out.println();
            }

        }

}