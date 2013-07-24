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
	private static Treasure yo= new Treasure();

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = true;
		String baseName = "D-test"; // Nombre del archivo

		pw = null;
		if( !test )pw = new PrintWriter(new File("./data/" + baseName + ".out"));

		br = new BufferedReader( new FileReader( new File( "./data/" + baseName + ".in" ) ) );

		solucionarProblema( );

		if( !test )	pw.close( );

	}

	private static void imprimirSolucion( String solucion )
	{
		if( test )System.out.println( solucion );
		else pw.println( solucion );
	}

	private static void solucionarProblema( ) throws IOException
	{
		int cases = Integer.parseInt( br.readLine( ) );
		int i = 0;
		while( i < cases )
		{
			String rta = "";

			String[] lK_N=br.readLine( ).split(" ");
			int k=Integer.parseInt(lK_N[0]);
			int n=Integer.parseInt(lK_N[1]);

			int[] llavesIniciales = new int[k];
			String[] valorLLavesInic=br.readLine().split(" ");
			for (int j = 0; j < llavesIniciales.length; j++) {
				llavesIniciales[i]=Integer.parseInt(valorLLavesInic[i]);
			}

			Cofre[] cofres= new Cofre[n];
			for (int j = 0; j < cofres.length; j++) {
				String infoCofre=br.readLine();
				String[] infoCofreAr=infoCofre.split(" ");

				int llaveMiaP = Integer.parseInt(infoCofreAr[0]);
				int numLLaves= Integer.parseInt(infoCofreAr[1]);
				String infoLlaves=infoCofre.substring(3);
				String[] llavesContenidas=infoLlaves.split(" ");
				int[] llavesContenidasP = new int[numLLaves];
				for (int l = 0; l < numLLaves; l++) {
					try{
						llavesContenidasP[i]=Integer.parseInt(llavesContenidas[i]);
					}catch(NumberFormatException e){}
				}
				final Cofre nuevo = yo.new Cofre(llaveMiaP, llavesContenidasP);
				cofres[i]=nuevo;
				System.out.println(cofres[i].toString());
			}

			String solucion = "Case #"+(i+1)+": "+rta;
			//imprimirSolucion( solucion );			
			i++;
		}
	}


	private class Cofre{
		private int llaveMia;
		private int[] llavesContenidas;

		public Cofre(int llaveMiaP,int[] llavesContenidasP)
		{
			llaveMia=llaveMiaP;
			llavesContenidas=llavesContenidasP;
		}

		public int getLlaveMia() {
			return llaveMia;
		}


		public int[] getLlavesContenidas() {
			return llavesContenidas;
		}

		public String toString(){
			String lasContenidas="";
			for (int i = 0; i < llavesContenidas.length; i++) {
				lasContenidas+=" "+llavesContenidas[i];
			}
			return llaveMia+lasContenidas;

		}

	}
}