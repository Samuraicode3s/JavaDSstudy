package gradetracker;

public class Student {

	private String name;
	private int[] grades;

	public Student(String name, int[] grades) {
		this.name = name;
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
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

	public String getLetterGrade() {
		// get average first, then go through if else to see where it ends up
		int avg = getAverage();
		if (avg >= 90 && avg <= 100) {
			return "A";
		}
		if (avg >= 80 && avg <= 89) {
			return "B";
		}
		if (avg >= 70 && avg <= 79) {
			return "C";
		}
		if (avg >= 60 && avg <= 69) {
			return "D";
		} else {
			return "F";
		}
	}

	public void printInfo() {
		System.out.println("Student name: " + name);
		System.out.println("The average grade is: " + getAverage());
		System.out.println("The max grade is: " + getMax());
		System.out.println("The min grade is: " + getMin());
		System.out.println("The letter grade is: " + getLetterGrade());
	}
	
	public void generateReport() {
		System.out.print("Report for " + name + ":\n");
		System.out.println("------------------------");
		printInfo();
		System.out.println("This interface has been implemented.");
	}
	

}
