package com.greatlearning.floorspaceproject;

import java.util.*;

public class FloorSpace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total No.floors in the building");
		int floors = sc.nextInt();

		PriorityQueue<Integer> queue = new PriorityQueue<>(java.util.Collections.reverseOrder());
		int floorSize[] = new int[floors];
		for (int i = 0; i < floors; i++) {
			System.out.println("Enter the floor size given on day :  " + (i + 1));
			floorSize[i] = sc.nextInt();
		}
		
		int maxFloors = floors;
		System.out.println("The order of construction is as follows");

		for (int i = 0; i < floors; i++) {		
			String buffer = " ";
			queue.add(floorSize[i]);
			while (!queue.isEmpty() && queue.peek() == maxFloors) {
				buffer += queue.remove() + " ";
				maxFloors--;
			}
			System.out.println("Day : " + (i + 1));
			System.out.println(buffer);
		}
	}
}
