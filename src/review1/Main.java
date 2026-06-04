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
		int[] nums = { 1, 2, 32, 4, 6, 26, 8, 9, 10, 15, 47 };
		int[] small = { 1, 2, 3, 4, 5 };
		int[] duplicates = { 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 6 };

		for (int num : nums) {
			System.out.print(num + " ");
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
		System.out.println();
		System.out.println("Fibonacci sequence: " + fibonacci(12));
		System.out.println();
		System.out.println("sum of the number of digits: " + sumDigits(123));
		System.out.println();

		System.out.println("Even numbers filtered: " + Arrays.toString(filterEvens(nums)));
		System.out.println();
		System.out.println("Second largest number: " + secondLargest(nums));
		System.out.println();
		System.out.println("The list was shifted left by one: " + Arrays.toString(shiftLeftOne(small)));
		System.out.println();
		System.out.println("The sum of 2 numbers in an array: " + twoSum(small, 6));
		System.out.println();
		System.out.println("Duplicates removed from sorted list " + Arrays.toString(removeDuplicates(duplicates)));

	}

	// Prints all integers from 1 to n
	public static void printNumbers(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}

	// Prints all even numbers from 2 to n, stepping by 2
	public static void printEven(int n) {
		for (int i = 2; i <= n; i += 2) {
			System.out.println(i);
		}
	}

	// Prints all odd numbers from 1 to n, stepping by 2
	public static void printOdd(int n) {
		for (int i = 1; i <= n; i += 2) {
			System.out.println(i);
		}
	}

	// Returns the sum of all numbers from 1 to n using a loop
	public static int sumUpTo(int n) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			num += i;
		}
		return num;
	}

	// Recursively computes n! (n factorial)
	// Base case: 0! = 1 (nothing left to multiply)
	// Recursive case: n * (n-1)!
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial((n - 1));
		}
	}

	// Takes an array and returns the sum of all its elements
	public static int sumArray(int[] arr) {
		int sum = 0;
		for (int number : arr) {
			sum += number;
		}
		return sum;
	}

	// Returns a new array with elements in reverse order
	// i starts at left of arr, j starts at right of rev
	// Each iteration: copy arr[i] into rev[j], move both pointers inward
	public static int[] reverseArray(int[] arr) {
		int[] rev = new int[arr.length];
		int j = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			rev[j] = arr[i];
			j--;
		}
		return rev;
	}

	// Returns the largest value in the array
	// Holds a max variable, replaces it whenever a larger value is found
	// Start with the first element of the array. That way it works for any array —
	// negatives, all the same number, anything. Then your loop starts at i = 1
	// since you already "checked" index 0.
	public static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// Returns true if target exists in the array, false otherwise
	public static boolean containsValue(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				return true;
			}
		}
		return false;
	}

	// Returns how many times target appears in the array
	public static int countOccurences(int[] arr, int target) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				total++;
			}
		}
		return total;
	}

	// Recursively returns the sum of all integers from 1 to n
	// Base case: nothing left to add (n <= 0), return 0
	// Recursive case: add n to the sum of everything below it
	public static int sumOfAll(int n) {
		if (n <= 0) {
			return 0;
		} else {
			return n + sumOfAll(n - 1);
		}
	}

	// Recursively reverses a string
	// Base case: empty string, nothing left to reverse, return ""
	// Recursive case: take last char + reverse everything before it
	public static String recursiveReverseString(String word) {
		if (word.length() == 0) {
			return "";
		} else {
			return word.charAt(word.length() - 1) + recursiveReverseString(word.substring(0, word.length() - 1));
		}
	}

	// Recursively checks if a string is a palindrome (reads same forwards and
	// backwards)
	// Base case: 0 or 1 characters left, always a palindrome, return true
	// Recursive case: if first and last chars match, check the middle
	// If they don't match, return false immediately
	public static boolean isPalindrome(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

	// Recursively returns the nth Fibonacci number
	// Sequence: 0, 1, 1, 2, 3, 5, 8, 13...
	// Base case 1: n == 0, return 0
	// Base case 2: n == 1 or 2, return 1
	// Recursive case: sum of the two previous Fibonacci numbers
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// Recursively returns the sum of all digits in n
	// Base case: n == 0, nothing left, return 0
	// Recursive case: last digit (n % 10) + sum of remaining digits (n / 10)
	public static int sumDigits(int n) {
		if (n == 0) {
			return 0;
		} else {
			return n % 10 + sumDigits(n / 10);
		}
	}

	public static int[] filterEvens(int[] arr) {
		// counter for evens, loop through, find evens, add evens to array that is the
		// size of the number of evens
		int even = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++; // found 3 evens, now size is 3
			}

		}
		int[] evenList = new int[even];
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] % 2 == 0) {
				evenList[index] = arr[j];
				index++;
			}
		}
		return evenList;
	}

	// { 1 2 3 4 5}
	public static int secondLargest(int[] arr) {
		// create largest and second largest int
		// loop, and ifs to compare
		int max = 0;
		int second = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				second = max;
				max = arr[i];
			}
			if (arr[i] < max && arr[i] > second) {
				second = arr[i];
			}
		}
		return second;
	}

	public static int[] shiftLeftOne(int[] arr) {
		int first = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = first;
		return arr;
	}

	/*
	 * public static boolean twoSum(int[] arr, int target){} loop through first. You
	 * cant really go wrong with this step. So to have a loop check for 2 numbers,
	 * NOT RIGHT NEXT TO EACH OTHER, but compare one number witht he rest, and do
	 * that with every number is the goal when looping, if index at position i +
	 * index at position j is equal to target, return true This means need i to loop
	 * through whole thing, and j will be added to every number. this means arr[0] +
	 * arr[0], then arr[0] + arr[1], and so on, with a if loop checking
	 */

	public static boolean twoSum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					return true;
				}

			}
		}
		return false;
	}
// you can do i + 1, but you need to stop the loop one early: i < arr.length - 1.

	public static int[] removeDuplicates(int[] arr) {
		int numDuplicates = 0;
		int index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				numDuplicates++;
			}
		}
		int[] cleanedList = new int[arr.length - numDuplicates];
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j] == arr[j + 1]) {
				cleanedList[index] = arr[j];
				index++;
			}
			return cleanedList;
		}
	}

// DO NOT DELETE
}
