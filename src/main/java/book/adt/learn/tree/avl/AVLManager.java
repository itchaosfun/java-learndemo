package book.adt.learn.tree.avl;

public class AVLManager {

    private AVLNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public AVLNode insert(AVLNode root, int data) {
        if (root == null) {
            return new AVLNode(data, null, null);
        }

        int rootData = root.data;
        if (rootData > data) {
            //向左插入
            root.left = insert(root.left, data);
        } else if (rootData < data) {
            //向右插入
            root.right = insert(root.right, data);
        } else {
            //重复了
            return root;
        }

        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (root == null) {
            return null;
        }

        if (height(root.left) - height(root.right) > 1) {
            //左边比右边深
            System.out.println("左边比右边深 ==>右旋");
            root = rotateRightChild(root);
//            if (height(root.left.left) >= height(root.left.right)) {
//                //左边的左子树大于左边的右子树 ==> 左左 -》右旋
//                System.out.println("左边的左子树大于左边的右子树 ==> 左左 -》右旋");
//            } else {
//                //左边的右子树大于左边的左子树 ===> 右旋
//                System.out.println("左边的左子树大于左边右子树 ===> 右旋");
//                root = rotateRightChild(root);
//            }
        } else if (height(root.right) - height(root.left) > 1) {
            //右边比左边深
            System.out.println("右边比左边深 ==>左旋");
            root = rotateLeftChild(root);
//            if (height(root.right.right) >= height(root.right.left)) {
//                //右边的右子树大于右边的左子树 ===> 右右 -》左旋
//                System.out.println("右边的右子树大于右边的左子树 ===> 右右 -》左旋");
//                root = rotateLeftChild(root);
//            } else {
//                //右边的左子树大于右边的右子树 ===> 左旋
//                System.out.println("左子树大于右子树 ===> 先左旋");
//                root = rotateLeftChild(root);
//            }
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        return root;
    }

    private AVLNode rotateRightChild(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private AVLNode rotateLeftChild(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    public void remove(int data) {
        remove(root, data);
    }

    public AVLNode remove(AVLNode root, int data) {
        if (root == null){
            return root;
        }

        int rootData = root.data;
        if (data > rootData){
            //向右
            root.right = remove(root.right,data);
        }else if (data < rootData){
            //向左
            root.left = remove(root.left,data);
        }else if (root.left != null && root.right != null){
            //两个节点的
            //寻找右子树的最小节点并赋值给当前的节点，之后删除那个最小节点的数据
            root.data = findMin(root.right);
            root.right = remove(root.right,root.data);
        }else {
            root = (root.left != null)?root.left:root.right;
        }

        return balance(root);
    }

    public AVLNode find(int data) {
        return find(root, data);
    }

    public AVLNode find(AVLNode root, int data) {

        int rootData = root.data;
        if (rootData > data) {
            //向左查
            if (root.left != null) {
                return find(root.left, data);
            } else {
                return null;
            }
        } else if (rootData < data) {
            //向右查
            if (root.right != null) {
                return find(root.right, data);
            } else {
                return null;
            }
        } else {
            //查到了
            return root;
        }
    }

    public void preForeach() {
        if (root == null) {
            System.out.println("树为空了。。");
            return;
        }
        preForeach(root, "");

    }

    private void preForeach(AVLNode root, String temp) {
        if (root == null) {
            return;
        }
        System.out.println(temp + root.data);
        temp += "\t";
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                System.out.println(temp + root.left.data);
            } else {
                preForeach(root.left, temp);
            }
        }

        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                System.out.println(temp + root.right.data);
            } else {
                preForeach(root.right, temp);
            }
        }
    }

    public void preForeachWithoutFormat() {
        preForeachWithoutFormat(root);
    }

    private void preForeachWithoutFormat(AVLNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.toString());
        if (root.left != null) {
            preForeachWithoutFormat(root.left);
        }

        if (root.right != null) {
            preForeachWithoutFormat(root.right);
        }
    }

    private int height(AVLNode root) {
        return root == null ? -1 : root.height;
    }

    private int findMin(AVLNode avlNode) {
        if (avlNode.left == null){
            return avlNode.data;
        }
        return findMin(avlNode.left);

    }
}
