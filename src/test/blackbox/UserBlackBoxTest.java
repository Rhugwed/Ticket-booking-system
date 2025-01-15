package test.blackbox;

import org.junit.Test;
import snippet.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserBlackBoxTest {

    @Test
    public void testDisplayUserInfo_ValidFields() {
        // Arrange
        User user = new User("John Doe", "johndoe", "password123", "123 Street", "1234567890");

        // Redirect console output to verify the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        user.displayUserInfo();

        // Capture output
        String actualOutput = out.toString().trim();
        String expectedOutput = "User Information:\n" +
                "Name: John Doe\n" +
                "Username: johndoe\n" +
                "Address: 123 Street\n" +
                "Phone: 1234567890";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    
    @Test
    public void testDisplayUserInfo_NullFields() {
        // Arrange: Create a user with null fields
        User user = new User(null, null, "password123", null, null);

        // Redirect console output to verify the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        user.displayUserInfo();

        // Capture output
        String actualOutput = out.toString().trim();
        String expectedOutput = "User Information:\n" +
                "Name: null\n" +
                "Username: null\n" +
                "Address: null\n" +
                "Phone: null";

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}