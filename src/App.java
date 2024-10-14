import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Instanciaciónes
        Scanner leer = new Scanner(System.in);
        AlgoritmosOrdenamiento algOrd = new AlgoritmosOrdenamiento();
        //Parametros
        boolean continuar = true;
        int[] arreglo = null;
        boolean arregloIngresado = false;

        //Inicio de programa en consola
        System.out.println("\n-------------------------------\n");
        System.out.println("..........BIENVENID@...........");
        System.out.println("\n-------------------------------\n");

        //Condicion
        while (continuar) {
            System.out.println("........MENU PRINCIPAL.........");
            System.out.println("- 1) Ingresar arreglo");
            System.out.println("- 2) Ordenar arreglo");
            System.out.println("- 3) Salir");
            System.out.println("\n-------------------------------\n");

            //Parametro
            int opcionMenuPrincipal = obtenerOpcionValida(leer, 1, 3);

            switch (opcionMenuPrincipal) {
                case 1:
                    arreglo = ingresarArreglo(leer);
                    arregloIngresado = true;
                    break;
                case 2:
                    if (arregloIngresado) {
                        ordenarArreglo(leer, arreglo, algOrd);
                    } else {
                        System.out.println("Primero debe ingresar un arreglo.");
                    }
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
            }
        }
        leer.close();
    }

    //Metodo odtenerOpcionValida
    private static int obtenerOpcionValida(Scanner leer, int min, int max) {
        int opcion;
        do {
            //Mensaje de advertencia o error
            System.err.println("Seleccione una opción:");
            //Verifica si es un entero
            while (!leer.hasNextInt()) {
                System.out.println("Error: Ingrese un entero válido.");
                leer.next();
            }
            opcion = leer.nextInt();
            //Condicion para el rango de opciones
            if (opcion < min || opcion > max) {
                System.out.println("Error: Opción fuera de rango.");
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    //Metodo ingresarArreglo
    private static int[] ingresarArreglo(Scanner leer) {
        //Parametro
        int tamanio;
        System.out.println(".......Ingreso de arreglo.......");
        System.out.println("Por favor ingresar el tamaño del arreglo");

        do {
            System.out.println("Ingrese un tamaño entero y positivo: ");
            //Verifica si es un entero
            while (!leer.hasNextInt()) {
                System.out.println("Te pedi un entero válido.");
                leer.next();
            }
            tamanio = leer.nextInt();
            //Verifica que no sea negativo
            if (tamanio <= 0) {
                System.out.println("El tamaño debe ser positivo.");
            }
        } while (tamanio <= 0);

        //Parametro
        int[] arreglo = new int[tamanio];
        System.out.println("....Ingrese los números del arreglo....");

        for (int i = 0; i < tamanio; i++) {
            System.out.println("Ingrese número en la posición " + (i + 1) + ":");
            //Verifica si es entero
            while (!leer.hasNextInt()) {
                System.out.println("Te pedí un ENTERO válido.");
                leer.next();
            }
            arreglo[i] = leer.nextInt();
        }

        System.out.println("Los números ingresados son:");
        //Imprime arreglo
        System.out.println(Arrays.toString(arreglo));

        return arreglo;
    }

    //Metodo ordenarArreglo
    private static void ordenarArreglo(Scanner leer, int[] arreglo, AlgoritmosOrdenamiento algOrd) {
        //Parametro
        int opcion, pasos, orden;

        boolean salida = false;
        do {
            System.out.println(".........MENU DE ORDENAMIENTO.........");
            System.out.println("- 0) Volver al menú principal");
            System.out.println("- 1) Metodo Selección");
            System.out.println("- 2) Metodo Inserción");
            System.out.println("- 3) Metodo Burbuja Normal");
            System.out.println("- 4) Metodo Burbuja Mejorado");
            System.out.println("\n--------------------------------------\n ");

            opcion = obtenerOpcionValida(leer, 0, 4);

            //Condicion de opciones
            if (opcion == 0) {
                salida = true;
                continue;
            }

            System.out.println("....Desea ver los pasos....");
            System.out.println("- 1) Si");
            System.out.println("- 2) No");

            pasos = obtenerOpcionValida(leer, 1, 2);
            boolean mostrarPasos = pasos == 1;

            System.out.println("....Elija el tipo de orden....");
            System.out.println("- 1) Ascendente");
            System.out.println("- 2) Descendente");

            orden = obtenerOpcionValida(leer, 1, 2);
            boolean ascendente = orden == 1;

            int[] arregloOrdenado = null;

            //Casos de opciones
            switch (opcion) {
                case 1:
                    System.out.println(".....METODO SELECCION.....");
                    arregloOrdenado = algOrd.Seleccion(arreglo, mostrarPasos, ascendente);
                    break;
                case 2:
                    System.out.println(".....METODO INSERCION.....");
                    arregloOrdenado = algOrd.Inserccion(arreglo, mostrarPasos, ascendente);
                    break;
                case 3:
                    System.out.println(".....METODO BURBUJA NORMAL.....");
                    arregloOrdenado = algOrd.Burbuja(arreglo, mostrarPasos, ascendente);
                    break;
                case 4:
                    System.out.println(".....METODO BURBUJA MEJORADO.....");
                    arregloOrdenado = algOrd.BurbujaMejorado(arreglo, mostrarPasos, ascendente);
                    break;
            }

            //Imprime arreglo sin ordenar
            System.out.println("Arreglo sin ordenar:");
            System.out.println(Arrays.toString(arreglo));

            //Imprime arreglo ordenado
            System.out.println("Arreglo ordenado:");
            System.out.println(Arrays.toString(arregloOrdenado));
            System.out.println("\n--------------------------\n");

            //Fin de salida de Consola
            

        } while (!salida);
    }
}
