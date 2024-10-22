package vistas;

import java.util.Scanner;

import bean.BArmarComputador;
import logica.LArmarComputador;

import bean.BChasis;
import bean.BDiscoDuro;

public class Inicio {

    public static void main(String[] args) {
        LArmarComputador logica = new LArmarComputador();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("==== MENÚ ARMAR COMPUTADOR ====");
            System.out.println("1. Insertar un nuevo computador");
            System.out.println("2. Buscar computador por ID");
            System.out.println("3. Listar computador por ID");
            System.out.println("4. Modificar computador por ID");
            System.out.println("5. Eliminar computador por ID");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
            case 1:
                insertarComputador(scanner, logica);
                break;
            case 2:
                buscarComputador(scanner, logica);
                break;
            case 3:
                logica.listarRegistros();
                break;
            case 4:
            	logica.modificarComputador(scanner, logica);
                break;
            case 5:
                System.out.print("Ingrese el ID del computador a eliminar: ");
                int idEliminar = scanner.nextInt();
                logica.eliminarComputador(idEliminar);
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void insertarComputador(Scanner scanner, LArmarComputador logica) {
        System.out.println("==== Insertar un nuevo computador ====");

        System.out.print("Ingrese el ID del computador: ");
        int idComputador = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el largo de la placa del chasis: ");
        int largoPlaca = scanner.nextInt();
        System.out.print("Ingrese el ancho de la placa del chasis: ");
        int anchoPlaca = scanner.nextInt();
        System.out.print("Ingrese el número de ranuras: ");
        int ranuras = scanner.nextInt();
        System.out.print("¿Administra cables? (true/false): ");
        boolean adminCables = scanner.nextBoolean();
        System.out.print("Ingrese el ancho del chasis: ");
        int anchoChasis = scanner.nextInt();
        System.out.print("Ingrese el alto del chasis: ");
        int altoChasis = scanner.nextInt();
        System.out.print("Ingrese la profundidad del chasis: ");
        int profundidadChasis = scanner.nextInt();
        scanner.nextLine();

        BChasis chasis = new BChasis();
        chasis.setLargoPlaca(largoPlaca);
        chasis.setAnchoPlaca(anchoPlaca);
        chasis.setRanuras(ranuras);
        chasis.setAdminCables(adminCables);
        chasis.setAncho(anchoChasis);
        chasis.setAlto(altoChasis);
        chasis.setProfundidad(profundidadChasis);

        System.out.print("Ingrese el tipo de disco duro (Magnetico/SSD): ");
        String tipoDisco = scanner.nextLine();
        System.out.print("Ingrese la interfaz del disco duro (IDE/SATA/SCSI/SAS): ");
        String interfaz = scanner.nextLine();
        System.out.print("Ingrese la capacidad del disco duro (en GB): ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        BDiscoDuro dd = new BDiscoDuro();
        dd.setTipoDisco(tipoDisco);
        dd.setInterfaz(interfaz);
        dd.setCapacidad(capacidad);

        BArmarComputador computador = new BArmarComputador(chasis, dd, idComputador);

        logica.insertar(computador);
    }

    private static void buscarComputador(Scanner scanner, LArmarComputador logica) {
        System.out.println("==== Buscar computador por ID ====");

        System.out.print("Ingrese el ID del computador: ");
        int id = scanner.nextInt();

        String resultado = logica.EncontrarRegistroIdentificacion(id);

        System.out.println("Resultado de la búsqueda: " + resultado);
    }
}
