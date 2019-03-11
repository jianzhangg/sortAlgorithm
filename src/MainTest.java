import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: 张健
 * @CreateDate: 2019-03-10 10:27
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        TreeNode tn0 = new TreeNode(1);
        TreeNode tn1 = new TreeNode(2);
        TreeNode tn2 = new TreeNode(3);
        TreeNode tn3 = new TreeNode(4);
        TreeNode tn4 = new TreeNode(5);
        TreeNode tn5 = new TreeNode(6);
        tn0.left=tn1;
        tn0.right=tn2;
        tn1.left=tn3;
        tn1.right=tn4;
        tn2.left=tn5;

        ArrayList<TreeNode> treeNodes = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            treeNodes.add(tn0);
        }
        List<TreeNode> treeNodes1 = printFromTopToBottom(1, 3, treeNodes);
        System.out.println(treeNodes1);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] sort(List<TreeNode> nodes) {
        // 如果大小只有三个及以下  直接返回
        if (nodes.size() <= 3) {
            return new int[]{nodes.get(0).val, nodes.get(0).left.val, nodes.get(0).right.val};
        }

        //  获取树的层级
        int ceil = (int) Math.ceil(Math.log(nodes.size()) / Math.log(2));

        // 定义一个可以包容所有node的数组,并赋值第一个
        int[] ints = new int[2 * nodes.size() + 1];
        ints[0] = nodes.get(0).val;


        // 循环层数
        for (int i = 0; i < ceil; i++) {
            // 定义一个可以容纳当前层级的节点个数的数组
            int[] ints1 = new int[2 ^ i];
            for (int j = (2 ^ (i - 1)); j < (2 ^ (i - 1)) + (2 ^ i); j++) {
//                ints[]
            }
        }
        return ints;
    }

    /**
     * i总为0 j为最大层级 sorted为首次加入root的节点List
     */
    private static List<TreeNode> printFromTopToBottom(int i, int j, List<TreeNode> sorted) {
        // 如果sorted为空  不执行
        if (sorted == null || sorted.size() == 0) return null;
        // 如果执行完了最大层级
        if (j < 0) return sorted;
        j--;
        for (int k = (2 ^ (i - 1)) - 1; k < (2 ^ (i - 1)) + (2 ^ i) - 1; k++) {
            sorted.set(k * 2 + 1, sorted.get(k).left);
            sorted.set(k * 2 + 2, sorted.get(k).right);
        }
        return printFromTopToBottom(i, j, sorted);
    }


    public class T {

        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> list = new ArrayList();
            if (root == null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            while (!queue.isEmpty()) {
                /**出队列*/
                TreeNode tn = queue.poll();
                if (tn.left != null) {
                    queue.offer(tn.left);
                }
                if (tn.right != null) {
                    queue.offer(tn.right);
                }
                list.add(tn.val);
            }
            return list;
        }
    }
}
