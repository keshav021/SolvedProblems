/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.io.*;
import java.util.*;
/**
 *
 * @author keshav
 */
public class LinkedList1 {
    static class Node{
            int data;
            Node next;    
        }
    static Node insert(Node head){
        //Node temp = head;
        System.out.println("Enter a number to add");
        Scanner sc = new Scanner(System.in);
        int val  = sc.nextInt();
        Node add = new Node();
        add.data= val;
        if(head==null){
            head= add;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = add;
        }
        return head;
    }
    
        static Node delete(Node head){
        //Node temp = head;
        System.out.println("Enter a number to delete");
        Scanner sc = new Scanner(System.in);
        int val  = sc.nextInt();
        if(head==null){
            System.out.println("List is empty");
            return null;
        }
        else{
            if(head.data==val){
                head = head.next;
            }
            else{
                Node temp = head.next;
                Node temp2 = head;
                while(temp!=null&&temp.data!=val){
                    temp2=temp;
                    temp = temp.next;
                }
                if(temp==null){
                    System.out.println("Item is not present in the list");
                    return head;
                }
                else if(temp.data==val){
                    System.out.println("Item is deleted from the list");
                    temp2.next = temp.next;
                }
                
                
                        
            }

        }
        return head;
    }
        
        
    static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = current;
        while(current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current = next;
        }
        head=prev;
        return head;
    }
    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main (String arg[]){
        Node head = new Node();
        head =null;
       
        while(true){
        System.out.println("WELCOME TO THE LINKED LIST DEMO");
        System.out.println("SELECT AN OPTION FROM THE BELOW");
        System.out.println("1. INSERT");
        System.out.println("2. DELETE");
        System.out.println("3. REVERSE");
        System.out.println("4. PRINT");
        System.out.println("5. EXIT");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        
            switch(choice)
            {
                case 1: head = insert(head);
                        break;
                case 2: head = delete(head);
                        break;
                case 3: head = reverse(head);
                        break;
                case 4: display(head);
                        break;
                case 5: System.out.println("BYE");
                        break;                    
            }
        }
    }
}
