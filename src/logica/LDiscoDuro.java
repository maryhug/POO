package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.BDiscoDuro;

public class LDiscoDuro {

    public void insertar(RandomAccessFile archivo, BDiscoDuro discoDuro) throws IOException {
        archivo.writeUTF(discoDuro.getTipoDisco());
        archivo.writeUTF(discoDuro.getInterfaz());
        archivo.writeInt(discoDuro.getCapacidad());
    }

    public BDiscoDuro leer(RandomAccessFile archivo) throws IOException {
        BDiscoDuro discoDuro = new BDiscoDuro();
        discoDuro.setTipoDisco(archivo.readUTF());
        discoDuro.setInterfaz(archivo.readUTF());
        discoDuro.setCapacidad(archivo.readInt());

        return discoDuro;
    }

    public String buscar(RandomAccessFile archivo) throws IOException {
        return "Disco Duro: [TipoDisco: " + archivo.readUTF() + ", Interfaz: " + archivo.readUTF()
                + ", Capacidad: " + archivo.readInt() + " GB]";
    }

    public BDiscoDuro modificarDiscoDuro(Scanner scanner) {
        BDiscoDuro discoDuro = new BDiscoDuro();

        
        System.out.print("Tipo de disco (Magnetico / SSD): ");
        discoDuro.setTipoDisco(scanner.next());
       
        System.out.print("Interfaz (IDE/SATA/SCSI/SAS/SATA Express): ");
        discoDuro.setInterfaz(scanner.next());

        System.out.print("Nueva capacidad: ");
        discoDuro.setCapacidad(scanner.nextInt());

        return discoDuro;
    }

    public void saltarRegistro(RandomAccessFile archivo) throws IOException {
        archivo.readUTF();
        archivo.readUTF();
        archivo.readInt();
    }
}
