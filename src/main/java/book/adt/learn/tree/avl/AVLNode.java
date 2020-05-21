package book.adt.learn.tree.avl;

public class AVLNode {

    public int data;
    public int height;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int data, AVLNode left, AVLNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "data=" + data +
                ", height=" + height +
                ", left=" + (left == null?"null":left.data) +
                ", right=" + (right == null?"null":right.data) +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }
}
