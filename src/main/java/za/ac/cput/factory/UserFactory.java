//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.factory;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    private static final String DEFAULT_ROLE = "Customer";

    public static User createUser(String userId, String userName, String email){
        return createUser(userId, userName, email, DEFAULT_ROLE);
    }

    public static User createUser(String userId, String userName, String email, String role){

        if ((Helper.isNullOrEmpty(userId))||(Helper.isNullOrEmpty(userName))){

            return  null;
        }


        if (!Helper.isValidEmail(email)) {
            return null;

        }

        if (!Helper.isNullOrEmpty(role)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setEmail(email)
                .setRole(role)
                .build();


    }
}