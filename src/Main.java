import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (! salir) {
            System.out.println("\n--- GESTIÓN DE CITAS TALLER ---");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Consultar citas por fecha");
            System.out.println("3. Calcular coste de servicio");
            System.out.println("4. Salir");
            System.out.print(" Seleccione una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 1) {
                registrarCita(scanner);
            }
            if (opcion == 4) {
                salir = true;
                System.out.println(" Saliendo del programa ...");
            }
        }
    }

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void registrarCita(Scanner scanner) {
        scanner.nextLine();

        System.out.println("\n--- REGISTRAR NUEVA CITA ---");

        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine().trim();

        System.out.print("Marca y modelo del vehículo: ");
        String vehiculo = scanner.nextLine().trim();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine().trim().toUpperCase();

        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print("Fecha de la cita (dd/MM/yyyy): ");
            String entrada = scanner.nextLine().trim();
            try {
                fecha = LocalDate.parse(entrada, FORMATO_FECHA);
                if (fecha.isBefore(LocalDate.now())) {
                    System.out.println("La fecha no puede ser anterior a hoy.");
                    fecha = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Usa el formato dd/MM/yyyy (ej. 25/11/2026).");
            }
        }

        System.out.println("\nCita registrada:");
        System.out.println("Cliente:   " + cliente);
        System.out.println("Vehículo:  " + vehiculo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Fecha:     " + fecha.format(FORMATO_FECHA));
    }

}

