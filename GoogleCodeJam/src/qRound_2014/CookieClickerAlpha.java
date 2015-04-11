package qRound_2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CookieClickerAlpha
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2014/CookieClickerAlpha/";
		String archivo = "B-large";//"A-small-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		DecimalFormat df=new DecimalFormat("0.0000000");
		
		int casos = Integer.parseInt(br.readLine());
		for(int c=1; c<=casos; c++)
		{
			//Separar informacion pertinente
			String[] aux=br.readLine().split(" +");
			double C=Double.parseDouble(aux[0]);
			double F=Double.parseDouble(aux[1]);
			double X=Double.parseDouble(aux[2]);
			
			double tiempoMinimo=X/2.0;
			ArrayList<Double> acumuladas=new ArrayList<Double>();
			for(int n=0; true; n++)
			{
				double p=2+n*F;
				
				if(n==0) acumuladas.add(0.0);
				else acumuladas.add((acumuladas.get(n-1)+(C/(2+(n-1)*F))));
				
				double e=acumuladas.get(n)+(X/p);
				
				if(e<=tiempoMinimo) tiempoMinimo=e;
				else break;
			}

			String solucion = "Case #"+c+": "+df.format(tiempoMinimo).replace(',', '.');
			imprimirSolucion(solucion);
		}
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}