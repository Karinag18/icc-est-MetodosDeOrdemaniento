import java.util.Arrays;

public class AlgoritmosOrdenamiento {

    //Metodo de Seleccion
    public int[] Seleccion(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if ((ascendente && arreglo[j] < arreglo[indiceMinimo]) 
                || (!ascendente && arreglo[j] > arreglo[indiceMinimo])) {
                    indiceMinimo = j;
                }
            }
            int numMenor = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = numMenor;

            if (pasos) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    //Metodo de Inserccion
    public int[] Inserccion(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j - 1;
            while (i >= 0 && (ascendente ? arreglo[i] > key : arreglo[i] < key)) {
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = key;

            if (pasos) {
                System.out.println("Paso " + j + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    //Metodo Burbuja Normal
    public int[] Burbuja(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente 
                && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;

                    if (pasos) {
                        System.out.println("Intercambio " + arreglo[j] + " con " + arreglo[j + 1]);
                    }
                }
            }
            if (pasos) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    //Metodo Burbuja Mejorado
    public int[] BurbujaMejorado(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        boolean huboIntercambio;
        for (int i = 0; i < arreglo.length - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] 
                < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    huboIntercambio = true;

                    if (pasos) {
                        System.out.println("Intercambio " + arreglo[j] + " con " + arreglo[j + 1]);
                    }
                }
            }
            if (pasos) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
            if (!huboIntercambio) {
                break;
            }
        }
        return arreglo;
    }
}
