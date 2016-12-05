class Node<E extends Comparable<E>> {

    E e;
    Node<E> right;
    Node<E> left;
    Node<E> parent;

    
    Node(E e) {
        this.e = e;
    }

    public String toString() {

        return e.toString();
    }
}