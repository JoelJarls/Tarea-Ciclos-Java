import java.util.Scanner;

public class cajeroAutomatico {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int opcion;
    int contadorDepositos = 0;       
    int contadorRetiros = 0;

    double saldo = 100; 
    double totalDepositado = 0;
    double totalRetirado = 0;
    double monto;

       do {

            System.out.println("\n===== CAJERO ACADEMICO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.printf(
                        "Saldo actual: $%.2f%n", saldo
                    );
                    break;

                case 2:
                    System.out.print(
                        "Ingrese el monto a depositar: "
                    );
                    monto = sc.nextDouble();

                    if (monto < 0) {
                        System.out.println(
                            "Error: No se permiten depositos negativos."
                        );
                    } else {
                        saldo += monto;
                        totalDepositado += monto;
                        contadorDepositos++;

                        System.out.println(
                            "Deposito realizado correctamente."
                        );
                        System.out.printf(
                            "Saldo actual: $%.2f%n", saldo
                        );
                    }
                    break;

                case 3:
                    System.out.print(
                        "Ingrese el monto a retirar: "
                    );
                    monto = sc.nextDouble();

                    if (monto < 0) {
                        System.out.println(
                            "Error: No se permiten retiros negativos."
                        );
                    } else if (monto > saldo) {
                        System.out.println(
                            "Error: Saldo insuficiente."
                        );
                    } else {
                        saldo -= monto;
                        totalRetirado += monto;
                        contadorRetiros++;

                        System.out.println(
                            "Retiro realizado correctamente."
                        );
                        System.out.printf(
                            "Saldo actual: $%.2f%n", saldo
                        );
                    }
                    break;

                case 4:
                    System.out.println("\n===== MOVIMIENTOS =====");

                    System.out.println(
                        "Depositos realizados: " + contadorDepositos
                    );

                    System.out.println(
                        "Retiros realizados: " + contadorRetiros
                    );

                    System.out.printf(
                        "Total depositado: $%.2f%n", totalDepositado
                    );

                    System.out.printf(
                        "Total retirado: $%.2f%n", totalRetirado
                    );

                    System.out.printf(
                        "Saldo actual: $%.2f%n", saldo
                    );
                    break;

                case 5:
                    System.out.println("\n===== RESUMEN FINAL =====");

                    System.out.println(
                        "Depositos realizados: " + contadorDepositos
                    );

                    System.out.println(
                        "Retiros realizados: " + contadorRetiros
                    );

                    System.out.printf(
                        "Total depositado: $%.2f%n", totalDepositado
                    );

                    System.out.printf(
                        "Total retirado: $%.2f%n", totalRetirado
                    );

                    System.out.printf(
                        "Saldo final: $%.2f%n", saldo
                    );

                    System.out.println(
                        "Gracias por utilizar el cajero."
                    );
                    break;

                default:
                    System.out.println(
                        "Error: Opcion inexistente."
                    );
            }

        } while (opcion != 5);

        sc.close();
    }
}
