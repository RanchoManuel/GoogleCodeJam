import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int casos = Integer.parseInt(br.readLine());
			construirSecuencia();
			for (int i = 0; i < casos; i++)
			{
				//Separar informacion pertinente
				long desiredNumber = Long.parseLong(br.readLine());
				String rta = solucionarCaso(desiredNumber);

				//---------------------------------------------

				String solucion = "Case #"+(i+1)+": "+rta;
				System.out.println(solucion);
			}
		}
	}

	private static void construirSecuencia() {
		StringBuilder sb0 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		for (int i=0; i<10; i++) {
			String secondPart = sb0.reverse().toString();
			secondPart = secondPart.replaceAll("0", "_");
			secondPart = secondPart.replace("1", "0");
			secondPart = secondPart.replace("_", "1");

			sb1 = sb1.append("0").append(secondPart);
			System.out.println(i + ": " + sb1);
			sb0 = sb1;
		}
	}

	private static String solucionarCaso(long d)
	{
		String rta="" + d;
		return rta;
	}
}
