package com.my.heap;

public class Node {
    private int data;
    
    public Node(int key){
        this.data = key;
    }
    
    public int getKey(){
        return this.data;
    }
    
    public void setKey(int key){
        this.data = key;
    }
    
}
