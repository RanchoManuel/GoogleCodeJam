import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
		Map<String, List<String>> G = new LinkedHashMap<>();

		for (String[] arco : ticketsInfo) {
			if(!G.containsKey(arco[0])) G.put(arco[0], new ArrayList<String>());
			if(!G.containsKey(arco[1])) G.put(arco[1], new ArrayList<String>());

			List<String> adj = G.get(arco[0]);
			adj.add(arco[1]);
			G.put(arco[0], adj);
		}
		for (String v : G.keySet()) System.out.println(v + ": " +G.get(v));

		Map<String, Boolean> marcados = new LinkedHashMap<>();
		Map<String, String> edgeTo = new LinkedHashMap<>();
		Map<String, Integer> distTo = new LinkedHashMap<>();
		
		for (String v : G.keySet()) {
			resetG(G, marcados, edgeTo, distTo);
			String order = bfs(v, G, marcados, edgeTo, distTo);
			if(order != null) return order;
		}
		
		return "";
	}

	private static void resetG(Map<String, List<String>> G, Map<String, Boolean> marcados, Map<String, String> edgeTo, Map<String, Integer> distTo) {
		for (String v : G.keySet()) {
			marcados.put(v, false);
			edgeTo.put(v, null);
			distTo.put(v, 0);
		}
	}

	private static String bfs(String source, Map<String, List<String>> G, Map<String, Boolean> marcados, Map<String, String> edgeTo, Map<String, Integer> distTo)
	{
		Queue<String> q = new LinkedList<>();

		return null;
	}
}
