package auxiliar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Esqueleto
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = true;
		String carpeta = "./data/competencia/problema/";// TODO
		String archivo = "Test";//"A-small-practice"; // TODO

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

			// TODO Separar informacion pertinente
			
			String rta = solucionarCaso();
			
			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}
	
	private static String solucionarCaso() {
		String rta="";
		// TODO solucionar el problema
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}