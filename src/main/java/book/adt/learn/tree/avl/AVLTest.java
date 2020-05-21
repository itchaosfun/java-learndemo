package book.adt.learn.tree.avl;

import book.adt.learn.tree.binary.BinarySearch;

import java.util.Scanner;

public class AVLTest {

    public void test() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        AVLManager avlManager = new AVLManager();
        int operateType = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("AVL的操作： 增（i）删（r）查(s)看(f)");
        String next;
        while (true) {
            if (scanner.hasNext()) {
                next = scanner.next();
                if (next.equals("i")) {
                    operateType = 0;
                    System.out.println("当前的操作类型是插入数据");
                } else if (next.equals("r")) {
                    operateType = 1;
                    System.out.println("当前的操作类型是删除数据");
                } else if (next.equals("s")) {
                    operateType = 2;
                    System.out.println("当前的操作类型是查找");
                } else if (next.equals("f")) {
                    operateType = 3;
                    System.out.println("当前的操作类型是有格式遍历");
                    avlManager.preForeach();
                } else if (next.equals("ff")) {
                    operateType = 4;
                    System.out.println("当前的操作类型是无格式遍历");
                    avlManager.preForeachWithoutFormat();
                }else {
                    try {
                        Integer data = Integer.parseInt(next);
                        switch (operateType) {
                            case 0:
                                avlManager.insert(data);
                                break;
                            case 1:
                                avlManager.remove(data);
                                break;
                            case 2:
                                AVLNode avlNode = avlManager.find(data);
                                System.out.println(avlNode.toString());
                                break;
                            case 3:

                                break;
                            case -1:
                                System.out.println("您还没有选择需要对二叉树进行哪种操作");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("您输入的数据不合法，请重新输入");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
