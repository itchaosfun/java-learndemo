package book.adt.learn.tree.binary;

import java.util.Scanner;

public class BinaryTest {

    public void test() {

        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int operateType = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("二叉树的操作： 增（i）删（r）查最大(max)查最小(min)是否包含(c)");
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
                } else if (next.equals("max")) {
                    operateType = 2;
                    System.out.println("当前的操作类型是寻找最大值");
                    Integer max = null;
                    try {
                        max = binarySearch.findMax();
                        System.out.println("最大值是：" + max);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (next.equals("min")) {
                    operateType = 3;
                    System.out.println("当前的操作类型是寻找最小值");
                    Integer min = null;
                    try {
                        min = binarySearch.findMin();
                        System.out.println("最小值是：" + min);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (next.equals("c")) {
                    System.out.println("当前的操作类型是查看某个值是否存在");
                    operateType = 4;
                } else if (next.equals("pre")) {
                    System.out.println("当前的操作类型是前序遍历");
                    operateType = 5;
                    binarySearch.preFroEach();
                } else if (next.equals("mid")) {
                    System.out.println("当前的操作类型是中序遍历");
                    operateType = 6;
                    binarySearch.midForEach();
                } else if (next.equals("aft")) {
                    System.out.println("当前的操作类型是后序遍历");
                    operateType = 7;
                    binarySearch.aftForEach();
                } else if (next.equals("clear")) {
                    System.out.println("当前的操作类型是清空树");
                    operateType = 8;
                    binarySearch.makeEmpty();
                } else {
                    try {
                        Integer data = Integer.parseInt(next);
                        switch (operateType) {
                            case 0:
                                binarySearch.insert(data);
                                break;
                            case 1:
                                binarySearch.remove(data);
                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:
                                boolean contain = binarySearch.contain(data);
                                System.out.println("" + data + (contain ? "存在" : "不存在"));
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
