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
        if(str.isEmpty() || str == null) {
            return true;
        }
        return false;
    }
    public static boolean isValidId(Long id) {

        return id != null && id > 0;
    }
    public static boolean isValidName(int qty){
        return qty > 0 && qty <= 1000;
    }

}//end of Helper class
