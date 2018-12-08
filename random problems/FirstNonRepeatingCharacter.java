/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldmansachs;
import java.util.Scanner;
/**
 *
 * @author keshav
 */
public class FirstNonRepeatingCharacter {
 
    public static void main(String s[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
       // System.out.println(s1);
        char c[] = s1.toCharArray();
        int a[] = new int[256];
        for(int i=0;i<s1.length();i++){
            a[(int)(c[i])]++;
        }
        
        System.out.println();
        for(int i=0;i<c.length;i++){
            if(a[(int)(c[i])]==1){
                System.out.println(""+c[i]);
                break;
            }
        }
    }
}
