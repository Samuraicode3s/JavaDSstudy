package gradetracker;

public class Student {

	private String name;
	private int[] grades;

	public Student(String name, int[] grades) {
		this.name = name;
		this.grades = grades;
	}

	public int getAverage() {
		// loop through, add all numbers, then divide by amount of numbers
		int sum = 0;
		int numbers = grades.length;
		int total = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		total = sum / numbers;
		return total;
	}
	
	public int getMax() {
		// counter, loop, replace with biggest, return
		int max = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;
	}
	
	
	public int getMin() {
		// counter, loop, replace with smallest, return
		int min = 100000000;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;
	}
	
	
	
	

	public void printInfo() {
		System.out.println("Student name: " + name);
		System.out.println("The average grade is: " + getAverage());
		System.out.println("The max grade is: " + getMax());
		System.out.println("The min grade is: " + getMin());
	}

}
