package round1A_2010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Rotate
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = true;
		String carpeta = "./data/round1A_2010/Rotate/";
		String archivo = "Test";//"A-small-practice"; 

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

			String[] paramJuego=br.readLine().split(" ");
			int n=Integer.parseInt(paramJuego[0]);
			int k=Integer.parseInt(paramJuego[1]);

			char[][] tablero=new char[n][n];
			for (int j = 0; j < n; j++)tablero[j]=br.readLine().toCharArray();

			String rta = solucionarCaso(tablero,n,k);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(char[][] tablero, int n, int k) 
	{
		//Aplicar gravedad a la derecha del tablero
		for (int j = 0; j < n; j++)
		{
			String puntos="",fichas="";

			for (int i = 0; i < n; i++)
			{
				char actual=tablero[j][i];
				if(actual=='.')puntos+=".";
				else fichas+=actual;
			}

			char[] nuevaFila=(puntos+fichas).toCharArray();
			for (int i = 0; i < n; i++)tablero[j][i]=nuevaFila[i];
		}

		for (char[] cs : tablero)System.out.println(cs);
		//Hacer conteo de fichas por filas columnas y diagonales

		int[] columnRed=new int[n];
		int[] auxColRed=new int[n];

		int[] filaRed=new int[n];
		int[] auxfRed=new int[n];

		int[] columnBlue=new int[n];
		int[] auxcolBlue=new int[n];

		int[] filaBlue=new int[n];
		int[] auxfBlue=new int[n];

		char ultimo='.';

		for (int j = 0; j < n; j++){
			for (int i = 0; i < n; i++){

				char actual=tablero[j][i];
				if(actual=='R'){
					
					
				}
				else if(actual=='B'){
					
					
				}
				ultimo=actual;
			}
		}

		//Revisar el conteo para saber si cumplen las condiciones
		boolean cumpleRed=false,cumpleBlue=false;
		for (int i = 0; i<n&&!cumpleRed; i++){System.out.println(columnRed[i]);if(columnRed[i]>=k||filaRed[i]>=k)cumpleRed=true;}
		for (int i = 0; i<n&&!cumpleBlue; i++){;if(columnBlue[i]>=k||filaBlue[i]>=k)cumpleBlue=true;}

		//Dar respuesta
		if(!cumpleRed && !cumpleBlue)return "Neither";
		else if(!cumpleRed && cumpleBlue)return "Blue";
		else if(cumpleRed && !cumpleBlue)return "Red";
		else return "Both";

	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}