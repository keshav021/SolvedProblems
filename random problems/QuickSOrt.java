/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author keshav
 */
public class QuickSOrt {
    static int partition(int[] a, int low , int high){
        Random rand= new Random();
        int k = low + rand.nextInt(453)%(high-low+1);
        int temp = a[high];
        a[high] = a[k];
        a[k]=temp;
        int i =low-1;
        int pivot = a[high];
        for(int j=low;j<high;j++){
            if(a[j]>=pivot){
                i=i+1;
                int temp2 = a[i];
                a[i]=a[j];
                a[j]=temp2;
            }
        }
        temp = a[high];
        a[high]=a[i+1];
        a[i+1]=temp;
        return i+1;
        
    }
            
            
    static void quickSort(int [] a , int low, int high){
        if(low<high){
            int q = partition(a,low,high);
            quickSort(a,low,q-1);
            quickSort(a,q+1,high);
        }
    }

    public static void main(String arg[]){
        Random rand = new Random();
        int n=30;
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(453);
            System.out.print(a[i]+" ");
        }
        System.out.println();
        quickSort(a,0,n-1);
        for(int i=0;i<n;i++){
             // a[i]=rand.nextInt(453);
              System.out.print(a[i]+" ");
          }    
        System.out.println();
    }
}
