/**
 * @Author: 张健
 * @CreateDate: 2019-03-07 10:20
 * @Version: 1.0
 * http://www.codeceo.com/article/10-sort-algorithm-interview.html#0-tsina-1-10490-397232819ff9a47a7b7e80a40613cfe1
 */
public class MergeSort {
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 31, 42, 65, 132, 534, 65, 75, 17, 68, 6, 98, 9, 7, 55, 32, 4, 324, 49, 876, 54324786, 5, 7, 654};
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
