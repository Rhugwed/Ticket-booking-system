package test.whitebox;

import org.junit.Test;
import snippet.Theatre;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TheatreWhiteBoxTest2 {

	@Test
	public void testShowTheatres_ValidDetails() {
	    // Arrange
	    Theatre theatre = new Theatre("Downtown", 300);

	    // Redirect console output
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(out));

	    // Act
	    theatre.showTheatres();

	    // Normalize and capture output
	    String actualOutput = out.toString().trim();

	    // Build expected output
	    String expectedOutput = String.join(System.lineSeparator(),
	            " Location:Downtown",
	            " Seating Capacity:300"
	    ).trim();

	    // Debugging: Print actual and expected outputs
	    System.out.println("Expected Output:\n" + expectedOutput);
	    System.out.println("Actual Output:\n" + actualOutput);

	    // Assert
	    assertEquals(expectedOutput, actualOutput);
	}
}