package qRound_2010_Africa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReverseWords
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = false;
		String carpeta="./data/qRound_2010_Africa/ReverseWords/";
		String archivo = "B-large-practice";

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
			// Separar informacion pertinente
			
			String frase =  br.readLine();
			String[] palabras=frase.split(" ");
			
			String rta=solucionarCaso(palabras);
			
			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}
	
	private static String solucionarCaso(String[] palabras) 
	{
		String rta="";
		for (int j = palabras.length-1; j >=0 ; j--)rta+=(j==0)?palabras[j]:palabras[j]+" ";
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}