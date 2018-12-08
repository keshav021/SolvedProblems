/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.util.*;
/**
 *
 * @author keshav
 */
public class BubbleSort {
    public static void main(String s[]){
        int n=100;
        int a[] = new int[n];
        Random rand = new Random();
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(453);
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
