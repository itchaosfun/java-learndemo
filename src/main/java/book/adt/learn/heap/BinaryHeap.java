package book.adt.learn.heap;

/**
 * 二叉堆
 * 在结构上是一个符合堆序性质的完全二叉树
 */
public class BinaryHeap {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new int[capacity + 1];
    }

    public BinaryHeap(int[] items) {
        currentSize = items.length;
        array = new int[(currentSize + 2) * (11 / 10)];
        int i = 1;
        for (int item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    public void insert(int value) {
        //insert是一个上滤的过程

        //是否需要扩容
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }

        //将末尾空出来一个位置，通过for循环依次向上判断元素之间的大小，直到发现有元素比他小的时候停止
        int hole = ++currentSize;
        for (array[0] = value; value < array[hole / 2]; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = value;

        printHeapArray(array);

    }

    public int findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception("array is empty");
        }
        return array[1];
    }

    public int deleteMin() throws Exception {
        if (isEmpty()) {
            throw new Exception("array is empty");
        }

        int minItem = findMin();
        //将数组中最后一个位置的元素设置到第一个上，虽然第一个位置名义上是空穴，此时的值确是最后一个数据的值
        array[1] = array[currentSize--];
        System.out.println("array[1] = " + array[1]);
        percolateDown(1);

        printHeapArray(array);

        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private int[] array;

    /**
     * 下滤
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        //hole是指空穴，将堆中最后一个数据X取出（见deleteMin）并赋值到该空穴上，并将该节点删除，接下来就是从1开始判断较小侧树的元素与X的大小
        //若小于X,则该元素填充上一个空穴的地方，该元素原先所在的地方成为新的空穴，接下来继续依次比较，直到X能够放入一个空穴中
        int child = 0;
        int temp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1] < array[child]) {
                //右儿子小于左儿子，child+1
                //其实就是找出左儿子和右儿子谁大谁小，小的才能填充到空穴内
                child++;
            }

            if (array[child] < temp) {
                //如果找出来的元素比最后一个元素小，那么就可以填充空穴
                array[hole] = array[child];
            } else {
                //此时找出来的元素比最后一个元素大，那么本次下滤操作结束，hole的位置已经找到，即最后一个元素需要填充的地方就找到了
                break;
            }
        }

        array[hole] = temp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }

        printHeapArray(array);
    }

    private void enlargeArray(int newSize) {
        int[] old = array;
        array = new int[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    private void printHeapArray(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++) {
            if (i % 2 == 0) {
                sb.append("\t");
            }
            System.out.println(sb.toString() + array[i]);

        }
    }

}
