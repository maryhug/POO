package logica;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.BArmarComputador;
import bean.BChasis;
import bean.BDiscoDuro;

public class LArmarComputador {

	/*
	 * Insertar un nuevo computador 
	 * Buscar computador por ID 
	 * Listar computador por
	 * ID Modificar computador por ID
	 * Eliminar computador por ID")
	 */

	public void insertar(BArmarComputador bArmarComputador) {
		try {
			RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "rw");
			archivo.seek(archivo.length());

			archivo.writeInt(bArmarComputador.getIdArmarComputardor());

			archivo.writeInt(bArmarComputador.getChasis().getLargoPlaca());
			archivo.writeInt(bArmarComputador.getChasis().getAnchoPlaca());
			archivo.writeInt(bArmarComputador.getChasis().getRanuras());
			archivo.writeBoolean(bArmarComputador.getChasis().isAdminCables());
			archivo.writeInt(bArmarComputador.getChasis().getAncho());
			archivo.writeInt(bArmarComputador.getChasis().getAlto());
			archivo.writeInt(bArmarComputador.getChasis().getProfundidad());

			archivo.writeUTF(bArmarComputador.getDd().getTipoDisco());
			archivo.writeUTF(bArmarComputador.getDd().getInterfaz());
			archivo.writeInt(bArmarComputador.getDd().getCapacidad());

			archivo.close();
			System.out.println("Datos guardados correctamente en el archivo.");

		} catch (IOException e) {
			System.out.println("Error al guardar los datos: " + e.getMessage());
		}
	}

	public String EncontrarRegistroIdentificacion(int wid) {
		String retorno = "No se encontró el computador con ID: " + wid;

		try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "r")) {
			archivo.seek(0);

			while (archivo.getFilePointer() < archivo.length()) {
				int id = archivo.readInt();

				if (id == wid) {
					int largoPlaca = archivo.readInt();
					int anchoPlaca = archivo.readInt();
					int ranuras = archivo.readInt();
					boolean adminCables = archivo.readBoolean();
					int anchoChasis = archivo.readInt();
					int altoChasis = archivo.readInt();
					int profundidadChasis = archivo.readInt();

					String tipoDisco = archivo.readUTF();
					String interfaz = archivo.readUTF();
					int capacidad = archivo.readInt();

					retorno = "Computador con ID: " + id + "\n" + "Chasis: [LargoPlaca: " + largoPlaca
							+ ", AnchoPlaca: " + anchoPlaca + ", Ranuras: " + ranuras + ", AdminCables: " + adminCables
							+ ", Ancho: " + anchoChasis + ", Alto: " + altoChasis + ", Profundidad: "
							+ profundidadChasis + "]\n" + "Disco Duro: [TipoDisco: " + tipoDisco + ", Interfaz: "
							+ interfaz + ", Capacidad: " + capacidad + " GB]";
					break;
				} else {
					archivo.readInt();
					archivo.readInt();
					archivo.readInt();
					archivo.readBoolean();
					archivo.readInt();
					archivo.readInt();
					archivo.readInt();
					archivo.readUTF();
					archivo.readUTF();
					archivo.readInt();
				}
			}
		} catch (EOFException e) {
			System.out.println("Se llegó al final del archivo inesperadamente.");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return retorno;
	}

	public void listarRegistros() {
		String wcadena;
		try (RandomAccessFile archivo = new RandomAccessFile(".\\Datos\\Datos.txt", "r")) {
			archivo.seek(0);
			while (archivo.getFilePointer() < archivo.length()) {

				int id = archivo.readInt();
				wcadena = "ID: " + id + " ";

				int largoPlaca = archivo.readInt();
				int anchoPlaca = archivo.readInt();
				int ranuras = archivo.readInt();
				boolean adminCables = archivo.readBoolean();
				int anchoChasis = archivo.readInt();
				int altoChasis = archivo.readInt();
				int profundidadChasis = archivo.readInt();

				String tipoDisco = archivo.readUTF();
				String interfaz = archivo.readUTF();
				int capacidad = archivo.readInt();

				wcadena += "Chasis: [LargoPlaca: " + largoPlaca + ", AnchoPlaca: " + anchoPlaca + ", Ranuras: "
						+ ranuras + ", AdminCables: " + adminCables + ", Ancho: " + anchoChasis + ", Alto: "
						+ altoChasis + ", Profundidad: " + profundidadChasis + "] ";

				wcadena += "Disco Duro: [TipoDisco: " + tipoDisco + ", Interfaz: " + interfaz + ", Capacidad: "
						+ capacidad + " GB]";

				System.out.println(wcadena);
			}
		} catch (EOFException e) {
			System.out.println("Se llegó al final del archivo inesperadamente.");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}

	public void modificarComputador(Scanner scanner, LArmarComputador logica) {
		System.out.print("Ingrese el ID del computador a modificar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Ingrese el nuevo largo de la placa del chasis: ");
		int largoPlaca = scanner.nextInt();
		System.out.print("Ingrese el nuevo ancho de la placa del chasis: ");
		int anchoPlaca = scanner.nextInt();
		System.out.print("Ingrese el nuevo número de ranuras: ");
		int ranuras = scanner.nextInt();
		System.out.print("¿Administra cables? (true/false): ");
		boolean adminCables = scanner.nextBoolean();
		System.out.print("Ingrese el nuevo ancho del chasis: ");
		int anchoChasis = scanner.nextInt();
		System.out.print("Ingrese el nuevo alto del chasis: ");
		int altoChasis = scanner.nextInt();
		System.out.print("Ingrese la nueva profundidad del chasis: ");
		int profundidadChasis = scanner.nextInt();
		scanner.nextLine();

		BChasis nuevoChasis = new BChasis();
		nuevoChasis.setLargoPlaca(largoPlaca);
		nuevoChasis.setAnchoPlaca(anchoPlaca);
		nuevoChasis.setRanuras(ranuras);
		nuevoChasis.setAdminCables(adminCables);
		nuevoChasis.setAncho(anchoChasis);
		nuevoChasis.setAlto(altoChasis);
		nuevoChasis.setProfundidad(profundidadChasis);

		System.out.print("Ingrese el nuevo tipo de disco duro (Magnetico/SSD): ");
		String tipoDisco = scanner.nextLine();
		System.out.print("Ingrese la nueva interfaz del disco duro (IDE/SATA/SCSI/SAS): ");
		String interfaz = scanner.nextLine();
		System.out.print("Ingrese la nueva capacidad del disco duro (en GB): ");
		int capacidad = scanner.nextInt();
		scanner.nextLine();

		BDiscoDuro nuevoDd = new BDiscoDuro();
		nuevoDd.setTipoDisco(tipoDisco);
		nuevoDd.setInterfaz(interfaz);
		nuevoDd.setCapacidad(capacidad);
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
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeBoolean(archivo.readBoolean());
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeInt(archivo.readInt());
					archivoTemporal.writeUTF(archivo.readUTF());
					archivoTemporal.writeUTF(archivo.readUTF());
					archivoTemporal.writeInt(archivo.readInt());
				} else {
					eliminado = true;
					archivo.readInt();
					archivo.readInt();
					archivo.readInt();
					archivo.readBoolean();
					archivo.readInt();
					archivo.readInt();
					archivo.readInt();
					archivo.readUTF();
					archivo.readUTF();
					archivo.readInt();
				}
			}

			archivoTemporal.close();
			archivo.close();

			new java.io.File(".\\Datos\\Datos.txt").delete();
			new java.io.File(".\\Datos\\Datos_temp.txt").renameTo(new java.io.File(".\\Datos\\Datos.txt"));

			if (eliminado) {
				System.out.println("Registro eliminado con éxito.");
			} else {
				System.out.println("No se encontró un registro con ID: " + wid);
			}

		} catch (IOException e) {
			System.out.println("Error al eliminar el registro: " + e.getMessage());
		}

		return eliminado;
	}

}
