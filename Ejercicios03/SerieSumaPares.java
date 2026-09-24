import java.util.Scanner;

public class SerieSumaPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        
        do {
            System.out.print("Ingrese N: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Por favor, ingrese un número entero positivo mayor a 0.");
            }
        } while (n <= 0);

        int contador = 0;   
        int acumulador = 0; 

        System.out.println("\nSerie:");
        for (int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
            contador++;
            acumulador += i;
        }
        System.out.println();

        
        System.out.println("\nCantidad de pares: " + contador);
        System.out.println("Suma: " + acumulador);

        if (contador > 0) {
            double promedio = (double) acumulador / contador;
            System.out.println("Promedio: " + promedio);
        } else {
            System.out.println("No se encontraron números pares en el rango.");
        }

        scanner.close();
    }
}
