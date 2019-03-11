/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * 复杂度为O(n^2) 精确为n+(n-1)+(n-2).....+1
 */
public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 每次for循环都会排出来一个最小值在前面,所以第二次for循环从后往前排,并且j>i,减少不必要重复
        for (int i = 0; i < arr.length - 1; i++) {
            // 这里为什么可以用length-1,因为j默认值等于length-1,所以他恰好可以循环到倒数第二和倒数第三个
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
        int[] arr = {11, 3, 4, 6, 12, 534, 65, 75, 7, 68, 6, 98, 9, 7, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
        BubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
