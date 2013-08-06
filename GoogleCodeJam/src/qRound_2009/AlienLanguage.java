package qRound_2009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class AlienLanguage
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = false;
		String carpeta = "./data/qRound_2009/AlienLanguage/";
		String archivo = "A-large-practice";
		
		pw = null;
		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		// Separar informacion pertinente

		String[] paramLenguaje=br.readLine().split(" ");
		int numPalabras_D =Integer.parseInt(paramLenguaje[1]);
		int casos_N =Integer.parseInt(paramLenguaje[2]);

		String[] diccionario=new String[numPalabras_D]; 
		for (int i = 0; i < numPalabras_D; i++) diccionario[i]=br.readLine();

		//---------------------------------------------

		for (int i = 0; i < casos_N; i++) {

			int rta=solucionarCaso(diccionario,br.readLine());

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static int solucionarCaso(String[] diccionario, String mensaje) 
	{
		int rta=0;
		
		String mascara=mensaje.replace("(", "[").replace(")", "]");
		for (String palabra : diccionario) if(Pattern.matches(mascara,palabra))rta++;
		
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}