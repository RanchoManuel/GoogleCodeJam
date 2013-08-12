package oContest_2010_Africa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GettoWork
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/oContest_2010_Africa/GettoWork/";
		String archivo = "B-small-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();

		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++)
		{
			//Separar informacion pertinente

			String[] paramPueblos=br.readLine().split(" ");
			int numPueblos=Integer.parseInt(paramPueblos[0]);
			int[] genteEnPublos=new int[numPueblos];
			int puebloOffice=Integer.parseInt(paramPueblos[1]);

			int numEmpleados=Integer.parseInt(br.readLine());
			String[] empleados=new String[numEmpleados];
			for (int j = 0; j < numEmpleados; j++)
			{
				empleados[j]=br.readLine();
				int pueblodondeVive=Integer.parseInt(empleados[j].charAt(0)+"");
				genteEnPublos[pueblodondeVive-1]++;
			}

			Arrays.sort(empleados);

			String rta = solucionarCaso(numPueblos,genteEnPublos,puebloOffice,empleados);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(int numPueblos, int[] genteEnPublos, int puebloOffice, String[] empleados) 
	{
		int[] carrosNecesarios=new int[numPueblos];
		for (int i = empleados.length-1; i >= 0; i--)
		{
			String[] paramActual=empleados[i].split(" ");
			int viveEn=Integer.parseInt(paramActual[0]);
			int puedeLlevar=Integer.parseInt(paramActual[1]);

			if(genteEnPublos[viveEn-1]>0 && puedeLlevar>0)
			{
				genteEnPublos[viveEn-1]-=puedeLlevar;
				carrosNecesarios[viveEn-1]++;
			}
		}
		
		String rta="";
		for (int i = 0; i < genteEnPublos.length; i++) if(genteEnPublos[i]>0 && i+1!=puebloOffice) rta="IMPOSSIBLE  ";

		for (int i = 0; i < carrosNecesarios.length; i++) rta+=(i==numPueblos-1)?carrosNecesarios[i]:carrosNecesarios[i]+" ";
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}