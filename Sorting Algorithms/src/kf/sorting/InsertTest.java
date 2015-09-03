package kf.sorting;

import java.util.Random;

public class InsertTest {

	public static void main(String[] args) {
		Insert insert = new Insert();
		int [] x = new int[10];
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			x[i] = r.nextInt(10);
		}
		insert.insertionsort(x, 0, x.length);
	}
}
