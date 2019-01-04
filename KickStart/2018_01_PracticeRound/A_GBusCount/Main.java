import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int casos = Integer.parseInt(br.readLine());
			for (int i = 0; i < casos; i++)
			{
				//Separar informacion pertinente
				int N = Integer.parseInt(br.readLine());


				String rta = solucionarCaso();

				//---------------------------------------------

				String solucion = "Case #"+(i+1)+": "+rta;
				System.out.println(solucion);
			}
		}
	}

	private static String solucionarCaso() 
	{
		String rta="";
		return rta;
	}
}
