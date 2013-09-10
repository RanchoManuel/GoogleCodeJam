package round1B_2010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class FileFix_it
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/round1B_2010/FileFix-it/";
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

			String[] paramDirs=br.readLine().split(" ");
			int numActuales=Integer.parseInt(paramDirs[0]);
			int numNuevos=Integer.parseInt(paramDirs[1]);
			
			//Procesar caso

			int rta=0;
			Set<String> directorios=new HashSet<String>();

			for (int j = 0; j < numActuales; j++) 
			{
				String[] carpetas=br.readLine().split("/");
				String carpetaDinamica="";
				for (int k = 1; k < carpetas.length; k++)
				{
					carpetaDinamica+=("/"+carpetas[k]);
					directorios.add(carpetaDinamica);
				}
			}
			
			for (int j = 0; j < numNuevos; j++) 
			{
				String[] carpetasNuevas=br.readLine().split("/");
				String carpetaDinamica="";
				for (int k = 1; k < carpetasNuevas.length; k++) 
				{
					carpetaDinamica+=("/"+carpetasNuevas[k]);
					if(directorios.add(carpetaDinamica))rta++;
				}
			}

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}