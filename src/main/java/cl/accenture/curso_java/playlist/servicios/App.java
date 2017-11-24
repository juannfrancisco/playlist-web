package cl.accenture.curso_java.playlist.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import cl.accenture.curso_java.playlist.modelo.Persona;

public class App {
	
	public static void main(String[] args) {
		
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add( "Hola" );
	    palabras.add( "Como estas ?" );
	    palabras.add( "Adios :)" );
	    palabras.add( 1, "test" );
		System.out.println( palabras );
		
		
		
		
		
		Collections.sort( palabras );
		System.out.println( palabras );
		
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("a", 18));
		personas.add(new Persona("b", 17));


		// Ordenar personas segun su nombre
		Collections.sort(personas, new Comparator<Persona>() {
		    @Override
		    public int compare(Persona p1, Persona p2) {
		        return p1.getNombre().compareTo(p2.getNombre() );
		    }
		});

		System.out.println( personas );


		// Ordenar personas segun su edad
		Collections.sort(personas, new Comparator<Persona>() {
		    @Override
		    public int compare(Persona p1, Persona p2) {
		       if( p1.getEdad() > p2.getEdad() ){
		           return 1;
		       }
		       if( p1.getEdad() < p2.getEdad() ){
		           return -1;
		       }
		       return 0;
		    }
		});

		System.out.println( personas );
		
	}
}
