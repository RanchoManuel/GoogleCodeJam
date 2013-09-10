package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Tic_Tac_Toe_Tomek
{
	private static boolean test=false;
	
	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main( String[] args ) throws Exception
	{
		String carpeta = "./data/qRound_2013/Tic_Tac_Toe_Tomek/";
		String archivo = "A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema( ) throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion & Procesar caso
			int tamTablero=4;
			
			final char[] n0 =  br.readLine().toCharArray();
			final char[] n1 =  br.readLine().toCharArray();
			final char[] n2 =  br.readLine().toCharArray();
			final char[] n3 =  br.readLine().toCharArray();

			char[][] matriz= {n0,n1,n2,n3};

			char[] rtas=new char[10];
			Arrays.fill(rtas, 'V');//V->Vacio

			boolean hayPuntos=false;
			for (int j = 0; j <tamTablero ; j++) {
				for (int ix = 0; ix < tamTablero ; ix++) 
				{
					char actual=matriz[j][ix];
					hayPuntos=(hayPuntos||actual=='.');

					if(j==0)lol(0,actual,rtas);
					if(j==1)lol(1,actual,rtas);
					if(j==2)lol(2,actual,rtas);
					if(j==3)lol(3,actual,rtas);
					if(ix==0)lol(4,actual,rtas);
					if(ix==1)lol(5,actual,rtas);
					if(ix==2)lol(6,actual,rtas);
					if(ix==3)lol(7,actual,rtas);
					if(j==ix)lol(8,actual,rtas);
					if(j==(tamTablero-ix-1))lol(9,actual,rtas);
				}
			}
			
			String rta=(hayPuntos)?"Game has not completed":"Draw";
			ciclo: for (char r : rtas) if(r!='P')rta=r+" won";else break ciclo;
			br.readLine();
			
			//---------------------------------------------
			
			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static void lol(int i, char actual, char[] rtas) 
	{
		if(rtas[i]=='V')rtas[i]=actual;
		else{
			if((rtas[i]=='T'&&actual=='X'||rtas[i]=='T'&&actual=='O')||(rtas[i]=='X'&&actual=='T'||rtas[i]=='O'&&actual=='T')||(rtas[i]=='X'&&actual=='X')||(rtas[i]=='O'&&actual=='O')){
				rtas[i]=(actual=='T')?rtas[i]:actual;
			}
			else rtas[i]='P';
		}
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}