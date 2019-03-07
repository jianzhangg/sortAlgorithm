/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * 复杂度为O(n^2) 精确为n+(n-1)+(n-2).....+1
 * selectSort2比selectSort1和bubbleSort节省了交换数组的次数,因为它先找到最小index再确定交换
 */
public class SelectSort {

    private static void selectSort1(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length-1; i++) {
            System.out.println(i);
            // 犹豫j默认值为i+1,当i为倒数第三个,为了保证正常运行.所以j<length
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void selectSort2(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
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
        int[] arr = {1, 3, 4, 6, 12, 534, 65, 75, 7, 68, 6, 98, 9, 7, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
        SelectSort.selectSort1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
