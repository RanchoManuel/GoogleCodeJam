import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;
import java.math.BigInteger;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//-----------------------------------------------------------
		Set<BigInteger> primos=new LinkedHashSet<BigInteger>();
		for(String line, aux[]; (line=br.readLine())!=null;)
		{
			if(!line.equals(""))
			{
				aux=line.trim().split("\\s+");
				for(String s: aux)
					primos.add(new BigInteger(s));
			}
		}

		int N=32, J=500;

		System.out.println("Case #1: ");

		long init=(long)Math.pow(2, N-1)+1, fin=(long)Math.pow(2, N);
		BigInteger rep;
		int encontrados=0;
		for(long i=init; i<fin && encontrados<J; i+=2)
		{
			boolean sirve=true;
			for(int j=2; j<=10 && sirve; j++)
			{
				rep=new BigInteger(new BigInteger(i+"").toString(2), j);
				if(primos.contains(rep)) sirve=false;
			}

			if(sirve)
			{
				boolean sirve2=true;
				String ans=(new BigInteger(i+"").toString(2));
				
				for(int j=2; j<=10 && sirve2; j++)
				{
					rep=new BigInteger(new BigInteger(i+"").toString(2), j);

					BigInteger primerDivisor=BigInteger.ONE;
					for(BigInteger primo: primos)
					{
						if(rep.mod(primo)==BigInteger.ZERO)
						{
							primerDivisor=primo;
							break;
						}
					}
					if(primerDivisor!=BigInteger.ONE)
						ans+=(" "+primerDivisor);
					else sirve2=false;
				}
				
				if(sirve2)
				{
					System.out.println(ans);
					encontrados++;
				}
			}
		}
		System.out.println("Me sirve? "+(encontrados==J));
		//-----------------------------------------------------------
		br.close();
	}
}
