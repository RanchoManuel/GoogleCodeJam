package auxiliar;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x1=0;
		int y1=1;
		int x2=1;
		int y2=10;
		
		//int[] ec={(y2-y1),(-x2+x1),((-y1*x2)+(x1*y2))};
		int[] ec2={(y1-y2),(1),(y1)};
		for (int comp : ec2) {
			System.err.print(comp+" ");
		}
		System.out.println();
		String ecuacion=(y2-y1)+"x ,"+(-x2+x1)+"y"+"="+((-y1*x2)+(x1*y2));
		
		System.out.println(ecuacion);
	}

}
