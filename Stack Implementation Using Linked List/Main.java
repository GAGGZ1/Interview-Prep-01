class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    // Push operation
    void push(int value) {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed into stack");
    }

    // Pop operation
    int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int poppedValue = top.data;
        top = top.next;

        return poppedValue;
    }

    // Peek operation
    int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == null;
    }

    // Display stack
    void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        Node temp = top;

        System.out.println("Stack elements:");

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();
    }
}