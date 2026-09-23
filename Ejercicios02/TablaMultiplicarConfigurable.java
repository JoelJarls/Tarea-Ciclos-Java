import java.util.Scanner;

public class TablaMultiplicarConfigurable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la tabla inicial: ");
        int tablaInicial = scanner.nextInt();

        System.out.print("Ingrese la tabla final: ");
        int tablaFinal = scanner.nextInt();

        System.out.print("Ingrese el multiplicador maximo (por defecto es 10): ");
        int maxMultiplicador = scanner.nextInt();

        System.out.println();

        if (tablaInicial > tablaFinal) {
            System.out.println("Error: La tabla inicial no puede ser mayor que la tabla final.");
        } else {
            for (int i = tablaInicial; i <= tablaFinal; i++) {
                System.out.println("TABLA DEL " + i);
                
                for (int j = 1; j <= maxMultiplicador; j++) {
                    System.out.println(i + " x " + j + " = " + (i * j));
                }
                
                System.out.println(); 
            }
        }

        scanner.close();
    }
}
