package practiceProblems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlienNumbers
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/practiceProblems/AlienNumbers/";
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
			// Separar informacion pertinente

			String[] paramNumeros=br.readLine().split(" ");
			char[]numero=paramNumeros[0].toCharArray();
			char[]lOrigen=paramNumeros[1].toCharArray();
			char[]lDestino=paramNumeros[2].toCharArray();

			String rta = solucionarCaso(numero,lOrigen,lDestino);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(char[] numero, char[] lOrigen, char[] lDestino)
	{
		Map<Character, Integer>mOrigen=new HashMap<Character, Integer>();
		int baseOrigen=lOrigen.length;
		for (int i = 0; i < baseOrigen; i++) mOrigen.put(lOrigen[i],i);

		long numBase10=0;
		for (int i = 0; i <numero.length; i++) numBase10+=mOrigen.get(numero[i])*Math.pow(baseOrigen,numero.length-i-1);

		Map<Long, Character>mDestino=new HashMap<Long, Character>();
		int baseDestino=lDestino.length;
		for (long i = 0; i < baseDestino; i++) mDestino.put(i,lDestino[(int) i]);

		ArrayList<Long> aux = new ArrayList<Long>();
		if(numBase10==0)aux.add((long) 0);
		while (numBase10 > 0) 
		{
			long residuo = numBase10 % baseDestino;
			aux.add(residuo);
			numBase10 /= baseDestino;
		}

		String rta="";
		for (int i = aux.size()-1; i >= 0; i--) rta+=mDestino.get(aux.get(i));
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}