package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Tic_Tac_Toe_Tomek
{

	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		// Imprimir a la consola (true) o al archivo (false)
		test = false;
		String baseName = "A-large"; // Nombre del archivo

		pw = null;
		if( !test )
		{
			pw = new PrintWriter( new File( "./data/" + baseName + ".out" ) );
		}

		// Abrir el archivo con los datos de entrada
		br = new BufferedReader( new FileReader( new File( "./data/" + baseName + ".in" ) ) );

		solucionarProblema( );

		// Si no era una prueba, cerrar el archivo de salida
		if( !test )
		{
			pw.close( );
		}

	}

	/**
	 * Imprimir una solucion al problema <br/>
	 * . Si el atributo test es verdadero, imprime a la salida estandar. Si es falso imprime al archivo de salida.
	 * @param solucion
	 */
	private static void imprimirSolucion( String solucion )
	{
		if( test )
		{
			System.out.println( solucion );
		}
		else
		{
			pw.println( solucion );
		}
	}

	/**
	 * Este es el metodo que realmente soluciona el problema
	 * @throws IOException
	 */
	private static void solucionarProblema( ) throws IOException
	{
		int cases = Integer.parseInt( br.readLine( ) );
		int i = 0;
		while( i < cases )
		{
			String rta = "";
			final char[] n0 =  br.readLine( ).toCharArray();
			final char[] n1 =  br.readLine( ).toCharArray();
			final char[] n2 =  br.readLine( ).toCharArray();
			final char[] n3 =  br.readLine( ).toCharArray();

			char[][] matriz= {n0,n1,n2,n3};

			char[] rtas=new char[10];
			for (int j = 0; j < rtas.length; j++) {rtas[j]='Q';}

			boolean hayPuntos=false;
			for (int j = 0; j <4 ; j++) {
				for (int k = 0; k < 4 ; k++) {

					char actual=matriz[j][k];
					if(!hayPuntos&&actual=='.')hayPuntos=true;

					if(j==0)lol(0,actual,rtas);
					if(j==1)lol(1,actual,rtas);
					if(j==2)lol(2,actual,rtas);
					if(j==3)lol(3,actual,rtas);
					if(k==0)lol(4,actual,rtas);
					if(k==1)lol(5,actual,rtas);
					if(k==2)lol(6,actual,rtas);
					if(k==3)lol(7,actual,rtas);
					if(j==k)lol(8,actual,rtas);
					if(j==(3-k))lol(9,actual,rtas);
				}
			}
			rta=(hayPuntos)?"Game has not completed":"Draw";
			for (int j = 0; j < rtas.length; j++) {
				char esta=rtas[j];
				if(esta!='W')rta=esta+" won";
			}

			br.readLine( );
			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion( solucion );

			i++;
		}
	}

	private static void lol(int i, char actual, char[] rtas) {

		if(rtas[i]=='Q')rtas[i]=actual;
		else{
			if((rtas[i]=='T'&&actual=='X'||rtas[i]=='T'&&actual=='O')||(rtas[i]=='X'&&actual=='T'||rtas[i]=='O'&&actual=='T')||(rtas[i]=='X'&&actual=='X')||(rtas[i]=='O'&&actual=='O')){
				if(actual!='T')rtas[i]=actual;
			}
			else rtas[i]='W';
		}
	}

}