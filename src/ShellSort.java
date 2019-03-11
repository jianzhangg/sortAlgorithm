/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort {

    private static void shellSort1(int[] arr) {
//        if (arr == null || arr.length == 0) return;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
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
        int[] arr = {11, 33, 4, 6, 12, 534, 65, 75, 7, 68, 6, 98, 9, 7, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
//        ShellSort.sort(arr);
        ShellSort.shellSort1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
