/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.util.HashMap;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author keshav
 */
public class Trie {
    static class Node{
        HashMap<Character,Node> table;
        boolean isComplete;
        public Node(){
            table = new HashMap<>();
            isComplete = false;
        }
    }
    
    Node insert(Node root, String s){
            Node current = root;
            //Node node = new Node();
            
            char c[] = s.toCharArray();
            for(int i=0;i<c.length;i++){
                //current =root;
                Node temp = current.table.get(c[i]);
                if(temp==null){
                    //Node temp = new Node();
                    temp = new Node();
                    current.table.put(c[i], temp);
                }
                current = temp;
               // current = current.table.get(c[i]);
            }
            if(current.isComplete==true){
                System.out.println(s+" SAME STRING EXIST");
            }
            else{
                //System.out.println(s+" ADDED TO THE TREE SUCCESSFULLY");
                current.isComplete=true;
            }
               
        
        return root;
    }
    
    public static void main(String args[]) throws IOException{
        Node root = new Node();
       // root=null;
        Trie tree = new Trie();
        BufferedReader br = new BufferedReader(new FileReader("/home/keshav/NetBeansProjects/CDSPrep/src/cdsprep/input.txt"));
        String st;
        while((st = br.readLine())!=null){
        String s = st;
        
            root = tree.insert(root,s);
        
        }
    }
}
