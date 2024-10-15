import java.util.Arrays;

public class AlgoritmosOrdenamiento {

    //Metodo de Seleccion
    public int[] Seleccion(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length); 
        boolean verifiOrdenado; //Parametro de verificacion de arreglo ordenado
        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            //verifiOrdenado = true;  // Suponemos que el arreglo está ordenado
            for (int j = i + 1; j < arreglo.length; j++) {
                if ((ascendente && arreglo[j] < arreglo[indiceMinimo]) 
                || (!ascendente && arreglo[j] > arreglo[indiceMinimo])) {
                    indiceMinimo = j;
                    verifiOrdenado = false;  // Si se encuentra un desorden, false
                }
            }
            //if (verifiOrdenado) {
                //System.out.println("El arreglo ya está ordenado después de " + (i + 1) + " pasos.");
                //break;  // Salimos del bucle
            //}

            int numMenor = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = numMenor;

            if (pasos) {
                //System.out.println("Intercambio " + arreglo[i] + " con " + arreglo[indiceMinimo]);
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;  // Retorna el arreglo ya ordenado

    }
    

    //Metodo de Inserccion
    public int[] Inserccion(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        boolean verifiOrdenado;  // Parámetro de verificación de arreglo ordenado

        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];  // Valor clave 
            int i = j - 1;
            //verifiOrdenado = true;  // Suponemos que el arreglo está ordenado

            // Desplazar los elementos mayores (ascendente) o menores (descendente)
            while (i >= 0 && (ascendente ? arreglo[i] > key : arreglo[i] < key)) {
                arreglo[i + 1] = arreglo[i];  // Desplazamiento
                i--;
                //verifiOrdenado = false;  // Si se encuentra un desorden, false
            }
            arreglo[i + 1] = key;  // Insertar el valor clave

            if (pasos) {
                //System.out.println("Inserción del valor " + key + " en la posición " + (i + 1));
                System.out.println("Paso " + j + ": " + Arrays.toString(arreglo));
            }

            // Si el arreglo ya está ordenado, terminamos
            //if (verifiOrdenado) {
                //System.out.println("El arreglo ya está ordenado después de " + j + " pasos.");
                //break;  // Salida del bucle
            //}
        }
        return arreglo;  // Retorna el arreglo ya ordenado
    }

    //Metodo Burbuja Normal
    public int[] Burbuja(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        boolean verifiOrdenado;  //Parametro de verificacion de arreglo ordenado
        for (int i = 0; i < arreglo.length - 1; i++) {
            verifiOrdenado = true;  // Suponemos que el arreglo está ordenado
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    // Intercambia los elementos si están en el orden incorrecto
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    verifiOrdenado = false;  // Si se encuentra un desorden, false
                }
                if (pasos) {
                    System.out.println("Intercambio " + arreglo[j] + " con " + arreglo[j + 1]);
                }
            }
    
            if (pasos) {
                // Imprimir el estado del arreglo después de cada pasada completa
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
    
            if (verifiOrdenado) {  // Si el arreglo ya esta ordenado
                System.out.println("El arreglo ya está ordenado después de " + (i + 1) + " pasos.");
                break;  // Salida del bucle
            }
        }
        return arreglo;  // Retorna el arreglo ya ordenado
    }
    

    //Metodo Burbuja Mejorado
    public int[] BurbujaMejorado(int[] arregloOriginal, boolean pasos, boolean ascendente) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        boolean verifiOrdenado;  // Parámetro de verificación de arreglo ordenado
    
        for (int i = 0; i < arreglo.length - 1; i++) {
            verifiOrdenado = true;  // Suponemos que el arreglo está ordenado
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    // Realizar el intercambio
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    verifiOrdenado = false;  // Si se encuentra un desorden, false
                    if (pasos) {
                        System.out.println("Intercambio " + arreglo[j] + " con " + arreglo[j + 1]);
                    }
                }
            }
    
            if (pasos) {
                // Imprimimos el arreglo después de cada paso
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
    
            if (verifiOrdenado) {  // Si el arreglo ya esta ordenado
                System.out.println("El arreglo ya está ordenado después de " + (i + 1) + " pasos.");
                break;  // Salida del bucle
            }
        }
        return arreglo;  // Retorna el arreglo ya ordenado
    }
    
    
}
