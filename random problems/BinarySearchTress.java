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
public class BinarySearchTress {
    
    static class Node{
        int data;
        Node left;
        Node right;
    }
     Node insert(Node root){
        System.out.println("Enter the value");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        Node node = new Node();
        node.data=val;
        if(root==null){
            root=node;
        }
        else{
            Node temp = root;
            Node temp2=temp;
            while(temp!=null){
                temp2=temp;
                if(temp.data>val){
                    temp= temp.left;
                }
                else{
                    temp = temp.right;
                }
            }
            if(temp2.data>val){
                temp2.left=node;
            }
            else{
                temp2.right=node;
            }
        }
        return root;
    }
    
     Node delete(Node root){
        System.out.println("Enter the value to be deleted");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        if(root==null){
            System.out.println("Tree is Empty");
            return null;
        }
        else{
            if(root.data==val){
                if(root.left==null&&root.right==null){
                    root=null;
                    System.out.println("The number is deleted from the tree");
                    return null;
                }
                else if(root.left==null){
                    root=root.right;
                    System.out.println("The number is deleted from the tree");
                    return root;                          
                }
                else{
                    root=root.left;
                    System.out.println("The number is deleted from the tree");
                    return root;
                }
            }
            Node temp= root;
            Node temp2 = temp;
            while(temp!=null){
                temp2=temp;
                if(val>temp.data){
                    temp=temp.right;
                }
                else if(val<temp.data){
                    temp = temp.left;
                }
                else if(temp.data==val){
                    if(temp.left==null&&temp.right==null){
                        if(temp2.data>temp.data){
                            temp2.left=null;
                        }
                        else{
                            temp2.right=null;
                        }
                    }
                    else if(temp.left==null||temp.right==null){
                        if(temp.left==null){
                            if(temp2.data>temp.data){
                                temp2.left=temp.right;
                            }
                            else{
                                temp2.right=temp.right;
                            }
                        }
                        if(temp.right==null){
                            if(temp2.data>temp.data){
                                temp2.left=temp.left;
                            }
                            else{
                                temp2.right=temp.left;
                            }
                        }
                    }
                    
                    else if(temp.left!=null&&temp.right==null){
                        Node par = temp;
                        par = par.left;
                        Node temp3 = par;
                        while(par.right!=null){
                            temp3=par;
                            par=par.right;
                        }
                        temp.data=par.data;
                        if(par.left!=null){
                            temp3.right=par.left;
                        }
                        
                    
                    }
                    
                }
            }
        }
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
    public static void main (String arg[]){
        Node root = new Node();
        root =null;
       BinarySearchTress bt = new BinarySearchTress();
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
                case 1: root = bt.insert(root);
                        break;
                case 2: root = bt.delete(root);
                        break;
                case 3: bt.inorder(root);
                        break;
                case 4: bt.preorder(root);
                        break;
                case 5: bt.postorder(root);
                        break;
            }
        }
    }    
}
