

public class BinarySearch<AnyType extends Comparable<? super AnyType>> {

    private BinaryNode<AnyType> root;

    public BinarySearch() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(AnyType x) {
        return contain(x, root);
    }

    public AnyType findMin() throws Exception {
        return findMin(root);
    }

    public AnyType findMax() throws Exception {
        return findMax(root);
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) throws Exception {
        root = remove(x, root);
    }

    public void preFroEach() {
        preFroEach(root, "");
    }

    public void midForEach() {
        midForEach(root);
    }

    public void aftForEach() {
        aftForEach(root);
    }


    private void aftForEach(BinaryNode<AnyType> t) {
        if (t == null) {
            return;
        }

        if (t.leftChild != null){
            aftForEach(t.leftChild);
        }

        if (t.rightChild != null){
            aftForEach(t.rightChild);
        }

        System.out.println(t.element);

    }

    private void midForEach(BinaryNode<AnyType> t) {
        if (t == null) {
            return;
        }

        if (t.leftChild != null) {
            midForEach(t.leftChild);
        }

        System.out.println(t.element);

        if (t.rightChild != null) {
            midForEach(t.rightChild);
        }
    }

    private void preFroEach(BinaryNode<AnyType> t, String temp) {
        if (t == null) {
            return;
        }
        if (t.leftChild != null || t.rightChild != null) {
            System.out.println(temp + t.element);
        }

        temp = temp + "\t";
        BinaryNode<AnyType> leftChild = t.leftChild;
        if (leftChild != null) {
            if (leftChild.leftChild == null && leftChild.rightChild == null) {
                System.out.println(temp + leftChild.element);
            } else {
                preFroEach(leftChild, temp);
            }
        }

        BinaryNode<AnyType> rightChild = t.rightChild;
        if (rightChild != null) {
            if (rightChild.leftChild == null && rightChild.rightChild == null) {
                System.out.println(temp + rightChild.element);
            } else {
                preFroEach(rightChild, temp);
            }
        }

    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) throws Exception {
        if (t == null) {
            throw new Exception("当前树为空");
        }
        System.out.println("x = " + x + ",, note = " + t.toString());
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.leftChild = remove(x, t.leftChild);
        } else if (compareResult > 0) {
            t.rightChild = remove(x, t.rightChild);
        } else if (t.leftChild != null && t.rightChild != null) {
            t.element = findMin(t.rightChild);
            t.rightChild = remove(t.element, t.rightChild);
        } else {
            t = t.leftChild != null ? t.leftChild : t.rightChild;
        }
        System.out.println("return value: " + (t==null?"null":t.toString()));
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.leftChild = insert(x, t.leftChild);
        } else if (compareResult > 0) {
            t.rightChild = insert(x, t.rightChild);
        } else {
            return t;
        }

        return t;
    }

    private AnyType findMax(BinaryNode<AnyType> t) throws Exception {
        if (t == null) {
            throw new Exception("当前树为空");
        }
        if (t.rightChild == null) {
            return t.element;
        }
        return findMax(t.rightChild);
    }

    private AnyType findMin(BinaryNode<AnyType> t) throws Exception {
        if (t == null) {
            throw new Exception("当前树为空");
        }
        if (t.leftChild == null) {
            return t.element;
        }
        return findMin(t.leftChild);
    }

    private boolean contain(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            contain(x, t.leftChild);
        } else if (compareResult > 0) {
            contain(x, t.rightChild);
        } else {
            return true;
        }
        return false;
    }
}
