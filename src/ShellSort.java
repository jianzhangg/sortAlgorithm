/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 * 为什么希尔排序有可能更快?因为插入排序在数组正序时只用O(n)复杂度.
 * 为什么是O(n)?其实不一定,根据具体情况来的.最好的情况是O(n) 这种情况即每次把数组内元素重新放到一个新数组,新数组是有序的,所以每次比较新数组的最值,只用比较一次,一个比较n次
 * 希尔排序的时间复杂度跟增量有关.假如一开始增量为g,每次都增量都减半,则需要n/g+n/(g/2)+n/(g/4)+.....n/1,所以...看起来复杂度是个有意思的数学问题?
 */
public class ShellSort {

    private static void shellSort1(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 设置增量，默认为length/2 增量对时间复杂度有影响,这种增量的时间复杂度为O(n^2) 具体原因我也不知道....有时间查查 感觉涉及到的数学有点深...
        // 果然在Wikipedia找到了相关资料....  https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                // 每次跨越增量用插入排序,比如增量是3,每次都和当前位的后三位比较,直到增量为1,增量为1的时候,就是对整个数组做选择排序.
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
