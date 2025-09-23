package pruebaCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import pruebaSerializacion.Pokemon;

public class PruebaCsv {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Pokemon> pokedex = new ArrayList<Pokemon>();
		pokedex.add(new Pokemon("Reshiram", 644, "Dragon"));
		pokedex.add(new Pokemon("Zekrom", 645, "Dragon"));
		pokedex.add(new Pokemon("Landorus", 646, "Tierra"));
		pokedex.add(new Pokemon("Kyurem", 647, "Dragon"));
		pokedex.add(new Pokemon("Victini", 492, "Fuego"));
		pokedex.add(new Pokemon("Bulbasaur", 1, "Planta"));
		pokedex.add(new Pokemon("Venusaur", 2, "Planta"));
		pokedex.add(new Pokemon("Ivysaur", 3, "Planta"));
		pokedex.add(new Pokemon("PokemonÑÑÑÑ", 2343, "Veneno"));
		
		File ficheroCSV = new File("archivo.csv");
		
		// Se usan las clases OutputStream para añadir encoding
		OutputStream outputCSV = new FileOutputStream(ficheroCSV);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputCSV,"UTF-8"));
		
		for (Pokemon p1 : pokedex) {
			pw.println(p1.getNombre() +","+ p1.getNumPokedex() +","+ p1.getTipoPrincipal());
			//pw.printf("%s,%s,%s",p1.getNombre(), p1.getNumPokedex() + p1.getTipoPrincipal());
		}
		
		// Importante cerrar el PrintWriter para que escriba en fichero
		pw.close();
		
		BufferedReader inputCSV = new BufferedReader(new FileReader(ficheroCSV));
		String texto = inputCSV.readLine();
		
		while (texto !=null) {
			System.out.println(texto);
			texto = inputCSV.readLine();
		}
		
		inputCSV.close();
		
		
		
	}

}
