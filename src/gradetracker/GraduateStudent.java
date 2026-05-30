package gradetracker;

public class GraduateStudent extends Student {

	private String thesisTopic;

	// super(DATAFIELDS OF SUPERCLASS) will pull the data from superclass, and make
	// sure to include it in params
	public GraduateStudent(String name, int[] grades, String thesisTopic) {
		super(name, grades);
		this.thesisTopic = thesisTopic;
	}

	// super.<METHODNAME> to copy what the previous superclass methods does, then
	// you can add on
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Thesis is on: " + thesisTopic);
	}

}
