import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase es el template para los compradores que quieren comprar boletos.
 */
public class Comprador {
    /** Nombre del comprador. */
    public String Nombre;

    /** Correo electronico del comprador. */
    public String Email;

    /** Cantidad de boletos que el comprador desea comprar. */
    public int CanBoletos;

    /** Presupuesto maximo del comprador. */
    public float PresupuestoMax;

    /**
     * Solicita al usuario los detalles necesarios para iniciar la compra.
     */
    public void SolicitarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre: ");
        Nombre = scanner.nextLine();
        System.out.print("Email: ");
        Email = scanner.nextLine();
        System.out.print("Cantidad de boletos: ");
        CanBoletos = scanner.nextInt();
        System.out.print("Presupuesto maximo: ");
        PresupuestoMax = scanner.nextFloat();
    }

    /**
     * Procesa la compra.
     *
     * @param localidades Un arreglo de objetos Localidad que representan las localidades disponibles.
     */
    public void ProcesarCompra(Localidad[] localidades) {
        if (CanBoletos <= 0 || CanBoletos > 20) {
            System.out.println("Cantidad de boletos sobrepasa el disopnible.");
            return;
        }

        Random rand = new Random();
        int ticket = rand.nextInt(15000) + 1;
        int a = rand.nextInt(15000) + 1;
        int b = rand.nextInt(15000) + 1;

        boolean ticketApto = (ticket >= Math.min(a, b)) && (ticket <= Math.max(a, b));

        if (ticketApto) {
            int localidadIndex = rand.nextInt(localidades.length);
            Localidad localidadSeleccionada = localidades[localidadIndex];

            if (localidadSeleccionada.getEspaciosDisp() == 0) {
                System.out.println("La localidad esta agotada.");
                return;
            }

            int boletosComprar = Math.min(CanBoletos, localidadSeleccionada.getEspaciosDisp());
            float totalCompra = boletosComprar * localidadSeleccionada.getPrecio();

            if (totalCompra > PresupuestoMax) {
                System.out.println("El presupuesto no es suficiente.");
                return;
            }

            localidadSeleccionada.VenderBoletos(boletosComprar);
            localidadSeleccionada.ActualizarEspacios(boletosComprar);
            ActualizarDatos();

            System.out.println("Compra realizada:");
            System.out.println("Localidad: " + localidadSeleccionada.getNumlocalidad());
            System.out.println("Boletos comprados: " + boletosComprar);
            System.out.println("Total: $" + totalCompra);
        } else {
            System.out.println("No es elegible para realizar la compra.");
        }
    }

    /**
     * Actualiza los datos del comprador. No creo que sea necesario incluirlo, en nuevo comprador se puede agregar los datos de nuevo si es necesario.
     */
    public void ActualizarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Actualizar nombre: ");
        Nombre = scanner.nextLine();
        System.out.print("Actualizar email: ");
        Email = scanner.nextLine();
        System.out.print("Actualizar cantidad de boletos: ");
        CanBoletos = scanner.nextInt();
        System.out.print("Actualizar presupuesto maximo: ");
        PresupuestoMax = scanner.nextFloat();
    }
}
