package practice.linkedList;

public class LinkedListDriver {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        for(int i=0;i<10;i++){

            list.insertAtHead(i);
        }
        list.printList();

    }

}
