/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1 此文章中i*=2有误,应为i=i*2+1
 * 复杂度为O(nlogn) 细分应该是第一次调整无序为大顶堆length/2-1次adjustHeap+length-1次adjustHeap,每次adjustHeap次数不固定,最多logn次
 * 叶子节点概念  https://blog.csdn.net/heyuchang666/article/details/50531944
 * 堆的具体实现  https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 为什么一开始这样排不好? 因为这种排序需要子树(最底层的上一层)已经排好序了  因为在j = j * 2 + 1 这里限制了最后一层达不到 比如第三层填满需要8个 而实际只有5个
//        adjustHeap(arr, 0, arr.length);


        // 调整无序数列为大顶堆 length/2-1为最后一个非叶子节点,--可以依次操作所有的根
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 每次把最值放在最后面  然后继续排序length-1  这里为什么循环length-1次  因为每次循环都会在adjustHeap中找到一个堆顶最值
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 比较从i开始,所有独立子树和节点的大小
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        // arr[i]为根的值,为了保证调整时不丢失
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if ( j + 1 < length && arr[j] < arr[j + 1]) {  // 如果实现小顶堆倒序排,>即可
                // 如果右节点的值更大,调整到右边的值
                j++;
            }
            if (arr[j] > temp) {// 如果实现小顶堆倒序排,<即可
                // 如果子节点大于根,交换位置
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }

        }
        arr[i] = temp;
    }


    /**
     * 交换数组中i和j的位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {11, 4, 9, 6};
        HeapSort.heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
