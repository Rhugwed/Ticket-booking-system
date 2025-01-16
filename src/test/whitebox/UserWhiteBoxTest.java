package test.whitebox;

import org.junit.Test;
import snippet.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserWhiteBoxTest {
    @Test
    public void testDisplayUserInfo() {
        // Arrange
        User user = new User("John Doe", "johndoe", "password123", "123 Street", "1234567890");

        // Redirect console output to verify the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        user.displayUserInfo();

        // Normalize output
        String actualOutput = out.toString().trim();
        String expectedOutput = String.join(System.lineSeparator(),
                "User Information:",
                "Name: John Doe",
                "Username: johndoe",
                "Address: 123 Street",
                "Phone: 1234567890",
                "Wallet Details: Not added."
        );

        // Assert
        assertEquals("The actual output did not match the expected output.", expectedOutput, actualOutput);
    }

    @Test
    public void testDisplayUserInfo_NullFields() {
        // Arrange: Create a user with some null fields
        User user = new User(null, null, "password123", null, "1234567890");

        // Redirect console output to verify the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act: Call displayUserInfo()
        user.displayUserInfo();

        // Normalize output
        String actualOutput = out.toString().trim();
        String expectedOutput = String.join(System.lineSeparator(),
                "User Information:",
                "Name: null",
                "Username: null",
                "Address: null",
                "Phone: 1234567890",
                "Wallet Details: Not added."
        );

        // Assert: Ensure the output correctly displays the null values
        assertEquals("The actual output did not match the expected output.", expectedOutput, actualOutput);
    
    

        // Assert: Ensure the output correctly displays wallet details
        assertTrue("Expected wallet details not found in the output.", actualOutput.contains("Wallet Details:"));
    
}
}
