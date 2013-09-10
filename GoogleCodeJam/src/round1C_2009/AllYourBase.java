package round1C_2009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AllYourBase 
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	private static final char[] valores="1023456789abcdefghijklmnopqrstuvwxyz".toCharArray();

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/round1C_2009/AllYourBase/";
		String archivo ="A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {

			// Separar informacion pertinente

			char[] mensaje=br.readLine().toCharArray();

			long rta = solucionarCaso(mensaje);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static long solucionarCaso(char[] mensaje)
	{
		Set<Character>simbolos=new HashSet<Character>();
		HashMap<Character, Character>ordenCaract=new HashMap<Character, Character>();
		int i=0;
		for (char digit : mensaje)
		{
			if(simbolos.add(digit)) 
			{
				ordenCaract.put(digit, valores[i]);
				i++;
			}
		}

		int base=simbolos.size();
		String representacionNumero="";
		for (char digit : mensaje)representacionNumero+=ordenCaract.get(digit);
		
		return(base>1)?Long.parseLong(representacionNumero,base):Long.parseLong(representacionNumero,2);
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}