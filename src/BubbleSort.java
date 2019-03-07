/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 */
public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 每次for循环都会排出来一个最小值在前面,所以第二次for循环从后往前排,并且j>i
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    /**
     *  交换数组中i和j的位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 12, 534, 65, 75, 7, 68, 6, 98, 9, 7, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
        BubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
