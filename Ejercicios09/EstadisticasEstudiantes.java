import java.util.Scanner;

public class EstadisticasEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes participarán? ");
        int n = sc.nextInt();

        int[] edad = new int[n];
        int[] semestre = new int[n];
        int[] horas = new int[n];

        int sumaEdad = 0;
        int sumaHoras = 0;
        int maxHoras = -1;
        int indiceMax = 0;
        int contMenos2 = 0;

        // Entrada de datos con validaciones
        for (int i = 0; i < n; i++) {
            // Edad
            do {
                System.out.print("Edad del estudiante " + (i + 1) + ": ");
                edad[i] = sc.nextInt();
                if (edad[i] < 16 || edad[i] > 80) {
                    System.out.println("Error: la edad debe estar entre 16 y 80");
                }
            } while (edad[i] < 16 || edad[i] > 80);

            // Semestre
            do {
                System.out.print("Semestre del estudiante " + (i + 1) + ": ");
                semestre[i] = sc.nextInt();
                if (semestre[i] < 1 || semestre[i] > 10) {
                    System.out.println("Error: el semestre debe estar entre 1 y 10");
                }
            } while (semestre[i] < 1 || semestre[i] > 10);

            // Horas de estudio
            do {
                System.out.print("Horas de estudio del estudiante " + (i + 1) + ": ");
                horas[i] = sc.nextInt();
                if (horas[i] < 0 || horas[i] > 24) {
                    System.out.println("Error: las horas deben estar entre 0 y 24");
                }
            } while (horas[i] < 0 || horas[i] > 24);

            // Acumuladores
            sumaEdad += edad[i];
            sumaHoras += horas[i];

            // Máximo de horas
            if (horas[i] > maxHoras) {
                maxHoras = horas[i];
                indiceMax = i + 1; // +1 para mostrar número de estudiante
            }

            // Contar estudiantes con menos de 2 horas
            if (horas[i] < 2) {
                contMenos2++;
            }
        }

        // Cálculo de promedios
        double edadProm = (double) sumaEdad / n;
        double horasProm = (double) sumaHoras / n;

        // Resultados
        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Edad promedio: " + edadProm);
        System.out.println("Horas promedio de estudio: " + horasProm);
        System.out.println("Estudiante con más horas de estudio: #" + indiceMax + " (" + maxHoras + " horas)");
        System.out.println("Estudiantes que estudian menos de 2 horas: " + contMenos2);
        System.out.println("Estudiantes por semestre:");

        // Conteo por semestre
        for (int s = 1; s <= 10; s++) {
            int contSemestre = 0;
            for (int i = 0; i < n; i++) {
                if (semestre[i] == s) {
                    contSemestre++;
                }
            }
            if (contSemestre > 0) {
                System.out.println("  Semestre " + s + ": " + contSemestre + " estudiante(s)");
            }
        }

        sc.close();
    }
}
