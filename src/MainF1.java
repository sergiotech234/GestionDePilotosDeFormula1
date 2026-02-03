import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainF1 {

    static ArrayList<Pilotos> pilotos = new ArrayList<>();
    static final String FICHERO = "pilotos_f1.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargarPilotos();

        int opcion;
        do {
            System.out.println("\n--- GESTIÓN PILOTOS F1 ---");
            System.out.println("1. Mostrar pilotos");
            System.out.println("2. Añadir piloto");
            System.out.println("3. Buscar piloto");
            System.out.println("4. Guardar pilotos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> mostrarPilotos();
                case 2 -> añadirPiloto();
                case 3 -> buscarPiloto();
                case 4 -> guardarPilotos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    // 1) Cargar pilotos desde fichero
    public static void cargarPilotos() {
        try (BufferedReader br = new BufferedReader(new FileReader("pilotos_f1.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(
                        ";");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String escuderia = partes[1];
                    int puntos = Integer.parseInt(partes[2]);
                    pilotos.add(new Pilotos(nombre, escuderia, puntos));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero o no existe.");
        }
    }

    // 2) Mostrar pilotos
    public static void mostrarPilotos() {
        if (pilotos.isEmpty()) {
            System.out.println("No hay pilotos registrados.");
            return;
        }
        System.out.println("\nLista de pilotos:");
        for (Pilotos p : pilotos) {
            System.out.println(p);
        }
    }

    // 3) Añadir piloto
    public static void añadirPiloto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        // Comprobar si ya existe
        for (Pilotos p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ese piloto ya existe.");
                return;
            }
        }

        System.out.print("Escudería: ");
        String escuderia = sc.nextLine();

        System.out.print("Puntos: ");
        int puntos = sc.nextInt();
        sc.nextLine();

        pilotos.add(new Pilotos(nombre, escuderia, puntos));
        System.out.println("Piloto añadido correctamente.");
    }

    // 4) Buscar piloto por nombre
    public static void buscarPiloto() {
        System.out.print("Nombre del piloto: ");
        String nombre = sc.nextLine();

        for (Pilotos p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Piloto encontrado:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Piloto no encontrado.");
    }

    // 5) Guardar pilotos al fichero
    public static void guardarPilotos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pilotos_f1.txt"))) {
            for (Pilotos p : pilotos) {
                bw.write(p.toFile());
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
        }
    }
}
