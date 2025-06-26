// Write a method delete() that takes an int argument k and deletes the kth element in a linked list, if it exists.

public void delete(int k) {
    if (k <= 0 || first == null) {
        return;
    }

    if (k == 1) {
        first = first.next;
        return;
    }

    Node current = first;
    Node previous = null;
    int count = 1;

    while (current != null && count < k) {
        previous = current;
        current = current.next;
        count++;
    }

    if (current != null) {
        previous.next = current.next;
    }
}
