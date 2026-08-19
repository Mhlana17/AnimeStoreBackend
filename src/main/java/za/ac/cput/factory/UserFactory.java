//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.factory;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;


public class UserFactory {

    public static User createUser(String userId, String userName, String email, String role){
        if (Helper.isNullOrEmpty(userName) || !Helper.isValidEmail(email) || !Helper.isValidRole(role)) {
            return null;
        }
        if (Helper.isNullOrEmpty(userId)) {
            userId = "U" + System.currentTimeMillis();
        }
        return new User.Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setEmail(email)
                .setRole(role)
                .build();
    }
}