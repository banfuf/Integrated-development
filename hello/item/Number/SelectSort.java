package Number;

/**
 * 直接选择排序算法实例
 * 
 * @author LiZhongWei
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] array = { 63, 4, 24, 1, 3, 15 };
		SelectSort sorter = new SelectSort();
		sorter.sort(array);
	}

	/**
	 * 直接选择排序法 (
	 * 
	 * @param array 要排序的数组
	 */
	public void sort(int[] array) {
		int index;
		for (int i = 1; i < array.length; i++) {
			index = 0;
			for (int j = 0; j <= array.length - i; j++) {
				if (array[j] > array[index]) {
					index = j;
				}
			}
			int temp = array[array.length - i];
			array[array.length - i] = array[index];
			array[index] = temp;
		}
		showArray(array);
	}

	/**
	 * 显示数组中的所有元素
	 * 
	 * @param array 要显示的数组
	 */
	public void showArray(int[] array) {
		for (int i : array) {
			System.out.print(" >" + i);
		}
		System.out.println();
	}
}
