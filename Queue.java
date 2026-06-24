public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null) {
            front = rear = newNode;
            return;
        }
        rear.setNext(newNode);
        rear = newNode;
    }

    public T dequeue()  {
        if (front == null) {
            return null;
        }

        T data = front.getData();
        front = front.getNext();
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}