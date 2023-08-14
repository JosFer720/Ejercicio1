import java.util.Scanner;

/**
 * La clase Menu contiene el método main que maneja el programa.
 */
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Localidad[] localidades = new Localidad[]{
            new Localidad(1, 100, 20),
            new Localidad(5, 500, 20),
            new Localidad(10, 1000, 20)
        };

        Comprador comprador = new Comprador();
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte ingresos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
        /**
         * Switch que permite escoger entre las opciones disponibles, el caso y la opcion 2 los considero redundantes pero de igual manera los dejo.
         */
            switch (opcion) {
                case 1:
                    comprador.SolicitarCompra();
                    comprador.ProcesarCompra(localidades);
                    break;
                case 2:
                    comprador.ProcesarCompra(localidades);
                    break;
                case 3:
                    ConsultarDisponibilidadTotal(localidades);
                    break;
                case 4:
                    ConsultarDisponibilidadIndividual(localidades);
                    break;
                case 5:
                    MostrarIngresos(localidades);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Introduce una opcion valida.");
            }
        } while (opcion != 6);
    }

    /**
     * Muestra la disponibilidad las localidades.
     */
    public static void ConsultarDisponibilidadTotal(Localidad[] localidades) {
        System.out.println("Disponibilidad total:");
        for (Localidad localidad : localidades) {
            System.out.println("Localidad " + localidad.getNumlocalidad() + ":");
            System.out.println("Boletos vendidos: " + localidad.getBoletosVen());
            System.out.println("Espacios disponibles: " + localidad.getEspaciosDisp());
            System.out.println();
        }
    }

    /**
     * Consulta la disponibilidad de una localidad específica.
     */
    public static void ConsultarDisponibilidadIndividual(Localidad[] localidades) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el numero de localidad: ");
        int numLocalidad = scanner.nextInt();

        for (Localidad localidad : localidades) {
            if (localidad.getNumlocalidad() == numLocalidad) {
                System.out.println("Localidad " + localidad.getNumlocalidad() + ":");
                System.out.println("Boletos vendidos: " + localidad.getBoletosVen());
                System.out.println("Espacios disponibles: " + localidad.getEspaciosDisp());
                System.out.println();
                return;
            }
        }

        System.out.println("Localidad no encontrada.");
    }

    /**
     * Muestra los ingresos generados por la venta de los boletos.
     */
    public static void MostrarIngresos(Localidad[] localidades) {
        float total = 0; // Declare and initialize the 'total' variable
        for (Localidad localidad : localidades) {
            total += localidad.getBoletosVen() * localidad.getPrecio();
        }
        System.out.println("Total generado por ventas: $" + total);
    }

}