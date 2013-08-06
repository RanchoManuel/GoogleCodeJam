package qRound_2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SpeakinginTongues
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;
	
	private static BufferedReader brG;
	private static BufferedReader brT;

	public static void main(String[] args) throws Exception
	{
		test = false;
		String carpeta = "./data/qRound_2012/SpeakinginTongues/";
		String archivo = "A-small-practice";
		
//		brG = new BufferedReader(new FileReader(new File(carpeta+"Googlerese.in")));
//		brT = new BufferedReader(new FileReader(new File(carpeta+"Traduccion.in")));
//		preProcesar();
		
		pw = null;
		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	@SuppressWarnings("unused")
	private static void preProcesar() throws IOException
	{
		int casos = Integer.parseInt(brG.readLine());
		Set<Character> letras=new TreeSet<Character>();
		Map<Character, Character> correspondencias=new HashMap<Character, Character>();
		
		for (int i = 0; i < casos; i++)
		{
			char[] secrt=brG.readLine().toCharArray();
			char[] traduccion=brT.readLine().toCharArray();
			for (int j=0; j<secrt.length; j++)if(letras.add(secrt[j]))correspondencias.put(secrt[j],traduccion[j]);
		}
		
		//Correspondencias de letras
		for (Character c : correspondencias.keySet())System.out.print(c);
		System.out.println();
		for (Character c : correspondencias.values())System.err.print(c);
		
		//Letras sin correspondencia
		char[] aux="abcdefghijklmnopqrstuvwxyz".toCharArray();
		Set<Character>alfabeto=new TreeSet<Character>();
		for (char c : aux)alfabeto.add(c);
		
		alfabeto.removeAll(letras);
		for (Character c : alfabeto)System.out.print(" "+c);
	}

	private static void solucionarProblema() throws IOException
	{
		char[] googlerese="fgdebcanolmjkhiwvutsrpyxqz ".toCharArray();
		char[] traduccion="cvsoheybkgluixdfpjwntramzq ".toCharArray();
		
		Map<Character, Character> correspondencias=new HashMap<Character, Character>();
		for (int i = 0; i < googlerese.length; i++)correspondencias.put(googlerese[i], traduccion[i]);
		
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) 
		{
			char[] linea=br.readLine().toCharArray();
			String rta = "";
			for (char c : linea)rta+=correspondencias.get(c);

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}