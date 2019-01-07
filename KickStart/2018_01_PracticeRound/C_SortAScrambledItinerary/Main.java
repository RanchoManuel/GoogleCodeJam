import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int casos = Integer.parseInt(br.readLine());
			for (int i=0; i < casos; i++)
			{
				//Separar informacion pertinente
				int N = Integer.parseInt(br.readLine().trim());
				String[][] ticketsInfo = new String[N][2];
				for (int j=0; j<N; j++) {
					ticketsInfo[j][0] = br.readLine().trim();
					ticketsInfo[j][1] = br.readLine().trim();
				}

				String rta = solucionarCaso(N, ticketsInfo);
				//---------------------------------------------

				String solucion = "Case #"+(i+1)+": "+rta;
				System.out.println(solucion);
			}
		}
	}

	private static String solucionarCaso(int N, String[][] ticketsInfo)
	{
		// 1) Create the graph and determine the source and destinatiosn of the tickets
		Map<String, List<String>> G = new LinkedHashMap<>();
		Set<String> sources = new LinkedHashSet<>();
		Set<String> destinations = new LinkedHashSet<>();

		for (String[] arco : ticketsInfo) {
			// Create the Graph
			if(!G.containsKey(arco[0])) G.put(arco[0], new ArrayList<String>());
			if(!G.containsKey(arco[1])) G.put(arco[1], new ArrayList<String>());

			List<String> adj = G.get(arco[0]);
			adj.add(arco[1]);
			G.put(arco[0], adj);
			// Fist iteration through the arch list to determine the source and destination
			sources.add(arco[0]);
			destinations.add(arco[1]);
		}
		// Second iteration through the arch list
		for (String[] arco : ticketsInfo) {
			sources.remove(arco[1]);
			destinations.remove(arco[0]);
		}
		
		// We expect that at least 1 source and destination exists (From the problem context)
		String[] aux = sources.toArray(new String[sources.size()]);
		String s = aux[0];
		aux = destinations.toArray(new String[destinations.size()]);
		String d = aux[0];	
		
		// VerGrafo(Map<String, List<String>> G)
		// for (String v : G.keySet()) System.out.println(v + ": " +G.get(v));
		// System.out.println("sources: " + sources);
		// System.out.println("s: " + s);
		// System.out.println("destinations: " + destinations);
		// System.out.println("d: " + d);
		
		return bfs(s, d, G);
	}

	private static String bfs(String source, String destination, Map<String, List<String>> G)
	{
		// Preparar Bfs
		Map<String, Boolean> marcados = new LinkedHashMap<>();
		Map<String, String> edgeTo = new LinkedHashMap<>();
		Map<String, Integer> distTo = new LinkedHashMap<>();

		for (String v : G.keySet()) {
			marcados.put(v, false);
			edgeTo.put(v, null);
			distTo.put(v, 0);
		}

		// Ejecutar Bfs
		Queue<String> q = new LinkedList<>();
		marcados.put(source, true);
		distTo.put(source, 0);
		q.add(source);

		while (!q.isEmpty()) {
			String v = q.poll();
			List<String> adjToV = G.get(v);
			for(String w: adjToV) {
				if(marcados.get(w) == false) {
					edgeTo.put(w, v);
					distTo.put(w, distTo.get(v) + 1);
					marcados.put(w, true);
					q.add(w);
				}
			}
		}

		// Ver Bfs
		// System.out.println("===============================================================");
		// System.out.println("marcados: " + marcados);
		// System.out.println("edgeTo: " + edgeTo);
		// System.out.println("distTo: " + distTo);
		// System.out.println("===============================================================");
		
		// Construir camino entre destino y fuente
		String answer = "";
		String prev = null;
		for (String x=destination; x != null; x=edgeTo.get(x)) {
			if (prev != null) {
				answer = " "  + (x+"-"+prev) + answer ;
			}
			prev = x;
		}
		return answer.trim();
	}
}
