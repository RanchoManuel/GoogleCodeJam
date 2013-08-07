package auxiliar;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ComparadorDeArchivos 
{
	private static final String INDICATIVO_ERROR = " <<<<<<<<<<<<<< ";
	private static PrintWriter pw;
	private static BufferedReader br1;
	private static BufferedReader br2;

	public static void main(String[] args) throws Exception
	{
		//TODO Poner las Rutas. Dado el caso.
		String carpeta = "./data/qRound_2010/SnapperChain/";
		String archivoMio = "A-small-practice.out";
		String archivoCorrecto = "A-small-practice2.out";

		File comparacion=new File(carpeta+"comparacion.txt");
		pw = new PrintWriter(comparacion);

		br1 = new BufferedReader(new FileReader(new File(carpeta+archivoMio)));
		br2 = new BufferedReader(new FileReader(new File(carpeta+archivoCorrecto)));
		comparar();

		pw.close();
		if(Desktop.isDesktopSupported())Desktop.getDesktop().open(comparacion);
	}

	private static void comparar() throws IOException 
	{
		pw.println("-----COMPARACION-----");

		String linea1=br1.readLine();
		String linea2=br2.readLine();
		int diferencias=0;

		while (linea1!=null&&linea2!=null)
		{
			String comp="";
			if(linea1.equals(linea2))comp=linea1;
			else
			{
				String rtaCorrecta=linea2.split(":")[1];
				comp=linea1+INDICATIVO_ERROR+rtaCorrecta;
				diferencias++;
			}
			pw.println(comp);
			linea1=br1.readLine();
			linea2=br2.readLine();
		}
		pw.println();
		pw.print("Diferencias: "+diferencias);
	}
}