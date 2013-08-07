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
		test = true;
		String carpeta = "./data/qRound_2013/FairandSquare/";
		String archivo = "Test";//"A-small-practice"; // TODO

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema( ) throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) 
		{
			int rta = 0;
			final String n=br.readLine();

			String[] limites=n.split(" ");
			long a=Long.parseLong(limites[0]);
			long b=Long.parseLong(limites[1]);

			long start=0;
			try
			{
				start = (long) Math.sqrt(a);
			}
			catch(RangeException e)
			{
				for (long j = 2147483647; (j*j) < a; j++)start=j;
			}

			ciclo:for (long j = start; j <=b ; j++)
			{
				long jCuadrado=j*j;
				if(a<=jCuadrado && jCuadrado<=b) if(esPalindromo(j)&&esPalindromo(jCuadrado))rta++;
				else break ciclo;
			}

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );
		}
	}

	private static boolean esPalindromo(long j) 
	{
		String cadena=j+"";
		char[] digitos=cadena.toCharArray();
		int tamanio=digitos.length;
		if(tamanio==1)return true;

		int cota=(int)Math.floor(tamanio);
		for (int i = 0; i < cota; i++)if(digitos[i]!=digitos[tamanio-i-1])return false;
		return true;
	}

	private static void imprimirSolucion( String solucion )
	{
		if( test )System.out.println( solucion );
		else pw.println( solucion );
	}
}