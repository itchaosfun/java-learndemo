

public class BinaryNode<AnyType> {
    AnyType element;
    BinaryNode<AnyType> leftChild;
    BinaryNode<AnyType> rightChild;

    public BinaryNode(AnyType element, BinaryNode<AnyType> leftChild, BinaryNode<AnyType> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "element=" + element +
                ", leftChild=" + (leftChild == null?"null":leftChild.element) +
                ", rightChild=" + (rightChild == null?"null":rightChild.element) +
                '}';
    }
}
