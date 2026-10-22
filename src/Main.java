import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter ;
import java.time.format.DateTimeParseException ;
import java.util.Locale;
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
            if (opcion == 3) {
                probarCalculoCoste(scanner);
            }
            if (opcion == 4) {
                salir = true;
                System.out.println(" Saliendo del programa ...");
            }
            }

        }

        public class GestorFechas {

         // Constante con el patron de formato espa ´ nol ˜
         private static final String PATRON_FECHA = "dd/MM/yyyy HH:mm";

         // Formateador reutilizable configurado con la localizacion´ en espanol ˜
         private static final DateTimeFormatter FORMATO_ESPANOL =  DateTimeFormatter.ofPattern (PATRON_FECHA , new
                Locale("es", "ES"));

        /**
        * Convierte un objeto LocalDateTime a una cadena con formato espanol dd/MM/yyyy HH:mm ˜
         * * @param fechaHora Objeto LocalDateTime a formatear
         * @return Cadena de texto formateada o mensaje de error si el parametro es nulo ´
         */

        public static String formatearFechaEspanol ( LocalDateTime fechaHora ) {
                     if ( fechaHora == null) {
                         return "Fecha no disponible ";
                         }
                    return fechaHora .format( FORMATO_ESPANOL );
                    }

        /**
         * 31 * Pide al usuario una fecha y hora por consola , valida la entrada
         * y la devuelve como objeto LocalDateTime .
         *@param scanner Objeto Scanner activo
         * @return LocalDateTime introducido por el usuario o la fecha actual si falla
         */
         public static LocalDateTime leerYValidarFecha (Scanner scanner) {
             System.out.print(" Introduzca la fecha y hora de la cita (" + PATRON_FECHA + "): ");
             String entrada = scanner. nextLine ().trim ();
                    try {
                        // Intenta parsear la cadena ingresada seg´un el patron definido ´
                        LocalDateTime fechaParseada = LocalDateTime .parse(entrada , FORMATO_ESPANOL );
                        System.out.println(" Fecha registrada correctamente .");
                        return fechaParseada ;
                    } catch ( DateTimeParseException e) {
}
             System.out.println("Formato incorrecto . Debe usar exactamente el formato: dd/MM/yyyy HH:mm");
             System.out.println("Se asignar´a la fecha y hora actual por defecto.");
             return LocalDateTime .now ();
             }
 }

         /**
         * Ejemplo de prueba para invocar desde la opcioncorrespondiente del menu.
          */
         public static void probarFormatoFecha (Scanner scanner) {
                 System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");

        System.out.println("\nCita registrada:");
        System.out.println("Cliente:   " + cliente);
        System.out.println("Vehículo:  " + vehiculo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Fecha:     " + fecha.format(FORMATO_FECHA));
    }
    public static double calcularCosteServicio(int tipoServicio, String matricula) {
        double precioBase;

        switch (tipoServicio) {
            case 1:
                precioBase = 50.0;   // Cambio de aceite y filtro
                break;
            case 2:
                precioBase = 120.0;  // Revisión general / Pre-ITV
                break;
            case 3:
                precioBase = 200.0;  // Cambio de frenos y discos
                break;
            case 4:
                precioBase = 350.0;  // Reparación de distribución
                break;
            default:
                System.out.println("Opción de servicio no válida. Se aplicará tarifa estándar.");
                precioBase = 80.0;
                break;
        }

        String matriculaLimpia = matricula.trim().toUpperCase();

        double porcentajeDescuento = 0.0;

        // Regla A: terminan en "ECO"
        if (matriculaLimpia.endsWith("ECO")) {
            porcentajeDescuento = 0.20;
            System.out.println("Aplicado 20% de descuento por matrícula ECO.");

            // Regla B: contienen "00"
        } else if (matriculaLimpia.contains("00")) {
            porcentajeDescuento = 0.10;
            System.out.println("Aplicado 10% de descuento por promoción especial (serie 00).");

            // Regla C: empiezan por 'H'
        } else if (matriculaLimpia.startsWith("H")) {
            porcentajeDescuento = 0.15;
            System.out.println("Aplicado 15% de descuento para vehículo histórico.");

        } else {
            System.out.println("No se aplican descuentos a esta matrícula.");
        }

        double descuento = precioBase * porcentajeDescuento;
        double precioFinal = precioBase - descuento;

        return precioFinal;
    }

    public static void probarCalculoCoste(Scanner scanner) {
        System.out.println("\n--- CÁLCULO DE COSTE DE SERVICIO ---");
        System.out.println("1. Cambio de aceite y filtro (50€)");
        System.out.println("2. Revisión general (120€)");
        System.out.println("3. Cambio de frenos (200€)");
        System.out.println("4. Distribución (350€)");
        System.out.print("Seleccione el tipo de servicio: ");
        int opcionServicio = scanner.nextInt();

        scanner.nextLine(); // Limpieza de búfer tras nextInt()

        System.out.print("Introduzca la matrícula del vehículo (ej. 1234ECO, H1234BBB, 0012KFX): ");
        String matriculaInput = scanner.nextLine();

        double total = calcularCosteServicio(opcionServicio, matriculaInput);

        System.out.printf("El importe total a pagar es: %.2f€\n", total);
    }

    public class GestorFechas {

        // Constante con el patron de formato espa ´ nol ˜
        private static final String PATRON_FECHA = "dd/MM/yyyy HH:mm";

        // Formateador reutilizable configurado con la localizacion´ en espanol ˜
        private static final DateTimeFormatter FORMATO_ESPANOL = DateTimeFormatter.ofPattern(PATRON_FECHA, new
                Locale("es", "ES"));

        /**
         * Convierte un objeto LocalDateTime a una cadena con formato espanol dd/MM/yyyy HH:mm ˜
         * * @param fechaHora Objeto LocalDateTime a formatear
         *
         * @return Cadena de texto formateada o mensaje de error si el parametro es nulo ´
         */

        public static String formatearFechaEspanol(LocalDateTime fechaHora) {
            if (fechaHora == null) {
                return "Fecha no disponible ";
            }
            return fechaHora.format(FORMATO_ESPANOL);
        }

        /**
         * 31 * Pide al usuario una fecha y hora por consola , valida la entrada
         * y la devuelve como objeto LocalDateTime .
         *
         * @param scanner Objeto Scanner activo
         * @return LocalDateTime introducido por el usuario o la fecha actual si falla
         */
        public static LocalDateTime leerYValidarFecha(Scanner scanner) {
            System.out.print(" Introduzca la fecha y hora de la cita (" + PATRON_FECHA + "): ");
            String entrada = scanner.nextLine().trim();
            try {
                // Intenta parsear la cadena ingresada seg´un el patron definido ´
                LocalDateTime fechaParseada = LocalDateTime.parse(entrada, FORMATO_ESPANOL);
                System.out.println(" Fecha registrada correctamente .");
                return fechaParseada;
            } catch (DateTimeParseException e) {
            }
            System.out.println("Formato incorrecto . Debe usar exactamente el formato: dd/MM/yyyy HH:mm");
            System.out.println("Se asignar´a la fecha y hora actual por defecto.");
            return LocalDateTime.now();
        }


        /**
         * Ejemplo de prueba para invocar desde la opcioncorrespondiente del menu.
         */
        public static void probarFormatoFecha(Scanner scanner) {
            System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");

            // 1. Mostrar la fecha/hora actual formateada
            LocalDateTime ahora = LocalDateTime.now();
            String fechaActualFormateada = formatearFechaEspanol(ahora);
            System.out.println(" Fecha y hora actual del sistema: " + fechaActualFormateada);

            // 2. Pedir una fecha al usuario y mostrar el resultado formateado
            LocalDateTime fechaCita = leerYValidarFecha(scanner);
            System.out.println("Cita fijada para el: " + formatearFechaEspanol(fechaCita));
        }
    }
}
