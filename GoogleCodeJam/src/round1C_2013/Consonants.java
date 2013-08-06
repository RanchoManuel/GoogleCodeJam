package round1C_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Consonants
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = true;
		String baseName = "A-large"; // Nombre del archivo

		pw = null;
		if( !test )
		{
			pw = new PrintWriter( new File( "./data/" + baseName + ".out" ) );
		}

		// Abrir el archivo con los datos de entrada
		br = new BufferedReader( new FileReader( new File( "./data/" + baseName + ".in" ) ) );

		solucionarProblema( );

		// Si no era una prueba, cerrar el archivo de salida
		if( !test )
		{
			pw.close( );
		}

	}

	/**
	 * Imprimir una solucion al problema <br/>
	 * . Si el atributo test es verdadero, imprime a la salida estandar. Si es falso imprime al archivo de salida.
	 * @param solucion
	 */
	private static void imprimirSolucion( String solucion )
	{
		if( test )
		{
			System.out.println( solucion );
		}
		else
		{
			pw.println( solucion );
		}
	}

	/**
	 * Este es el metodo que realmente soluciona el problema
	 * @throws IOException
	 */
	private static void solucionarProblema( ) throws IOException
	{
		int cases = Integer.parseInt( br.readLine( ) );
		int i = 0;
		while( i < cases )
		{
			String[] linea=br.readLine( ).split(" ");
			String lol=linea[0];
			char[] nombre=lol.toCharArray();
			int n=Integer.parseInt(linea[1]);
			
			int n_value=0;
			for (int j = 0; j < nombre.length; j++) {
				for (int k = j; k < nombre.length; k++) {
					CharSequence palAnalizada=lol.subSequence(j, k+1);
					
					int valueMax=0;
					int valueTemp=0;
					for (int l = 0; l < palAnalizada.length(); l++) {
						char letra = palAnalizada.charAt(l);
						if(letra!='a'&&letra!='e'&&letra!='i'&&letra!='o'&&letra!='u')
						{
							valueTemp++;
							if(valueTemp>valueMax)valueMax=valueTemp;
						}
						else valueTemp=0;
					}
					if(valueMax>=n)n_value++;
				}
			}
			String solucion = "Case #"+(i+1)+": "+n_value;
			imprimirSolucion( solucion );

			i++;
		}
	}
}