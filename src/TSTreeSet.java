import java.util.Iterator;
import java.util.TreeSet;

/**
 * This class implements a TreeSet
 *
 * @author Thomas Binu and Savitha Jayasankar
 **/
public class TSTreeSet<E extends Comparable<E>> extends TreeSet<E> {

    private Node<E> root;
    int size = 0;

    boolean isElementFound = true;

    public TSTreeSet() {
    }

    public void init() {
    }

    /**
     * Iterative Algorithm to add elements to TreeSet
     */
    @Override
    public boolean add(E e) {


        if (root == null) {
            root = new Node<E>(e);
            size++;
            return true;
        } else {

            Node<E> parent;
            Node<E> currentNode = root;

            while (true) {

                parent = currentNode;
                if (currentNode.e.compareTo(e) > 0) {

                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parent.left = new Node<E>(e);
                        parent.left.parent = parent;
                        size++;
                        return true;
                    }

                } else if (currentNode.e.compareTo(e) < 0) {

                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parent.right = new Node<E>(e);
                        parent.right.parent = parent;
                        size++;
                        return true;
                    }
                } else if (currentNode.e.compareTo(e) == 0) {
                    return false;
                }

            }
        }
    }

    public boolean remove(E e) {

        // Hack that needs to be removed
        isElementFound = true;
        deleteRecursive(root, e);
        if (isElementFound) {
            size--;
        }
        return isElementFound;

    }

    public Node<E> deleteRecursive(Node<E> parentNode, E e) {

        if (parentNode == null) {
            isElementFound = false;
            return null;

        } else {

            if (parentNode.e.compareTo(e) > 0) {

                parentNode.right = deleteRecursive(parentNode.right, e);

            } else if (parentNode.e.compareTo(e) < 0) {

                parentNode.left = deleteRecursive(parentNode.left, e);

            } else {

                if (parentNode.right == null && parentNode.left == null) { // if leaf node
                    return null;

                } else if (parentNode.right == null) { //if node with single child
                    return parentNode.left;

                } else if (parentNode.left == null) { //if node with single child
                    return parentNode.right;

                } else { // if node has 2 children

                    Node<E> nextInorderSuccessor = getMinNode(parentNode.right);

                    //replace the parent node value with the inorder successor
                    parentNode.e = nextInorderSuccessor.e;

                    //delete the inorder successor
                    parentNode.right = deleteRecursive(parentNode.right, e);

                }

            }
            return parentNode;
        }
    }


    public void print() {
        printUsingInOrderSucessor();
    }

    private Node inOrderSuccessor(Node currentNode) {

        if (currentNode == null) {
            return getMinNode(root);

        } else if (currentNode.right != null) {
            return getMinNode(currentNode.right);
        } else {

            Node parent = currentNode.parent;

            //While the current node is a the right child of a parent node
            while (parent != null && currentNode == parent.right) {
                currentNode = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private void printUsingInOrderSucessor() {

        Node tempNode = null;
        while ((tempNode = inOrderSuccessor(tempNode)) != null) {
            System.out.println(tempNode.e);
        }
    }

    private void inOrderTraversal(Node node) {

        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.e.toString());
        inOrderTraversal(node.right);

    }

    private Node<E> getMinNode(Node node) {

        Node minNode = node;
        while (minNode.left != null) {

            minNode = minNode.left;
        }
        return minNode;
    }


    public void parse() {
    }

    public String toString() {
        return "";
    }

    public void clear() {

        root = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {

        Comparable comparable = (Comparable) o;
        Node currentNode = root;
        while (currentNode != null) {
            if (comparable.compareTo(currentNode.e) > 0) {
                currentNode = currentNode.right;
            } else if (comparable.compareTo(currentNode.e) < 0) {
                currentNode = currentNode.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {

        return root == null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new TSIterator<E>(root);
    }

}