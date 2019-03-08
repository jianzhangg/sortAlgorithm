/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * 复杂度为O(nlogn)  递归分治会有logn层,每次都有n次遍历
 */
public class QuickSort {


    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) return;
        if (left >= right) return;
        // 把第一个元素设为基数后,pivotPos为该元素现在在数组中的index
        int pivotPos = partition(arr, left, right);
        // 分别再排序基数左边和右边的元素
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 默认左边的是基数  保存基数的值
        int pivotKey = arr[left];
        // 先从右边便利,因为基数在左边
        while (left < right) {
            while (left < right && arr[right] >= pivotKey) {
                right--;
            }
            //如果arr[right]<pivotKey 说明arr[right]小于基数 就把他挪到最终基数index的左边,这时候基数index还没算出来,但可以确定在基数左边
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotKey) {
                left++;
            }
            // 同理 挪到基数右边
            arr[right] = arr[left];
        }
        // 如果left=right,也就是两指针相遇,可以确定基数的index=left=right,不存在left>right的情况
        arr[left] = pivotKey;
        return left;
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
        int[] arr = {21, 3, 4, 6, 12, 534, 65, 75, 7, 68, 6, 98, 9, 7, 555, 32, 43, 324, 1, 49, 876, 54324786, 5, 7, 654};
        // 假设第一个数为基数开始排序
        QuickSort.quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
