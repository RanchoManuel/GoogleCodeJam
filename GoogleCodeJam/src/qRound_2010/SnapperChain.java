package qRound_2010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SnapperChain
{
	private static boolean test=false;
	
	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2010/SnapperChain/";
		String archivo = "A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			// Separar informacion pertinente

			String[] paramProblem=br.readLine().split(" ");
			int n=Integer.parseInt(paramProblem[0]);
			int k=Integer.parseInt(paramProblem[1]);

			String rta = solucionarCaso(n,k);

			//---------------------------------------------
			
			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int n, int k) 
	{
		String binario=Integer.toBinaryString(k);
		String ceros="";
		
		if(binario.length()<n)for (int i = binario.length(); i <n ; i++)ceros+="0";	
		else binario=binario.substring(binario.length()-n);
		
		char[]configFinal=(ceros+binario).toCharArray();
		
		for (char snapper : configFinal)if(snapper=='0')return "OFF";
		return "ON";
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}