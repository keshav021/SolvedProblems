import java.io.*;
import java.util.*;

public class CellPhone{
	
	static void solve(int []a, int num_len, String s2[]){
		int b[] = new int[num_len];
		long sum= 0;
		for(int i=0;i<num_len;i++){
			b[i]=Integer.parseInt(s2[i]);
			sum = sum + a[b[i]];
		}
		System.out.println(sum);

	}

	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String s[] = br.readLine().split(" ");
			int len = s.length;
			int a[] = new int[len];
			Arrays.fill(a,1000);
			for(int i=0;i<len;i++){
				a[i]=Integer.parseInt(s[i]);
			}
			int num_len= Integer.parseInt(br.readLine());
			String s2[] = br.readLine().split("");
			boolean flag =true;
			while(flag){
				boolean flag2=false;
				for(int i=0;i<10;i++){
					for(int j=i;j<10;j++){
						int k = (i+j)%10;
						if(a[k]>a[i]+a[j]){
							a[k]=a[i]+a[j];
							flag2=true;
						}
					}
				}
				if(flag2==false){
					break;
				}
			}
			solve(a,num_len,s2);
		}
	}
}