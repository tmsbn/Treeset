import java.util.Iterator;

class TSIterator<E extends Comparable<E>> implements Iterator<E>{

    private Node<E> root;
    private Node<E> currentNode = null;

    public TSIterator(Node<E> root) {
        this.root = root;
    }

    public boolean hasNext() {
        return getInOrderSuccessor(currentNode) != null;
    }

    public E next() {
        currentNode = getInOrderSuccessor(currentNode);
        return currentNode.e;
    }

    @Override
    public void remove() {

    }

    private Node<E> getInOrderSuccessor(Node<E> currentNode) {

        if (currentNode == null) {
            return getMinNode(root);

        } else if (currentNode.right != null) {

            //
            return getMinNode(currentNode.right);
        } else {

            Node<E> parent = currentNode.parent;

            //While the current node is a the right child of a parent node
            while (parent != null && currentNode == parent.right) {
                currentNode = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private Node<E> getMinNode(Node<E> node) {

        if(node == null)
            return node;

        Node<E> minNode = node;
        while (minNode.left != null) {

            minNode = minNode.left;
        }
        return minNode;
    }
}