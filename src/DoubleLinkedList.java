/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-08-02
 * Time:18:39
 **/
class Node{
    private Node next;
    private Node prev;
    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
}
public class DoubleLinkedList {

    public Node head;
    public Node tail;

    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        head = node;

    }
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
    }
    private  Node findIndex(int index){
        Node cur = this.head;
        while(index != 0){
            cur = cur.getNext();
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        Node node = new Node(data);
        if(index <0 || index > size()){
            System.out.println("当前位置不合法");
            return;
        }
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        Node cur = findIndex(index);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.getPrev().setNext(node);
        cur.setPrev(node);



    }
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public int  remove(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == key){
                int oldData = cur.getData();
                if (this.head.getData() == key){
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                }else {
                    cur.getPrev().setNext(cur.getNext());
                    if (cur.getNext() != null){
                        cur.getNext().setPrev(cur.getPrev());
                    }
                    this.tail = cur.getPrev();
                }
                return oldData;
            }
            cur = cur.getNext();

        }
        return -1;

    }
    public void removeAllKey(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == key){
                int oldData = cur.getData();
                if (this.head.getData() == key){
                    this.head = this.head.getNext();
                    if (this.head != null){
                        this.head.setPrev(null);
                    }

                }else {
                    cur.getPrev().setNext(cur.getNext());
                    if (cur.getNext() != null){
                        cur.getNext().setPrev(cur.getPrev());
                    }
                    this.tail = cur.getPrev();
                }

            }
            cur = cur.getNext();

        }

    }
    public int size(){
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    public void clear(){
        this.head = null;
        this.tail = null;
    }
    public static void main(String[] args) {

    }
}
