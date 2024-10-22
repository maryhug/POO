package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.BArmarComputador;
import bean.BChasis;
import bean.BDiscoDuro;

public class LArmarComputador {

    private LChasis logicaChasis = new LChasis();
    private LDiscoDuro logicaDiscoDuro = new LDiscoDuro();

    public void insertar(BArmarComputador bArmarComputador) {
        try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "rw")) {
            archivo.seek(archivo.length());

            archivo.writeInt(bArmarComputador.getIdArmarComputardor());

            logicaChasis.insertar(archivo, bArmarComputador.getChasis());

            logicaDiscoDuro.insertar(archivo, bArmarComputador.getDd());

            System.out.println("Computador insertado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }

    public String EncontrarRegistroIdentificacion(int wid) {
        String retorno = "No se encontró el computador con ID: " + wid;

        try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "r")) {
            archivo.seek(0);

            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();

                if (id == wid) {
                    String chasisInfo = logicaChasis.buscar(archivo);
                    String discoDuroInfo = logicaDiscoDuro.buscar(archivo);

                    retorno = "Computador con ID: " + id + "\n" + chasisInfo + "\n" + discoDuroInfo;
                    break;
                } else {
                    logicaChasis.saltarRegistro(archivo);
                    logicaDiscoDuro.saltarRegistro(archivo);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return retorno;
    }

    public void listarRegistros() {
        try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "r")) {
            archivo.seek(0);

            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();
                String chasisInfo = logicaChasis.buscar(archivo);
                String discoDuroInfo = logicaDiscoDuro.buscar(archivo);

                System.out.println("ID: " + id + "\n" + chasisInfo + "\n" + discoDuroInfo + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void modificarComputador(int wid, Scanner scanner) {
        boolean encontrado = false;

        try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "rw")) {
            RandomAccessFile archivoTemporal = new RandomAccessFile(".\\Datos\\Datos_temp.txt", "rw");

            archivo.seek(0);
            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();

                if (id == wid) {
                    encontrado = true;

                    System.out.println("Modificando chasis...");
                    BChasis nuevoChasis = logicaChasis.modificarChasis(scanner);

                    System.out.println("Modificando disco duro...");
                    BDiscoDuro nuevoDiscoDuro = logicaDiscoDuro.modificarDiscoDuro(scanner);

                    archivoTemporal.writeInt(id);
                    logicaChasis.insertar(archivoTemporal, nuevoChasis);
                    logicaDiscoDuro.insertar(archivoTemporal, nuevoDiscoDuro);
                } else {
                    archivoTemporal.writeInt(id);
                    logicaChasis.insertar(archivoTemporal, logicaChasis.leer(archivo));
                    logicaDiscoDuro.insertar(archivoTemporal, logicaDiscoDuro.leer(archivo));
                }
            }

            archivo.close();
            archivoTemporal.close();

            if (encontrado) {
                new java.io.File(".\\Datos\\Datos.txt").delete();
                new java.io.File(".\\Datos\\Datos_temp.txt").renameTo(new java.io.File(".\\Datos\\Datos.txt"));
                System.out.println("Computador modificado correctamente.");
            } else {
                new java.io.File(".\\Datos\\Datos_temp.txt").delete();
                System.out.println("No se encontró un computador con ID: " + wid);
            }
        } catch (IOException e) {
            System.out.println("Error al modificar los datos: " + e.getMessage());
        }
    }

    public boolean eliminarComputador(int wid) {
        boolean eliminado = false;

        try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "r")) {
            RandomAccessFile archivoTemporal = new RandomAccessFile(".\\Datos\\Datos_temp.txt", "rw");

            archivo.seek(0);
            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();

                if (id != wid) {
                    archivoTemporal.writeInt(id);
                    logicaChasis.insertar(archivoTemporal, logicaChasis.leer(archivo));
                    logicaDiscoDuro.insertar(archivoTemporal, logicaDiscoDuro.leer(archivo));
                } else {
                    eliminado = true;
                    logicaChasis.saltarRegistro(archivo);
                    logicaDiscoDuro.saltarRegistro(archivo);
                }
            }

            archivoTemporal.close();
            archivo.close();

            new java.io.File(".\\Datos\\Datos.txt").delete();
            new java.io.File(".\\Datos\\Datos_temp.txt").renameTo(new java.io.File(".\\Datos\\Datos.txt"));

            if (eliminado) {
                System.out.println("Computador eliminado correctamente.");
            } else {
                System.out.println("No se encontró un computador con ID: " + wid);
            }

        } catch (IOException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }

        return eliminado;
    }
}
