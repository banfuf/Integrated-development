package NASA;

public class BubbleSort1 {
	public static void main(String[] args) {
		int[] array = { 63, 4, 24, 1, 3, 15 };
		BubbleSort sorter = new BubbleSort();
		sorter.sort(array);
	}

	/**
	 * 冒泡排序
	 * 
	 * @param array 要排序的数组
	 */
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
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
