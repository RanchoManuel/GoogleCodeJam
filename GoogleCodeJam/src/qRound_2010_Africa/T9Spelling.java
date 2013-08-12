package qRound_2010_Africa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class T9Spelling
{
	private static boolean test=false;

	private static PrintWriter pw;
	private static BufferedReader br;

	private static String[] letras = {"2","22","222","3","33","333",
		"4","44","444",	"5","55","555",	"6","66","666",
		"7","77","777","7777","8","88","888","9","99","999","9999"};
	private static char[] teclas = {'2','2','2','3','3','3',
		'4','4','4','5','5','5','6','6','6',
		'7','7','7','7','8','8','8','9','9','9','9'};

	public static void main(String[] args) throws Exception
	{
		String carpeta = "./data/qRound_2010_Africa/T9Spelling";
		String archivo = "C-large-practice";
		
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

			char[] mensaje = br.readLine().toCharArray();

			String rta=solucionarCaso(mensaje);

			//---------------------------------------------

			String solucion="Case #"+(i+1)+": "+rta;
			imprimirSolucion(solucion);
		}
	}

	private static String solucionarCaso(char[] mensaje) 
	{
		String rta="";
		char ultimaTecla=0;

		for (int i = 0; i < mensaje.length; i++)
		{
			int letraActual = mensaje[i];
			String aEscribir="";
			char teclaActual='0';

			if(letraActual==' ')aEscribir="0";
			else
			{
				aEscribir=letras[letraActual-'a'];
				teclaActual=teclas[letraActual-'a'];
			}

			rta+=(teclaActual==ultimaTecla)?" "+aEscribir:aEscribir;
			ultimaTecla=teclaActual;
		}
		
		return rta;
	}

	private static void imprimirSolucion(String solucion)
	{
		if(test)System.out.println(solucion);
		else pw.println(solucion);
	}
}