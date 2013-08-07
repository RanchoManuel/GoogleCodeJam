package qRound_2010_Africa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreCredit
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = false;
		String carpeta = "./data/qRound_2010_Africa/StoreCredit/";
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

			int credito =  Integer.parseInt(br.readLine());
			int numItems =  Integer.parseInt(br.readLine());
			String preciosItems =  br.readLine();
			String[] precios=preciosItems.split(" ");

			String rta=solucionarCaso(credito,numItems,precios);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int credito, int numItems, String[] precios) 
	{
		String rta="";
		ciclo: for (int i = 0; i < numItems; i++)
		{
			for (int j = i+1; j < numItems; j++)
			{
				int precio1=Integer.parseInt(precios[i]);
				int precio2=Integer.parseInt(precios[j]);

				if(precio1+precio2==credito)
				{
					rta += " "+(i+1)+" "+(j+1);
					break ciclo;
				}
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