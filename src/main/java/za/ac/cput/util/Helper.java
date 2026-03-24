package za.ac.cput.util;

public class Helper {

    public static boolean isValidPrice(Double price) {
        return price > 0 && price <= 1000000;
    }
    public static boolean isNullOrEmpty(String s){
        if(s.isEmpty() || s == null)
            return true;
        return false;
    }
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }










}//end of Helper class
