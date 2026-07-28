//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    @Override
    public User create(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }
    

    @Override
    public Optional<User> read(String id) {
        if (id == null || id.isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findById(id);
    }
    

    @Override
    public User update(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            return null;
        }
        if (!userRepository.existsById(user.getUserId())) {
            return null;
        }
        return userRepository.save(user);
    }
    

    @Override
    public boolean delete(String id) {
        if (id == null || id.isEmpty()) {
            return false;
        }
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    

    @Override
    public List<User> searchByUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        return userRepository.findByUserName(userName);
    }

    @Override
    public Optional<User> searchByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findByEmail(email);
    }
    

    @Override
    public List<User> searchUsersByPattern(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return null;
        }
        return userRepository.findByUserNameContainingIgnoreCase(pattern);
    }
}
