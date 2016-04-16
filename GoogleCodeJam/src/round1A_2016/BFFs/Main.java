import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Arrays;

public class Main //TODO Completar algun dia
{
	private static ArrayList<Integer> comp=new ArrayList<Integer>();
	private static int fuente=0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//-----------------------------------------------------------
		int T=Integer.parseInt(br.readLine()), N, rta;
		
		String aux[];
		for(int c=1; c<=T; c++)
		{
			comp.clear();
			N=Integer.parseInt(br.readLine());
			
			//Representarlo como un problema de grafos
			int[] amigo=new int[N];
			@SuppressWarnings("unchecked")
			List<Integer>[] adj=new ArrayList[N];
			for(int i=0;i<N; i++) adj[i]=new ArrayList<Integer>();
			
			aux=br.readLine().split("\\s+");
			for(int i=0, bff; i<N; i++)
			{
				bff=Integer.parseInt(aux[i])-1;
				adj[i].add(bff);
				amigo[i]=bff;
			}
			
			//Conseguir la componenete de amistad mas larga
			int[] marcados=new int[N];
			Arrays.fill(marcados, -1);
			for(int i=0; i<N; i++) if(marcados[i]==-1) bfs(i, adj, marcados);

			rta=comp.size();
			
			// TODO aqui es el cambio futuro: 
			// Usar la componente de amistad mas larga para encontrar la respuesta
			boolean[] arriba=new boolean[N], abajo=new boolean[N];
			int v;
			for(v=fuente; !arriba[v]; v=amigo[v])
			{
				if(arriba[amigo[v]])
				{
					break;
				}
				arriba[v]=true;
				abajo[v]=true;
			}
			
			for(int i=0; i<N; i++)
			{
				if(!abajo[i] && v==amigo[i])
				{
					rta++;
					break;
				}	
			}
			
			System.out.printf("Case #%d: %d\n", c, rta);
		}
		//-----------------------------------------------------------
		br.close();
	}
	
	private static void bfs(int source, List<Integer>[] adj, int[] marcados)
	{
		ArrayList<Integer> compEsta=new ArrayList<Integer>();
	
		Queue<Integer> q=new LinkedList<Integer>();
		marcados[source]=source;
		q.add(source);
		compEsta.add(source);

		while(!q.isEmpty())
		{
			int v=q.poll();
			for(int w: adj[v])
			{
				if(marcados[w]!=source)
				{
					marcados[w]=source;
					q.add(w);
					compEsta.add(w);
				}
			}
		}
		
		if(compEsta.size()>comp.size())
		{
			fuente=source;
			comp=compEsta;
		}
	}
}
