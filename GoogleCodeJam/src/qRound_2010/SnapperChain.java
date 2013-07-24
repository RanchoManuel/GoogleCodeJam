package qRound_2010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SnapperChain
{

	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = false;
		String baseName = "A-small-practice"; // Nombre del archivo

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
	 * Imprimir una soluci�n al problema <br/>
	 * . Si el atributo test es verdadero, imprime a la salida est�ndar. Si es falso imprime al archivo de salida.
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
	 * Este es el m�todo que realmente soluciona el problema
	 * @throws IOException
	 */
	private static void solucionarProblema( ) throws IOException
	{
		int cases = Integer.parseInt( br.readLine( ) );
		int i = 0;
		while( i < cases )
		{
			final String caso =  br.readLine( );
			String rta = "ON";
			String[] palabras=caso.split(" ");
			int n=Integer.parseInt(palabras[0]);
			int k=Integer.parseInt(palabras[1]);

			String binario=Integer.toBinaryString(k);
			char[] digitos=binario.toCharArray();
			int j=0;
			for (j = digitos.length-1; j >=0 && n>0 ; j--) {
				if(digitos[j]=='0'){
					rta="OFF";
					n=0;
				}
				n--;
			}

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );

			i++;
		}
	}

}