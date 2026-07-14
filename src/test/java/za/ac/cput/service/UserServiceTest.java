//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {
    
    @Autowired
    private IUserService userService;
    
    private static User testUser;
    private static final String TEST_USER_ID = "user_service_test_123";
    private static final String TEST_USERNAME = "ServiceTestUser";
    private static final String TEST_EMAIL = "servicetest@example.com";
    
    @BeforeEach
    public void setUp() {
        userService.getAll().forEach(user -> userService.delete(user.getUserId()));
        
        testUser = new User.Builder()
                .setUserId(TEST_USER_ID)
                .setUserName(TEST_USERNAME)
                .setEmail(TEST_EMAIL)
                .build();
    }
    
    @Test
    @DisplayName("Test 1: Create User - Success")
    void testCreateUserSuccess() {
        User createdUser = userService.create(testUser);
        
        assertNotNull(createdUser, "Created user should not be null");
        assertEquals(TEST_USER_ID, createdUser.getUserId(), "User ID should match");
        assertEquals(TEST_USERNAME, createdUser.getUserName(), "Username should match");
        assertEquals(TEST_EMAIL, createdUser.getEmail(), "Email should match");
    }
    
    @Test
    @DisplayName("Test 2: Create User - Null User")
    void testCreateUserNullUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.create(null);
        }, "Should throw IllegalArgumentException for null user");
    }
    
    @Test
    @DisplayName("Test 3: Create User - Null UserId")
    void testCreateUserNullUserId() {
        User userWithNullId = new User.Builder()
                .setUserId(null)
                .setUserName(TEST_USERNAME)
                .setEmail(TEST_EMAIL)
                .build();
        
        assertThrows(IllegalArgumentException.class, () -> {
            userService.create(userWithNullId);
        }, "Should throw IllegalArgumentException for null userId");
    }
    
    @Test
    @DisplayName("Test 4: Read User - Success")
    void testReadUserSuccess() {
        userService.create(testUser);
        Optional<User> readUser = userService.read(TEST_USER_ID);
        
        assertTrue(readUser.isPresent(), "User should be present");
        assertEquals(TEST_USER_ID, readUser.get().getUserId(), "User ID should match");
    }
    
    @Test
    @DisplayName("Test 5: Read User - Not Found")
    void testReadUserNotFound() {
        Optional<User> readUser = userService.read("nonexistent_user_id");
        
        assertTrue(readUser.isEmpty(), "User should not be found");
    }
    
    @Test
    @DisplayName("Test 6: Read User - Null UserId")
    void testReadUserNullUserId() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.read(null);
        }, "Should throw IllegalArgumentException for null userId");
    }
    
    @Test
    @DisplayName("Test 7: Update User - Success")
    void testUpdateUserSuccess() {
        userService.create(testUser);
        
        User updatedUser = new User.Builder()
                .setUserId(TEST_USER_ID)
                .setUserName("UpdatedTestUser")
                .setEmail("updated@example.com")
                .build();
        
        User result = userService.update(updatedUser);
        
        assertNotNull(result, "Updated user should not be null");
        assertEquals("UpdatedTestUser", result.getUserName(), "Username should be updated");
        assertEquals("updated@example.com", result.getEmail(), "Email should be updated");
    }
    
    @Test
    @DisplayName("Test 8: Update User - Not Found")
    void testUpdateUserNotFound() {
        User nonexistentUser = new User.Builder()
                .setUserId("nonexistent_id")
                .setUserName(TEST_USERNAME)
                .setEmail(TEST_EMAIL)
                .build();
        
        assertThrows(IllegalArgumentException.class, () -> {
            userService.update(nonexistentUser);
        }, "Should throw IllegalArgumentException for non-existent user");
    }
    
    @Test
    @DisplayName("Test 9: Update User - Null User")
    void testUpdateUserNullUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.update(null);
        }, "Should throw IllegalArgumentException for null user");
    }
    
    @Test
    @DisplayName("Test 10: Delete User - Success")
    void testDeleteUserSuccess() {
        userService.create(testUser);
        boolean deleted = userService.delete(TEST_USER_ID);
        
        assertTrue(deleted, "User should be deleted successfully");
        assertTrue(userService.read(TEST_USER_ID).isEmpty(), "User should not exist after deletion");
    }
    
    @Test
    @DisplayName("Test 11: Delete User - Not Found")
    void testDeleteUserNotFound() {
        boolean deleted = userService.delete("nonexistent_user_id");
        
        assertFalse(deleted, "Deletion should return false for non-existent user");
    }
    
    @Test
    @DisplayName("Test 12: Delete User - Null UserId")
    void testDeleteUserNullUserId() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.delete(null);
        }, "Should throw IllegalArgumentException for null userId");
    }
    
    @Test
    @DisplayName("Test 13: Get All Users - Success")
    void testGetAllUsersSuccess() {
        userService.create(testUser);
        
        User secondUser = new User.Builder()
                .setUserId("user_service_test_456")
                .setUserName("AnotherTestUser")
                .setEmail("another@example.com")
                .build();
        userService.create(secondUser);
        
        List<User> allUsers = userService.getAll();
        
        assertNotNull(allUsers, "User list should not be null");
        assertEquals(2, allUsers.size(), "Should have 2 users");
    }
    
    @Test
    @DisplayName("Test 14: Get All Users - Empty List")
    void testGetAllUsersEmpty() {
        List<User> allUsers = userService.getAll();
        
        assertNotNull(allUsers, "User list should not be null");
        assertTrue(allUsers.isEmpty(), "User list should be empty");
    }
    
    @Test
    @DisplayName("Test 15: Search By UserName - Success")
    void testSearchByUserNameSuccess() {
        userService.create(testUser);
        List<User> results = userService.searchByUserName(TEST_USERNAME);
        
        assertFalse(results.isEmpty(), "Search results should not be empty");
        assertEquals(1, results.size(), "Should find 1 user");
        assertEquals(TEST_USERNAME, results.get(0).getUserName(), "Username should match");
    }
    
    @Test
    @DisplayName("Test 16: Search By UserName - Not Found")
    void testSearchByUserNameNotFound() {
        List<User> results = userService.searchByUserName("NonexistentUser");
        
        assertTrue(results.isEmpty(), "Search results should be empty");
    }
    
    @Test
    @DisplayName("Test 17: Search By UserName - Null UserName")
    void testSearchByUserNameNullUserName() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.searchByUserName(null);
        }, "Should throw IllegalArgumentException for null userName");
    }
    
    @Test
    @DisplayName("Test 18: Search By Email - Success")
    void testSearchByEmailSuccess() {
        userService.create(testUser);
        Optional<User> result = userService.searchByEmail(TEST_EMAIL);
        
        assertTrue(result.isPresent(), "User should be found");
        assertEquals(TEST_EMAIL, result.get().getEmail(), "Email should match");
    }
    
    @Test
    @DisplayName("Test 19: Search By Email - Not Found")
    void testSearchByEmailNotFound() {
        Optional<User> result = userService.searchByEmail("nonexistent@example.com");
        
        assertTrue(result.isEmpty(), "User should not be found");
    }
    
    @Test
    @DisplayName("Test 20: Search By Email - Null Email")
    void testSearchByEmailNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.searchByEmail(null);
        }, "Should throw IllegalArgumentException for null email");
    }
    
    @Test
    @DisplayName("Test 21: Search By Pattern - Success")
    void testSearchByPatternSuccess() {
        userService.create(testUser);
        
        User secondUser = new User.Builder()
                .setUserId("user_service_test_789")
                .setUserName("ServiceUser2")
                .setEmail("serviceuser2@example.com")
                .build();
        userService.create(secondUser);
        
        List<User> results = userService.searchUsersByPattern("Service");
        
        assertFalse(results.isEmpty(), "Search results should not be empty");
        assertEquals(2, results.size(), "Should find 2 users matching pattern");
    }
    
    @Test
    @DisplayName("Test 22: Search By Pattern - No Matches")
    void testSearchByPatternNoMatches() {
        userService.create(testUser);
        List<User> results = userService.searchUsersByPattern("NonExistentPattern");
        
        assertTrue(results.isEmpty(), "Search results should be empty");
    }
    
    @Test
    @DisplayName("Test 23: Search By Pattern - Null Pattern")
    void testSearchByPatternNullPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.searchUsersByPattern(null);
        }, "Should throw IllegalArgumentException for null pattern");
    }
    
    @Test
    @DisplayName("Test 24: Search By Pattern - Case Insensitive")
    void testSearchByPatternCaseInsensitive() {
        userService.create(testUser);
        List<User> resultsLower = userService.searchUsersByPattern("servicetest");
        List<User> resultsUpper = userService.searchUsersByPattern("SERVICETEST");
        
        assertEquals(1, resultsLower.size(), "Should find user with lowercase pattern");
        assertEquals(1, resultsUpper.size(), "Should find user with uppercase pattern");
    }
}
