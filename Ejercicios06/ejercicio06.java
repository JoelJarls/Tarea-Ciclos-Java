import java.util.Scanner;

public class ejercicio06 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("=== TRIANGULO Y PATRONES ===");
            System.out.print("Ingrese un numero entre 2 y 10: ");

            while (!sc.hasNextInt()) {
                System.out.print("Error: Ingrese un numero entero entre 2 y 10: ");
                sc.next();
            }
            int n = sc.nextInt();

            // Validacion de rango de 2 a 10
            while (n < 2 || n > 10) {
                System.out.print("Error: El numero debe estar entre 2 y 10. Ingrese de nuevo: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Error: Ingrese un numero entero entre 2 y 10: ");
                    sc.next();
                }
                n = sc.nextInt();
            }

            // PATRON 1: Triangulo creciente de asteriscos
            System.out.println("\n--- PATRON 1 ---");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            // PATRON 2: Triangulo decreciente de asteriscos
            System.out.println("\n--- PATRON 2 ---");
            for (int i = n; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            // PATRON 3: Triangulo creciente de numeros
            System.out.println("\n--- PATRON 3 ---");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                System.out.println();
            }

        }
    }
}