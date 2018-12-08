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
public class InsertionSort {
    public static void main(String s[]){
        Random rand = new Random();
        int n= 100;
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(453);
        }
        for(int i=1;i<n;i++){
            int temp = a[i];
            int j=i-1;
            while(j>=0&&a[j]>temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
