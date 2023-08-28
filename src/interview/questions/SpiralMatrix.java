package interview.questions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix {

	public static void main(String args[]) {
		
		List<List<Integer>> nums2x2 = new ArrayList<>();
		nums2x2.add(Arrays.asList(1, 2));
		nums2x2.add(Arrays.asList(3, 4));
		
		List<List<Integer>> nums3x3 = new ArrayList<>();
		nums3x3.add(Arrays.asList(1, 2, 3));
		nums3x3.add(Arrays.asList(4, 5, 6));
		nums3x3.add(Arrays.asList(7, 8, 9));
		
		List<List<Integer>> nums4x4 = new ArrayList<>();
		nums4x4.add(Arrays.asList(1, 2, 3, 4));
		nums4x4.add(Arrays.asList(5, 6, 7, 8));
		nums4x4.add(Arrays.asList(9, 10, 11, 12));
		nums4x4.add(Arrays.asList(13, 14, 15, 16));
		
		List<List<Integer>> nums5x5 = new ArrayList<>();
		nums5x5.add(Arrays.asList(1, 2, 3, 4, 5));
		nums5x5.add(Arrays.asList(6, 7, 8, 9, 10));
		nums5x5.add(Arrays.asList(11, 12, 13, 14, 15));
		nums5x5.add(Arrays.asList(16, 17, 18, 19, 20));
		nums5x5.add(Arrays.asList(21, 22, 23, 24, 25));
		
		printSpiralMatrix(nums2x2);
		printSpiralMatrix(nums3x3);
		printSpiralMatrix(nums4x4);
		printSpiralMatrix(nums5x5);
	}
	
	private static void printSpiralMatrix(List<List<Integer>> nums) {
		int n = nums.size();
		if(n == 0) {return;}
		int m = nums.get(0).size();
		
		List<List<Integer>> dirs = new ArrayList<>();
		dirs.add(Arrays.asList(0, 1));
		dirs.add(Arrays.asList(1, 0));
		dirs.add(Arrays.asList(0, -1));
		dirs.add(Arrays.asList(-1, 0));
		
		int dirIndex = 0;
		int dirX = 0;
		int dirY = 1;
		
		int maxLeft = 0;
		int maxRight = m-1;
		int maxTop = 1;
		int maxBottom = n-1;
		
		int curX = 0;
		int curY = 0;
		
		System.out.print(nums.get(curX).get(curY));
		
		while(maxLeft <= maxRight || maxTop <= maxBottom) {
			dirX = dirs.get(dirIndex).get(0);
			dirY = dirs.get(dirIndex).get(1);
			curX += dirX;
			curY += dirY;
			
			System.out.print("->" + nums.get(curX).get(curY));
			
			if(curY == maxRight && dirIndex == 0) {
				dirIndex = (dirIndex+1)%4;
				maxRight--;
			}
			else if(curX == maxBottom && dirIndex == 1) {
				dirIndex = (dirIndex+1)%4;
				maxBottom--;
			}
			else if(curY == maxLeft && dirIndex == 2) {
				dirIndex = (dirIndex+1)%4;
				maxLeft++;
			}
			else if(curX == maxTop && dirIndex == 3) {
				dirIndex = (dirIndex+1)%4;
				maxTop++;
			}
		}
		
		System.out.print("\n");
	}
}
