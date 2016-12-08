package me.algorithm.ch02;

/**
 * Created by Administrator on 2016/12/8.
 */
public class Node {
    private int data;
    private Node next;
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }

}
