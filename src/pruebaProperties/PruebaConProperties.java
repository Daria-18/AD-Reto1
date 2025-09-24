package pruebaProperties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PruebaConProperties {

	//Apartado 1
	
	public static void main(String[] args) throws IOException {
		
		// Se declara como variable final los ficheros a usar
		final String fich1 = "archivoPrueba.txt";
		final String fich2 = "archivoPrueba.xml";

		// Se crean objetos de Properties y FileOutputStreams para guardar
		// en dos ficheros los mismos datos
		Properties ejemploGuardar = new Properties();
		
		FileOutputStream outputStream = new FileOutputStream(fich1);
		FileOutputStream outputStream2 = new FileOutputStream(fich2);
		
		ejemploGuardar.setProperty("id1", "Ash Ketchum");
		ejemploGuardar.setProperty("id2", "Pedrito");
		ejemploGuardar.setProperty("id3", "Carlitos");
		ejemploGuardar.setProperty("id4", "Ariana Grande");
		ejemploGuardar.setProperty("id5", "LeBron James");
		ejemploGuardar.setProperty("id6", "Spike Spiegel");
		ejemploGuardar.setProperty("id7", "Gerard Way");
		
		ejemploGuardar.store(outputStream, "Comentarios");
		ejemploGuardar.storeToXML(outputStream2, "Comentarios2");
		
		// Se crean objetos para leer los archivos de texto
		
		Properties ejemploCargar = new Properties();
		Properties ejemploCargar2 = new Properties();
		
		FileInputStream inputStream = new FileInputStream(fich1);
		FileInputStream inputStream2 = new FileInputStream(fich2);
		
		ejemploCargar.load(inputStream);
		ejemploCargar2.loadFromXML(inputStream2);
		
		//Tratamiento del fichero plano .txt
		//Se accede a un ID en concreto
		System.out.println("Valor en ID4 en el fichero plano: " + ejemploCargar.getProperty("id4"));
		
		//Se leen todos los valores
		System.out.println(ejemploCargar.toString());
		
		//Tratamiento del fichero plano .txt
		//Se accede a un ID en concreto
		
		System.out.println("\nValor en ID6 en el fichero XML: " + ejemploCargar2.getProperty("id6"));
		
		//Se leen todos los valores
		System.out.println(ejemploCargar2.toString());
		
		
		
	}

}
