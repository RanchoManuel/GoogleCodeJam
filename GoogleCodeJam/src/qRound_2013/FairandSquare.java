package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.w3c.dom.ranges.RangeException;

public class FairandSquare
{

	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = false;
		String baseName = "C-large-1"; // Nombre del archivo

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
			int rta = 0;
			final String n =  br.readLine( );

			String[] numeros=n.split(" ");

			long in_A=Long.parseLong(numeros[0]);
			long in_B=Long.parseLong(numeros[1]);

			long start=0;
			try{
				start = (long) Math.sqrt(in_A);
			}
			catch(RangeException e)
			{
				for (long j = 2147483647; (j*j) < in_A; j++) {
					start=j;
				}
			}
			boolean parar=false;
			for (long j = start; j <=in_B && !parar; j++) {
				long jCuadrado=j*j;
				if(in_A<=jCuadrado&&jCuadrado<=in_B){
					if(esPalindromo(j)&&esPalindromo(jCuadrado))rta++;
				}
				else parar=true;
			}

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );

			i++;
		}
	}

	private static boolean esPalindromo(long j) {
		
		String cadena=j+"";
		char[] digitos=cadena.toCharArray();
		int tamanio=digitos.length;
		if(tamanio==1)return true;

		int cota=(int)Math.floor(tamanio);
		for (int i = 0; i < cota; i++) {
			if(digitos[i]!=digitos[tamanio-i-1])return false;
		}
		return true;
	}

}