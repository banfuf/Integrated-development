package Number;

/**
 * 反转算法排序实例
 * 
 * @author LiZhongWei
 */
public class ReverseSort {
	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 60 };
		ReverseSort sorter = new ReverseSort();
		sorter.sort(array);
	}

	/**
	 * 直接选择排序法
	 * 
	 * @param array 要排序的数组
	 */
	public void sort(int[] array) {
		System.out.println("数组原有的内容: ");
		showArray(array);
		int temp;
		int len = array.length;
		for (int i = 0; i < len / 2; i++) {
			temp = array[i];
			array[i] = array[len - 1 - i];
			array[len - 1 - i] = temp;
		}
		System.out.println("数组反转后内容: ");
		showArray(array);
	}

	/**
	 * 显示数组中的所有元素
	 * 
	 * @param array 要显示的数组
	 */
	public void showArray(int[] array) {
		for (int i : array) {
			System.out.print("\t" + i);
		}
		System.out.println();
	}
}
