package oContest_2010_Africa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class OddManOut
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/oContest_2010_Africa/OddManOut/";
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
			
			br.readLine();
			String[] invitaciones=br.readLine().split(" ");
			
			String rta = solucionarCaso(invitaciones);
			
			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}
	
	private static String solucionarCaso( String[] invitaciones) 
	{
		Set<String>todos=new HashSet<String>(), aparejados=new HashSet<String>();
		
		for (String invit : invitaciones)if(!todos.add(invit))aparejados.add(invit);
		
		todos.removeAll(aparejados);
		
		String rta="";
		for (String solo : todos)rta=solo;
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}