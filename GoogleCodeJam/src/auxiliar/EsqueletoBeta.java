package auxiliar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EsqueletoBeta
{

	private static PrintWriter pw;
	private static boolean test;
	private static Scanner sc;

	public static void main(String[] args) throws Exception
	{
		test = true;
		String carpeta = "./data/competencia/problema/";// TODO Ubicacion de los archivos
		String baseName = "Test";//"A-small-practice"; // TODO Nombre de los archivos

		pw = null;
		if(!test)pw = new PrintWriter(new File(carpeta+baseName+".out"));

		System.setIn(new FileInputStream(carpeta+baseName+".in"));
		sc = new Scanner(System.in);
		solucionarProblema();

		if(!test)pw.close();
	}

	/**
	 * Este metodo separa los casos de prueba
	 * @throws IOException
	 */
	private static void solucionarProblema() throws IOException
	{
		int casos = sc.nextInt();
		for (int i = 0; i < casos; i++) {

			// TODO Separar informacion pertinente
			
			String rta = solucionarCaso();
			
			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}
	
	/**
	 * Este metodo que realmente soluciona el problema
	 * @return
	 */
	private static String solucionarCaso() {
		String rta="";
		// TODO solucionar el problema
		return rta;
	}

	/**
	 * Imprime una solucion al problema. (!) Deja un enter al final que hay que borrar.
	 * @param solucion
	 */
	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}