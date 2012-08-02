package com.dakuupa.validation;

import java.util.regex.Pattern;

/**
 *
 * @author etwilliams
 */
public class EmailAddressValidator {

    //old //"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String EMAIL_ADDRESS_PATTERN = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 

    public static boolean isValid(String email) {
       
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN, Pattern.CASE_INSENSITIVE);
        if (!pattern.matcher(email).matches()) {
            return false;
        } else {
            return true;
        }
    }
    
}
