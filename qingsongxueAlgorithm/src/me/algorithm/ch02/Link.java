package me.algorithm.ch02;

/**
 * Created by Administrator on 2016/12/8.
 */
public class Link {
    private Node first;
    private Node last;
    private int size;
    public Link(){
    }
    public void addLast(int data){
        if(this.size == 0){
            first = new Node();
            first.setData(data);
            last = first;
        }else {
            Node node = new Node();
            node.setData(data);
            last.setNext(node);
            last = node;
        }
        this.size++;
    }
    public void addFirst(int data){
        if(this.size == 0){
            first = new Node();
            first.setData(data);
            last = first;
        }else{
            Node node = new Node();
            node.setData(data);
            node.setNext(first);
            first = node;
        }
        this.size++;
    }

    /**
     * 在index下标之后插入 (index从0开始)
     * @param data
     * @param index
     */
    public void add(int data,int index){
        if(this.size > index){
            if(index == 0){
                //this.addFirst(data);
                Node node = new Node();
                node.setData(data);
                node.setNext(first.getNext());
                first.setNext(node);
                this.size++;
            }else if(index + 1 == size){
                this.addLast(data);
            }else{
                Node tmp = this.get(index);
                Node node = new Node();
                node.setData(data);
                node.setNext(tmp.getNext());
                tmp.setNext(node);
                this.size++;
            }
        }else{
            throw new IndexOutOfBoundsException("链表没那么长");
        }
    }
    public Node get(int index){
        Node tmp = this.first;
        if(index + 1 < this.size) {
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
        }else{
            tmp = null;
        }
        return tmp;
    }
    public void removeFirst(){
        if(this.size == 0){
            throw new IndexOutOfBoundsException("链表没有元素");
        }else {
            first = first.getNext();
            this.size--;
        }
    }
    public void removeLast(){
        if(this.size == 0){
            throw new IndexOutOfBoundsException("链表没有元素");
        }else if(this.size == 1){
            first = null;
            last = null;
            this.size--;
        }else {
            Node node = get(this.size - 2);
            last = node;
            node.setNext(null);
            this.size--;
        }
    }

    //index从0开始
    public void remove(int index){
        if(index < this.size){
            if(index == 0){
                removeFirst();
            }else if(index + 1 == size){
                removeLast();
            }else{
                Node tmp = get(index - 2);// 当前节点的前一个节点
                Node next = tmp.getNext();//当前节点
                tmp.setNext(next.getNext());
                next = null;//空间回收
                this.size--;
            }
        }else{
            throw new IndexOutOfBoundsException("链表没那么长");
        }
    }

    public int size(){
        return  this.size;
    }

    public void printAll(){
        Node node = first;
        while (node != null){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
    public static void main(String[] args){
        Link link = new Link();
        link.addLast(4);
        link.addLast(8);
        link.addFirst(6);
//        link.addFirst(3);
//        link.add(7,2);
//        link.removeFirst();
//        link.removeLast();
        link.remove(1);
//        link.add(88,2);
        link.printAll();
//        System.out.println(link.size());
    }
}
