package practice.linkedList;

public class SingleLinkedList<T> {

    public class Node{
       T data;
        Node next;
        }
        Node head;

   public SingleLinkedList(){
       head = null;
   }

   public void insertAtHead(T data){
       Node node = new Node();
       node.data = data;
       node.next = head;
        head = node;
   }
   public  void printList(){

       Node currentNode = head;

       while(currentNode.next != null) {
           System.out.print(currentNode.data);
           System.out.print("-->");
           currentNode = currentNode.next;
       }

   }


}
