package qRound_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Tic_Tac_Toe_Tomek2
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2013/Tic_Tac_Toe_Tomek/";
		String archivo = "A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			int tamTablero=4;

			char[] f0=br.readLine().toCharArray();
			char[] f1=br.readLine().toCharArray();
			char[] f2=br.readLine().toCharArray();
			char[] f3=br.readLine().toCharArray();
			char[][] tablero= {f0,f1,f2,f3};
			br.readLine();

			String rta = solucionarCaso(tamTablero,tablero);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int tamTablero, char[][] tablero) 
	{
		int[] filasX=new int[tamTablero], columnsX=new int[tamTablero];
		int[] filasO=new int[tamTablero], columnsO=new int[tamTablero];
		int diagSupX=0,diagInfX=0;
		int diagSupO=0,diagInfO=0;
		boolean hayPuntos=false;
		
		for (int j = 0; j < tamTablero; j++)
		{
			for (int i = 0; i < tamTablero; i++) 
			{
				char ficha=tablero[j][i];
				if (ficha=='X') 
				{
					filasX[i]++;
					columnsX[j]++;
					if(i==j)diagSupX++;
					if((tamTablero-i-1)==j)diagInfX++;
				}
				else if(ficha=='O')
				{
					filasO[i]++;
					columnsO[j]++;
					if(i==j)diagSupO++;
					if((tamTablero-i-1)==j)diagInfO++;
				}
				else if(ficha=='T') 
				{
					filasX[i]++;
					columnsX[j]++;
					filasO[i]++;
					columnsO[j]++;
					if(i==j){diagSupX++;diagSupO++;}
					if((tamTablero-i-1)==j){diagInfX++;diagInfO++;}
				}
				else hayPuntos=true;
			}
		}
		
		String rta=(hayPuntos)?"Game has not completed":"Draw";
		for (int i = 0; i < tamTablero; i++)if(columnsX[i]==tamTablero||filasX[i]==tamTablero)rta="X won";
		for (int i = 0; i < tamTablero; i++)if(columnsO[i]==tamTablero||filasO[i]==tamTablero)rta="O won";
		if(diagSupX==tamTablero||diagInfX==tamTablero)rta="X won";
		if(diagSupO==tamTablero||diagInfO==tamTablero)rta="O won";

		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}