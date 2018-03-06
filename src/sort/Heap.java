package sort;

import java.util.Arrays;

public class Heap {

    public static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) sink(a, i, a.length-1);

        int n = a.length - 1;
        while (n > 0) {
            swap(a, 0, n--);
            sink(a, 0, n);
        }
    }

    private static void sink(int[] a, int i, int n) {
        while (2 * i + 1 <= n) {
            int j = 2 * i + 1;
            if (j + 1 <= n && a[j] < a[j + 1]) j++;
            if (a[i] < a[j]) {
                swap(a, i, j);
                i = j;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{2,3,1,4,6,8,3};
        int[] a = new int[]{0,1,2,3};

        sort(a);
        for (int e : a) {
            System.out.println(e);
        }
    }

    public static void main2(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort2(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    /*public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }*/

}
