package qRound_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class InfiniteHouseofPancakes
{
	private static String archivo="B-small-attempt1";
	private static boolean test=false;

	public static void main(String[] args) throws IOException
	{
		PrintWriter pr;
		if(test) pr=new PrintWriter(System.out);
		else pr=new PrintWriter(new File("./data/qRound_2015/InfiniteHouseofPancakes/"+archivo+".out"));
		BufferedReader br=new BufferedReader(new FileReader(new File("./data/qRound_2015/InfiniteHouseofPancakes/"+archivo+".in")));
		//--------------------------------------------------------------------------------------
		int casos=Integer.parseInt(br.readLine()), rta, D;
		PQsort pqs=new PQsort();
		Queue<Integer> simulacion=new PriorityQueue<Integer>(pqs);
		Queue<Integer> otroTurno=new PriorityQueue<Integer>(pqs);
		String[] aux;
		for(int c=1; c<=casos; c++)
		{
			rta=0;
			D=Integer.parseInt(br.readLine());
			aux=br.readLine().split(" ");

			simulacion.clear();
			for(String string : aux) simulacion.add(Integer.parseInt(string));

			for(rta=0; !simulacion.isEmpty(); rta++)
			{
//				System.out.println(simulacion);
				otroTurno.clear();
				boolean yaNoMAs=false;
				while(!simulacion.isEmpty())
				{
					int numPanques=simulacion.poll();
					if(numPanques<=3)
					{
						if(numPanques>1)
						{
							if(yaNoMAs) otroTurno.add(numPanques);
							else otroTurno.add(numPanques-1);
						}
					}
					else if(numPanques%2==0)
					{
						if(yaNoMAs) otroTurno.add(numPanques);
						else
						{
							otroTurno.add(numPanques/2);
							otroTurno.add(numPanques/2);
							yaNoMAs=true;
						}
					}
					else if(numPanques%2==1)
					{
						if(yaNoMAs) otroTurno.add(numPanques);
						else
						{
							otroTurno.add(numPanques/2);
							otroTurno.add((numPanques/2)+1);
							yaNoMAs=true;
						}
					}
				}
				simulacion=new PriorityQueue<Integer>(otroTurno);
			}
//			System.out.println("--------------");
			pr.printf("Case #%d: %d\n",c, rta);
		}
		//--------------------------------------------------------------------------------------
		br.close();pr.close();
	}

	static class PQsort implements Comparator<Integer>
	{
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
}