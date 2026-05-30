package gradetracker;

public class Main {

	public static void main(String[] args) {
		// System.out.println();
		int[] grades = { 95, 90, 93, 97, 99 };
		int[] grades2 = { 95, 95, 80, 89, 85 };
		int[] grades3 = { 67, 75, 80, 82, 58 };
		Student S1 = new Student("Ronin", grades);
		S1.printInfo();

		System.out.println();

		Student S2 = new Student("Jeiran", grades2);
		S2.printInfo();
		System.out.println();

		Student GS1 = new GraduateStudent("John", grades3, "Cybersecurity");
		GS1.printInfo();
		System.out.println();
		GS1.generateReport();
	}

}
