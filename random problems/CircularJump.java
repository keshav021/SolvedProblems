import java.io.*;
import java.util.*;

public class CircularJump{
	
	static void solve(int a[], int fill[], int x, int y, int n ){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		fill[x]=0;
		while(!q.isEmpty()){
			int temp = q.poll();
			int right = temp+a[temp];
			if(right>n){
				right = right -n;
			}
			int left = temp-a[temp];
			if(left<1){
				left = left + n;
			}
			int val = fill[temp]+1;
			if(val<fill[right]){
				q.add(right);
				fill[right]=val;
			}
			if(val<fill[left]){
				q.add(left);
				fill[left]=val;
			}
		}
		if(fill[y]==Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(fill[y]);
		}
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String s[] = br.readLine().split(" ");
			int n= Integer.parseInt(s[0]);
			int x = Integer.parseInt(s[1]);
			int y= Integer.parseInt(s[2]);
			int a[] =new int[n+1];
			String s2[] = br.readLine().split(" ");
			for(int i=1;i<=n;i++){
				a[i]= Integer.parseInt(s2[i-1]);
				if(a[i]%n==0){
					a[i] -= ((a[i]/n)-1)*n;
				}
				else{
					a[i] -= ((a[i]/n))*n;
				}
			}
			int fill[] = new int[n+1];
			Arrays.fill(fill,Integer.MAX_VALUE);
			solve(a,fill,x,y,n);

		}
	}
}