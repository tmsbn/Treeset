import java.util.Iterator;

/**
 * This class implements in Iterator
 *
 * @author Thomas Binu and Savitha Jayasankar
 **/
class TSIterator<E extends Comparable<E>> implements Iterator<E>{

    private Node<E> root;
    private Node<E> currentNode = null;
    private boolean isNullAdded;

    public TSIterator(boolean isNullAdded, Node<E> root) {
        this.root = root;
        this.isNullAdded = isNullAdded;
    }

    /**
     * Checks if the next element when traversing tree in the sorted order
     * @return
     */
    public boolean hasNext() {
        return getInOrderSuccessor(currentNode) != null;
    }

    /**
     * Returns the next element when traversing tree in the sorted order
     * @return
     */
    public E next() {
        currentNode = getInOrderSuccessor(currentNode);
        return currentNode.e;
    }

    @Override
    public void remove() {

    }

    /**
     * Get Inorder successor of the node
     * @param currentNode
     * @return
     */
    private Node<E> getInOrderSuccessor(Node<E> currentNode) {

        if(isNullAdded){
            isNullAdded = false;
            return null;
        }if (currentNode == null) {
            return getMinNode(root);

        } else if (currentNode.right != null) {

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

    /**
     * Search for the node with the minimum value
     * @param node
     * @return
     */
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