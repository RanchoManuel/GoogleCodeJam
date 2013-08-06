package round1A_2008;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class MinimumScalarProduct
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = false;
		String carpeta = "./data/round1A_2008/MinimumScalarProduct/";
		String archivo = "A-large-practice";

		pw = null;
		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {

			String rta = "";

			// Separar informacion pertinente

			int tamanio=Integer.parseInt(br.readLine());

			String[] numeros1=br.readLine().split(" ");
			int[] vector1=new int[tamanio];
			for (int j = 0; j < numeros1.length; j++)vector1[j]=Integer.parseInt(numeros1[j]);

			String[] numeros2=br.readLine().split(" ");
			int[] vector2=new int[tamanio];
			for (int j = 0; j < numeros2.length; j++)vector2[j]=Integer.parseInt(numeros2[j]);

			rta=solucionarCaso(tamanio,vector1,vector2);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int tamanio, int[] vector1, int[] vector2)
	{
		long rta=0;

		Arrays.sort(vector1);
		Arrays.sort(vector2);

		for (int i = 0; i < tamanio; i++) rta+= (long)vector1[i]*(long)vector2[(tamanio-1)-i];

		return rta+"";
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}