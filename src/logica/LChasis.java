package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.BChasis;

public class LChasis {

    public void insertar(RandomAccessFile archivo, BChasis chasis) throws IOException {
        archivo.writeInt(chasis.getLargoPlaca());
        archivo.writeInt(chasis.getAnchoPlaca());
        archivo.writeInt(chasis.getRanuras());
        archivo.writeBoolean(chasis.isAdminCables());
        archivo.writeInt(chasis.getAncho());
        archivo.writeInt(chasis.getAlto());
        archivo.writeInt(chasis.getProfundidad());
    }

    public BChasis leer(RandomAccessFile archivo) throws IOException {
        BChasis chasis = new BChasis();
        chasis.setLargoPlaca(archivo.readInt());
        chasis.setAnchoPlaca(archivo.readInt());
        chasis.setRanuras(archivo.readInt());
        chasis.setAdminCables(archivo.readBoolean());
        chasis.setAncho(archivo.readInt());
        chasis.setAlto(archivo.readInt());
        chasis.setProfundidad(archivo.readInt());

        return chasis;
    }

    public String buscar(RandomAccessFile archivo) throws IOException {
        return "Chasis: [LargoPlaca: " + archivo.readInt() + ", AnchoPlaca: " + archivo.readInt()
                + ", Ranuras: " + archivo.readInt() + ", AdminCables: " + archivo.readBoolean()
                + ", Ancho: " + archivo.readInt() + ", Alto: " + archivo.readInt()
                + ", Profundidad: " + archivo.readInt() + "]";
    }

    public BChasis modificarChasis(Scanner scanner) {
        BChasis chasis = new BChasis();
        System.out.print("Nuevo largo de la placa del chasis: ");
        chasis.setLargoPlaca(scanner.nextInt());

        System.out.print("Nuevo ancho de la placa del chasis: ");
        chasis.setAnchoPlaca(scanner.nextInt());

        System.out.print("Nuevo número de ranuras: ");
        chasis.setRanuras(scanner.nextInt());

        System.out.print("¿Administra cables? (true/false): ");
        chasis.setAdminCables(scanner.nextBoolean());

        System.out.print("Nuevo ancho del chasis: ");
        chasis.setAncho(scanner.nextInt());

        System.out.print("Nuevo alto del chasis: ");
        chasis.setAlto(scanner.nextInt());

        System.out.print("Nueva profundidad del chasis: ");
        chasis.setProfundidad(scanner.nextInt());

        return chasis;
    }

    public void saltarRegistro(RandomAccessFile archivo) throws IOException {
        archivo.readInt();
        archivo.readInt();
        archivo.readInt();
        archivo.readBoolean();
        archivo.readInt();
        archivo.readInt();
        archivo.readInt();
    }
}