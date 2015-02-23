package adt;

/**
 * Created by alshevchuk on 22.02.2015.
 */
public class ADT_Main {
    public static void main(String[] args) {
        Queue<String> q1 = new Queue<>();
        System.out.println("Init size() = " + q1.size());
        q1.enqueue("1");
        q1.enqueue("2");
        q1.enqueue("3");
        q1.enqueue("4");
        q1.enqueue("5");
        q1.enqueue("6");
        q1.enqueue("7");
        System.out.println("Size() = " + q1.size());

        System.out.println("toString():\n" + q1.toString());

        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println("After all operations size() = " + q1.size());
    }
}
