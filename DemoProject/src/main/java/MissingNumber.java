
public class MissingNumber {

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 4, 5, 7, 9 };
		int temp = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] == temp + 1) {
				temp = a[i];
			} else {
				temp = temp + 1;
				System.out.println("Missing:" + temp);
				temp = temp + 1;
				
			}
		}

	}

}
