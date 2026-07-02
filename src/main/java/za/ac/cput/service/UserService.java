//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Create a new user
     * @param user the user to create
     * @return the created user
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    /**
     * Read a user by ID
     * @param userId the user ID
     * @return optional containing the user if found
     */
    public Optional<User> readUser(String userId) {
        return userRepository.findById(userId);
    }
    
    /**
     * Update an existing user
     * @param user the user to update
     * @return the updated user
     * @throws IllegalArgumentException if user doesn't exist
     */
    public User updateUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new IllegalArgumentException("User with ID " + user.getUserId() + " not found");
        }
        return userRepository.save(user);
    }
    
    /**
     * Delete a user by ID
     * @param userId the user ID to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteUser(String userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    
    /**
     * Get all users
     * @return list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Search users by userName
     * @param userName the username to search
     * @return list of users matching the username
     */
    public List<User> searchByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
    /**
     * Search users by email
     * @param email the email to search
     * @return optional containing the user if found
     */
    public Optional<User> searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    /**
     * Search users by userName pattern
     * @param pattern the search pattern
     * @return list of users matching the pattern
     */
    public List<User> searchUsersByPattern(String pattern) {
        return userRepository.findByUserNameContainingIgnoreCase(pattern);
    }
}
