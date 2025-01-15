package test.whitebox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import snippet.User;

public class UserTest6 {

    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize the user object with test data
        user = new User("John Doe", "johndoe", "password123", "123 Street", "1234567890");
    }

   

    @Test
    public void testManageWalletDetails_EmptyInput() {
        // Simulate empty input (pressing Enter with no input)
        String currentWalletDetails = user.getWalletDetails();

        // Call the method with empty input (simulated behavior for testing)
        user.manageWalletDetails();

        // Ensure wallet details have not changed (empty input should not modify the wallet)
        assertEquals(currentWalletDetails, user.getWalletDetails());
    }

    

    @Test
    public void testManageWalletDetails_NoChanges() {
        // Test with the same wallet details (no change)
        String currentWalletDetails = user.getWalletDetails();

        // Simulate no input, pressing Enter (empty)
        user.manageWalletDetails();

        // Verify that wallet details remain unchanged
        assertEquals(currentWalletDetails, user.getWalletDetails());
    }
}
