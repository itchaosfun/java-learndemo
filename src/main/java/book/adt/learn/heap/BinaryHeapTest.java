package book.adt.learn.heap;

import java.util.Scanner;

public class BinaryHeapTest {

    public void test() {

        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15, 67, 39, 88, 48, 21, 96, 74, 50};

        BinaryHeap binaryHeap = new BinaryHeap();
        int operateType = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("二叉堆的操作： 增（i）删（r）查最小(min)是否为空(e)置空(me)数组构建(a)");
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
                    try {
                        binaryHeap.deleteMin();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (next.equals("min")) {
                    operateType = 2;
                    System.out.println("当前的操作类型是寻找最小值");
                    Integer max = null;
                    try {
                        max = binaryHeap.findMin();
                        System.out.println("最大值是：" + max);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }  else if (next.equals("e")) {
                    System.out.println("当前的操作类型是查看是否为空");
                    operateType = 3;
                    System.out.println("当前二叉堆"+(binaryHeap.isEmpty()?"":"不")+"为空");
                } else if (next.equals("me")) {
                    System.out.println("当前的操作类型是置空");
                    operateType = 4;
                    binaryHeap.makeEmpty();
                } else if (next.equals("a")){
                    operateType = 5;
                    System.out.println("当前的操作类型是数组构建二叉堆");
                    binaryHeap = new BinaryHeap(array);
                }
                else {
                    try {
                        Integer data = Integer.parseInt(next);
                        switch (operateType) {
                            case 0:
                                binaryHeap.insert(data);
                                break;
                            case 1:
                                binaryHeap.deleteMin();
                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case -1:
                                System.out.println("您还没有选择需要对二叉堆进行哪种操作");
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
