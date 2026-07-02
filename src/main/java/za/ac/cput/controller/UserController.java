//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * Create a new user
     * @param user the user to create
     * @return ResponseEntity with created user and 201 status
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    
    /**
     * Read a user by ID
     * @param userId the user ID
     * @return ResponseEntity with user if found, 404 if not found
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> readUser(@PathVariable String userId) {
        Optional<User> user = userService.readUser(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    /**
     * Get all users
     * @return ResponseEntity with list of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    /**
     * Update an existing user
     * @param userId the user ID
     * @param user the updated user data
     * @return ResponseEntity with updated user or 404 if not found
     */
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        try {
            User existingUser = userService.readUser(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            user.setUserId(userId);
            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Delete a user by ID
     * @param userId the user ID
     * @return ResponseEntity with 204 if deleted, 404 if not found
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    /**
     * Search users by userName
     * @param userName the username to search
     * @return ResponseEntity with list of matching users
     */
    @GetMapping("/search/username/{userName}")
    public ResponseEntity<List<User>> searchByUserName(@PathVariable String userName) {
        List<User> users = userService.searchByUserName(userName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    /**
     * Search users by email
     * @param email the email to search
     * @return ResponseEntity with user if found, 404 if not found
     */
    @GetMapping("/search/email/{email}")
    public ResponseEntity<User> searchByEmail(@PathVariable String email) {
        Optional<User> user = userService.searchByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    /**
     * Search users by userName pattern
     * @param pattern the search pattern
     * @return ResponseEntity with list of matching users
     */
    @GetMapping("/search/pattern")
    public ResponseEntity<List<User>> searchByPattern(@RequestParam String pattern) {
        List<User> users = userService.searchUsersByPattern(pattern);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
