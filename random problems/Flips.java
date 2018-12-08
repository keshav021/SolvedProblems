import java.io.*;
import java.util.*;

public class Flips{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int a[] = new int[s.length];
		for(int i=0;i<s.length;i++){
			a[i]=Integer.parseInt(s[i]);
			if(a[i]==0){
				a[i]=1;
			}
			else{
				a[i]=-1;
			}
		}
		int sum=a[0];
		int max =a[0];
		int left=-1;
		int right =-1;
		int max_left=-1;
		int max_right=-1;
		int count=0;
		for(int i=1;i<s.length;i++){
			if(sum<=0){
				sum =0;
				left=i;
				count =0;
			}
			
				sum= sum+a[i];
				//count++;
				if(sum>max){
					right = i;
					max_left=left;
					max=sum;
				
			}
		}
		System.out.println(max_left+" "+right);
	}
}