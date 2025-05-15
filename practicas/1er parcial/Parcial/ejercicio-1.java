//Dadas las implementaciones de Stack & Queue vistas en clase, agregue a LinkedListQueue los siguientes métodos:
    //peek(): devuelve el elemento más antiguo de la cola.
    //reverse(): invierte el orden de la cola.
    //multiDequeue(int k): devuelve una nueva cola con los siguientes k elementos, o hasta que la cola esté vacía.
//Mencionar y justificar el orden de complejidad de cada uno de ellos.


public class LinkedListQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    public LinkedListQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public E peek() {           //es O(1)
        if (first == null) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return first.item;
    }

    public void reverse(){      //es O(n)
        Stack<E> stack = new Stack<>(); //O(1)
        while (!isEmpty()) {    //mientras que mi queue no esta vacia. O(n)
            stack.push(dequeue());  //O(n)
        }
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
    }

    public Queue<E> multiDequeue(int k) { //es O(n)
        Queue<E> result = new LinkedListQueue<E>();
        for (int i = 0; i < k && !isEmpty(); i++) { //O(n)
            result.enqueue(dequeue());  //O(2)
        }
        return result;  //O(1)
    }


}

