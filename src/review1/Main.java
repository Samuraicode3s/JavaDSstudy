package review1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// System.out.println(); COPY
		/*
		 * printNumbers(5); System.out.psrintln(); printEven(10); System.out.println();
		 * printOdd(9); System.out.println(); System.out.println(sumUpTo(25));
		 * System.out.println(); System.out.println(factorial(5));
		 */
		int[] nums = { 2, 4, 6, 4, 8, 4, 10 };
		for (int num : nums) {
			System.out.println(num);
		}
		System.out.println();
		System.out.print("Sum of numbers in array: " + sumArray(nums));

		System.out.println();

		System.out.println("Reverse: " + Arrays.toString(reverseArray(nums)));
		System.out.println("Max number: " + findMax(nums));
		System.out.println("Does nums contain number 0? " + containsValue(nums, 0));
		System.out.println("Does nums contain number 8? " + containsValue(nums, 8));
		System.out.println("4 shows up this many times: " + countOccurences(nums, 4));
		System.out.println();
		System.out.println("Recursive method returns: " + sumOfAll(4));
		System.out.println();
		System.out.print("Reversing a string: " + recursiveReverseString("palindrome"));
		System.out.println(); 
		System.out.println("Is this number a palindrome? " + isPalindrome("121"));

	}

	public static void printNumbers(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}

	public static void printEven(int n) {
		for (int i = 2; i <= n; i += 2) {
			System.out.println(i);
		}
	}

	public static void printOdd(int n) {
		for (int i = 1; i <= n; i += 2) {
			System.out.println(i);
		}
	}

	// Write sumUpTo(int n) — returns the sum of all numbers from 1 to n.
	// Print the result from main.
	public static int sumUpTo(int n) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			num += i;
		}
		return num;
	}

	// n! = n * (n - 1)!
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial((n - 1));
		}
	}

//write a method sumArray(int[] arr) that takes an array and returns the sum of all its elements. 
//Call it from main and print the result.

	public static int sumArray(int[] arr) {
		// create sum variable, loop, add, return
		int sum = 0;
		for (int number : arr) {
			sum += number;
		}
		return sum;
	}

	// Write a method that takes an int array and returns a
	// new array with the elements in reverse order.
	public static int[] reverseArray(int[] arr) {

		int[] rev = new int[arr.length];
		int j = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			rev[j] = arr[i];
			j--;
		}

		return rev;
		/*
		 * You create a new empty array rev of the same size i starts at 0 (left side of
		 * arr) and goes up j starts at arr.length - 1 (right side of rev) and goes down
		 * Each iteration: copy arr[i] into rev[j], then move both pointers Return rev —
		 * arr is never modified
		 */
	}

	public static int findMax(int[] arr) {
		// hold max, loop, replace, return max in the end
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static boolean containsValue(int[] arr, int target) {
		// loop through, if stat to see if target in arr, then return
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				return true;
			}
		}
		return false;
	}

	public static int countOccurences(int[] arr, int target) {
		// set counter to 0, loop through, each hit adds +1, return counter
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				total++;
			}
		}
		return total;
	}

	public static int sumOfAll(int n) {
		// base case, rec case, Make sure base case is less than or equal so no
		// StackOverflowError
		// This recursive method will return the sum of all ints from 1 to n
		if (n <= 0) {
			return 0;
		} else {
			return n + sumOfAll(n - 1);
		}
	}

	public static String recursiveReverseString(String word) {
		// Base case: nothing left to reverse, stop and return empty string
		if (word.length() == 0) {
			return "";
		} else {
			// Recursive case: take last char + reverse the rest
			return word.charAt(word.length() - 1) + recursiveReverseString(word.substring(0, word.length() - 1));
		}

	}

	public static boolean isPalindrome(String s) {
		// convert int to string, then base case, then rec case
		// base case, what to do when nothing left
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}
}
