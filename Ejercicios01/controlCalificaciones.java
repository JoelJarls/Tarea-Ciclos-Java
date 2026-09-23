package controlcalificaciones;

import java.util.Scanner;

public class ControlCalificaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Ingrese la cantidad de estudiantes: ");
            n = sc.nextInt();
            if (n > 0) {
                break;
            } else {
                System.out.println("Error: el número de estudiantes debe ser mayor que cero.");
            }
        }

        double suma = 0;
        double mayor = -1.0; 
        double menor = 11.0; 
        int aprobados = 0;
        int reprobados = 0;
        final double NOTA_APROBACION = 7.0; 

        for (int i = 0; i < n; i++) {
            double nota;
            
            while (true) {
                System.out.print("Ingrese la nota del estudiante " + (i + 1) + " (0 a 10): ");
                nota = sc.nextDouble();
                if (nota >= 0 && nota <= 10) {
                    break;
                } else {
                    System.out.println("Error: la nota debe estar entre 0 y 10.");
                }
            }

            suma += nota;

            if (nota > mayor) {
                mayor = nota;
            }
            if (nota < menor) {
                menor = nota;
            }

            if (nota >= NOTA_APROBACION) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double promedio = suma / n;

        System.out.println("\n--- Resultados ---");
        System.out.println("Numero de estudiantes: " + n);
        System.out.println("Suma de calificaciones: " + suma);
        System.out.println("Promedio general: " + promedio);
        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de reprobados: " + reprobados);
        System.out.println("Nota mas alta: " + mayor);
        System.out.println("Nota mas baja: " + menor);

    }
}
