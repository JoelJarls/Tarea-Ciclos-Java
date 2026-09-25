import java.util.Scanner;

public class ParqueaderoBasico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arreglos paralelos para almacenar hasta 100 vehículos
        int MAX = 100;
        String[] tipos = new String[MAX];
        String[] roles = new String[MAX];
        int[] horasArray = new int[MAX];
        String[] dias = new String[MAX];
        boolean[] boletos = new boolean[MAX];
        double[] valores = new double[MAX];
        
        int cantidadVehiculos = 0;
        int opcion = 0;
        
        while (opcion != 5) {
            System.out.println("\n================================");
            System.out.println("   PARQUEADERO UNIVERSITARIO");
            System.out.println("================================");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar vehículos registrados");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Mostrar recaudación");
            System.out.println("5. Salir");
            System.out.println("================================"); // Menú solicitado[cite: 1, 2]
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea del buffer
            
            if (opcion == 1) {
                if (cantidadVehiculos < MAX) {
                    System.out.print("Tipo de vehículo (Carro/Moto/Bicicleta): ");
                    String tipo = scanner.nextLine();
                    
                    System.out.print("Rol (Estudiante/Docente/Visitante): ");
                    String rol = scanner.nextLine();
                    
                    int horas = 0;
                    while (horas <= 0) { // Validación de horas positivas[cite: 1]
                        System.out.print("Número de horas (> 0): ");
                        horas = scanner.nextInt();
                        scanner.nextLine();
                    }
                    
                    System.out.print("Día de la semana (Lunes a Domingo): ");
                    String dia = scanner.nextLine();
                    
                    System.out.print("¿Boleto perdido? (Si/No): ");
                    String boletoStr = scanner.nextLine();
                    boolean boletoPerdido = false;
                    if (boletoStr.equalsIgnoreCase("si") || boletoStr.equalsIgnoreCase("sí")) {
                        boletoPerdido = true;
                    }
                    
                    // --- Cálculos de tarifa según el enunciado[cite: 1] ---
                    double tarifaBase = 0;
                    if (tipo.equalsIgnoreCase("Carro")) {
                        tarifaBase = 1.00;
                    } else if (tipo.equalsIgnoreCase("Moto")) {
                        tarifaBase = 0.60;
                    } else if (tipo.equalsIgnoreCase("Bicicleta")) {
                        tarifaBase = 0.25;
                    }
                    
                    double subtotal = horas * tarifaBase;
                    
                    // Descuentos[cite: 1]
                    double descuento = 0;
                    if (rol.equalsIgnoreCase("Estudiante")) {
                        descuento = 0.20; // 20%
                    } else if (rol.equalsIgnoreCase("Docente")) {
                        descuento = 0.10; // 10%
                    }
                    
                    subtotal = subtotal - (subtotal * descuento);
                    
                    // Recargo de fin de semana[cite: 1]
                    if (dia.equalsIgnoreCase("Sabado") || dia.equalsIgnoreCase("Sábado") || dia.equalsIgnoreCase("Domingo")) {
                        subtotal = subtotal + (subtotal * 0.15); // 15%
                    }
                    
                    double total = subtotal;
                    // Recargo de boleto[cite: 1]
                    if (boletoPerdido == true) {
                        total = total + 2.00;
                    }
                    
                    // Guardar en arreglos
                    tipos[cantidadVehiculos] = tipo;
                    roles[cantidadVehiculos] = rol;
                    horasArray[cantidadVehiculos] = horas;
                    dias[cantidadVehiculos] = dia;
                    boletos[cantidadVehiculos] = boletoPerdido;
                    valores[cantidadVehiculos] = total;
                    
                    cantidadVehiculos = cantidadVehiculos + 1;
                    System.out.println("Vehículo registrado exitosamente. Valor a pagar: $" + total);
                } else {
                    System.out.println("No hay espacio para más vehículos.");
                }
                
            } else if (opcion == 2) {
                if (cantidadVehiculos == 0) {
                    System.out.println("No hay vehículos registrados.");
                } else {
                    System.out.println("\n--- LISTA DE VEHÍCULOS ---");
                    for (int i = 0; i < cantidadVehiculos; i = i + 1) {
                        String bol = "No";
                        if (boletos[i] == true) {
                            bol = "Sí";
                        }
                        System.out.println("Vehículo " + (i + 1) + " | Tipo: " + tipos[i] + " | Rol: " + roles[i] + " | Horas: " + horasArray[i] + " | Día: " + dias[i] + " | Boleto perdido: " + bol + " | Pagado: $" + valores[i]);
                    }
                }
                
            } else if (opcion == 3) {
                if (cantidadVehiculos == 0) {
                    System.out.println("No hay vehículos registrados.");
                } else {
                    int cCarros = 0, cMotos = 0, cBicis = 0;
                    int cEst = 0, cDoc = 0, cVis = 0;
                    int totalHoras = 0;
                    
                    for (int i = 0; i < cantidadVehiculos; i = i + 1) {
                        if (tipos[i].equalsIgnoreCase("Carro")) cCarros++;
                        else if (tipos[i].equalsIgnoreCase("Moto")) cMotos++;
                        else if (tipos[i].equalsIgnoreCase("Bicicleta")) cBicis++;
                        
                        if (roles[i].equalsIgnoreCase("Estudiante")) cEst++;
                        else if (roles[i].equalsIgnoreCase("Docente")) cDoc++;
                        else if (roles[i].equalsIgnoreCase("Visitante")) cVis++;
                        
                        totalHoras = totalHoras + horasArray[i];
                    }
                    
                    double promedio = (double) totalHoras / cantidadVehiculos;
                    
                    System.out.println("\n--- ESTADÍSTICAS ---");
                    System.out.println("Carros: " + cCarros + " | Motos: " + cMotos + " | Bicicletas: " + cBicis);
                    System.out.println("Estudiantes: " + cEst + " | Docentes: " + cDoc + " | Visitantes: " + cVis);
                    System.out.println("Total de horas: " + totalHoras);
                    System.out.println("Promedio de permanencia: " + promedio + " horas");
                }
                
            } else if (opcion == 4) {
                if (cantidadVehiculos == 0) {
                    System.out.println("No hay vehículos registrados.");
                } else {
                    double totalRecaudado = 0;
                    double mayorPagado = 0;
                    double menorPagado = 999999; 
                    
                    for (int i = 0; i < cantidadVehiculos; i = i + 1) {
                        totalRecaudado = totalRecaudado + valores[i];
                        
                        if (valores[i] > mayorPagado) {
                            mayorPagado = valores[i];
                        }
                        if (valores[i] < menorPagado) {
                            menorPagado = valores[i];
                        }
                    }
                    
                    System.out.println("\n--- RECAUDACIÓN ---");
                    System.out.println("Total recaudado: $" + totalRecaudado);
                    System.out.println("Mayor valor pagado: $" + mayorPagado);
                    System.out.println("Menor valor pagado: $" + menorPagado);
                }
                
            } else if (opcion == 5) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
