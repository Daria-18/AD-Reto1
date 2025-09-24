package pruebaRandomAccess;

import java.io.*;
import java.util.Scanner;

public class PruebaRaf {

	// Apartado 6.1
	
	public static void main(String[] args) throws IOException {

		int[] arrayRandom = new int[20];
		int posicion = 0;
		
		File ficheroNormal = new File("datos.bin");
		
		if(ficheroNormal.exists()) {
			DataInputStream inputFichero= new DataInputStream(new FileInputStream(ficheroNormal));
			
			for(int i = 0; i<arrayRandom.length;i++) {
				arrayRandom[i] = inputFichero.readInt();
			}
			
			inputFichero.close();
			
		}
		
		else {
			DataOutputStream outputFichero = new DataOutputStream(new FileOutputStream(ficheroNormal));
			
			for(int i = 0; i<arrayRandom.length;i++) { 
				arrayRandom[i]=0;
				outputFichero.writeInt(0);
			}
					
			outputFichero.close();
		}
		
		RandomAccessFile ficheroRandom = new RandomAccessFile(ficheroNormal, "rwd");
		Scanner inputUser = new Scanner(System.in);
		
		while (posicion != -1) {
			try {
				
				//Se imprime todo el fichero al usuario
				System.out.println("Leyendo fichero ");
				for (int i = 0; i < arrayRandom.length; i++) {
					ficheroRandom.seek(i*4);
					arrayRandom[i] = ficheroRandom.readInt();
					System.out.println("Valor en posicion " + (i+1) + ":" + arrayRandom[i]);
				}
				
				System.out.println("Di una posición a reescribir (-1 para salir)");
				posicion = inputUser.nextInt();
				if (posicion == -1) {
					System.out.println("Cerrando");
					break;
				}
				
				System.out.println("Di un numero para sobreescribir la posicion " + posicion);
				int nuevoNumero = inputUser.nextInt();
				//Importante romper el bucle si cae en una posición inválida para evitar archivos muy grandes
				if (posicion > 20 || posicion < 1) {
					System.out.println("Introduce una posición valida!");
					continue;
				} 
				
				//Posicionamos el puntero en la posición deseada, cada int ocupa 4 bytes
				ficheroRandom.seek((posicion-1) * 4);
				ficheroRandom.writeInt(nuevoNumero);
				
				
			} catch (EOFException e) {
				break;
			}
		}
		
		ficheroRandom.close();
		inputUser.close();
		
	}

}
