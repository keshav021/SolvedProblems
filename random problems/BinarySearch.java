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
public class BinarySearch {
    public static void main(String s[]){
        int a[] = {4, 8,12,13,15};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to search");
        int k= sc.nextInt();
        int low=0;
        int high = a.length-1;
        int mid =(low+high)/2;
        while(low<high&&a[mid]!=k){
            if(a[mid]>k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        if(a[mid]==k){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }
    }
}
