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
public class AVLTrees {
    static class Node{
           int data;
           Node left;
           Node right;
           int height;
       }
 
    Node insert(Node root){
     System.out.println("Enter the value to be added");
     
        
        
        return root;  
    }
    Node delete(Node root){
        return root;
    }
     void inorder(Node root){
        if(root==null){
            return;
        }
        
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        
        
    }

     void preorder(Node root){
        if(root==null){
            return;
        }
        
            
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        
        
    } 
 

     void postorder(Node root){
        if(root==null){
            return;
        }
        
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
       
        
    }    
 
    public static void main(String args[]){
        Node root = new Node();
        root = null;
        AVLTrees tree = new AVLTrees();
        while(true){
        System.out.println();    
        System.out.println("WELCOME TO THE BST DEMO");
        System.out.println("SELECT AN OPTION FROM THE BELOW");
        System.out.println("1. INSERT");
        System.out.println("2. DELETE");
        System.out.println("3. PRINT INORDER");
        System.out.println("4. PRINT PREORDER");
        System.out.println("5.PRINT POSTORDER");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        
            switch(choice)
            {
                case 1: root = tree.insert(root);
                        break;
                case 2: root = tree.delete(root);
                        break;
                case 3: tree.inorder(root);
                        break;
                case 4: tree.preorder(root);
                        break;
                case 5: tree.postorder(root);
                        break;
            }
        }
        
    }
    
}
