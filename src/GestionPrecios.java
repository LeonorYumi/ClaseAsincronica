import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrecios {
    static ArrayList<Double> listaPrecios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENÚ DE PRECIOS INMOBILIARIOS =====");
            System.out.println("1. Ingresar precio");
            System.out.println("2. Mostrar todos los precios");
            System.out.println("3. Mostrar precio más alto");
            System.out.println("4. Mostrar precio más bajo");
            System.out.println("5. Mostrar precios iguales");
            System.out.println("6. Buscar un precio específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ingresarPrecio();
                    break;
                case 2:
                    mostrarPrecios();
                    break;
                case 3:
                    precioMasAlto();
                    break;
                case 4:
                    precioMasBajo();
                    break;
                case 5:
                    precioIguales();
                    break;
                case 6:
                    buscarPrecio();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }
    // Opción 1
    public static void ingresarPrecio() {
        System.out.print("Ingrese un precio (mayor que 0): ");
        double precio = scanner.nextDouble();

        if (precio > 0) {
            listaPrecios.add(precio);
            System.out.println("Precio agregado correctamente.");
        } else {
            System.out.println("Error: el precio debe ser mayor que cero.");
        }
    }
    // Opción 2
    public static void mostrarPrecios() {
        if (listaPrecios.isEmpty()) {
            System.out.println("No existen precios registrados.");
        } else {
            System.out.println("Lista de precios:");
            for (double p : listaPrecios) {
                System.out.println("- $" + p);
            }
        }
    }
    // Opción 3
    public static void precioMasAlto() {
        if (listaPrecios.isEmpty()) {
            System.out.println("No hay precios registrados.");
            return;
        }
        double max = listaPrecios.get(0);
        for (double p : listaPrecios) {
            if (p > max) {
                max = p;
            }
        }
        System.out.println("El precio más alto es: $" + max);
    }
    // Opción 4
    public static void precioMasBajo() {
        if (listaPrecios.isEmpty()) {
            System.out.println("No hay precios registrados.");
            return;
        }
        double min = listaPrecios.get(0);
        for (double p : listaPrecios) {
            if (p < min) {
                min = p;
            }
        }
        System.out.println("El precio más bajo es: $" + min);
    }
    // Opción 5
    public static void precioIguales() {
        if (listaPrecios.isEmpty()) {
            System.out.println("No hay precios registrados.");
            return;
        }
        System.out.print("Ingrese el precio que desea buscar repetidos: ");
        double valor = scanner.nextDouble();
        boolean encontrado = false;
        int contador = 0;
        for (double p : listaPrecios) {
            if (p == valor) {
                encontrado = true;
                contador++;
            }
        }
        if (encontrado) {
            System.out.println("El precio $" + valor + " aparece " + contador + " veces.");
        } else {
            System.out.println("No existen precios iguales al valor ingresado.");
        }
    }
    // Opción 6
    public static void buscarPrecio() {
        System.out.print("Ingrese el precio que quiere buscar: ");
        double buscar = scanner.nextDouble();
        if (listaPrecios.contains(buscar)) {
            System.out.println("El precio SÍ existe.");
        } else {
            System.out.println("El precio NO se encuentra registrado.");
        }
    }
}