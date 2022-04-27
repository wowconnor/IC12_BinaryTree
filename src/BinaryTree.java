public class BinaryTree<E extends Comparable<E>>{

    private Node<E> mRoot;

    public BinaryTree()
    {
        mRoot = null;
    }

    public void clear()
    {
        mRoot = null;
        // Request garbage collection
        System.gc();
    }
    public E getRootData()
    {
        return mRoot.mData;
    }

    private Node<E> addRecursive(Node<E> current, E element)
    {
        if(current==null)
            return new Node(element);
        else if(element.compareTo(current.mData)<0)
            current.mLeft = addRecursive(current.mLeft, element);
        else if(element.compareTo((current.mData))>0)
            current.mRight = addRecursive(current.mRight, element);
        else
            return current;
        return current;
    }

    public boolean add(E element)
    {
        // Call recursive method
        mRoot = addRecursive(mRoot, element);
        return true;
    }

    public boolean contains(E element)
    {
        return containsRecursive(mRoot, element);
    }

    private boolean containsRecursive(Node current, E element)
    {
        if(current == null)
            return false;
        else if(element.compareTo((E) current.mData)==0)
            return true;
        return (element.compareTo((E) current.mData)<0)
                ? containsRecursive(current.mLeft, element)
                : containsRecursive(current.mRight, element);
    }
    public void remove(E element)
    {
        mRoot = removeRecursive(mRoot, element);
    }
    public Node<E> removeRecursive(Node<E> current, E element)
    {
        if(element.compareTo(current.mData)==0)
            current = null;
        else if(element.compareTo(current.mData)<0)
            current.mLeft = removeRecursive(current.mLeft, element);
        else if(element.compareTo((current.mData))>0)
            current.mRight = removeRecursive(current.mRight, element);
        else
            return current;
        return current;
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.mLeft);
            System.out.print(node.mData + ", ");
            traverseInOrder(node.mRight);
        }
    }

    @Override
    public String toString() {
        System.out.print("[");
        traverseInOrder(mRoot);
        System.out.print("\b\b]");
        return "";
    }

    //NODE CLASS
    private class Node<E extends Comparable<E>>
    {
        private Node<E> mLeft;
        private E mData;
        private Node<E> mRight;

        public Node(E data, Node<E> left, Node<E> right)
        {
            mData = data;
            mLeft = left;
            mRight = right;
        }

        public Node(E data)
        {
            this(data, null, null);
        }

        public boolean isLeaf()
        {
            return mLeft == null && mRight == null;
        }
    }
    //
}
