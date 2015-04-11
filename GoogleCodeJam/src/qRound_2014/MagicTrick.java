package qRound_2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MagicTrick
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2014/MagicTrick/";
		String archivo = "A-small-attempt0";//"A-small-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		br.close();
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos=Integer.parseInt(br.readLine());
		for(int i=1; i<=casos; i++)
		{
			SortedSet<Integer> posibles1=new TreeSet<Integer>();
			Set<Integer> posibles2=new HashSet<Integer>(4);

			int sitio1=Integer.parseInt(br.readLine());
			for(int j=1;j<=4; j++)
			{
				if(j==sitio1)
				{
					String[] aux=br.readLine().split(" +");
					for (String carta : aux) posibles1.add(Integer.parseInt(carta));
				}
				else br.readLine();
			}
			
			int sitio2=Integer.parseInt(br.readLine());
			for(int j=1;j<=4; j++)
			{
				if(j==sitio2)
				{
					String[] aux=br.readLine().split(" +");
					for (String carta : aux) posibles2.add(Integer.parseInt(carta));
				}
				else br.readLine();
			}
			
			posibles1.retainAll(posibles2);

			String rta=(posibles1.size()==1)?""+posibles1.first():(posibles1.size()>1)?"Bad magician!":"Volunteer cheated!";

			String solucion="Case #"+i+": "+rta;
			imprimirSolucion(solucion);
		}
	}
	

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}