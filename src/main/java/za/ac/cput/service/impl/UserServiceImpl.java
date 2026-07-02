//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of IUserService
 * Provides CRUD operations and search functionality for User entity
 */
@Service
public class UserServiceImpl implements IUserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Create a new user
     * @param user the user to create
     * @return the created user
     * @throws IllegalArgumentException if user is null or userId is empty
     */
    @Override
    public User create(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User and userId cannot be null or empty");
        }
        return userRepository.save(user);
    }
    
    /**
     * Read a user by ID
     * @param id the user ID
     * @return optional containing the user if found
     */
    @Override
    public Optional<User> read(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }
        return userRepository.findById(id);
    }
    
    /**
     * Update an existing user
     * @param user the user to update
     * @return the updated user
     * @throws IllegalArgumentException if user doesn't exist or user is null
     */
    @Override
    public User update(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User and userId cannot be null or empty");
        }
        if (!userRepository.existsById(user.getUserId())) {
            throw new IllegalArgumentException("User with ID " + user.getUserId() + " not found");
        }
        return userRepository.save(user);
    }
    
    /**
     * Delete a user by ID
     * @param id the user ID to delete
     * @return true if deleted, false if not found
     */
    @Override
    public boolean delete(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    /**
     * Get all users
     * @return list of all users
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    /**
     * Search users by userName
     * @param userName the username to search
     * @return list of users matching the username
     */
    @Override
    public List<User> searchByUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("UserName cannot be null or empty");
        }
        return userRepository.findByUserName(userName);
    }
    
    /**
     * Search users by email
     * @param email the email to search
     * @return optional containing the user if found
     */
    @Override
    public Optional<User> searchByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return userRepository.findByEmail(email);
    }
    
    /**
     * Search users by userName pattern
     * @param pattern the search pattern
     * @return list of users matching the pattern
     */
    @Override
    public List<User> searchUsersByPattern(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be null or empty");
        }
        return userRepository.findByUserNameContainingIgnoreCase(pattern);
    }
}
