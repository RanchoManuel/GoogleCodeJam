package practiceContest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OldMagician
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/practiceContest/OldMagician/";
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
			String[] auxBolas=br.readLine().split(" ");
			int blancas=Integer.parseInt(auxBolas[0]);
			int negras=Integer.parseInt(auxBolas[1]);

			String rta = solucionarCaso(blancas, negras);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int blancas, int negras) 
	{
		while(negras+blancas>1)
		{
			int nuevasNegras=Math.min(negras, blancas);
			
			int nuevasBlancas=(negras+blancas)-(nuevasNegras*2);
			if(nuevasBlancas%2==0) nuevasBlancas/=2;
			else 
			{
				nuevasBlancas=(nuevasBlancas-1)/2;
				
				if(negras>blancas)nuevasNegras++;
				else if(blancas>negras)nuevasBlancas++;
			}
			
			negras=nuevasNegras;
			blancas=nuevasBlancas;
		}

		return(negras==1)?"BLACK":"WHITE";
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}