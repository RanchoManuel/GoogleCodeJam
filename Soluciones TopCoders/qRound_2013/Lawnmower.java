package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Lawnmower
{

	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = true;
		String baseName = "B-test"; // Nombre del archivo

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

			String[] lN_M=br.readLine( ).split(" ");
			int n=Integer.parseInt(lN_M[0]);
			int m=Integer.parseInt(lN_M[1]);
			int[][] matriz= new int[m][n];

			int masAlta=0;
			for (int k = 0; k < n; k++) {
				String[] fila =  br.readLine( ).split(" ");
				for (int j = 0; j < m; j++) {
					int altPasto=Integer.parseInt(fila[j]);
					matriz[j][k]=altPasto;
					if(altPasto>masAlta)masAlta=altPasto;
				}
			}

			boolean[][] deboPasarFilas=new boolean[masAlta][n];
			for (int j = 0; j < masAlta; j++) {
				for (int k = 0; k < n; k++) {
					deboPasarFilas[j][k]=true;
				}
			}
			boolean[][] deboPasarColumn=new boolean[m][masAlta];			
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < masAlta; k++) {
					deboPasarColumn[j][k]=true;
				}
			}

			for (int w = masAlta-1; w >=0 ; w--) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < n; k++) {
						lol(w,j,k,matriz[j][k],deboPasarFilas,deboPasarColumn);
					}
				}
			}

			boolean seguir=true;
			for (int j = 0; j < m && seguir; j++) {
				for (int k = 0; k < n && seguir; k++) {
					seguir=lol2(j,k,matriz[j][k],deboPasarFilas,deboPasarColumn,masAlta-1);
				}
			}
			rta=(seguir)?"YES":"NO";

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );			
			i++;
		}
	}

	private static void lol(int alturaMaquina, int j, int k, int alturaDeseada,	boolean[][] deboPasarFilas, boolean[][] deboPasarColumn) {
		deboPasarColumn[j][alturaMaquina]=(deboPasarColumn[j][alturaMaquina]&&((alturaMaquina+1)>=alturaDeseada));
		deboPasarFilas[alturaMaquina][k]=(deboPasarFilas[alturaMaquina][k]&&((alturaMaquina+1)>=alturaDeseada));
	}

	private static boolean lol2(int j, int k, int valorEnPos, boolean[][] deboPasarFilas, boolean[][] deboPasarColumn, int valorMax) {

		boolean fila=true;
		boolean columna=true;

		for (int l = valorMax; l >= valorEnPos-1; l--) {
			fila=fila&&deboPasarFilas[l][k];
		}

		for (int l = valorMax; l >=valorEnPos-1; l--) {
			columna=columna&&deboPasarColumn[j][l];
		}

		return fila||columna;

	}
}