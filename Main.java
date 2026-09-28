import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion = -1;

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO TREE-STOCK ===");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Inorden)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el ID del producto (número entero): ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        inventario.insertar(id, nombre);
                        System.out.println("¡Producto registrado con éxito!");
                        break;
                    case 2:
                        inventario.mostrarInorden();
                        break;
                    case 3:
                        System.out.print("Ingrese el ID a buscar: ");
                        int idBuscar = scanner.nextInt();
                        boolean encontrado = inventario.buscar(idBuscar);
                        if (encontrado) {
                            System.out.println(" Resultado: El producto con ID " + idBuscar + " SÍ existe en el inventario.");
                        } else {
                            System.out.println(" Resultado: El producto con ID " + idBuscar + " NO se encuentra en el inventario.");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
            }
        } while (opcion != 0);

        scanner.close();
    }
}