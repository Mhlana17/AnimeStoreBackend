//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * User service interface extending generic IService
 * Defines additional search and query operations for User entity
 */
public interface IUserService extends IService<User, String> {
    
    /**
     * Search users by userName
     * @param userName the username to search
     * @return list of users matching the username
     */
    List<User> searchByUserName(String userName);
    
    /**
     * Search users by email
     * @param email the email to search
     * @return optional containing user if found
     */
    Optional<User> searchByEmail(String email);
    
    /**
     * Search users by userName pattern
     * @param pattern the search pattern
     * @return list of users matching the pattern
     */
    List<User> searchUsersByPattern(String pattern);
}
