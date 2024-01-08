package workshops.practice_problems.classes_and_objects;

public class SampleRectangle {
	/* FIELDS */
	private double length, width; // must be > 0
	private String color; // must be red, green, blue, or black

	/* CONSTRUCTORS */
	// default (no-args)
	public SampleRectangle() {
		length = 1.0;
		width = 1.0;
		color = "black";
	}

	public SampleRectangle(double length, double width, String color) {
		// check length
		if (length > 0)
			this.length = length;
		else
			this.length = 1.0;

		// check width
		if (width > 0)
			this.width = width;
		else
			this.width = 1.0;

		// check color
		if (color.equals("red") || color.equals("green") || color.equals("blue") || color.equals("black"))
			this.color = color;
		else
			this.color = "black";
	}

	/* GETTERS AND SETTERS */
	// length
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0)
			this.length = length;
	}

	// width
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0)
			this.width = width;
	}

	// color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color.equals("red") || color.equals("green") || color.equals("blue") || color.equals("black"))
			this.color = color;
	}

	/* OTHER INSTANCE METHODS */
	public double getPerimeter() {
		return 2 * length + 2 * width;
	}

	public double getArea() {
		return length * width;
	}

	public boolean equals(Object other) {
		if (other == null)
			return false;

		if (!(other instanceof SampleRectangle)) // check if other object is a SampleRectangle
			return false;

		if (this == other) // check if both references are pointing to the same object
			return true;

		SampleRectangle otherRect = (SampleRectangle) other; // cast other as a SampleRectangle
		if (this.length == otherRect.length // check lengths are equal
				&& this.width == otherRect.width // check widths are equal
				&& this.color.equals(otherRect.color)) // check colors are equal
			return true;

		return false;
	}

	/* STATIC METHODS */
	public static double calculatePerimeter(double length, double width) {
		return 2 * length * width;
	}

	public static double calculateArea(double length, double width) {
		return length * width;
	}
}