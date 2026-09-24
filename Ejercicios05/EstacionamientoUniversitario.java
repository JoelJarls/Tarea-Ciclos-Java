import java.util.Scanner;

public class EstacionamientoUniversitario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Contadores y Acumuladores
        int contMoto = 0, contAuto = 0, contCamioneta = 0;
        double totalRecaudado = 0.0;
        
        int tipoVehiculo;
        double horas;
        int continuar;
        
        // Bucle principal para registrar varios vehículos
        do {
            System.out.println("\nSeleccione el tipo de vehículo:");
            System.out.println("1. Motocicleta");
            System.out.println("2. Automóvil");
            System.out.println("3. Camioneta");
            System.out.print("Opción: ");
            tipoVehiculo = scanner.nextInt();
            
            if (tipoVehiculo >= 1 && tipoVehiculo <= 3) {
                // Validación con do-while: horas mayores que cero
                do {
                    System.out.print("Horas estacionado: ");
                    horas = scanner.nextDouble();
                    if (horas <= 0) {
                        System.out.println("Error: Las horas deben ser mayores que cero.");
                    }
                } while (horas <= 0);
                
                double pago = 0.0;
                
                // Estructura switch para procesar las tarifas
                switch (tipoVehiculo) {
                    case 1:
                        pago = horas * 0.50;
                        contMoto++;
                        break;
                    case 2:
                        pago = horas * 1.00;
                        contAuto++;
                        break;
                    case 3:
                        pago = horas * 1.50;
                        contCamioneta++;
                        break;
                }
                
                totalRecaudado += pago; // Acumulador
                System.out.printf("El vehículo debe pagar: $%.2f\n", pago);
                
            } else {
                System.out.println("Opción de vehículo no válida.");
            }
            
            System.out.print("\n¿Desea registrar otro vehículo? (1 para Sí, 0 para terminar): ");
            continuar = scanner.nextInt();
            
        } while (continuar != 0);
        
        // Cálculos para el reporte final
        int totalVehiculos = contMoto + contAuto + contCamioneta;
        double promedioPagado = 0.0;
        
        if (totalVehiculos > 0) {
            promedioPagado = totalRecaudado / totalVehiculos;
        }
        
        // Imprimir Reporte Final
        System.out.println("\n===== REPORTE =====");
        System.out.println("Motocicletas: " + contMoto);
        System.out.println("Automóviles: " + contAuto);
        System.out.println("Camionetas: " + contCamioneta);
        System.out.println("Total vehículos: " + totalVehiculos);
        System.out.printf("Total recaudado: $%.2f\n", totalRecaudado);
        System.out.printf("Promedio pagado: $%.2f\n", promedioPagado);
        System.out.println("===================");
        
        scanner.close();
    }
}
