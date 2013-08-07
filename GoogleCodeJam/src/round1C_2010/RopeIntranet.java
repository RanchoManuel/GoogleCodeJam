package round1C_2010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RopeIntranet
{
	private static PrintWriter pw;
	private static boolean test;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception
	{
		test = true;
		String carpeta = "./data/round1C_2010/RopeIntranet/";
		String archivo = "A-large-practice";

		if(!test)pw = new PrintWriter(new File(carpeta+archivo+".out"));

		br = new BufferedReader(new FileReader(new File(carpeta+archivo+".in")));
		solucionarProblema();
		
		if(!test)pw.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos = Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) {

			// Separar informacion pertinente

			int numCables=Integer.parseInt(br.readLine());

			String[] cables=new String[numCables];
			for (int j = 0; j < numCables; j++) cables[j]=br.readLine();

			int rta = solucionarCasoPro(cables);

			//---------------------------------------------

			String solucion = "Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	
	// Este metodo tambien sirve
	/*
	private static int solucionarCaso(String[] cables)
	{
		int rta=0;
		for (int i = 0; i < cables.length; i++) {

			String[] valoresDeY1=cables[i].split(" ");
			int v1_y1=Integer.parseInt(valoresDeY1[0]);
			int v1_y2=Integer.parseInt(valoresDeY1[1]);
			int[] ec1={(v1_y1-v1_y2),1,v1_y1};

			for (int j = i+1; j < cables.length; j++) {

				String[] valoresDeY2=cables[j].split(" ");
				int v2_y1=Integer.parseInt(valoresDeY2[0]);
				int v2_y2=Integer.parseInt(valoresDeY2[1]);
				int[] ec2={(v2_y1-v2_y2),1,v2_y1};

				double deltaR=(ec1[0]*ec2[1])-(ec2[0]*ec1[1]);
				double deltaX=(ec1[2]*ec2[1])-(ec2[2]*ec1[1]);

				if(deltaR!=0){
					double x=deltaX/deltaR;
					if(x>0 && x<1)rta++;
				}
			}
		}
		return rta;
	}
	*/
	
	private static int solucionarCasoPro(String[] cables)
	{
		int rta=0;
		for (int i = 0; i < cables.length; i++) {

			String[] valoresDeY1=cables[i].split(" ");
			int v1_y1=Integer.parseInt(valoresDeY1[0]);
			int v1_y2=Integer.parseInt(valoresDeY1[1]);

			for (int j = i+1; j < cables.length; j++) {

				String[] valoresDeY2=cables[j].split(" ");
				int v2_y1=Integer.parseInt(valoresDeY2[0]);
				int v2_y2=Integer.parseInt(valoresDeY2[1]);
				
				if((v1_y1>v2_y1 && v1_y2<v2_y2)||(v1_y1<v2_y1 && v1_y2>v2_y2)) rta++;
			}
		}
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}