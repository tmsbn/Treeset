class Node<E extends Comparable<E>> {

    E e;
    Node<E> right;
    Node<E> left;
    Node<E> parent;

    
    Node(E e) {
        this.e = e;
    }

    boolean contains(E e) {

        return true;
    }

    public void parse(E e[]) {
    }

    public String toString() {

        return "";
    }
}