package LinkedList;


import java.util.Scanner;

public class RemoveDuplicatesFromLinkedList {
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    Node head;
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
        } else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            RemoveDuplicatesFromLinkedList llist = new RemoveDuplicatesFromLinkedList();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }


            llist.head = removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
    static Node removeDuplicates(Node root)
    {
        return null;
        // Your code here
    }

}
