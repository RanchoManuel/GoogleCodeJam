import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//-----------------------------------------------------------
		int casos=Integer.parseInt(br.readLine());
		
		String rta;
		char letras[], ch;
		
		for(int c=1; c<=casos; c++)
		{
			rta="";
			
			letras=br.readLine().toCharArray();
			for(int i=0; i<letras.length; i++)
			{
				ch=letras[i];
				if(i==0) rta+=ch;
				else
				{
					if(ch<rta.charAt(0)) rta+=ch;
					else rta=ch+rta;
				}
			}
			
			System.out.printf("Case #%d: %s\n", c, rta);
		}
		//-----------------------------------------------------------
		br.close();
	}
}
