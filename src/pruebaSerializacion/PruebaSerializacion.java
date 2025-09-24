package pruebaSerializacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PruebaSerializacion {

	// Apartado 5
	
	public static void main(String[] args) {
		List<Pokemon> pokedex = new ArrayList<Pokemon>();
		pokedex.add(new Pokemon("Reshiram", 644, "Dragon"));
		pokedex.add(new Pokemon("Zekrom", 645, "Dragon"));
		pokedex.add(new Pokemon("Landorus", 646, "Tierra"));
		pokedex.add(new Pokemon("Kyurem", 647, "Dragon"));
		pokedex.add(new Pokemon("Victini", 492, "Fuego"));

		File ficheroPoke = new File("Pokemon.obj");
 
		try {
			guardarFichero(pokedex, ficheroPoke);
			leerFichero(ficheroPoke);
		} catch (IOException e) {
			System.out.println("error fichero objetos");
		} catch (ClassNotFoundException e) {
			System.out.println("Error lectura fichero objetos");
		}

	}

	public static void guardarFichero(List<Pokemon> pokedex, File fichero) throws IOException {
		FileOutputStream fo = new FileOutputStream(fichero);
		ObjectOutputStream guardarObjetos = new ObjectOutputStream(fo);

		for (Pokemon p : pokedex) {
			guardarObjetos.writeObject(p);
		}
		System.out.println("Pokedex guardada");
		guardarObjetos.close();
	}

	public static void leerFichero(File fichero) throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(fichero);
		ObjectInputStream datos = new ObjectInputStream(fi);
		Pokemon p;
		try {
			while (true) {
				p = (Pokemon) datos.readObject();
				System.out.println(p.getNombre() + " " + p.getNumPokedex() + " " + p.getTipoPrincipal());
			}
		} catch (EOFException e) {
			System.out.println("Fin fichero objetos");
		}
		datos.close();
	}

}
