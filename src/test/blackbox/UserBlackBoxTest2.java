package test.blackbox;

import org.junit.Test;
import snippet.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserBlackBoxTest2 {

    @Test
    public void testViewShowtimes_NoShowtimes() {

        User user = new User("John Doe", "johndoe", "password123", "123 Street", "1234567890");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        user.viewShowtimes();

        String actualOutput = out.toString().trim();
        String expectedOutput = "--- Available Showtimes ---\nNo showtimes available.";
        assertEquals(expectedOutput, actualOutput);
    }
}