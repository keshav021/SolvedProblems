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
public class MinHeap {
    int heapSize;
    int heap[];
    public MinHeap(int n){
        heapSize=0;
        heap = new int[n+1];
    }
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }
 
    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }
 
    /** Clear heap */
    public void makeEmpty( )
    {
        heapSize = 0;
    }
 
    /** Function to  get index parent of i **/
    private int parent(int i) 
    {
        return (i - 1)/2;
    }
 
    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) 
    {
        return 2 * i + k;
    }
 
    /** Function to insert element */
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }
 
    /** Function to find least element **/
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }
 
    /** Function to delete min element **/
    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }
 
    /** Function to delete element at an index **/
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown2(ind);        
        return keyItem;
    }
 
    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];    
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }
 
    /** Function heapifyDown **/

    
    private void swap(int heap[],int index1,int index2){
        int temp;
        temp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=temp;
    }
    private void heapifyDown2(int ind){
        int left = 2*ind+1;
        int right= 2*ind+2;
        int smallest = ind;
        if(left<heapSize&&heap[left]<heap[smallest]){
            smallest=left;
        }
        if(right<heapSize&&heap[right]<heap[smallest]){
            smallest=right;
        }
        if(smallest!=ind){
            swap(heap,ind,smallest);
            heapifyDown2(smallest);
        }
        
    }

 
    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     
  
    
    
    public static void main(String s[]){

       Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");
        /** Make object of BinaryHeap **/
        MinHeap bh = new MinHeap(scan.nextInt() );
 
        char ch;
        /**  Perform Binary Heap operations  **/
        do    
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");            
            System.out.println("4. check empty");
            System.out.println("5. clear");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter integer element to insert");
                    bh.insert( scan.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Min Element : "+ bh.deleteMin()); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }                 
                break;                                
            case 3 : 
                System.out.println("Full status = "+ bh.isFull());
                break;                                   
            case 4 : 
                System.out.println("Empty status = "+ bh.isEmpty());
                break; 
            case 5 : 
                bh.makeEmpty();
                System.out.println("Heap Cleared\n");
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display heap **/
            bh.printHeap();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
  
        
    }
}
