import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class primero
{
	
	public static void main(String [] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("entrada.in"));
		System.setOut(new PrintStream("salida.out"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			String [] existentes = new String[n];
			for(int j = 0; j < n; j++)
			{
				existentes[j] = sc.next();
			}
			String [] nuevos = new String[m];
			for(int j = 0; j < m; j++)
			{
				nuevos[j] = sc.next();
			}
			HashMap <String, Integer> a = new HashMap <String, Integer> ();
			for(int j = 0; j < n; j++)
				a.put(existentes[j], 0);
			int acumulado = 0;
			for(int j = 0; j < m; j++)
			{
				StringTokenizer st = new StringTokenizer(nuevos[j], "/");
				String hasta = "";
				while(st.hasMoreTokens())
				{
					hasta += "/" + st.nextToken();
					if(!a.containsKey(hasta))
					{
						a.put(hasta, 0);
						acumulado++;
					}						
				}
			}
			System.out.println("Case #" + i + ": " + acumulado);
		}
	}

}
