package com.my.heap;

import java.util.Formatter;

public class Heap {
    private Node[] hArray;
    private int maxSize;
    private int curSize;
    
    public Heap(int max){
        this.maxSize = max;
        this.curSize = 0;
        this.hArray = new Node[this.maxSize];
    }
    
    public void increaseSize(){
        Node[] oldArray = this.hArray;
        this.hArray = new Node[this.maxSize*2];
        System.arraycopy(oldArray, 0, this.hArray, 0, this.maxSize);
        this.maxSize *= 2;
    }
    
    public boolean isEmpty(){
        return (this.curSize == 0);
    }
    
    public boolean insert(int key){
        if (key < 0) return false;
        if (this.curSize == this.maxSize)
            this.increaseSize();
        
        Node newNode = new Node(key);
        this.hArray[this.curSize] = newNode;
        up(curSize++);
        return true;
    }
    
    public Node remove(){
        this.hArray[0] = this.hArray[--this.curSize];
        down(0);
        return this.hArray[0];
    }
    
    public boolean change(int x, int value){
        if (value == -1) return false;
        x--;
        if ((x < 0)||(x >= this.maxSize)){
            return false;
        }
        int oldValue = this.hArray[x].getKey();
        this.hArray[x].setKey(value);
        if (oldValue < value){
            up(x);
        }
        else{
            down(x);
        }
        return true;
    }
    
    public void show(){
        System.out.print("Массив: ");
        for (int i = 0; i < this.curSize; i++){
            if (this.hArray[i] != null){
                System.out.print("[" + (i+1) + "]" + this.hArray[i].getKey() + " ");
            }
            else{
                System.out.print("-- ");
            }
        }
        System.out.println();

        int n = this.maxSize;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        
        String dots = "....................................................................";
        System.out.println(dots + dots);
        while (this.curSize > 0){
            if (column == 0){
                for (int i = 0; i < n; i++){
                    System.out.print(" ");
                }
            }
            Formatter fmt = new Formatter();
            System.out.print(fmt.format("%2s",this.hArray[j].getKey()));
            if (++j == this.curSize){
                break;
            }
            if (++column == itemsPerRow){
                n /= 2;
                itemsPerRow *= 2;
                column =  0;
                System.out.println();
            }
            else{
                for(int i = 0; i < n*2 - 2; i++){
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }
    
    public void up(int x){
        int parent = (x-1)/2;
        Node bot = this.hArray[x];
        while ((x>0)&&(this.hArray[parent].getKey() < bot.getKey())){
            this.hArray[x] = this.hArray[parent];
            x = parent;
            parent = (parent-1)/2;
        }
        this.hArray[x] = bot;
    }
    
    private boolean leftIsLess(int l, int r){
        return (r < this.curSize)&&(this.hArray[l].getKey() < this.hArray[r].getKey());
    }
    
    public void down(int x){
        int maxChild;
        Node top = this.hArray[x];
        while (x < this.curSize/2){
            int lChild = 2*x + 1;
            int rChild = lChild + 1;
            if (leftIsLess(lChild,rChild)){
                maxChild = rChild;
            }else{
                maxChild = lChild;
            }
            if (top.getKey() >= this.hArray[maxChild].getKey()){
                break;
            }
            this.hArray[x] = this.hArray[maxChild];
            x = maxChild;
        }
        this.hArray[x] = top;
    }
}
