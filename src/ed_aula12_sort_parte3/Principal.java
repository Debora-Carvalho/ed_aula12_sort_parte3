package ed_aula12_sort_parte3;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		int[] valores = {5, 3, 2, 1, 6, 7, 3};
		
		mergeSort(valores);
		
		System.out.println(Arrays.toString(valores));

	}

	private static void mergeSort(int[] valores) {
		int length = valores.length;
		
		//caso base do método recursivo
		if(length == 1) {
			return;     //encerrar método void com o return
		}
		
		int[] left = new int[length/2];
		int[] right = new int[length - length/2];
		
		//recurso oferecido pelo proprio Java para copiar elementos de um array para outro
		System.arraycopy(valores, 0, left, 0, left.length);
		System.arraycopy(valores, length/2, right, 0, right.length);
		
		imprimeValores(valores, left, right);
		
		//chamada recursiva
		mergeSort(left);
		mergeSort(right);
		
		//método para concatenar em um único vetor
		merge(valores, left, right);
	}

	private static void merge(int[] valores, int[] left, int[] right) {
		int indexL = 0, indexR = 0, indexV = 0;
		
		while (indexL < left.length && indexR < right.length) {
			if (left[indexL] < right[indexR]) {
				valores[indexV++] = left[indexL++];
			}
			else {
				valores[indexV] = right[indexR++];
			}
		}
	}

	private static void imprimeValores(int[] valores, int[] left, int[]right) {
		System.out.println(Arrays.toString(valores));	
		System.out.println(Arrays.toString(left));	
		System.out.println(Arrays.toString(right));	
	}

}
