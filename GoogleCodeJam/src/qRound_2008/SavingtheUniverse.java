package qRound_2008;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class SavingtheUniverse
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2008/SavingtheUniverse/";
		String archivo = "A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			int numEngines=Integer.parseInt(br.readLine());
			for (int j = 0; j < numEngines; j++)br.readLine();
			int numQuerys=Integer.parseInt(br.readLine());

			int rta = solucionarCaso(numEngines,numQuerys);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static int solucionarCaso(int numEngines,  int numQuerys) throws IOException 
	{
		int rta=0, aux=0;
		Set<String> engines=new HashSet<String>();
		
		for (int i = 0; i < numQuerys; i++)
		{
			String query=br.readLine();
			if(engines.add(query))aux++;
			
			if(aux==numEngines)
			{
				rta++;
				aux=1;
				engines.clear();
				engines.add(query);
			}
		}

		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}