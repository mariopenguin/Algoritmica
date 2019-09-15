import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[1000000];
        Random random = new Random();

        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt();
        }
        long inicio =System.currentTimeMillis();
        //ordenarPorBurbuja(array);
        ordenarPorCombSort(array);
        //Arrays.sort(array);
        long finalizado = System.currentTimeMillis();
        long duracion = finalizado - inicio;
        System.out.println(duracion+ " longitud"+array.length);
    }


    static void ordenarPorBurbuja (int[] vector){
        boolean ordenado=false;
        int j=vector.length-1;
        while (!ordenado) {
            ordenado=true;
            for (int i=0; i<j; i++) {
                if (vector[i]>vector[i+1]) {
                    int aux=vector[i]; vector[i]=vector[i+1]; vector[i+1]=aux;
                    ordenado=false;
                }
            }
            j--;
        }
    }

    static void ordenarPorCombSort (int[] vector){
        boolean ordenado=false;
        int gap=vector.length-1;
        //Ordena los extremos
        if (vector[0]>vector[gap]) {
            int aux=vector[0]; vector[0]=vector[gap]; vector[gap]=aux;
        }
        //Mientras no ordenado y gap>1
        while (!ordenado || gap>1) {
            if (gap>1) gap=(int) Math.floor(gap/1.3);
            ordenado=true;
            int i=0;
            //
            while (i+gap < vector.length) {
                if (vector[i]>vector[i+gap]) {
                    int aux=vector[i]; vector[i]=vector[i+gap]; vector[i+gap]=aux;
                    ordenado=false;
                }
                i++;
            }
        }
    }
}
