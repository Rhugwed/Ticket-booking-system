package test.whitebox;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import snippet.User;
import static org.junit.Assert.*;

public class UserloginTest {

    @Test
    public void testValidSignup() {
        // Arrange
        List<User> users = new ArrayList<>();
        User user = new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907");

        // Act
        boolean isAdded = addUser(users, user);

        // Assert
        assertTrue("User should be successfully added.", isAdded);
    }

    @Test
    public void testDuplicateUsernameSignup() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907"));
        User duplicateUser = new User("Vishu", "van_sh", "vs1243", "1 lincoln", "779790908");

        // Act
        boolean isAdded = addUser(users, duplicateUser);

        // Assert
        assertFalse("Duplicate username should not be allowed.", isAdded);
    }

    @Test
    public void testValidLogin() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907"));

        // Act
        boolean isLoggedIn = login(users, "van_sh","securePass1243");

        // Assert
        assertTrue("Login should succeed for valid credentials.", isLoggedIn);
    }

    @Test
    public void testInvalidLogin() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907"));

        // Act
        boolean isLoggedIn = login(users, "van_sh","securePass123");

        // Assert
        assertFalse("Login should fail for invalid credentials.", isLoggedIn);
    }

    // Helper method for user signup
    private boolean addUser(List<User> users, User newUser) {
        for (User user : users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                return false; // Duplicate username
            }
        }
        users.add(newUser);
        return true;
    }

    // Helper method for user login
    private boolean login(List<User> users, String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Invalid credentials
    }
}
