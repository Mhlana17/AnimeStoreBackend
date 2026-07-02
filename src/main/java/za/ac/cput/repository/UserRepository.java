//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    /**
     * Search for users by userName
     * @param userName the username to search
     * @return list of users matching the userName
     */
    List<User> findByUserName(String userName);
    
    /**
     * Search for users by email
     * @param email the email to search
     * @return optional containing user if found
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Search for users by userName containing a pattern
     * @param pattern the search pattern
     * @return list of users matching the pattern
     */
    List<User> findByUserNameContainingIgnoreCase(String pattern);
}