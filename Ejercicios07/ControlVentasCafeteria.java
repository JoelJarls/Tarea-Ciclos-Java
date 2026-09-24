import java.util.Scanner;

public class ControlVentasCafeteria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcionMenu;
        int totalVentas = 0;
        int totalProductos = 0;
        double totalRecaudado = 0.0;

        int cantCafe = 0;
        int cantSandwich = 0;
        int cantJugo = 0;
        int cantEmpanada = 0;

        do {
            System.out.println("===================================");
            System.out.println("      CAFETERÍA UNIVERSITARIA      ");
            System.out.println("===================================");
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Mostrar tabla de productos");
            System.out.println("4. Salir");
            System.out.println("===================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un número entre 1 y 4: ");
                scanner.next();
            }
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    int opcionProducto;
                    do {
                        System.out.println("\n--- SELECCIONE PRODUCTO ---");
                        System.out.println("1. Café       $1.00");
                        System.out.println("2. Sándwich   $2.50");
                        System.out.println("3. Jugo       $1.50");
                        System.out.println("4. Empanada   $1.25");
                        System.out.print("Opción (1-4): ");

                        while (!scanner.hasNextInt()) {
                            System.out.print("Entrada inválida. Ingrese un número entre 1 y 4: ");
                            scanner.next();
                        }
                        opcionProducto = scanner.nextInt();
                    } while (opcionProducto < 1 || opcionProducto > 4);

                    int cantidad;
                    do {
                        System.out.print("Ingrese la cantidad (mayor a 0): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Entrada inválida. Ingrese una cantidad entera positiva: ");
                            scanner.next();
                        }
                        cantidad = scanner.nextInt();
                    } while (cantidad <= 0);

                    double precio = 0.0;
                    switch (opcionProducto) {
                        case 1:
                            precio = 1.00;
                            cantCafe += cantidad;
                            break;
                        case 2:
                            precio = 2.50;
                            cantSandwich += cantidad;
                            break;
                        case 3:
                            precio = 1.50;
                            cantJugo += cantidad;
                            break;
                        case 4:
                            precio = 1.25;
                            cantEmpanada += cantidad;
                            break;
                    }

                    totalVentas++;
                    totalProductos += cantidad;
                    totalRecaudado += (precio * cantidad);

                    System.out.println("¡Venta registrada con éxito!\n");
                    break;

                case 2:
                    System.out.println("\n=== ESTADÍSTICAS DE VENTAS ===");
                    if (totalVentas > 0) {
                        double promedioVenta = totalRecaudado / totalVentas;

                        System.out.println("Número de ventas: " + totalVentas);
                        System.out.println("Cantidad total de productos: " + totalProductos);
                        System.out.printf("Total recaudado: $%.2f\n", totalRecaudado);
                        System.out.printf("Promedio por venta: $%.2f\n", promedioVenta);

                        int mayorCantidad = Math.max(Math.max(cantCafe, cantSandwich), Math.max(cantJugo, cantEmpanada));

                        System.out.println("Producto(s) con mayor cantidad vendida (" + mayorCantidad + " unidades):");
                        if (cantCafe == mayorCantidad) System.out.println("- Café");
                        if (cantSandwich == mayorCantidad) System.out.println("- Sándwich");
                        if (cantJugo == mayorCantidad) System.out.println("- Jugo");
                        if (cantEmpanada == mayorCantidad) System.out.println("- Empanada");
                    } else {
                        System.out.println("No se han registrado ventas.");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("\n=== TABLA DE PRODUCTOS ===");
                    System.out.println("1. Café       $1.00");
                    System.out.println("2. Sándwich   $2.50");
                    System.out.println("3. Jugo       $1.50");
                    System.out.println("4. Empanada   $1.25\n");
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.\n");
                    break;
            }

        } while (opcionMenu != 4);

        scanner.close();
    }
}
