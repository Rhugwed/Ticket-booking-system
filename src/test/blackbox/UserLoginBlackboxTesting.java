package test.blackbox;

import org.junit.Test;

import snippet.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserLoginBlackboxTesting {

    @Test
    public void testSuccessfulSignup() {
        // Arrange
        List<User> users = new ArrayList<>();
        User newUser = new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907");

        // Act
        boolean result = addUser(users, newUser);

        // Assert
        assertTrue("user should be register succesfully", result);
    }

    @Test
    public void testSignupWithDuplicateUsername() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907"));
        User duplicateUser = new User("Vishu", "van_sh", "vs1243", "1 lincoln", "779790908");

        // Act
        boolean result = addUser(users, duplicateUser);

        // Assert
        assertFalse("Duplicate username should not be allowed.", result);
    }

    
    @Test
    public void testSuccessfulLogin() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass1243", "1 putneyroad", "779790907"));

        // Act
        boolean loginSuccess = login(users, "van_sh", "securePass1243");

        // Assert
        assertTrue("Login should succeed for valid credentials.", loginSuccess);
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User("Vanshaj", "van_sh", "securePass123", "1 putneyroad", "779790907"));

        // Act
        boolean loginSuccess = login(users, "van_sh", "wrongPass");

        // Assert
        assertFalse("Login should fail with incorrect password.", loginSuccess);
    }

    @Test
    public void testLoginWithNonExistentUser() {
        // Arrange
        List<User> users = new ArrayList<>();

        // Act
        boolean loginSuccess = login(users, "non_existent_user", "somePassword");

        // Assert
        assertFalse("Login should fail for a non-existent user.", loginSuccess);
    }

    // Helper methods to simulate black-box behavior
    private boolean addUser(List<User> users, User newUser) {
        for (User user : users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                return false; // Duplicate username
            }
        }
        users.add(newUser);
        return true;
    }

    private boolean login(List<User> users, String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; 
            }
        }
        return false; 
    }
}