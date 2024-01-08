package workshops.practice_problems.classes_and_objects;

public class CircleSolution {
	/* ========== FIELDS ========== */
	// radius - private double
	// color - private String
	private double radius;
	private String color;

	/* ========== CONSTRUCTORS ========== */
	// default: radius = 1.0, color = "black"
	public CircleSolution() {
		radius = 1.0;
		color = "black";
	}

	// non-default: takes radius and color
	public CircleSolution(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	/* ========== METHODS ========== */
	// double getRadius()
	public double getRadius() {
		return radius;
	}

	// void setRadius(double radius)
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// String getColor()
	public String getColor() {
		return color;
	}

	// void setColor(String color)
	public void setColor(String color) {
		this.color = color;
	}

	// double getCircumference()
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

	// double getArea()
	public double getArea() {
		return Math.PI * radius * radius;
	}

	// static double calculateCircumference(double radius)
	public static double calculateCircumference(double radius) {
		return 2 * Math.PI * radius;
	}

	// static double calculateArea(double radius)
	public static double calculateArea(double radius) {
		return Math.PI * radius * radius;
	}

	// boolean equals(Object other) - returns true if both are circles and have the
	// same radius
	// and color, returns false otherwise
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (!(other instanceof CircleSolution)) {
			return false;
		}

		if (this == other) {
			return true;
		}

		CircleSolution otherCircle = (CircleSolution) other;
		return this.radius == otherCircle.radius && this.color.equals(otherCircle.color);
	}
}
