package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Treasure
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;
	
	private static Treasure yo;

	public static void main( String[] args ) throws Exception
	{
		yo=new Treasure();
		
		test = true;
		String carpeta = "./data/qRound_2013/Treasure/";
		String archivo = "Test";//"A-small-practice"; // TODO

		pw = null;
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

			String[] paramTesoro=br.readLine().split(" ");
			int k=Integer.parseInt(paramTesoro[0]);
			int n=Integer.parseInt(paramTesoro[1]);

			int[] llavesIniciales = new int[k];
			String[] valorLLavesInic=br.readLine().split(" ");
			for (int l = 0; l < k; l++)llavesIniciales[l]=Integer.parseInt(valorLLavesInic[l]);

			Cofre[] cofres= new Cofre[n];
			for (int j = 0; j < n; j++)
			{
				String infoCofre=br.readLine();
				String[] infoCofreAr=infoCofre.split(" ");

				int llaveMiaP=Integer.parseInt(infoCofreAr[0]);
				int numLLaves=Integer.parseInt(infoCofreAr[1]);

				int[] llavesContenidas = new int[numLLaves];
				if(infoCofre.length()>3)
				{
					String[] llavesContenidasInic=infoCofre.substring(4).split(" ");
					for (int l = 0; l < numLLaves; l++)llavesContenidas[l]=Integer.parseInt(llavesContenidasInic[l]);
				}
				cofres[j] = yo.new Cofre(llaveMiaP, llavesContenidas);
			}

			String rta = solucionarCaso(k,llavesIniciales,n,cofres);

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );			
		}
	}

	private static String solucionarCaso(int k, int[] llavesIniciales, int n, Cofre[] cofres)
	{
		return "IMPOSSIBLE";
	}

	private static void imprimirSolucion( String solucion )
	{
		if( test )System.out.println( solucion );
		else pw.println( solucion );
	}

	private class Cofre
	{
		private int llaveMia;
		private int[] llavesContenidas;

		public Cofre(int llaveMiaP,int[] llavesContenidasP)
		{
			llaveMia=llaveMiaP;
			llavesContenidas=llavesContenidasP;
		}

		public int getLlaveMia(){return llaveMia;}

		public int[] getLlavesContenidas(){return llavesContenidas;}

		public String toString()
		{
			String lasContenidas="";
			for (int llaveContenida : llavesContenidas)lasContenidas+=" "+llaveContenida;
			return llaveMia+"|"+lasContenidas;
		}
	}
}