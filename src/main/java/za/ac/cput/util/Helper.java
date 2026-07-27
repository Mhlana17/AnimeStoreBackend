//Author: Phihlello Junaid Maroga 219354359
//Author: Sisonke Mhlana(221805486)
package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
    public static boolean isValidEmail(String email){
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean isValidPrice(Double price) {

        return price > 0 && price <= 1000000;
    }
    public static boolean isNullOrEmpty(String str){
        if(str == null || str.isEmpty())
            return true;
        return false;
    }
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }

    public static boolean isValidRole(String role) {
        if (isNullOrEmpty(role)) {
            return false;
        }
        return role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("Customer");
    }


}//end of Helper class