/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 * 复杂度为O(n^2) 精确为
 */
public class InsertSort {

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 从第二位开始  假设第一位是正确的
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];
            // 从第二个开始 target卡在arr[j-1]前面  直到arr[j-1]>target
            while (j > 0 && target < arr[j - 1]) {
                // 预留出放target的位置  把数组往后挪
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 54, 6, 12, 534, 65, 75, 17, 68, 6, 98, 9, 74, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
        InsertSort.insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
