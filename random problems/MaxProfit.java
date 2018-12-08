import java.io.*;
import java.util.*;

public class MaxProfit{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		int cost = Integer.parseInt(br.readLine());
		String s1[] = br.readLine().split(" ");
		String s2[] = br.readLine().split(" ");
		int a[] = new int[n];int b[] = new int[n];
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(s1[i]);
			b[i]=Integer.parseInt(s2[i]);
		}
		int dp1[] = new int[n];int dp2[] = new int[n];
		dp1[n-1]=a[n-1];
		dp2[n-1]=b[n-1];
		for(int i=n-2;i>=0;i--){
			dp1[i]= a[i]+Math.max(dp1[i+1],dp2[i+1]-cost);
			dp2[i]= b[i]+Math.max(dp2[i+1],dp1[i+1]-cost);
		}
		System.out.println("MaxProfit is "+ Math.max(dp1[0],dp2[0]));
		for(int i=0;i<n;i++){
			System.out.print(dp1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(dp2[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			if(dp1[i]>dp2[i]){
				System.out.print("A ");
			}
			else{
				System.out.print("B ");
			}
		}
	}

}