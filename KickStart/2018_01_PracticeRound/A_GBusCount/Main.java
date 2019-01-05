import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

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
				String[] strCities = br.readLine().trim().split("\\s+");
				int[] bussesStops = new int[strCities.length];
				for (int j=0; j<strCities.length; j++) {
					bussesStops[j] = Integer.parseInt(strCities[j]);
				}
				int P = Integer.parseInt(br.readLine().trim());
				int[] queryCities = new int[P];
				for (int j=0; j<P; j++) {
					queryCities[j] = Integer.parseInt(br.readLine().trim());
				}
				br.readLine();

				String rta = solucionarCaso(N, bussesStops, P, queryCities);
				//---------------------------------------------

				String solucion = "Case #"+(i+1)+": "+rta;
				System.out.println(solucion);
			}
		}
	}

	private static String solucionarCaso(int N, int[] bussesStops, int P, int[] queryCities)
	{
		// 1) Recorrer las paradas y saber las ciudades
		SortedSet<City> cities = new TreeSet<>();
		for (int i=0 ; i<2*N; i+=2) {
			int from = bussesStops[i];
			int to = bussesStops[i+1];
			City newFrom = new City(from, 0);
			City newTo = new City(to, 0);
			cities.add(newFrom);
			if (from-1 > 0) cities.add(new City(from-1, 0));
			cities.add(new City(from+1, 0));
			cities.add(newTo);
			if (to-1 > 0) cities.add(new City(to-1, 0));
			cities.add(new City(to+1, 0));
		}

		City[] arrayCities = cities.toArray(new City[cities.size()]);

		// 2) Recorrer de nuevo las paradas y sumar buses a las ciudades visitadas
		for (int i=0 ; i<2*N; i+=2) {
			int from = bussesStops[i];
			int to = bussesStops[i+1];
			int posFrom = Arrays.binarySearch(arrayCities, new City(from, 0));
			int posTo = Arrays.binarySearch(arrayCities, new City(to, 0));
			for (int j=posFrom; j<= posTo; j++) {
				arrayCities[j].busses++;
			}
		}
		// System.out.println(Arrays.toString(arrayCities));

		String rta=""; 
		for (int city : queryCities) {
			if(!rta.isEmpty()) rta+=" ";
			int posCity = Arrays.binarySearch(arrayCities, new City(city, 0));
			if (posCity < 0) {
				posCity = (-(posCity) - 1);
				// System.out.println("city: " + city + " posCity:" + posCity);
				rta += (posCity>0 && posCity<arrayCities.length) ? arrayCities[posCity].busses : 0;
			} else rta += arrayCities[posCity].busses;
		}
		return rta;
	}

	private static class City implements Comparable<City> {
		int cityId, busses;

		public City(int cityId, int busses) {
			this.cityId = cityId;
			this.busses = busses;
		}	

		@Override
		public int compareTo(City o) {
			return Integer.compare(cityId, o.cityId);
		}

		@Override
		public String toString() {
			return cityId + " (" + busses + ")";
		}
	}

}
