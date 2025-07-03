package 算法模板;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        FenwickTree ft = new FenwickTree(nums);
        System.out.println(ft.rangeSum(1, 2));
        ft.update(1, 20);
        System.out.println(ft.rangeSum(1, 2));
        System.out.println(ft.rangeSum(1, 5));

    }
}
