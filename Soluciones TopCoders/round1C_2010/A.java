import java.awt.geom.Line2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;


public class A 
{
	public static void main(String [] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("A-small-attempt0.in"));
		System.setOut(new PrintStream("salida.out"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int a = 1; a <= t; a++)
		{
			int n = sc.nextInt();
			Stack <Linea> s = new Stack <Linea> ();
			for(int i = 0; i < n; i++)
			{
				Linea nueva = new Linea();
				nueva.a = sc.nextInt();
				nueva.b = sc.nextInt();
				s.push(nueva);
			}
			int acumulado = 0;
			while(!s.isEmpty())
			{
				Linea actual = s.pop();
				for(Linea otra : s)
				{
					if(otra.intersecta(actual))
						acumulado++;
				}
			}
			System.out.println("Case #" + a + ": " + acumulado);
		}
	}
	
	static class Linea
	{
		int a, b;

		public boolean intersecta(Linea otra) 
		{
			Line2D lineaA = new Line2D.Double(0, a, 100, b);
			Line2D lineaB = new Line2D.Double(0, otra.a, 100, otra.b);
			return lineaA.intersectsLine(lineaB);
		}
	}

}
