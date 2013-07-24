import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

public class r1B_A {
public static void main(String[] args) {
		String prblm="A"; boolean fl=true;
		String filein=prblm+"-"+((fl)?"large":"small")+".in.txt";
		String fileout=prblm+"-"+((fl)?"large":"small")+".out.txt";
		try {
			BufferedReader fr= new BufferedReader(new FileReader(filein));
			BufferedWriter fw= new BufferedWriter(new FileWriter(fileout));
			String s=fr.readLine();
			int n=Integer.parseInt(s);
			for (int i = 1; i <= n; i++) {
				s=fr.readLine();
				String[] as=s.split(" ");
				int N=Integer.parseInt(as[0]);
				int M=Integer.parseInt(as[1]);
				HashSet<String> trs=new HashSet<String>();
				for (int j = 0; j < N; j++) {
					s=fr.readLine();
					trs.add(s);
				}
				int nmkd=0;
				for (int j = 0; j < M; j++) {
					s=fr.readLine();
					int k=s.length();					
					while (k>0){
						s=s.substring(0,k);
						if (trs.contains(s)) break;
						trs.add(s); nmkd++;
						k=s.lastIndexOf('/');	
					}
				}				
				System.out.println(nmkd);
				fw.write("Case #"+i+": "+  nmkd +"\n");
			}
			fr.close();
			fw.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}