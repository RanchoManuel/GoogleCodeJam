package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Lawnmower
{
	private static boolean test=true;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		String carpeta = "./data/qRound_2013/Lawnmower/";
		String archivo = "Test";//"A-small-practice"; // TODO

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema( ) throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			String[] paramJardin=br.readLine( ).split(" ");
			int n=Integer.parseInt(paramJardin[0]);
			int m=Integer.parseInt(paramJardin[1]);
			int[][] matriz= new int[m][n];

			int masAlta=0;
			for (int ix = 0; ix < n; ix++) 
			{
				String[] fila=br.readLine().split(" ");
				for (int j = 0; j < m; j++) 
				{
					int altPasto=Integer.parseInt(fila[j]);
					matriz[j][ix]=altPasto;
					if(altPasto>masAlta)masAlta=altPasto;
				}
			}

			//---------------------------------------------
			
			String rta=solucionarCaso(m,n,matriz,masAlta);

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);			
		}
	}

	private static String solucionarCaso(int m, int n, int[][] matriz,int masAlta) 
	{
		boolean[][] deboPasarFilas=new boolean[masAlta][n];
		for (boolean[] fila : deboPasarFilas)Arrays.fill(fila, true);
		
		boolean[][] deboPasarColumn=new boolean[m][masAlta];
		for (boolean[] fila : deboPasarColumn)Arrays.fill(fila, true);

		for (int w = masAlta-1; w >=0 ; w--) {
			for (int j = 0; j < m; j++) {
				for (int i = 0; i < n; i++) {
					lol(w,j,i,matriz[j][i],deboPasarFilas,deboPasarColumn);
				}
			}
		}

		boolean seguir=true;
		for (int j = 0; j < m && seguir; j++) {
			for (int i = 0; i < n && seguir; i++) {
				seguir=lol2(j,i,matriz[j][i],deboPasarFilas,deboPasarColumn,masAlta-1);
			}
		}
		
		return (seguir)?"YES":"NO";
	}

	private static void lol(int alturaMaquina, int j, int k, int alturaDeseada,	boolean[][] deboPasarFilas, boolean[][] deboPasarColumn)
	{
		deboPasarColumn[j][alturaMaquina]=(deboPasarColumn[j][alturaMaquina]&&((alturaMaquina+1)>=alturaDeseada));
		deboPasarFilas[alturaMaquina][k]=(deboPasarFilas[alturaMaquina][k]&&((alturaMaquina+1)>=alturaDeseada));
	}

	private static boolean lol2(int j, int i, int valorEnPos, boolean[][] deboPasarFilas, boolean[][] deboPasarColumn, int valorMax)
	{
		boolean fila=true;
		boolean columna=true;

		for (int l = valorMax; l >= valorEnPos-1; l--)fila=fila&&deboPasarFilas[l][i];

		for (int l = valorMax; l >=valorEnPos-1; l--)columna=columna&&deboPasarColumn[j][l];

		return fila||columna;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}