package vistas;

import java.util.Scanner;
import bean.BArmarComputador;
import bean.BChasis;
import bean.BDiscoDuro;
import logica.LArmarComputador;

public class Inicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LArmarComputador logicaArmarComputador = new LArmarComputador();
        boolean salir = false;

        while (!salir) {
            System.out.println("----- Menú -----");
            System.out.println("1. Insertar computador");
            System.out.println("2. Buscar computador por ID");
            System.out.println("3. Listar todos los computadores");
            System.out.println("4. Modificar computador");
            System.out.println("5. Eliminar computador");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    BArmarComputador nuevoComputador = new BArmarComputador();
                    nuevoComputador.setIdArmarComputardor(generarId(scanner));
                    
                    System.out.println("Insertar datos del chasis:");
                    BChasis nuevoChasis = new BChasis();
                    System.out.print("Largo de la placa: ");
                    nuevoChasis.setLargoPlaca(scanner.nextInt());
                    System.out.print("Ancho de la placa: ");
                    nuevoChasis.setAnchoPlaca(scanner.nextInt());
                    System.out.print("Número de ranuras: ");
                    nuevoChasis.setRanuras(scanner.nextInt());
                    System.out.print("Administra cables (true/false): ");
                    nuevoChasis.setAdminCables(scanner.nextBoolean());
                    System.out.print("Ancho del chasis: ");
                    nuevoChasis.setAncho(scanner.nextInt());
                    System.out.print("Alto del chasis: ");
                    nuevoChasis.setAlto(scanner.nextInt());
                    System.out.print("Profundidad del chasis: ");
                    nuevoChasis.setProfundidad(scanner.nextInt());

                    System.out.println("Insertar datos del disco duro:");
                    BDiscoDuro nuevoDiscoDuro = new BDiscoDuro();
                    System.out.print("Tipo de disco (Magnetico / SSD): ");
                    nuevoDiscoDuro.setTipoDisco(scanner.next());
                    System.out.print("Interfaz (IDE/SATA/SCSI/SAS/SATA Express): ");
                    nuevoDiscoDuro.setInterfaz(scanner.next());
                    System.out.print("Capacidad (en GB): ");
                    nuevoDiscoDuro.setCapacidad(scanner.nextInt());

                    nuevoComputador.setChasis(nuevoChasis);
                    nuevoComputador.setDd(nuevoDiscoDuro);

                    logicaArmarComputador.insertar(nuevoComputador);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del computador a buscar: ");
                    int idBuscar = scanner.nextInt();
                    String resultado = logicaArmarComputador.EncontrarRegistroIdentificacion(idBuscar);
                    System.out.println(resultado);
                    break;

                case 3:
                    logicaArmarComputador.listarRegistros();
                    break;

                case 4:
                    System.out.print("Ingrese el ID del computador a modificar: ");
                    int idModificar = scanner.nextInt();
                    logicaArmarComputador.modificarComputador(idModificar, scanner);
                    break;

                case 5:
                    System.out.print("Ingrese el ID del computador a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    logicaArmarComputador.eliminarComputador(idEliminar);
                    break;
                case 6:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static int generarId(Scanner scanner) {
        System.out.print("Ingrese el ID del computador: ");
        return scanner.nextInt();
    }
}