package test.whitebox;

import org.junit.Test;
import snippet.MainMenu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainMenuWhiteBoxTesting {

    @Test
    public void testUserSignup_ValidInput() {
        // Arrange
        String input = "newuser\npassword123\nJohn Doe\n9876543210\n123 Street\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        MainMenu.userSignup();

        // Assert
        assertTrue(out.toString().contains("User registered successfully."));
        assertTrue(MainMenu.users.stream().anyMatch(user -> user.getUsername().equals("newuser")));
    }


}