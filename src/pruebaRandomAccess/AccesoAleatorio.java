package pruebaRandomAccess;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import pruebaSerializacion.Pokemon;

public class AccesoAleatorio {
	
	// Apartado 7
	
	static final int TAM_REGISTRO = 200;

	public static void main(String[] args) {
		try{
			RandomAccessFile pokedex = new RandomAccessFile("Pokemon.dat", "rw");
            Pokemon p1 = new Pokemon("Reshiram",644,"Dragon");
            Pokemon p2 = new Pokemon("Zekrom",645,"Dragon");
            /* Pokemon p3 = new Pokemon("Reshiggjszfytrgram",644,"Dragon");
             * este objeto seria demasido largo para el registro por lo que saltaria una excepcion*/

            escribirPokemon(pokedex, p1, 0); 
            escribirPokemon(pokedex, p2, 1); 
            //escribirPokemon(pokedex, p3, 2); 

            
            //Introduce la posicion en el segundo argumento
            System.out.println(leerPokemon(pokedex, 1));

        } 
		catch (EOFException ex) { System.out.println("Te pasaste de posición!!");}
		
		catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		

	}
	public static void escribirPokemon(RandomAccessFile pokedex, Pokemon pokemon, int posicion) throws IOException {
		pokedex.seek(posicion * TAM_REGISTRO);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(pokemon);
        oos.flush();

        byte[] datos = baos.toByteArray();

        
        if (datos.length > TAM_REGISTRO) {
            throw new IOException("El objeto es demasiado grande para el registro");
        }

        pokedex.write(datos);

       
        for (int i = datos.length; i < TAM_REGISTRO; i++) {
        	pokedex.writeByte(0);
        }

        oos.close();
        baos.close();
    }

    public static Pokemon leerPokemon(RandomAccessFile pokedex, int posicion) throws IOException, ClassNotFoundException {
    	pokedex.seek((posicion-1) * TAM_REGISTRO);

        byte[] datos = new byte[TAM_REGISTRO];
        pokedex.readFully(datos);

        ByteArrayInputStream bais = new ByteArrayInputStream(datos);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Pokemon persona = (Pokemon) ois.readObject();

        ois.close();
        bais.close();

        return persona;
    }

}