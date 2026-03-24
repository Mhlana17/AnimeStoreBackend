
package za.ac.cput.factory;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User createUser(String userId, String userName, String email){

        if (Helper.isNullOrEmpty(userId)){
            return null;
        }
        if(Helper.isNullOrEmpty(userName)){
            return null;
        }
        if(Helper.isValidEmail(email)) {
            return null;

        }
        return new User.Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setEmail(email)
                .build();


        }
}
