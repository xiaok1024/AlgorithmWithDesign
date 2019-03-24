package 排序算法2;

import java.util.Arrays;

import 排序算法.MergeSort;

public class 插入排序_希尔排序 {
	
	public static void main(String[] args) {

		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	/*基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
	 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2
	 */

	public static void sort(int[] a) {
			//时间复杂度:平均nlog2n 最好n 最差 n2 空间复杂度: 1 不稳定
	    int d = a.length;
		for(;;) {
				d=d>>1;//步长
				//每次遍历都是步长的次数
				for(int x=0;x<d;x++) {
					//按步长进行插入排序
					for(int i=x+d;i<a.length;i+=d) {
						int temp =a[i];
						int j;
						
						for(j=i-d;j>=0&&temp<a[j];j -=d) {
							a[j+d] =a[j];
						}
						a[j+d] =temp;
					}
				}
				//结束条件
				if(d==1) {
					break;
				}
		}
	}
}
