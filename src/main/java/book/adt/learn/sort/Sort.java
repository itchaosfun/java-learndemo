package book.adt.learn.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort {

    /**
     * 插入排序
     * 插入排序是两两交换本示例是后一个跟前一个相比的
     * 比如45比23大，不用交换，本次内循环结束break
     * 12比45小，12跟45交换，12还比23小，12再跟23交换，j=0了，本次循环结束break
     * 此时array=[12,23,45,49,35,65,15]
     * 下面的23,45,49大小顺序是对的，35那里需要处理了，35比49小，35和49交换，35比45小，35跟45继续交换，35比23大，本次内循环结束break
     * ......以此推演下去即可~
     * 插入排序的时间复杂度最坏为O(N^2),最好为O(N),平均时间复杂度为O(N^2)
     */
    public void insertionSort() {
        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15};

        int j;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            a:
            for (j = i; j > 0; j--) {
                if (temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break a;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("i = " + array[i]);
        }
    }

    /**
     * 冒泡排序
     * 冒泡排序是每一轮选出一个最大的数的做法
     * 第一轮选出最大的数交换到末位，第二轮选出第二大的数交换到末位...直至结束
     * 冒泡排序的时间复杂度最坏为O(N^2),最好为O(N),平均时间复杂度为O(N^2)
     */
    public void bubbleSort() {
        int count = 0;
        int[] array = new int[]{23, 33, 47, 49, 53, 65, 75};
        for (int i = 0; i < array.length; i++) {

            boolean didSwap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = array[j];
                count++;
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    didSwap = true;
                }
            }

            if (!didSwap) {
                break;
            }
        }

        System.out.println("count = " + count);
        printArray(array);
    }


    /**
     * 选择排序
     * 选择排序就是每一轮选出一个最小的做法
     * 第一遍找最小值赋值给第一位，第二遍找第二小值赋值给第二位...直至结束
     * 选择排序的时间复杂度最坏为O(N^2),最好为O(N),平均时间复杂度为O(N^2)
     */
    public void selectSort() {
        int[] array = new int[]{23, 45, 47, 49, 53, 65, 75};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            boolean didSwap = false;
            for (int j = i + 1; j < array.length; j++) {
                count++;
                if (min > array[j]) {
                    int temp = array[j];
                    array[j] = min;
                    min = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
            array[i] = min;
        }
        System.out.println("count = " + count);
        printArray(array);

    }

    /**
     * 希尔排序
     * 希尔排序其实就是带有步进的插入排序
     * 其基本思路是，初始步进值为 length/2，依次比较第i个值与第（i+length/2）的值的大小，若大于则进行交换操作
     * 第一轮结束后，第二轮选组length/2/2作为步进值，重复上一行逻辑，直至结束
     * 希尔排序的时间复杂度最坏情形是O(N^2),最好和平均情形至今仍为有明确的证明结果，但有例子试验结果为O(N^7/6)
     */
    public void shellSort() {
        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15, 67, 39, 88, 48, 21, 96, 74, 50};
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            /**
             * 原始逻辑：
             *  for (int i = 0; i < array.length; i++) {
             *     int temp = array[i];
             *     a:
             *     for (j = i; j > 0; j -= gap) {
             *         if (j - gap >= 0 && temp < array[j - gap]) {
             *             array[j] = array[j - gap];
             *             array[j - gap] = temp;
             *         } else {
             *             break a;
             *         }
             *     }
             * }
             *
             * 优化逻辑阶段一
             * for (int i = 0; i < array.length; i++) {
             *     int temp = array[i];
             *     a:
             *     for (j = i; j >= gap; j -= gap) {
             *         if (temp < array[j - gap]) {
             *             array[j] = array[j - gap];
             *             array[j - gap] = temp;
             *         } else {
             *             break a;
             *         }
             *     }
             * }
             *
             * 优化逻辑阶段二
             * for (int i = gap; i < array.length; i++) {
             *     int temp = array[i];
             *     a:
             *     for (j = i; j >= gap; j -= gap) {
             *         if (temp < array[j - gap]) {
             *             array[j] = array[j - gap];
             *             array[j - gap] = temp;
             *         } else {
             *             break a;
             *         }
             *     }
             * }
             *
             * 优化逻辑阶段三
             * for (int i = gap; i < array.length; i++) {
             *     int temp = array[i];
             *     for (j = i; j >= gap && temp < array[j - gap]; j -= gap) {
             *         array[j] = array[j - gap];
             *         array[j - gap] = temp;
             *     }
             * }
             *
             */
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                for (j = i; j >= gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                    array[j - gap] = temp;
                }
            }
        }
        printArray(array);
    }

    /**
     * 堆排序
     * 堆排序的思路是基于以下几点考虑：
     * 1.根据给定数组构建一个大根堆的时间复杂度为O(2N)
     * 2.找出最大值的时间复杂度为O(1)
     * <p>
     * 所以在对一个数组进行排序的时候，可以先将该数组构建成为一个大根堆，然后找出其中的最大值和堆尾交换，
     * 并再对剩下的N-1个元素重新构建大根堆，直至结束，这样最后就会是最大的元素在末位
     * 堆排序的时间复杂度最坏为O(n log n),最好为O(n log n)，平均为O(n log n)
     */
    public void heapSort() {
        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15, 67, 39, 88, 48, 21, 96, 74, 50};
        for (int i = array.length / 2; i >= 0; i--) {
            //构造大根堆（最大值在根处，父节点>子节点）
            //从第i个非叶子节点处开始构造大根堆，所以i从array.length / 2处开始
            percDown(array, i, array.length);
        }
        printArray(array);

        for (int i = array.length - 1; i > 0; i--) {
            swapRefrence(array, 0, i);
            percDown(array, 0, i);
        }
        printArray(array);
    }

    private void swapRefrence(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    /**
     * 下滤操作进行构建i处的大根堆
     *
     * @param array  array
     * @param i      索引
     * @param length length
     */
    private void percDown(int[] array, int i, int length) {
        int child = 0;
        int temp = array[i]; //取出i处的元素后，依次与下一层的较大值进行比较

        for (; i * 2 + 1 < length; i = child) {
            child = i * 2 + 1; //下一层节点的所在处
            if (child != length - 1 && array[child] < array[child + 1]) {
                //判断左元素与右元素的大小，找出二者较大值的所在位置
                child++;
            }
            if (temp < array[child]) {   //如果temp的值是小于此元素，那么就说明找到了temp应该放入的位置，该位置就是i
                array[i] = array[child];
            } else {
                break;
            }
        }
        //把temp放入i处
        array[i] = temp;
    }

    /**
     * 归并排序
     * 采用分治算法
     * 基本思路如下：
     * 将一个数组从中间分开，分为左半部分和右半部分，分别对左右两部分进行递归排序
     * 将已经排好序的左右两部分整合在一起排序，这一步的排序时间为O(N)
     * 归并排序的时间复杂度最坏为O(n log n),最好为O(n log n)，平均为O(n log n)
     */
    public void mergeSort() {
        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15, 67, 39, 88, 48, 21, 96, 74, 50};
        int[] tempArray = new int[array.length];

        mergeSort(array, tempArray, 0, array.length - 1);

        printArray(array);
    }

    private void mergeSort(int[] array, int[] tempArray, int left, int right) {

        if (left < right) {
            int center = (left + right) / 2;
            //分治左边
            mergeSort(array, tempArray, left, center);
            //分治右边
            mergeSort(array, tempArray, center + 1, right);
            //将左右排好的数组整合
            merge(array, tempArray, left, center + 1, right);
        }
    }

    private void merge(int[] array, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] < array[rightPos]) {
                tempArray[tempPos++] = array[leftPos++];
            } else {
                tempArray[tempPos++] = array[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = array[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = array[rightPos++];
        }

        printArray(tempArray);

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }

    /**
     * 快速排序
     * 快排的方法同样是采用了分治的思想
     * 首先选出一个基准因子d（简单的话就直接取第一个值），设立两个指针i和j，i初始为0，j为数组末位
     * 从j开始向左移动，直至发现其值比 d小的为止，j停，i开始从左向右移动，直至发现其值比 d大的为止，
     * 若此时i<j,那么交换i和j的值，j继续移动，重复上一行步骤直到 i>=j时停止，交换基准因子 d 和i所在的位置
     * 至此第一轮结束，此时的数组分成了两部分，小于d的在左边，大于d的在右边，然后分别对左边和右边的数组进行递归处理
     * 快速排序的时间复杂度最坏为O(N^2),最好为O(n log n),平均为O(n log n)
     */
    public void quickSort() {
        int[] array = new int[]{23, 45, 12, 49, 35, 65, 15, 67, 39, 88, 48, 21, 96, 74, 50};
        quickSort(array, 0, array.length - 1);
        printArray(array);

    }

    private void quickSort(int[] array, int left, int right) {

        if (left > right) return;

        int divisor = array[left];
        int i = left;
        int j = right;
        for (; ; ) {
            while (array[j] >= divisor && j > i) {
                j--;
            }

            while (array[i] <= divisor && j > i) {
                i++;
            }

            if (i < j) {
                swapRefrence(array, i, j);
            } else {
                break;
            }
        }

        swapRefrence(array, left, i);

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    private int media(int[] array, int left, int right) {
        int center = (left + right) / 2;
        if (array[left] > array[center]) {
            swapRefrence(array, left, center);
        } else if (array[center] > array[right]) {
            swapRefrence(array, center, right);
        } else if (array[left] > array[right]) {
            swapRefrence(array, left, right);
        }

        swapRefrence(array, center, right - 1);
        return array[right - 1];
    }


    /**
     * 桶排序
     * 给定一个数组n，最大值不超过M
     * 新建桶数组，长度为M（M > n.length,否则，长度为n.length），下标为n的值，value为一个list，list将n依次添加
     */
    public void bucketSortInt() {
        int[] arr = new int[]{22, 4, 55, 6, 33, 7, 88, 9, 10, 27, 25, 16, 37, 8, 19};
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        List<Integer>[] buckets = new ArrayList[max + 1];

        for (int i = 0; i < arr.length; i++) {
            if (buckets[arr[i]] == null) {
                buckets[arr[i]] = new ArrayList<>();
            }
            buckets[arr[i]].add(arr[i]);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                for (Integer integer : bucket) {
                    arr[idx++] = integer;
                }
            }
        }

        printArray(arr);

    }

    /**
     * 基数排序
     * 基数排序的应用场景大多用在长度相同的字符串比较上
     * 大致逻辑如下：
     * 从低位开始依次进行桶排序，直至结束，那么拿到的桶数据就是有序的
     */
    public void radixSortString() {
        String[] arr =
                new String[]{"hello", "world", "happy", "lucky", "trees",
                        "learn", "study", "japan", "china", "today",
                        "lover", "heart", "month", "beach", "windy"};
        int length = 5;

        final int BUCKET = 256;
        List<String>[] buckets = new ArrayList[BUCKET];
        for (int i = 0; i < BUCKET; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = length - 1; i >= 0; i--) {
            for (String s : arr) {
                //从低位开始进行排序
                buckets[s.charAt(i)].add(s);
            }
            /* buckets数组在第i位上已经是有序的了*/

            int idx = 0;
            for (List<String> bucket : buckets) {
                for (String s : bucket) {
                    System.out.println("s = " + s);
                    //将有序的buckets元素挨个替换到arr数组中
                    arr[idx++] = s;
                }
                bucket.clear();
            }
        }

        printStringArray(arr);

    }

    /**
     * 基数排序
     */
    public void radixSortInt() {

        int[] arr = new int[]{22, 4, 55, 6, 33, 7, 88, 9, 10, 27, 25, 16, 37, 8, 19};
        List<Integer>[] buckets = new ArrayList[10];

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        String s = String.valueOf(max);

        for (int i = 0; i < s.length(); i++) {

            for (int a : arr) {
                int b = (int) (a / Math.pow(10, i));
                int mod = b % 10;
                if (buckets[mod] == null) {
                    buckets[mod] = new ArrayList<>();
                }
                List<Integer> bucket = buckets[mod];
                bucket.add(a);
            }

            int idx = 0;
            for (List<Integer> bucket : buckets) {
                if (bucket != null) {
                    for (Integer integer : bucket) {
                        arr[idx++] = integer;
                    }
                    bucket.clear();
                }
            }
        }

        printArray(arr);

    }

    /**
     * 计数基数排序
     * 相对于普通的基数排序而言，减少了额外的ArrayList的空间复杂度
     * 实现步骤如下
     */
    public void countRadixSortString() {
        String[] arr =
                new String[]{"hello", "world", "happy", "lucky", "trees",
                        "learn", "study", "japan", "china", "today",
                        "lover", "heart", "month", "beach", "windy"};

        final int BUCKET = 256;
        int N = arr.length;
        String[] buffer = new String[N];

        String[] in = arr;
        String[] out = buffer;

        int stringLen = 5;

        for (int i = stringLen - 1; i >= 0; i--) {
            //从低位开始遍历每一个字符
            //计数器数组
            int[] count = new int[BUCKET + 1];

            a:
            for (int j = 0; j < N; j++) {
                //N是数组个数
                //该字符的ASCII码 + 1，作为count数组的指针，count数量++
                count[in[j].charAt(i) + 1]++;
            }
            //通过a循环后，count数组已经统计到字符在每个指针处的个数了

            for (int k = 1; k <= BUCKET; k++) {
                //进行累加操作，目的是对这些字符位置进行排序
                /* 比如假设一共有8个数据， 上面的count数组为{0,1,2,0,1,0,2,2,0}（省略了无意义的0处）意为：
                 * 在指针0处有1个数据；指针1处有2个数据；指针3处没有数据；
                 * 那么仅仅这样是无法知道字符应该放在哪个位置的
                 * 但经过累加之后会变成{0,1,3,3,4,4,6,8,8}，里面的数据表明了这个字符应该放在哪个位置
                 * */
                count[k] += count[k - 1];
            }

            printStringArray(in);

            for (int n = 0; n < N; n++) {
                //此处的++,很有必要，因为有可能会有相同的字符，相同的字符会按照录入顺序排在后面一位
                int countN = count[in[n].charAt(i)]++;
//                System.out.println("n = " + in[n] + ", countN = " + countN);
                out[countN] = in[n];
            }

            printStringArray(out);

            String[] temp = in;
            in = out;
            out = temp;
        }

        if (stringLen % 2 == 1) {
            out = in;
        }
        printStringArray(out);

    }

    /**
     * 可变长度的字符串基数排序
     * 是基数排序的变种
     * 首先，按照字符串长度分别装入桶中，然后回填到arr数组里，这样arr就是一个按照字符串长度的顺序排列的数组了
     * 其次，从最长的字符串末位开始排序，startIndex就是用于控制字符串末位的
     * 最后将排好序的buckets回填到arr里
     */
    public void radixSort() {
        String[] arr =
                new String[]{"hello", "window", "happy", "lucky", "tree",
                        "learn", "student", "japanese", "china", "yesterday",
                        "love", "heart", "monday", "beach", "windy"};
        final int BUCKET = 256;
        int maxLen = 9;
        //字符串长度的桶
        List<String>[] wordsLength = new ArrayList[maxLen + 1];
        //字符串排序用的桶
        List<String>[] buckets = new ArrayList[BUCKET];

        for (int i = 0; i < wordsLength.length; i++) {
            wordsLength[i] = new ArrayList<>();
        }

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        //按照长度分别装桶
        for (String s : arr) {
            wordsLength[s.length()].add(s);
        }
        //回填给arr数组里，这样arr数组就是一个按照字符串长度顺序排列的数组
        int idx = 0;
        for (List<String> strings : wordsLength) {
            for (String string : strings) {
                arr[idx++] = string;
            }
        }

        for (int i = 0; i < wordsLength.length; i++) {
            List<String> strings = wordsLength[i];
            System.out.println(i + " : " + strings);
        }

        printStringArray(arr);

        //令 startIndex 初始为该数组长度
        int startIndex = arr.length;

        //从最长字符串的末位开始进行一次遍历排序
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            //wordsLength[pos + 1].size()  该位置处一共有几个字符存在
            /*startIndex -= wordsLength[pos + 1].size();  本次遍历需要对arr数组的哪几位进行排序
            * 分析：
            *   从pos+1可以看出来，是从最长字符的末位开始排序的，而startIndex为数组长度，按照本示例
            *   startIndex初始应为15，最长字符仅有1个，所以wordsLength[pos + 1].size() = 1；
            *   那么startIndex -= wordsLength[pos + 1].size()后，startIndex就为14，再结合下面的
            *   for循环，循环的起始为startIndex，结束为arr.length，所以只需循环一次即可；
            *   接下来接着分析：
            *       此时pos = maxLen-2，根据本示例 startIndex -= wordsLength[pos + 1].size()后
            *       startIndex为13，那么for循环需要进行两次，需要对japanese的e 和 yesterday的a进行
            *       排序；
            *       继续分析：
            *           此时pos = maxLen-3;根据本示例 startIndex -= wordsLength[pos + 1].size()
            *           后startIndex为12，那么for循环需要进行三次，需要对student的t，japanese的s以
            *           及yesterday的d进行排序
            * 根据上面的分析可以看到，startIndex作为一个起始控制点，是很容易就实现了排序的逻辑
            */
            startIndex -= wordsLength[pos + 1].size();
            for (int i = startIndex; i < arr.length; i++) {
                System.out.println("startIndex = " + startIndex + ", pos = " + pos + ", arr[i] = " + arr[i] + ", arr[i].charAt(pos) = " + arr[i].charAt(pos));
                buckets[arr[i].charAt(pos)].add(arr[i]);
            }

            idx = startIndex;

            for (List<String> bucket : buckets) {
                for (String s : bucket) {
                    arr[idx++] = s;
                }

                bucket.clear();
            }
            printStringArray(arr);
        }

        printStringArray(arr);

    }

    private void printArray(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        System.out.println("array = [" + sb.toString() + "]");
    }

    private void printStringArray(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        System.out.println("array = [" + sb.toString() + "]");
    }
}
